#include <stdio.h>

int gcd(int a, int b)
{
	if (b == 0)
	{
		return a;
	}
	else
	{
		return gcd(b, a % b);
	}
}

int main(void) {
	int denominator[2], numerator[2];
	int den, num = 0, n;

	for (int i = 0; i < 2; i++) {
		scanf("%d %d", &numerator[i], &denominator[i]);
	}

	den = denominator[0] * denominator[1];

	for (int i = 0, j = 1; i < 2, j >= 0; i++, j--) {
		num += numerator[j] * denominator[i];
	}

	n = gcd(num, den);

	printf("%d %d", num / n, den / n);

	return 0;
}
