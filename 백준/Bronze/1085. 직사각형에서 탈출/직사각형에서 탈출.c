#include <stdio.h>
#include <math.h>

int main() {
	int x, y, min, length;
	int xy[2], coordinate[4] = { 0, };
	
	scanf("%d %d %d %d", &xy[0], &xy[1], &coordinate[2], &coordinate[3]);

	for (int i = 0; i < 2; i++) {
		for (int j = i; j < 4; j += 2) {
			length = abs(xy[i] - coordinate[j]);
			if ((i == 0 && j == 0) || min > length) {
				min = length;
			}
		}
	}

	printf("%d", min);
	
	return 0;
}