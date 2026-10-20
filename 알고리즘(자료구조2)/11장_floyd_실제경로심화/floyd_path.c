#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 100
#define INF 1000000 /* 무한대 (연결이 없는 경우) */

typedef struct GraphType {
    int n; // 정점의 개수
    int weight[MAX_VERTICES][MAX_VERTICES];
} GraphType;

int dist[MAX_VERTICES][MAX_VERTICES];
int next_node[MAX_VERTICES][MAX_VERTICES]; // 슬라이드의 next[][] 배열 (중간 거쳐가는 정점 기록)

// 최단 경로 결과 출력 함수
void print_dist(GraphType* g) {
    printf("========== [최단 거리 행렬] ==========\n");
    for (int i = 0; i < g->n; i++) {
        for (int j = 0; j < g->n; j++) {
            if (dist[i][j] == INF)
                printf("  * ");
            else
                printf("%3d ", dist[i][j]);
        }
        printf("\n");
    }
    printf("=======================================\n\n");
}

// 슬라이드의 Path(i, j) 재귀 경로 추적 함수
void print_path(int i, int j) {
    if (dist[i][j] == INF) {
        printf("경로 없음");
        return;
    }

    int intermediate = next_node[i][j];

    // 중간에 거쳐가는 정점이 없으면 (직접 연결된 간선)
    if (intermediate == -1) {
        return;
    }

    // intermediate(k)를 기준으로 분할 재귀 호출: Path(i, k) -> k -> Path(k, j)
    print_path(i, intermediate);
    printf("%d -> ", intermediate);
    print_path(intermediate, j);
}

// 전체 경로를 깔끔하게 출력해주는 wrapper 함수
void show_full_path(int i, int j) {
    if (dist[i][j] == INF) {
        printf("정점 %d -> 정점 %d: 이동 불가\n", i, j);
        return;
    }

    printf("정점 %d -> 정점 %d (비용: %d) | 경로: %d -> ", i, j, dist[i][j], i);
    print_path(i, j);
    printf("%d\n", j);
}

// 플로이드 알고리즘 + 경로 복원
void floyd_path_reconstruction(GraphType* g) {
    int i, j, k;

    // 1. 초기화
    for (i = 0; i < g->n; i++) {
        for (j = 0; j < g->n; j++) {
            dist[i][j] = g->weight[i][j];
            next_node[i][j] = -1; // null 상태 (-1로 지정)
        }
    }

    // 2. 메인 3중 for문
    for (k = 0; k < g->n; k++) {
        for (i = 0; i < g->n; i++) {
            for (j = 0; j < g->n; j++) {
                // k를 거쳐가는 경로가 더 짧으면 갱신
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    next_node[i][j] = k; // 거쳐간 정점 k를 저장!
                }
            }
        }
    }

    print_dist(g);
}

int main(void) {
    GraphType g = { 5,
        { { 0,   3,   8,   INF, -4  },
          { INF, 0,   INF, 1,   7   },
          { INF, 4,   0,   INF, INF },
          { 2,   INF, -5,  0,   INF },
          { INF, INF, INF, 6,   0   } }
    };

    floyd_path_reconstruction(&g);

    printf("========== [경로 추적 결과] ==========\n");
    // 정점 0에서 다른 모든 정점으로 가는 경로 출력 예시
    for (int j = 0; j < g.n; j++) {
        if (0 != j) {
            show_full_path(0, j);
        }
    }

    return 0;
}