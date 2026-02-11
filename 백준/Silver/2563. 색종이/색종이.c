#include<stdio.h>

int main(void) {
	int n, count = 0;
	int result[100][100] = { 0, };
	int x, y;

	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) { 
		scanf("%d %d", &x, &y); // x, y에 두 자연수를 받아 넣음
		for (int j = x; j < x + 10; j++) { // x ~ x + 10까지 
			for (int k = y; k < y + 10; k++) { // y ~ y + 10까지 
				result[j][k] = 1;	//안의 숫자를 1로 변경
			}
		}
	}

	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) { // 배열의 모든 칸을 확인
			if (result[i][j] == 1) { //배열 안의 숫자가 1이면 개수를 셈
				count++;
			}
		}
	}
	
	printf("%d", count);

	return 0;
}