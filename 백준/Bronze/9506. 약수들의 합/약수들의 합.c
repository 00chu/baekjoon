#include <stdio.h>

int main(void) {
	int n = 0, count = 0, result = 0;
	int divisor[100000] = { 0, };

	while (1) { 
		scanf("%d", &n);

		if (n == -1) {
			break;
		}
		
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				divisor[count] = i;
				result += i;
				count++;
			}
		}

		if (n == result) {
			printf("%d = %d", n, divisor[0]);
			for (int i = 1; i < count; i++) {
				printf(" + %d", divisor[i]);
			}
			printf("\n");

		}
		else {
			printf("%d is NOT perfect.\n", n);
		}

		result = 0;
		count = 0;
	}
	return 0;
}
