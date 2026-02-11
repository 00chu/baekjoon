#include <stdio.h>

int main(void) {
	int N, result, num = 1; // 초기 상태

	scanf("%d", &N);

	for (int i = 1; i <= N; i++) {
		num *= 2;
		result = (num + 1) * (num + 1);
	}

	printf("%d", result);

	return 0;
}