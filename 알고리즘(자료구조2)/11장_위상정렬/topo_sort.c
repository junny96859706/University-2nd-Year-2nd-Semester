#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50

// 인접 리스트의 노드 구조체
typedef struct GraphNode {
    int vertex;
    struct GraphNode* link;
} GraphNode;

// 그래프 구조체 (인접 리스트 표현)
typedef struct GraphType {
    int n; // 정점의 개수
    GraphNode* adj_list[MAX_VERTICES]; // 노드 주소들을 담은 포인터 배열
} GraphType;

// 그래프 초기화
void graph_init(GraphType* g)
{
    int v;
    g->n = 0;
    for (v = 0; v < MAX_VERTICES; v++)
        g->adj_list[v] = NULL;
}

// 정점 삽입 연산
void insert_vertex(GraphType* g, int v)
{
    if (((g->n) + 1) > MAX_VERTICES) {
        fprintf(stderr, "그래프: 정점의 개수 초과");
        return;
    }
    g->n++;
}

// 간선 삽입 연산: v를 u의 인접 리스트에 삽입한다.
void insert_edge(GraphType* g, int u, int v)
{
    GraphNode* node;
    if (u >= g->n || v >= g->n) {
        fprintf(stderr, "그래프: 정점 번호 오류");
        return;
    }
    node = (GraphNode*)malloc(sizeof(GraphNode));
    node->vertex = v; // 정점 v 저장
    node->link = g->adj_list[u]; // 기존 u번 정점의 리스트 맨앞에 새노드 연결 (헤드 삽입)
    g->adj_list[u] = node; // u번 정점의 헤더 포인터를 새노드로 변경
}

// ==================== 스택 코드 ====================
#define MAX_STACK_SIZE 100
typedef int element;

typedef struct {
    element stack[MAX_STACK_SIZE];
    int top;
} StackType;

// 스택 초기화 함수
void init(StackType* s)
{
    s->top = -1;
}

// 공백 상태 검출 함수
int is_empty(StackType* s)
{
    return (s->top == -1);
}

// 포화 상태 검출 함수
int is_full(StackType* s)
{
    return (s->top == (MAX_STACK_SIZE - 1));
}

// 삽입함수
void push(StackType* s, element item)
{
    if (is_full(s)) {
        fprintf(stderr, "스택 포화 에러\n");
        return;
    }
    else s->stack[++(s->top)] = item;
}

// 삭제함수
element pop(StackType* s)
{
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    else return s->stack[(s->top)--];
}

// ==================== 위상 정렬 알고리즘 ====================
// 위상정렬을 수행한다.
int topo_sort(GraphType* g)
{
    int i;
    StackType s;
    GraphNode* node;

    // [1단계] 동적 할당으로 진입차수 배열 생성 및 초기화
    int* in_degree = (int*)malloc(g->n * sizeof(int));
    for (i = 0; i < g->n; i++)
        in_degree[i] = 0; // 모든 과목의 선수과목 수를 일단 0으로 초기화

    // [2단계] 모든 정점의 진입차수 계산
    for (i = 0; i < g->n; i++) {
        GraphNode* node = g->adj_list[i]; // 정점 i에서 나오는 간선들
        while (node != NULL) {
            in_degree[node->vertex]++;
            node = node->link;
        }
    }

    // [3단계] 진입차수가 0인 정점을 스택에 초기 삽입
    init(&s); // 스택 초기화 (top = -1)
    for (i = 0; i < g->n; i++) {
        if (in_degree[i] == 0) push(&s, i); // 진입차수가 0인 정점만 스택 삽입
    }

    // [4단계] 위상순서 생성 (스택이 빌 때까지 반복)
    while (!is_empty(&s)) {
        int w;
        w = pop(&s);
        printf("정점 %d -> ", w); // 정점 출력
        node = g->adj_list[w];   // 각 정점의 진입 차수를 변경

        while (node != NULL) {
            int u = node->vertex;
            in_degree[u]--; // 진입 차수를 감소
            if (in_degree[u] == 0) push(&s, u); // 새로 0이 된 정점을 스택에 푸시
            node = node->link; // 다음 정점
        }
    }

    free(in_degree);
    printf("\n");
    return (i == g->n); // 반환값이 1이면 성공, 0이면 사이클 존재로 실패
}

int main(void)
{
    GraphType g;

    graph_init(&g);
    insert_vertex(&g, 0);
    insert_vertex(&g, 1);
    insert_vertex(&g, 2);
    insert_vertex(&g, 3);
    insert_vertex(&g, 4);
    insert_vertex(&g, 5);
    insert_vertex(&g, 6);
    insert_vertex(&g, 7);
    insert_vertex(&g, 8);

    // 정점 0의 인접 리스트 생성
    insert_edge(&g, 0, 2);
    insert_edge(&g, 0, 4);
    insert_edge(&g, 0, 6);

    // 정점 1의 인접 리스트 생성
    insert_edge(&g, 1, 0);
    insert_edge(&g, 1, 7);

    // 정점 2의 인접 리스트 생성
    insert_edge(&g, 2, 4);
    insert_edge(&g, 2, 6);
    insert_edge(&g, 2, 8);

    // 정점 3의 인접 리스트 생성
    //insert_edge(&g, 3, 5);

    // 정점 4의 인접 리스트 생성
    insert_edge(&g, 4, 3);
    insert_edge(&g, 4, 7);
    insert_edge(&g, 4, 8);

    insert_edge(&g, 5, 0);
    insert_edge(&g, 5, 2);

    insert_edge(&g, 6, 3);
    insert_edge(&g, 6, 8);

    insert_edge(&g, 7, 6);

    insert_edge(&g, 8, 3);

    // 위상 정렬 실행
    printf("=== 위상 정렬 결과 ===\n");
    topo_sort(&g);

    return 0;
}