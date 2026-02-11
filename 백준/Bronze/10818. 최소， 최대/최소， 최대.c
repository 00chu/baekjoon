#include <stdio.h>

int main() {
	int num=0,n,i,min=1000000,max=-1000000;
	scanf("%d", &num);
	for (i = 0; i < num; i++) {
		scanf("%d", &n);
		if (n <= min) {
			min = n;
		}
		if (n >= max) {
			max = n;
		}
	}
	printf("%d %d", min, max);
}