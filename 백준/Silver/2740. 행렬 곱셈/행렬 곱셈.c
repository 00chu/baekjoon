#include <stdio.h>

int main(void) {
	int N, M, K, temp;
	int A[100][100], B[100][100], result[100][100];

	scanf("%d %d", &N, &M); // 행렬 A의 크기
	for (int i = 0; i < N; i++) { // 행렬 A의 원소
		for (int j = 0; j < M; j++) {
			scanf("%d", &A[i][j]);
		}
	}


	scanf("%d %d", &M, &K); //행렬 B의 크기
	for (int i = 0; i < M; i++) { //행렬 B의 원소
		for (int j = 0; j < K; j++) {
			scanf("%d", &B[i][j]);
		}
	}



	for (int i = 0; i < N; i++) { //최종 결과를 계산하는 부분
		for (int j = 0; j < K; j++) {
			temp = 0;
			for (int k = 0; k < M; k++) {
				temp += A[i][k] * B[k][j]; 
			}
			result[i][j] = temp;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < K; j++) {
			printf("%d ", result[i][j]);
		}
		printf("\n");;
	}

	return 0;
}