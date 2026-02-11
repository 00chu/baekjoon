#include <stdio.h>

int main() {
	int N, temp, count = 0, flag;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		flag = 0;

		scanf("%d", &temp);

		if (temp == 1) {
			flag = 1;
		}
		else {
			for (int j = 2; j < temp; j++) {
				if (temp % j == 0) {
					flag = 1;
					break;
				}
			}
		}
		
		if (flag == 0) {
			count++;
		}
	}
	printf("%d", count);
	return 0;
}