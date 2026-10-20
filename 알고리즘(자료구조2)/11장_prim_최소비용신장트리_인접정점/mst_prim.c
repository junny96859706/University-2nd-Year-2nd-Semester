#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 100
#define INF 1000L

typedef struct GraphType {
    int n; // 정점의 개수
    int weight[MAX_VERTICES][MAX_VERTICES];
} GraphType;

int selected[MAX_VERTICES]; // 정점이 이미 MST 트리에 포함되었는지 여부
int distance[MAX_VERTICES]; // MST 트리에서 각 정점까지 연결하는 데 필요한 최소 가중치

// 최소 dist[v] 값을 갖는 정점을 반환
// 아직 MST 트리에 선택되지 않은 정점들 중에서, 현재 트리에 가장 가까운 정점을 찾는 함수
int get_min_vertex(int n)
{
    int v, i;

    // 첫 번째 for문: 아직 선택 안 된 정점 중 아무거나 하나 찾아서 임시 기준점 v로 지정
    for (i = 0; i < n; i++) {
        if (!selected[i]) {
            v = i;
            break;
        }
    }

    // 두 번째 for문: 전체 정점을 조사하면서 아직 선택 안 되었고, 
    // 최단 거리 값이 v보다 더 작은 정점이 있으면 기준점 v를 그 정점으로 변경
    for (i = 0; i < n; i++) {
        if (!selected[i] && (distance[i] < distance[v]))
            v = i;
    }

    return (v);
}

void prim(GraphType* g, int s)
{
    int i, u, v;

    // 1단계: 초기화
    for (u = 0; u < g->n; u++)
        distance[u] = INF; // 연결되지 않은 정점은 distance 값이 INF(무한대)로 남아있음!

    distance[s] = 0; // 시작 정점 s의 거리는 0

    for (i = 0; i < g->n; i++) {
        u = get_min_vertex(g->n); // 가장 가까운 정점 선택
        selected[u] = TRUE;

        // 만약 뽑힌 정점의 거리가 여전히 INF라면 더 이상 연결될 정점이 없다는 뜻
        if (distance[u] == INF) return;

        printf("정점 %d 추가\n", u);

        // 새로 추가된 정점 u를 기준으로 주변 거리 갱신!
        for (v = 0; v < g->n; v++) {
            if (g->weight[u][v] != INF) { // 간선이 u와 v 사이에 존재한다면
                if (!selected[v] && g->weight[u][v] < distance[v]) {
                    distance[v] = g->weight[u][v]; // 더 짧은 길을 찾았으므로 distance[v] 값을 최솟값으로 덮어씌움 (갱신)
                }
            }
        }
    }
}

int main(void)
{
    GraphType g = { 7,
        { { 0,   29,  INF, INF, INF, 10,  INF },
          { 29,  0,   16,  INF, INF, INF, 15  },
          { INF, 16,  0,   12,  INF, INF, INF },
          { INF, INF, 12,  0,   22,  INF, 18  },
          { INF, INF, INF, 22,  0,   27,  25  },
          { 10,  INF, INF, INF, 27,  0,   INF },
          { INF, 15,  INF, 18,  25,  INF, 0   } }
    };

    prim(&g, 0);

    return 0;
}