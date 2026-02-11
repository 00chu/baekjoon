#include <stdio.h>

int main() {
	int angle[3], result = 0, count = 0, sameAngle = 0;

	for (int i = 0; i < 3; i++) {
		scanf("%d", &angle[i]);
		if (angle[i] == 60) {
			count++;
		}
		result += angle[i];
	}

	for (int i = 0; i < 2; i++) {
		for (int j = i + 1; j < 3; j++) {
			if (angle[i] == angle[j]) {
				sameAngle++;
			}
		}
	}

	if (count == 3) {
		printf("Equilateral");
	}
	else if (result == 180 && sameAngle == 1) {
		printf("Isosceles");
	}
	else if (result == 180 && sameAngle == 0) {
		printf("Scalene");
	}
	else if (result != 180) {
		printf("Error");
	}
	
	return 0;
}
