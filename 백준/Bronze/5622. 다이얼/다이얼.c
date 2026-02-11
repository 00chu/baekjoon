#include <stdio.h>

int main(void) {

	int time[] = { 3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10 };
	char num[16];
	int sum = 0;

	scanf("%s", &num);
	for (int i = 0; num[i] != '\0';i++) {
		sum += time[num[i] - 'A'];
	}
	printf("%d",sum);
	return 0;
}