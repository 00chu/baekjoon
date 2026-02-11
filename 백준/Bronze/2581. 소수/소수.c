#include <stdio.h>

int main() {
	int M, N, flag, sum = 0, min;

	scanf("%d", &M);
	scanf("%d", &N);

	for (int i = M; i <= N; i++) {
		flag = 0;

		if (i == 1) {
			flag = 1;
		}
		else {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = 1;
					break;
				}
			}
		}
		
		if (flag == 0) {
			if (sum == 0) {
				min = i;
			}
			sum += i;
		}
	}
	if (sum == 0) {
		printf("-1");
	}
	else {
		printf("%d\n", sum);
		printf("%d", min);
	}
	
	return 0;
}