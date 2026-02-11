#include <stdio.h>
#include <stdlib.h>

typedef int elementType;

typedef struct Node {	//노드 구조체 선언
	int data;
	struct Node* leftChild;
	struct Node* rightChild;	
}Node;

Node* new_Node(int key) {		//노드 생성하는 함수
	Node* newNode = (Node*)malloc(sizeof(Node)); // 새로운 노드를 동적할당.
	newNode -> data = key;
	newNode -> leftChild = NULL;
	newNode -> rightChild = NULL;

	return newNode; //노드를 가리키는 포인터 반환. 포인터를 반환해야 노드 안의 원소로 접근이 가능.
}

Node* insertNode(Node* root, int key) { //루트랑 비교하여 값을 추가하는 부분
	if (root == NULL) {
		root = new_Node(key);
		return root;
	}
	else if (root->data > key) // key 값이 root 보다 작다면 왼쪽 서브트리로
		root -> leftChild = insertNode(root -> leftChild, key);
	else if (root->data < key)  // key 값이 root 보다 크다면 오른쪽 서브트리로
		root -> rightChild = insertNode(root -> rightChild, key);
	return root;
}

void postorder(Node* root) { //후위순회
	if (root) {
		postorder(root -> leftChild);
		postorder(root -> rightChild);
		printf("%d\n", root -> data);
	}
	return;
}


int main(void) {
	Node* root = NULL;
	int temp;

	while (scanf("%d", &temp) != EOF) {
		root = insertNode(root, temp);
	}

	postorder(root);

	return 0;
}