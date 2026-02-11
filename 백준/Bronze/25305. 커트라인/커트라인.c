#include<stdio.h>

int main(void) {
	int num = 0, temp, list[1000], n, k;

	scanf("%d %d", &n, &k);

	for (int i = 0; i < n; i++) {
		scanf("%d", &list[i]);
	}

	for (int i = 0; i < n - 1; i++) {
		for (int i = 0; i < n - 1; i++) {
			if (list[i] > list[i + 1]) {
				temp = list[i];
				list[i] = list[i + 1];
				list[i + 1] = temp;
			}
		}
	}

	printf("%d", list[n - k]);
}