#include <stdio.h>

int main() {
	int arr[10];
	int count[42] = { 0 };
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		scanf("%d", &arr[i]);
		arr[i] = arr[i] % 42;
	}
	for (int i = 0; i < 10; i++) {
		count[arr[i]]++;
		if (count[arr[i]] == 2) {
			count[arr[i]]--;
		}
	}
	for (int i = 0; i < 42; i++) {
		sum = sum + count[i];
	}
	printf("%d ", sum);
	return 0;
}