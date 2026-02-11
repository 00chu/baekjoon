#include<stdio.h>

int main(void) {
	int num, find, list[100], result = 0;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d ", &list[i]);
	}
	scanf("%d", &find);
	for (int i = 0; i < num; i++) {
		if (list[i] == find) {
			result = result + 1;
		}
	}
	printf("%d", result);
}