#include <stdio.h>
int main(void)
{
	int a, b, number, n = -1, i = 0, k = 0;
	scanf("%d", &number);
	a = number / 10;
	b = number % 10;
	while (number != n) {
		i = a + b;
		n = b * 10 + i % 10;
		k++;
		a = n / 10;
		b = n % 10;
	}
	printf("%d", k);
	return 0;
}