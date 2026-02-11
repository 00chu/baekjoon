#include <stdio.h>

int main(void)
{
	char a[1000000] = { 0, };
	int num=0,len;

	gets(a);
	len = strlen(a);
	
	for (int i = 0; i < len; i++) {
		if (a[i] == ' ') {
			if (a[i - 1] != '  ' && a[i + 1] != ' ') {
				num++;
			}
		}
	} if (a[0] == ' ')
		num--;
	if (a[len - 1] == ' ')
		num--; 

	printf("%d", num+1);

	return 0;
}