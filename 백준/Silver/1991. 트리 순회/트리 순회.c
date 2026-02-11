#include <stdio.h>
#include <stdlib.h>

typedef char elementType;

typedef struct Node {	//노드 구조체 선언
	char data;
	struct Node* leftChild;
	struct Node* rightChild;
}Node;

Node* new_Node(char key) {		//노드 생성하는 함수
	Node* newNode = (Node*)malloc(sizeof(Node)); // 새로운 노드를 동적할당.
	newNode->data = key;
	newNode->leftChild = NULL;
	newNode->rightChild = NULL;

	return newNode; //노드를 가리키는 포인터 반환. 포인터를 반환해야 노드 안의 원소로 접근이 가능.
}


Node* searchNode(Node* root, char key) {	//루트랑 비교하여 값을 찾는 부분
	if (root== NULL) {
		return NULL;
	}
	if (root -> data == key) {
		return root;
	}
	else {
		Node* temp = searchNode(root->leftChild, key);
		if (temp != NULL) {
			return temp;
		}
		else {
			return searchNode(root->rightChild, key);
		}
	}
}

void preorder(Node* root) { //전위순회
	if (root) {
		printf("%c", root->data);
		preorder(root->leftChild);
		preorder(root->rightChild);
	}
	return;
}

void inorder(Node* root) { //중위순회
	if (root) {
		inorder(root->leftChild);
		printf("%c", root->data);
		inorder(root->rightChild);
	}
	return;
}

void postorder(Node* root) { //후위순회
	if (root) {
		postorder(root->leftChild);
		postorder(root->rightChild);
		printf("%c", root->data);
	}
	return;
}

Node* start = NULL;

int main(void) {
	Node* root = NULL;
	Node* left;
	Node* right;

	int N;
	char R, l, r;

	scanf("%d", &N);
	getchar();

	for (int i = 0; i < N; i++) {
		scanf("%c %c %c", &R, &l, &r);
		getchar();
		
		if (R == 'A') {
			root = new_Node(R);
			start = root;
		}
		else {
			root = searchNode(start, R);
		}

		if (l != '.') {
			root->leftChild = new_Node(l);
		}
		if (r != '.') {
			root->rightChild = new_Node(r);
		}
	}

	preorder(start);
	printf("\n");
	inorder(start);
	printf("\n");
	postorder(start);


	return 0;
}