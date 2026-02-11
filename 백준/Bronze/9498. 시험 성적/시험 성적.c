#include <stdio.h>
int main(void) 
{
	int A;
	scanf("%d", &A);

	if (90<=A&&A<=100) {
		printf("A");
	}
	else if (80 <= A && A <= 89) {
		printf("B");
	}
	else if (70 <= A && A <= 79) {
		printf("C");
	}
	else if (60 <= A && A <= 69) {
		printf("D");
	}
	else {
		printf("F");
	}
	return 0;
}