#include <stdio.h>

int main(void) {
	int A, B, V, sum = 0, count = 1;

	scanf("%d %d %d", &A, &B, &V);

	count = (V - B - 1) / (A - B) + 1;

	printf("%d", count);
	
	return 0;
}