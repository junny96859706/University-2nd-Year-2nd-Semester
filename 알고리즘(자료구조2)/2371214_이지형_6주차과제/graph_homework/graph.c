#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>
#include "graph.h"

extern void kruskal(GraphType*, int);
extern void prim(GraphType*, int, int);
extern void shortest_path(GraphType*, int);
extern void floyd(GraphType*, int, int);

void main(int argc, char* argv[])
{
	FILE* fp;
	int num_node;
	int i, j, prim_st, short_st, fl_st, fl_end, st_kind = 0, max_e = 0;
	GraphType g;

	if (argc != 2) {
		printf("<Usage>: graph graph.txt\n");
		return;
	}
	fp = fopen(argv[1], "r");

	if (fp == NULL) {
		printf("파일을 열 수 없습니다! (%s)\n", argv[1]);
		return;
	}

	if (fp != NULL) {
		fscanf(fp, "%d", &num_node);
		g.n = num_node;
		g.n_e = 0;
		g.adj_mat = (int**)malloc(sizeof(int*) * num_node);		// 인접행렬 표현
		for (i = 0; i < num_node; i++) {
			g.adj_mat[i] = (int*)malloc(sizeof(int) * num_node);
			for (j = 0; j < num_node; j++)
				g.adj_mat[i][j] = 0;
		}
		max_e = num_node * num_node / 2;
		g.edges = (struct Edge*)malloc(sizeof(struct Edge) * max_e);	// for Kruskal alg.
		for (i = 0; i < max_e; i++) {
			g.edges[i].start = g.edges[i].end = 0;
			g.edges[i].weight = INF;
		}
		for (i = 0; i < num_node; i++)
			for (j = 0; j < num_node; j++)
				fscanf(fp, "%d", &(g.adj_mat[i][j]));
		for (i = 0; i < num_node; i++)				// 인접행렬에서 LL을 이용한 간선 리스트 만들기 for Kruskal alg.
			for (j = 0; j < i; j++)
				if (g.adj_mat[i][j] > 0 && g.adj_mat[i][j] != INF) {	// only valid edges
					g.edges[g.n_e].start = i + 1;	// 노드 번호는 1부터 시작
					g.edges[g.n_e].end = j + 1;
					g.edges[g.n_e++].weight = g.adj_mat[i][j];
				}
		printf("\n그래프 인접행렬 표현: \n");
		for (i = 0; i < num_node; i++) {
			for (j = 0; j < num_node; j++)
				printf("%3d ", g.adj_mat[i][j]);
			printf("\n");
		}
		printf("\n");
	}

	// MST program
	printf("\n크루스칼 신장 트리 알고리즘 \n");
	printf("최소(0을 입력) 또는 최대(1을 입력) 신장 트리? "); scanf("%d", &st_kind);
	kruskal(&g, st_kind);

	printf("\n프림 신장 트리 알고리즘 \n");
	printf("최소(0을 입력) 또는 최대(1을 입력) 신장 트리? "); scanf("%d", &st_kind);
	printf("프림 알고리즘을 위한 출발 노드 번호? "); scanf("%d", &prim_st);
	prim(&g, prim_st - 1, st_kind);

	// shortest path program
	printf("\nDijkstra 최단 경로 알고리즘을 위한 출발 노드 번호? "); scanf("%d", &short_st);
	shortest_path(&g, short_st - 1);

	printf("\nFloyd 최단 경로 알고리즘을 위한 출발 노드 번호와 도착 노드 번호? ");
	scanf("%d %d", &fl_st, &fl_end);
	floyd(&g, fl_st, fl_end);

	fclose(fp);
}