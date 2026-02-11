#include<stdio.h>

int main(void) {
	int N, M;
	int result[100] = { 0, };
	int i, j, temp;

	scanf("%d %d", &N, &M);

	for (int n = 0; n < N; n++) {	//
		result[n] = n + 1;
	}
	
	for (int n = 0; n < M; n++) {	// M번 공을 넣음
		scanf("%d %d", &i, &j);	// i = 바구니 1, j = 바구니2 
		i -= 1;
		j -= 1;
		for (i, j; i < j; i++, j--) { //★
			temp = result[i];
			result[i] = result[j];
			result[j] = temp;
		}
	}
	
	for (int i = 0; i < N; i++) {
		printf("%d ", result[i]);
	}

	return 0;
}