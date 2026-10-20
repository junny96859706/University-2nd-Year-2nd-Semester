#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 100
#define INF 1000000

typedef struct GraphType {
    int n;
    int weight[MAX_VERTICES][MAX_VERTICES];
} GraphType;

int distance[MAX_VERTICES];
int found[MAX_VERTICES];
int prev[MAX_VERTICES]; // 슬라이드에 추가된 경로 저장용 배열

int choose(int distance[], int n, int found[]) {
    int min = INF;
    int minpos = -1;
    for (int i = 0; i < n; i++) {
        if (distance[i] < min && !found[i]) {
            min = distance[i];
            minpos = i;
        }
    }
    return minpos;
}

// 역추적(prev) 배열을 사용해 실제 경로를 출력하는 함수
void print_path(int start, int end) {
    int path[MAX_VERTICES];
    int count = 0;
    int curr = end;

    // 목적지부터 시작점까지 거꾸로 추적
    while (curr != -1) {
        path[count++] = curr;
        if (curr == start) break;
        curr = prev[curr];
    }

    printf("정점 %d까지의 최단 경로: ", end);
    for (int i = count - 1; i >= 0; i--) {
        printf("%d", path[i]);
        if (i > 0) printf(" -> ");
    }
    printf(" (총 비용: %d)\n", distance[end]);
}

void shortest_path(GraphType* g, int start) {
    for (int i = 0; i < g->n; i++) {
        distance[i] = g->weight[start][i];
        found[i] = FALSE;

        // 경로 초기화: 직속으로 연결된 정점이면 직전 정점을 start로 지정
        if (g->weight[start][i] != INF && i != start)
            prev[i] = start;
        else
            prev[i] = -1;
    }

    found[start] = TRUE;
    distance[start] = 0;
    prev[start] = -1;

    for (int i = 0; i < g->n - 1; i++) {
        int u = choose(distance, g->n, found);
        if (u == -1) break;
        found[u] = TRUE;

        for (int z = 0; z < g->n; z++) {
            if (!found[z] && g->weight[u][z] != INF) {
                // 더 짧은 경로 발견 시 distance 값 및 직전 방문 정점(prev) 갱신!
                if (distance[u] + g->weight[u][z] < distance[z]) {
                    distance[z] = distance[u] + g->weight[u][z];
                    prev[z] = u; // prev[z] = u; (슬라이드 핵심 연산)
                }
            }
        }
    }
}

int main(void) {
    GraphType g = { 6,
        { { 0,   10,  30,  15,  INF, INF },
          { 10,  0,   INF, INF, 20,  INF },
          { 30,  INF, 0,   INF, INF, 5   },
          { 15,  INF, INF, 0,   INF, 20  },
          { INF, 20,  INF, INF, 0,   15  },
          { INF, INF, 5,   20,  15,  0   } }
    };

    int start = 0;
    shortest_path(&g, start);

    printf("=== 다익스트라 최단 경로 및 경로 추적 결과 ===\n");
    for (int i = 0; i < g.n; i++) {
        print_path(start, i);
    }

    return 0;
}