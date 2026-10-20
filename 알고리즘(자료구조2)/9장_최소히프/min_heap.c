#include <stdio.h>
#include <stdlib.h>

#define MAX_ELEMENT 200

typedef struct {
    int key;
} element;

typedef struct {
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;

// 생성 함수
HeapType* create()
{
    return (HeapType*)malloc(sizeof(HeapType));
}

// 초기화 함수
void init(HeapType* h)
{
    h->heap_size = 0;
}

// 최소 히프 삽입 함수 (부모보다 작으면 위로 이동)
void insert_min_heap(HeapType* h, element item)
{
    int i;
    i = ++(h->heap_size);

    // 트리를 거슬러 올라가면서 부모 노드(i/2)와 비교 (부모보다 작으면 스왑)
    while ((i != 1) && (item.key < h->heap[i / 2].key)) {
        h->heap[i] = h->heap[i / 2];
        i /= 2;
    }
    h->heap[i] = item; // 새로운 노드를 삽입
}

// 최소 히프 삭제 함수 (가장 작은 루트 노드 삭제 후 정렬)
element delete_min_heap(HeapType* h)
{
    int parent, child;
    element item, temp;

    item = h->heap[1]; // 루트 노드(가장 작은 값)
    temp = h->heap[(h->heap_size)--]; // 맨 마지막 노드 가져옴
    parent = 1;
    child = 2;

    while (child <= h->heap_size) {
        // 자식 노드 중 더 '작은' 자식 노드를 찾는다.
        if ((child < h->heap_size) &&
            (h->heap[child].key > h->heap[child + 1].key))
            child++;

        // 임시 노드가 자식 노드보다 작거나 같으면 위치 확정
        if (temp.key <= h->heap[child].key) break;

        // 한 단계 아래로 이동
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}

int main(void)
{
    element e1 = { 10 }, e2 = { 5 }, e3 = { 30 };
    element e4, e5, e6;
    HeapType* heap;

    heap = create(); // 히프 생성
    init(heap);      // 초기화

    // 삽입
    insert_min_heap(heap, e1);
    insert_min_heap(heap, e2);
    insert_min_heap(heap, e3);

    // 삭제 (오름차순 출력: 5 -> 10 -> 30)
    printf("최소 히프 삭제 결과:\n");
    e4 = delete_min_heap(heap);
    printf("< %d > ", e4.key);
    e5 = delete_min_heap(heap);
    printf("< %d > ", e5.key);
    e6 = delete_min_heap(heap);
    printf("< %d > \n", e6.key);

    free(heap);
    return 0;
}