#include <stdio.h>
int main(void)
{
	int a[5];
	int b=0,sum=0;
	for (int i = 0; i < 5; i++) {
		scanf("%d", &b);
		if (b >= 40) {
			a[i] = b;
		}
		else {
			a[i] = 40;
		}
	}
	for (int i = 0; i < 5; i++) {
		sum += a[i];
	}
	printf("%d", sum / 5);
	return 0;
}