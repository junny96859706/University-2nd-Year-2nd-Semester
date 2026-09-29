#include <stdio.h>
#include <stdlib.h> //동적메모리 할당,프로그램종료등 C언어의 기본적인 시스템기능을 사용할때 꼭 필요한 헤더파일
#define MAX_ELEMENT 200

typedef struct {
	int key;
} element;

typedef struct {
	element heap[MAX_ELEMENT];
	int heap_size;
}HeapType;

//------------------------------------------------------------------------------------------//

HeapType* create() { //생성함수
	return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h) { //초기화 함수
	h->heap_size = 0;
}

//-----------------------------------------------------------------------------------------//

void insert_max_heap(HeapType* h, element item) { //삽입함수
	int i;
	i = ++(h->heap_size);

	//트리를 거슬러 올라가면서 부모노드와 비교하는 과정
	while (i != 1 && item.key > h->heap[i / 2].key) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	//element 구조체 전체를 통째로 복사해서 넣음 (정상!)
	h->heap[i] = item; //새로운 노드를 삽입 
}

//-----------------------------------------------------------------------------------------//

element delete_max_heap(HeapType* h) { //삭제함수
	int parent, child;
	element item, temp;

	item = h->heap[1]; //루트노드 반환
	temp = h->heap[(h->heap_size)--]; //temp에 사원(맨밑단)을 가져오고, 힙크기-1
	parent = 1; 
	child = 2;

	while (child <= h->heap_size) {
		//2단계:현재 노드의 자식노드중 더 큰 자식 노드를 찾는다.
		if ( child < h->heap_size && (h->heap[child].key < h->heap[child + 1].key))
			child += 1;
		//3단계:밑단사원과 자식 비교
		if (temp.key >= h->heap[child].key) 
			break;
		h->heap[parent] = h->heap[child];
		parent = child;
		child = child * 2;
	}
	
	h->heap[parent] = temp;
	return item;
}

//------------------------------------------------------------------------------------------//

int main() {
	element e1 = { 10 }, e2 = { 5 }, e3 = { 30 };
	element e4, e5, e6;
	HeapType* heap;

	heap = create(); //히프생성
	init(heap);

	insert_max_heap(heap, e1);
	insert_max_heap(heap, e2);
	insert_max_heap(heap, e3);

	e4 = delete_max_heap(heap);
	printf("< %d >", e4.key);
	e5 = delete_max_heap(heap);
	printf("< %d >", e5.key);
	e6 = delete_max_heap(heap);
	printf("< %d >", e6.key);

	free(heap);
	return 0;
}