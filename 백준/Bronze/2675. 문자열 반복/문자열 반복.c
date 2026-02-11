#include <stdio.h>

int main() {
	int n,R=0,len;
	char s[20];
	scanf("%d ", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &R);
		scanf("%s", s);

		len = strlen(s);

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < R; j++) {
				printf("%c", s[i]);
			}
		}
		printf("\n");
	}
	return 0;
}