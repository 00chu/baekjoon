#include <stdio.h>
int main(void)
{
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);
	if(a<=b&& b>=c) {							/*a,c<b*/
		if (a <= c)							/*b>c>a*/
			printf("%d", c);
		else {								/*b>a>c*/
			printf("%d", a);
		}
	}
		else if (a<=c && c>=b) {						/*a,b<c*/
		if (a <= b) {							/*c>b>a*/
			printf("%d", b);
		}
		else {								/*c>a>b*/
			printf("%d", a);
		}
		}
		else if (a >= b && a >= c) {						/*b,c<a*/
		if (b >= c) {							/*a>b>c*/
			printf("%d", b);
		}
		else {								/*a>c>b*/
			printf("%d", c);
		}

	}
}