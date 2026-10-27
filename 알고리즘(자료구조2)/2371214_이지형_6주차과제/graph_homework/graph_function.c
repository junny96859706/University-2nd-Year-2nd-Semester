#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include "graph.h"

// ==========================================
// 1. Kruskal 알고리즘 (최소/최대 신장 트리)
// ==========================================
static int* parent = NULL;

static void set_init(int n) {
    for (int i = 0; i <= n; i++) {
        parent[i] = -1;
    }
}

static int set_find(int curr) {
    if (parent[curr] == -1) return curr;
    return parent[curr] = set_find(parent[curr]);
}

static void set_union(int a, int b) {
    int root1 = set_find(a);
    int root2 = set_find(b);
    if (root1 != root2) parent[root1] = root2;
}

static int compare_asc(const void* a, const void* b) {
    return ((struct Edge*)a)->weight - ((struct Edge*)b)->weight;
}

static int compare_desc(const void* a, const void* b) {
    return ((struct Edge*)b)->weight - ((struct Edge*)a)->weight;
}

void kruskal(GraphType* g, int st_kind) {
    if (g->n_e <= 0) {
        printf("%s를 구할 수 없다\n", st_kind == 1 ? "최대비용신장트리" : "최소비용신장트리");
        return;
    }

    parent = (int*)malloc((g->n + 1) * sizeof(int));
    set_init(g->n);

    struct Edge* temp_edges = (struct Edge*)malloc(g->n_e * sizeof(struct Edge));
    for (int i = 0; i < g->n_e; i++) {
        temp_edges[i] = g->edges[i];
    }

    if (st_kind == 1)
        qsort(temp_edges, g->n_e, sizeof(struct Edge), compare_desc);
    else
        qsort(temp_edges, g->n_e, sizeof(struct Edge), compare_asc);

    int accepted = 0;
    int total_weight = 0;

    printf("\n=== [%s Kruskal 알고리즘 결과] ===\n", st_kind == 1 ? "최대비용신장트리" : "최소비용신장트리");

    for (int i = 0; i < g->n_e; i++) {
        int uset = set_find(temp_edges[i].start);
        int vset = set_find(temp_edges[i].end);

        if (uset != vset) {
            printf("(%d, %d, %d)\n", temp_edges[i].start, temp_edges[i].end, temp_edges[i].weight);
            total_weight += temp_edges[i].weight;
            accepted++;
            set_union(uset, vset);
        }
        if (accepted == g->n - 1) break;
    }

    if (accepted < g->n - 1) {
        printf("%s를 구할 수 없다\n", st_kind == 1 ? "최대비용신장트리" : "최소비용신장트리");
    }
    else {
        printf("총 가중치 합: %d\n", total_weight);
    }

    free(temp_edges);
    free(parent);
    parent = NULL;
}

// ==========================================
// 2. Prim 알고리즘 (최소/최대 신장 트리)
// ==========================================
void prim(GraphType* g, int s, int st_kind) {
    int n = g->n;
    if (s < 0 || s >= n) {
        printf("입력하신 출발 노드가 범위(1~%d)를 벗어났습니다.\n", n);
        return;
    }

    int* selected = (int*)malloc(n * sizeof(int));
    int* dist = (int*)malloc(n * sizeof(int));
    int* near_node = (int*)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        selected[i] = FALSE; // for문으로 0(FALSE) 초기화
        dist[i] = g->adj_mat[s][i];
        near_node[i] = s;
    }

    selected[s] = TRUE;
    int accepted = 0;
    int total_weight = 0;

    printf("\n=== [%s Prim 알고리즘 결과 (출발 노드: %d)] ===\n",
        st_kind == 1 ? "최대비용신장트리" : "최소비용신장트리", s + 1);

    for (int i = 0; i < n - 1; i++) {
        int target = -1;
        int target_val = (st_kind == 1) ? -1 : INF;

        for (int j = 0; j < n; j++) {
            if (!selected[j]) {
                if (st_kind == 0 && dist[j] < target_val) {
                    target_val = dist[j];
                    target = j;
                }
                else if (st_kind == 1 && dist[j] != INF && dist[j] > target_val) {
                    target_val = dist[j];
                    target = j;
                }
            }
        }

        if (target == -1 || target_val == INF || target_val == 0) break;

        selected[target] = TRUE;
        printf("(%d, %d, %d)\n", near_node[target] + 1, target + 1, dist[target]);
        total_weight += dist[target];
        accepted++;

        for (int v = 0; v < n; v++) {
            if (!selected[v] && g->adj_mat[target][v] != INF && g->adj_mat[target][v] != 0) {
                if (st_kind == 0 && g->adj_mat[target][v] < dist[v]) {
                    dist[v] = g->adj_mat[target][v];
                    near_node[v] = target;
                }
                else if (st_kind == 1 && (dist[v] == INF || g->adj_mat[target][v] > dist[v])) {
                    dist[v] = g->adj_mat[target][v];
                    near_node[v] = target;
                }
            }
        }
    }

    if (accepted < n - 1) {
        printf("%s를 구할 수 없다\n", st_kind == 1 ? "최대비용신장트리" : "최소비용신장트리");
    }
    else {
        printf("총 가중치 합: %d\n", total_weight);
    }

    free(selected);
    free(dist);
    free(near_node);
}

