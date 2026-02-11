#include <stdio.h>

int main(void) {
	int number, count = 1, countN, temp, div = 1;
	int num[15] = { 0, };

	scanf("%d", &number);

	while (number > div) {
		div *= 10;
		count++;
	}

	countN = count;

	while (count != 0) {
		if ((number / div) == 0 && count == countN) {
			div /= 10;
			count--;
			countN = count;
		}
		num[--count] = number / div;
		number %= div;
		div /= 10;
	}


	for (int i = 0; i < countN; i++) {
		for (int j = 0; j < (countN - 1) - i; j++) {
			if (num[j] < num[j + 1]) {
				temp = num[j];
				num[j] = num[j + 1];
				num[j + 1] = temp;
			}
		}
	}

	for (int i = 0; i < countN; i++) {
		printf("%d", num[i]);
	}

	return 0;
}