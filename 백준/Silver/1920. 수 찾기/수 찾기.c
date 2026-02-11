#include <stdio.h>

int temp[100000]; // 병합에 필요한 임시 배열

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

int main(void) {
	int N, M, num;
	int arr[100000];

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	merge_sort(arr, 0, N - 1);

	scanf("%d", &M);

	for (int i = 0; i < M; i++) {
		scanf("%d", &num);

		if (num > arr[N - 1]) {
			printf("0\n");
		}
		else if (num < arr[0]) {
			printf("0\n");
		}
		else {
			int low = 0, high = N - 1, mid= (low + high) / 2;
			
			while (1) {
				mid = (low + high) / 2;
				
				if (mid < low || mid > high) {
					printf("0\n");
					break;
				}
				if (num == arr[mid]) {
					printf("1\n");
					break;
				}
				else if (num > arr[mid]) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
		}
	}

	return 0;
}