#include <stdio.h>
#include <string.h>

int main(void) {
	char word[101], w1, w2;
	int count = 0;

	scanf("%s", word);

	for (int i = 0; i < strlen(word); i++) {
		if (word[i] == word[(strlen(word) - 1) - i]) {
			count++;
		}
	}

	if (count == strlen(word)) {
		printf("1");
	}
	else {
		printf("0");
	}

	return 0;
}