#include<stdio.h>

int main(void) {
	int N, M;
	int result[100] = {0, };
	int i, j, k;

	scanf("%d %d", &N, &M);
	
	for (int n = 0; n < M; n++) { 
		scanf("%d %d %d", &i, &j, &k);
		for (i; i <= j; i++) {
			result[i - 1] = k;
		}
	}
	
	for (int i = 0; i < N; i++) {
		printf("%d ", result[i]);
	}
	return 0;
}