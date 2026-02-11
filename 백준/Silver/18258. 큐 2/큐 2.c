#include <stdio.h>
#include <string.h>

#define queueSize 2000000

int main(void) {
	int queue[queueSize];
	int front = 0, rear = 0;
	int N, temp ;
	char order[10];

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {

		scanf("%s", &order);

		if (!strcmp(order, "push")) {
			scanf("%d", &temp);
			queue[rear++] = temp;
		}
		else if (!strcmp(order, "pop")) {
			if (front == rear) {
				printf("-1\n");
			}
			else {
				printf("%d\n", queue[front++]);
			}
		}
		else if (!strcmp(order, "size")) {
			printf("%d\n", rear - front);
		}
		else if (!strcmp(order, "empty")) {
			if (front == rear) {
				printf("1\n");
			}
			else {
				printf("0\n");
			}
		}
		else if (!strcmp(order, "front")) {
			if (front == rear) {
				printf("-1\n");
			}
			else {
				printf("%d\n", queue[front]);
			}
		}
		else if (!strcmp(order, "back")) {
			if (front == rear) {
				printf("-1\n");
			}
			else {
				printf("%d\n", queue[rear - 1]);
			}
		}
	}

	return 0;
}