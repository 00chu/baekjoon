#include <stdio.h>
int main(void) 
{
	int A,B,B1,b1,b2,b3;
	scanf("%d", &A);
	scanf("%d", &B);
	B1 = B;
	b3 = B1 / 100;
	B1=B1 - b3*100;
	b2 = B1 / 10;
	B1=B1 - b2*10;
	b1 = B1 / 1;
	printf("%d\n", A * b1);
	printf("%d\n", A * b2);
	printf("%d\n", A * b3);
	printf("%d\n", A * B);
	return 0;
}