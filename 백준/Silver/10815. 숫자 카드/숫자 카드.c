#include <stdio.h>

int temp[500000] = {0, }; // 병합에 필요한 임시 배열

void merge(int array[], int low, int mid, int high) {

	int L, M, H;
	L = low;
	M = mid + 1;
	H = low;

	// 배열을 정렬
	while (L <= mid && M <= high) {
		if (array[L] <= array[M])
			temp[H++] = array[L++];
		else
			temp[H++] = array[M++];
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

void merge_search(int array[], int num, int low, int high) {
	int mid = (low + high) / 2;
	while (1) {
		mid = (low + high) / 2;
		if (array[mid] == num || array[low] == num || array[high] == num) {
			printf("1 ");
			return 0;
		}
		else if (mid == high || mid == low) {
			break;
		}
		else if (array[mid] > num) {
			high = mid;
		}
		else if (array[mid] < num) {
			low = mid;
		}
		
	}
	printf("0 ");
}

int main() {
	int N, M, temp;
	int array[500000];

	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &array[i]);
	}

	merge_sort(array, 0, N - 1);

	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d", &temp);
		merge_search(array, temp, 0, N - 1);
	}

	return 0;
}