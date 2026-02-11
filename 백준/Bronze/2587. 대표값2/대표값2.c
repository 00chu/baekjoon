#include<stdio.h>

int main(void) {
	int num = 0, temp, list[5], result = 0;
	for (int i = 0; i < 5; i++) {
		scanf("%d", &list[i]);
	}
	for (int i = 0; i < 4; i++) {
		for (int i = 0; i < 4; i++) {
			if (list[i] > list[i + 1]) {
				temp = list[i];
				list[i] = list[i + 1];
				list[i + 1] = temp;
			}
		}
	}
	for (int i = 0; i < 5; i++) {
		result += list[i];
	}
	printf("%d\n", result / 5);
	printf("%d\n", list[2]);
}