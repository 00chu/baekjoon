#include <stdio.h>

int main(void) {
	int N, M, max = 0;
	int num[10000] = { 0, };

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &M);
		num[M - 1] += 1;
		if (max < M) {
			max = M;
		}
	}

	for (int i = 0; i < max; i++) {
		for (int j = 0; j < num[i]; j++) {
			printf("%d\n", i + 1);
		}
	}

	return 0;
}