#include <stdio.h>
int main(void) 
{
	int num;
	scanf("%d", &num);
		for(int i=1;i<=num;i++) {
			for (int k = num - i; k > 0;k--) {
				printf(" ");
			}
			for (int k = 1; k <= i; k++) {
				printf("*");
			}
			printf("\n");
		}
	return 0;
}