// ==========================================
// 3. Dijkstra 최단 경로 알고리즘
// ==========================================
static void print_dijkstra_path(int start, int end, int* prev) {
    if (end == start) {
        printf("%d", start + 1);
        return;
    }
    if (prev[end] == -1) {
        printf("경로 없음");
        return;
    }
    print_dijkstra_path(start, prev[end], prev);
    printf(" -> %d", end + 1);
}

void shortest_path(GraphType* g, int start) {
    int n = g->n;
    if (start < 0 || start >= n) {
        printf("입력하신 출발 노드가 범위(1~%d)를 벗어났습니다.\n", n);
        return;
    }

    int* dist = (int*)malloc(n * sizeof(int));
    int* found = (int*)malloc(n * sizeof(int));
    int* prev = (int*)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        dist[i] = g->adj_mat[start][i];
        found[i] = FALSE; // for문으로 0(FALSE) 초기화
        if (g->adj_mat[start][i] != INF && g->adj_mat[start][i] != 0 && i != start)
            prev[i] = start;
        else
            prev[i] = -1;
    }

    found[start] = TRUE;
    dist[start] = 0;

    for (int i = 0; i < n - 1; i++) {
        int min_val = INF, u = -1;
        for (int j = 0; j < n; j++) {
            if (!found[j] && dist[j] < min_val) {
                min_val = dist[j];
                u = j;
            }
        }

        if (u == -1) break;
        found[u] = TRUE;

        for (int w = 0; w < n; w++) {
            if (!found[w] && g->adj_mat[u][w] != INF && g->adj_mat[u][w] != 0) {
                if (dist[u] + g->adj_mat[u][w] < dist[w]) {
                    dist[w] = dist[u] + g->adj_mat[u][w];
                    prev[w] = u;
                }
            }
        }
    }

    printf("\n=== [Dijkstra 최단 경로 (출발 노드: %d)] ===\n", start + 1);
    for (int i = 0; i < n; i++) {
        if (i == start) continue;
        printf("목적지 노드 %d | 최단 거리: ", i + 1);
        if (dist[i] == INF) {
            printf("INF | 경로: 없음\n");
        }
        else {
            printf("%3d | 경로: ", dist[i]);
            print_dijkstra_path(start, i, prev);
            printf("\n");
        }
    }

    free(dist);
    free(found);
    free(prev);
}

// ==========================================
// 4. Floyd 최단 경로 알고리즘
// ==========================================
static void print_floyd_path(int u, int v, int** next_node) {
    if (next_node[u][v] == -1) {
        printf(" -> %d", v + 1);
        return;
    }
    int k = next_node[u][v];
    print_floyd_path(u, k, next_node);
    print_floyd_path(k, v, next_node);
}

void floyd(GraphType* g, int req_st, int req_end) {
    int n = g->n;
    int req_u = req_st - 1;
    int req_v = req_end - 1;

    int** A = (int**)malloc(n * sizeof(int*));
    int** next_node = (int**)malloc(n * sizeof(int*));

    for (int i = 0; i < n; i++) {
        A[i] = (int*)malloc(n * sizeof(int));
        next_node[i] = (int*)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            A[i][j] = g->adj_mat[i][j];
            next_node[i][j] = -1;
        }
    }

    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][k] != INF && A[k][j] != INF) {
                    if (A[i][k] + A[k][j] < A[i][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                        next_node[i][j] = k;
                    }
                }
            }
        }
    }

    printf("\n=== [Floyd 특정 노드 쌍 최단 경로 (%d -> %d)] ===\n", req_st, req_end);
    if (req_u < 0 || req_u >= n || req_v < 0 || req_v >= n || A[req_u][req_v] == INF) {
        printf("최단 거리: INF | 경로: 없음\n");
    }
    else {
        printf("최단 거리: %d | 경로: %d", A[req_u][req_v], req_st);
        print_floyd_path(req_u, req_v, next_node);
        printf("\n");
    }

    printf("\n=== [Floyd 모든 노드 쌍 최단 경로 결과] ===\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            printf("%d -> %d | 거리: ", i + 1, j + 1);
            if (A[i][j] == INF) {
                printf("INF | 경로: 없음\n");
            }
            else {
                printf("%3d | 경로: %d", A[i][j], i + 1);
                print_floyd_path(i, j, next_node);
                printf("\n");
            }
        }
    }

    for (int i = 0; i < n; i++) {
        free(A[i]);
        free(next_node[i]);
    }
    free(A);
    free(next_node);
}