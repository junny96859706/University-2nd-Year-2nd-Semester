#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 100
#define INF 1000000 /* 무한대 (연결이 없는 경우) */ // oo을 표현하기 위해서

typedef struct GraphType {
    int n; // 정점의 개수
    int weight[MAX_VERTICES][MAX_VERTICES];
} GraphType;

int distance[MAX_VERTICES]; /* 시작정점으로부터의 최단경로 거리 */
int found[MAX_VERTICES];    /* 방문한 정점 표시 */ // S집합을 의미

// 아직 최단경로가 확정되지 않은 정점들 중, distance가 가장 작은 정점의 인덱스 반환
int choose(int distance[], int n, int found[])
{
    int i, min, minpos;
    min = INT_MAX; // 최소거리를 찾기 위해 일단 가장 큰값(무한대)으로 설정
    minpos = -1;   // 최소 거리를 가진 정점을 저장할 변수

    for (i = 0; i < n; i++) {
        if (distance[i] < min && !found[i]) {
            min = distance[i]; // 최저가 갱신
            minpos = i;        // 최저가를 가진 정점번호 저장
        }
    }
    return minpos;
}

// 출력함수
void print_status(GraphType* g)
{
    static int step = 1;
    printf("STEP %d: ", step++);
    printf("distance: ");
    for (int i = 0; i < g->n; i++) {
        if (distance[i] == INF)
            printf(" * ");
        else
            printf("%2d ", distance[i]);
    }
    printf("\n");
    printf("       found: ");
    for (int i = 0; i < g->n; i++) {
        printf("%2d ", found[i]);
    }
    printf("\n\n");
}

void shortest_path(GraphType* g, int start) // start: 시작정점
{
    int i, u, w;

    /* 초기화 */
    for (i = 0; i < g->n; i++) {
        distance[i] = g->weight[start][i]; // 초기화
        found[i] = FALSE;
    }

    found[start] = TRUE; /* 시작 정점 방문 표시 */
    distance[start] = 0;

    for (i = 0; i < g->n - 1; i++) {
        print_status(g);
        u = choose(distance, g->n, found);
        found[u] = TRUE; // 집합 S에 추가!

        for (w = 0; w < g->n; w++) {
            if (!found[w]) {
                // 더 짧은 경로를 발견하면 distance 값 갱신
                if (distance[u] + g->weight[u][w] < distance[w])
                    distance[w] = distance[u] + g->weight[u][w];
            }
        }
    }
}

int main(void)
{
    // 기말고사 문제 예상! -> 이 행렬만 보고 그래프를 그릴 줄 알아야 한다.
    // 가중치 행렬
    GraphType g = { 7,
        { { 0,   7,   INF, 3,   10,  INF, INF },
          { 7,   0,   4,   10,  2,   6,   INF },
          { INF, 4,   0,   2,   INF, INF, INF },
          { INF, 10,  2,   0,   11,  9,   4   },
          { 3,   2,   INF, 11,  0,   INF, 5   },
          { 10,  6,   INF, 9,   INF, 0,   INF },
          { INF, INF, INF, 4,   5,   INF, 0   } }
    };

    shortest_path(&g, 0);

    return 0;
}