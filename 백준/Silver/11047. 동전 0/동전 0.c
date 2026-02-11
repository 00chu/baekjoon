#include <stdio.h>

int main(void) {
	int N, K, k, result = 0, n = 0, j = 0;
	int A[10];

	scanf("%d %d", &N, &K);

	for (int i = 0; i < N; i++) {
		scanf("%d", &A[i]);
	}

	for (int i = N - 1; i >= 0; i--) { // 배열이 끝날 때까지
		if (K >= A[i]) { // K값이 배열 내의 숫자보다 클 때
			n += K / A[i];
			K %= A[i];
		}
	}

	printf("%d", n);

	return 0;
}