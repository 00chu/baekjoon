#include <stdio.h>
#include <stdlib.h>

typedef struct Coordinate {
	int x;
	int y;
} Coordinate;

Coordinate temp[100000]; // 병합에 필요한 임시 배열

void merge(Coordinate* array, int low, int mid, int high) {

	int L, M, H;
	L = low;
	M = mid + 1;
	H = low;

	// 배열을 정렬
	while (L <= mid && M <= high) {
		if (array[L].x < array[M].x) {
			temp[H++] = array[L++];
		}
		else if (array[L].x > array[M].x) {
			temp[H++] = array[M++];
		}
		else if (array[L].x == array[M].x) {
			if (array[L].y < array[M].y) {
				temp[H++] = array[L++];
			}
			if (array[L].y > array[M].y) {
				temp[H++] = array[M++];
			}
		}
	}

	// 두 배열 병합
	if (L > mid) {
		for (int i = M; i <= high; i++)
			temp[H++] = array[i];
	}
	else {
		for (int i = L; i <= mid; i++)
			temp[H++] = array[i];
	}


	for (int i = low; i <= high; i++) {// 임시배열을 원래에 배열로 복사
		array[i] = temp[i];
	}
}

void merge_sort(int array[], int low, int high) {
	if (low < high) {
		int mid = (low + high) / 2;  // 중간을 기준으로 리스트 분할
		merge_sort(array, low, mid); // 앞 리스트 정렬
		merge_sort(array, mid + 1, high); // 뒤 리스트 정렬
		merge(array, low, mid, high); // 정렬된 배열 병합
	}
}


int main(void) {
	int N, temp;

	scanf("%d", &N);

	Coordinate* num = (Coordinate*)malloc(sizeof(Coordinate) * N);

	for (int i = 0; i < N; i++) {
		scanf("%d %d", &num[i].x, &num[i].y);
	}

	merge_sort(num, 0, N - 1);

	for (int i = 0; i < N; i++) {
		printf("%d %d\n", num[i].x, num[i].y);
	}

    return 0;
}