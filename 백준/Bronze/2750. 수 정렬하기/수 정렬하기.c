#include<stdio.h>

int main(void) {
	int num = 0, temp, list[1000];
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d", &list[i]);
	}
	for (int i = 0; i < num - 1; i++) {
		for (int i = 0; i < num - 1; i++) {
			if (list[i] > list[i + 1]) {
				temp = list[i];
				list[i] = list[i + 1];
				list[i + 1] = temp;
			}
		}
	}
	for (int i = 0; i < num; i++) {
		printf("%d\n", list[i]);
	}
}