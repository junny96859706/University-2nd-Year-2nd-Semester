#pragma once

#define TRUE 1
#define FALSE 0
#define INF 999

struct Edge {			// 간선을 나타내는 구조체
	int start, end, weight;
};

typedef struct GraphType {
	int n;					// 정점의 개수
	int n_e;				// 간선의 개수
	int** adj_mat;			// 인접 행렬
	struct Edge* edges;		// 간선 정보
} GraphType;
