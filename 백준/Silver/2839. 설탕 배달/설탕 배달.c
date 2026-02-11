#include <stdio.h>

int main(void) {
	int N, temp, result = 0, count = 0;

	scanf("%d", &N);

	while (N > 0) {
		if (N % 5 == 0) {
			count += N / 5;
			N %= 5;
			break;
		}
		else { // 3으로 나누면 최대 봉지수가 나올 것
			N -= 3;
			count++;
		}
	}	

	if (N == 0) {
		printf("%d", count);
	}
	else {
		printf("-1");
	}

	return 0;
}