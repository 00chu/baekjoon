#include<stdio.h>

int main(void) {
	int n1, n2, result, num1, num2;
	int N1[3], N2[3];
	int pow[3] = { 1, 10, 100 };

	scanf("%d %d", &n1, &n2);

	num1 = n1;
	num2 = n2;

	for (int i = 2; i >= 0; i--) {
		N1[i] = n1 / pow[i];
		n1 = n1 % pow[i];
		N2[i] = n2 / pow[i];
		n2 = n2 % pow[i];
	}

	for (int i = 0; i <= 2; i++) {
		if (N1[i] > N2[i]) {
			result = num1;
			break;
		}
		else if (N1[i] < N2[i]) {
			result = num2;
			break;
		}
	}

	if (result == num1) {
		for (int i = 0; i <= 2; i++) {
			printf("%d", N1[i]);
		}
	}
	else {
		for (int i = 0; i <= 2; i++) {
			printf("%d", N2[i]);
		}
	}

	return 0;
}