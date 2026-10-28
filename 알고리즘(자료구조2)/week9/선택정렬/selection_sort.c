#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define swap(x,y,t) ((t)=(x) , (x)=(y),(y)=(t))
#define MAX_SIZE 10

void selection_sort(int list[], int n) { //선택정렬함수
	int i, j, least, temp;
	for (i = 0; i < n-1; i++) {
		least = i;
		for (j = i + 1; j < n; j++) {
			if (list[j] < list[least])
				least = j;
		}
		swap(list[i], list[least], temp);
	}
}

void insertion_sort(int list[],int n) { //삽입정렬함수 
	int i, j, key;
	for (i = 1; i < n; i++) {
		key = list[i];
		for (j = i - 1; j >= 0 && list[j] > key; j--) {
			list[j + 1] = list[j];
		}
		list[j+1] = key;

	}
}

void bubble_sort(int list[], int n) { //버블정렬함수
	int i, j, temp;
	for (i = n - 1; i > 0; i--) {
		for (j = 0; j < i; j++) { //앞뒤레코드 비교
			if (list[j] > list[j + 1])
				swap(list[j], list[j + 1], temp);
		}
	}
}

int main() {
	int n = MAX_SIZE;
	int list[MAX_SIZE];
	srand((unsigned int)time(NULL)); //for문안에 삽입하면 안된다!!(for문은 1초보다 빠르기 때문) 

	for (int i = 0; i < n; i++) {
		list[i] = rand() % 100;
	}

	selection_sort(list, n);

	for (int i = 0; i < n; i++) {
		printf("%d ", list[i]);
	}

	return 0;
}