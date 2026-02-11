#include<stdio.h>

int main(void) {
	int d[4], result = 0, num = 0;

	scanf("%d %d %d", &d[1], &d[2], &d[3]);
	num = d[1];

	if (d[1] == d[2] || d[2] == d[3] || d[1] == d[3]) {
		if (d[1] == d[2] && d[2] == d[3]) {
			result = 10000 + d[1] * 1000;
		}
		else {
			if (d[1] == d[3])
				result = 1000 + d[1] * 100;
			else{
				for (int i = 1; i <= 2; i++) {
					if (d[i] == d[i + 1]) {
						num = d[i + 1];
					}
				}
				result = 1000 + num * 100;
			}
		}
	}

	else {
		for (int i = 1; i <= 2; i++) {
			if (num <= d[i + 1])
				num = d[i + 1];
		}
		result = num * 100;
	}

	printf("%d", result);
}