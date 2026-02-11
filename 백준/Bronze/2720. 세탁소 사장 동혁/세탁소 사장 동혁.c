#include <stdio.h>

int main(void) {
	int T, change, quarter = 0, dime = 0, nickel = 0, penny = 0;

	scanf("%d", &T);

	for (int i = 0; i < T; i++) {
		scanf("%d", &change);

		while (change > 0) {
			if (change >= 25) {
				quarter = change / 25;
				change %= 25;
			}
			else if (change >= 10 && change < 25) {
				dime = change / 10;
				change %= 10;
			}
			else if (change >= 5 && change < 10) {
				nickel = change / 5;
				change %= 5;
			}
			else if (change < 5) {
				penny = change;
				change = 0;
			}
		}
		printf("%d %d %d %d\n", quarter, dime, nickel, penny);
		quarter = 0, dime = 0, nickel = 0, penny = 0;
	}

	

	return 0;
}