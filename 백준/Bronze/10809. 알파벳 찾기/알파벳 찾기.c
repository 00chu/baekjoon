#include <stdio.h>

int main() {
	char S[100];
	char bet[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	int a[26];
	int loc;
	scanf("%s", &S);
	char *p;
	for (int i = 0; i < 26; i++) {
		p = strchr(S, bet[i]);
		loc = (int)(p - S);
		if (p != NULL) {
			a[i] = loc;
		}
		else {
			a[i] = -1;
		}
		
	}
	for (int j = 0; j < 26; j++) {
		printf("%d ", a[j]);
	}
	return 0;
}