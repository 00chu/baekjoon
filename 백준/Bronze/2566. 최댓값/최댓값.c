#include<stdio.h>

int main(void) {
	int list[9][9], result = 0, x, y;

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			scanf("%d", &list[i][j]);
		}
	}

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (result <= list[i][j]) {
				result = list[i][j];
				x = i;
				y = j;
			}
		}
	}
	printf("%d\n%d %d", result, x + 1, y + 1);
	return 0;
}