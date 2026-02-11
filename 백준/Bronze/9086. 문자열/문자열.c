#include <stdio.h>
#include <string.h>

int main(void) {
	int T;
	char word[10][1000];

	scanf("%d", &T);
	

	for (int i = 0; i < T; i++) {
		scanf("%s", &word[i]);
	}

	for (int i = 0; i < T; i++) {
		printf("%c%c\n", word[i][0], word[i][strlen(word[i]) - 1]);
	}
	

	return 0;
}