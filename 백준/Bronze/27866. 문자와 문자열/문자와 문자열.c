#include <stdio.h>

int main(void) {
	int i, n;
	char word[1000], alphabet;

	scanf("%s", &word);
	scanf("%d", &i);

	printf("%c", word[i - 1]);

	return 0;
}