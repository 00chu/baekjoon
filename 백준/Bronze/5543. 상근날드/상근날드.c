#include <stdio.h>
int main(void)
{
	int a[3],b[2],sum;
	int c=0,d=0,minimum=5000;
	for (int i = 0; i < 3; i++) {
		scanf("%d", &c);
		a[i] = c;
	}
	for (int i = 0; i < 2; i++) {
		scanf("%d", &d);
		b[i] = d;
	}
	for (int i = 0; i < 2; i++) {
		for (int k = 0; k < 3; k++) {
			sum= b[i] + a[k]-50;
			if (sum < minimum)
				minimum = sum;
		}
	}
	printf("%d",minimum);
	return 0;
}