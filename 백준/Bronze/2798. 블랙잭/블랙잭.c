#include <stdio.h>

int main(void) {
	int N, M;
	int card[100];
	int a, b, c, result = 0, temp = 0;

	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		scanf("%d", &card[i]);
	}
	for (int i = 0; i < N; i++) {
		a = card[i];
		for (int j = i + 1; j < N; j++) {
			b = card[j];
			for (int k = j + 1; k < N; k++) {
				c = card[k];
				temp = a + b + c;
				if (result<= temp && temp <= M) {
					result = temp;
				}
			}
		}
	}
	printf("%d", result);
}