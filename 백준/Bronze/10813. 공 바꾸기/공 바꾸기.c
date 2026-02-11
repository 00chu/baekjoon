#include<stdio.h>

int main(void) {
	int N, M;
	int result[100] = {0, };	// 모든 배열을 0으로 초기화.
	int i, j, temp;

	scanf("%d %d", &N, &M);

	for (int n = 0; n < N; n++) {	// N번의 바구니에 N번이 적힌 공 넣음
		result[n] = n + 1;
	}
	
	for (int n = 0; n < M; n++) {	// M번 공을 넣음
		scanf("%d %d", &i, &j);	// i = 바구니 1, j = 바구니2 
		temp = result[i - 1];	// i번 바구니와 j번 바구니의 공을 교환
		result[i - 1] = result[j - 1]; 
		result[j - 1] = temp;
	}
	
	for (int i = 0; i < N; i++) {
		printf("%d ", result[i]);
	}
	return 0;
}