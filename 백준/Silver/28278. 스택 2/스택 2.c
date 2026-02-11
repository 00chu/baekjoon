#include <stdio.h>
#include <stdlib.h>

typedef struct Stack { // 스택 구조체 생성
	int data[1000000];
	int top; // 최상위 인덱스를 가리킬 변수
}Stack;

Stack* new_stack() {		//스택 생성하는 함수
	Stack* newStack = (Stack*)malloc(sizeof(Stack)); // 새로운 스택을 동적할당.
	newStack->top = -1;
	return newStack; //스택를 가리키는 포인터 반환.
}

int main(void) {
	Stack* stack = new_stack();
	int order = 0, N, x;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {

		scanf("%d", &order);

		switch (order) {
		case(1):
			scanf("%d", &x);
			++(stack->top); // top을 하나 높임
			stack->data[stack->top] = x; // top위치의 stack에 x 추가
			break;

		case(2):
			if (stack->top >= 0) { // 스택에 정수가 있으면 출력 (pop)
				printf("%d\n", stack->data[stack->top]);
				(stack->top)--;
			}
			else
				printf("%d\n", -1);
			break;

		case(3):
			printf("%d\n", (stack->top) + 1); // 스택에 들어있는 정수
			break;

		case(4):
			if (stack->top >= 0) // 스택에 정수가 있으면 출력
				printf("%d\n", 0);
			else
				printf("%d\n", 1);
			break;

		case(5):
			if (stack->top >= 0) // 스택에 정수가 있으면 맨 위 정수 출력
				printf("%d\n", stack->data[stack->top]);
			else
				printf("%d\n", -1);
			break;
		}
	}

	return 0;
}