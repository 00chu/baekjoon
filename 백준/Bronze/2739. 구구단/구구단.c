#include <stdio.h>
int main(void) 
{
	int n=0,k;
	scanf("%d", &n);
	for (int i = 1; i < 10; i++) {
		k = n * i;
		printf("%d * %d = %d\n", n,i,k);
	}
}