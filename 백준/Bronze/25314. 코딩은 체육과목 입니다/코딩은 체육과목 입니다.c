#include<stdio.h>

int main(void) {
	int N, num;
	char result[1000];

	scanf("%d", &N);
	num = N / 4;

	for (int i = 0; i < num; i++) {
		printf("long ");
	}

	printf("int");

	return 0;
}