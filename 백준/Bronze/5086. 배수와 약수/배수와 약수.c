#include <stdio.h>

int main(void) {
	int n = 1, m = 1;

	while (n != 0 && m != 0) {
		scanf("%d %d", &n, &m);
		if (n < m) {
			if (m % n == 0) {
				printf("factor\n");
			}
			else
				printf("neither\n");
		}
		if (n > m) {
			if (n % m == 0) {
				printf("multiple\n");
			}
			else
				printf("neither\n");
		}
	}

	return 0;
}
