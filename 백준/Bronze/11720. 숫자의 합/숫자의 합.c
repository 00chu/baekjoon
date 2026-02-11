#include <stdio.h>

int main() {
	int N;
	char num[100]={ 0 };

	scanf("%d", &N);
	scanf("%s", &num);

	int sum = 0;
	for (int j = 0; j < N; j++) {
		sum += num[j]-'0';
	}
	printf("%d", sum);
	return 0;
}