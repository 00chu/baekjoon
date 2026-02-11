#include <stdio.h>

int main() {
	int n, x, y, xMin = 10000, xMax = -10000, yMin = 10000, yMax = -10000;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);

		if (xMin >= x) {
			xMin = x;
		}
		if (xMax <= x) {
			xMax = x;
		}

		if (yMin >= y) {
			yMin = y;
		}
		if (yMax <= y) {
			yMax = y;
		}	
	}

	if (n == 1) {
		printf("0");
	}
	else {
		printf("%d", (xMax - xMin) * (yMax - yMin));
	}	
	
	return 0;
}
