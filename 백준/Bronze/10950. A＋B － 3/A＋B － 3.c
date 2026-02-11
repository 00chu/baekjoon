#include <stdio.h>
int main(void) 
{
	int A=0, B=0,num=0;
	scanf("%d", &num);
	for(int i=0;i<num;i++) {
		scanf("%d %d", &A, &B);
		printf("%d\n", A + B);
	}
	return 0;
}