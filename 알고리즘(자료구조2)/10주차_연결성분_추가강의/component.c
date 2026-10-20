#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 50

typedef struct GraphType {
    int n; // 정점의 개수
    int adj_mat[MAX_VERTICES][MAX_VERTICES];
} GraphType;

int visited[MAX_VERTICES];
int count; // 연결 성분 번호 (그룹 ID)

// 그래프 초기화
void init(GraphType* g) {
    int r, c;
    g->n = 0;
    for (r = 0; r < MAX_VERTICES; r++)
        for (c = 0; c < MAX_VERTICES; c++)
            g->adj_mat[r][c] = 0;
}

// 정점 삽입
void insert_vertex(GraphType* g, int v) {
    if (((g->n) + 1) > MAX_VERTICES) return;
    g->n++;
}

// 간선 삽입
void insert_edge(GraphType* g, int start, int end) {
    g->adj_mat[start][end] = 1;
    g->adj_mat[end][start] = 1;
}

// 연결 성분용 DFS (방문 표시를 count 값으로 함)
void dfs_mat(GraphType* g, int v) {
    int w;
    visited[v] = count; // 현재 덩어리 번호(count)를 기록

    for (w = 0; w < g->n; w++) {
        if (g->adj_mat[v][w] && !visited[w])
            dfs_mat(g, w);
    }
}

// 연결 성분 구하기 함수
void find_connected_component(GraphType* g) {
    int i;
    count = 0;

    for (i = 0; i < g->n; i++) {
        if (!visited[i]) { // 아직 방문되지 않은 정점이 있으면
            count++;       // 새로운 덩어리 번호 부여
            dfs_mat(g, i); // 해당 정점과 연결된 모든 정점 방문
        }
    }
}

int main(void) {
    GraphType* g = (GraphType*)malloc(sizeof(GraphType));
    init(g);

    // 정점 5개 생성 (0 ~ 4)
    for (int i = 0; i < 5; i++)
        insert_vertex(g, i);

    // 1번 덩어리 연결 (0-1, 0-2)
    insert_edge(g, 0, 1);
    insert_edge(g, 0, 2);

    // 2번 덩어리 연결 (3-4)
    insert_edge(g, 3, 4);

    find_connected_component(g);

    printf("총 연결 성분(덩어리) 개수: %d\n\n", count);
    for (int i = 0; i < g->n; i++) {
        printf("정점 %d -> 연결 성분 그룹 [%d]\n", i, visited[i]);
    }

    free(g);
    return 0;
}