#include <stdio.h>
int main(void) 
{
	int h=0,m=0,time;
	scanf("%d %d", &h, &m);
	if (h == 0) {
		h = 24;
	}
	time=(h * 60 + m)-45;
	h = time / 60;
	m = time % 60;
	if (h == 24) {
		h = 0;
	}
	printf("%d %d", h, m);
}