#include <stdio.h>

int main() {
	int length[3], sameLength = 0, maxLength = 0, sumLength = 0;

	
	while (1) {
		scanf("%d %d %d", &length[0], &length[1], &length[2]);

		if (length[0] == 0 && length[1] == 0 && length[2] == 0) {
			break;
		}

		sameLength = 0;
		maxLength = 0;
		sumLength = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (length[i] == length[j]) {
					sameLength++;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			if (maxLength <= length[i]) {
				maxLength = length[i];
			}
			sumLength += length[i];
		}
	
		if (maxLength >= (sumLength - maxLength)) {
			printf("Invalid\n");
		}
		else {
			if (sameLength == 3) {
				printf("Equilateral\n");
			}
			else if (sameLength == 1) {
				printf("Isosceles\n");
			}
			else if (sameLength == 0) {
				printf("Scalene\n");
			}
		}
	}

	return 0;
}
