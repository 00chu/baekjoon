#include <stdio.h>
int main(void) 
{
	int n=0, x=0, a[10000];
	scanf("%d %d", &n, &x);
	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for (int i = 0; i < n; i++) {
		if (x > a[i]) {
			printf("%d ", a[i]);
		}
	}
	
	return 0;
}