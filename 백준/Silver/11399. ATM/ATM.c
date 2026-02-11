#include <stdio.h>

void quickSort(int array[], int low, int high) {
	int L = low, H = high;
	if (high < 1) return; //원소 개수가 1개면 바로 출력함

	int pivot = array[(low + high) / 2]; 	//가운데 원소를  기준원소로 삼음

	while (low <= high) {
		while (array[low] < pivot) low++; //기준원소보다 low원소가 작을 때 low를 증가시킨다
		while (array[high] > pivot) high--; //기준원소보다 high원소가 클 때 high를 감소시킨다
		if (low <= high) {
			int tmp = array[low];			//원소를 교환시킨다
			array[low] = array[high];
			array[high] = tmp;
			low++;
			high--;
		}
	} while (low <= high);

	//재귀
	if (L < high)
		quickSort(array, L, high); //왼쪽 배열 재귀

	if (low < H)
		quickSort(array, low, H); //오른쪽 배열 재귀

}

int main(void){
	int A[1000];
	int N, sum = 0;
	
	scanf("%d", &N);
	
	for(int i = 0; i < N; i++){
		scanf("%d", &A[i]);
	}	
	
	quickSort(A, 0, N - 1);
	
	for(int i = 0; i < N; i++){
		sum += A[i] * (N - i);
	}
	
	printf("%d", sum);
	
	return 0;
}	
