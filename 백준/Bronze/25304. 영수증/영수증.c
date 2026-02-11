#include<stdio.h>

int main(void) {
	int price, count, n1, n2, all, compare = 0;
	scanf("%d", &price);
	scanf("%d", &count);
	for (int i = 1; i <= count; i++) {
		scanf("%d %d", &n1, &n2);
		all = n1 * n2;
		compare = compare + all;
	}
	if (compare == price) {
		printf("Yes");
	}
	else
		printf("No");
}