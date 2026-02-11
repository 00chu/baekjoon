#include <stdio.h>

int main() {
	int num,max=1,number=0,j,d;
	int n[9];
	for (int i = 0; i < 9; i++) {
		scanf("%d", &num);
			if (num >= max) {
			max = num;
		}
		n[i]=num;
	}
	for (j = 0; j < 9; j++) {
		if (n[j] == max) {
			d=j+1;
		}
	}
	printf("%d\n", max);
	printf("%d", d);
}