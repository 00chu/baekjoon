#include <stdio.h>

int main(void) {
	int N;

	scanf("%d", &N);

	for (int i = 1, temp = N; i <= 2 * N - 1, temp >= 0; i++, temp--) {
		if (i <= (2 * N - 1) / 2) {
			for (int j = temp - 1; j > 0; j--) {
				printf(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) {
				printf("*");
			}
		}
		else if (N == i) {
			for (int j = 0; j < 2 * i - 1; j++) {
				printf("*");
			}
			temp = N - 1;
		}
		else {
			for (int j = 0; j < i - N; j++) {
				printf(" ");
			}
			for (int j = 2 * temp; j >= 0; j--) {
				printf("*");
			}
		}
		printf("\n");
	}

	return 0;
}