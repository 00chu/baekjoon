#include <stdio.h>

int main(void) {
	char word[5][15] = { 0, }, result[75] = { 0, };
	int count = 0;

	for (int i = 0; i < 5; i++) {
		scanf("%s", word[i]);
	}

	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 5; j++) {
			if (word[j][i]) {
				result[count++] = word[j][i];
			}
		}
	}

	count = 0;

	while (result[count]) {
		printf("%c", result[count]);
		count++;
	}

	return 0;
}
