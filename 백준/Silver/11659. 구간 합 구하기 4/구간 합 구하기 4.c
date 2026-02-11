#include <stdio.h>

int main(void) {
	int N, M, i, j, result = 0;
	int num[2][100000];

	scanf("%d %d", &N, &M);

	for (int k = 0; k < N; k++) {
		scanf("%d", &num[0][k]);
		 result += num[0][k];
		 num[1][k] = result;
	}

	for (int k = 0; k < M; k++) {
		scanf("%d %d", &i, &j);

		if (i == 1) {
			result = num[1][j - 1];
			printf("%d\n", result);
		}
		else if (i == j) {
			result = num[0][j - 1];
			printf("%d\n", result);
		}
		else {
			result = num[1][j - 1] - num[1][i - 2];
			printf("%d\n", result);
		}
	}

	return 0;
}
