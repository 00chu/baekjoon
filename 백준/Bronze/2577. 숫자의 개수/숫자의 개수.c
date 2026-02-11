#include <stdio.h>

int main() {
	int A, B, C, num[10] = { 0 }, n,temp;
	A >= 100;
	B >= 100;
	C >= 100;
	scanf("%d", &A);
	scanf("%d", &B);
	scanf("%d", &C);
	n= A * B * C;
	temp = n;
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (n >= 1 && n % 10 == i)
				num[i]++;
				n /= 10;
		}
		printf("%d\n", num[i]);
		n = temp;
	}
}