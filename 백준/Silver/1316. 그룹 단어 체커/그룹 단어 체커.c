#include <stdio.h>
#include <string.h>

int main(void) {
    int N, count = 0, flag;
    char word[100];

    scanf("%d", &N);

    count = N;
    for (int i = 0; i < N; i++) {
        scanf("%s", &word);
        flag = 0;
        for (int j = 0; j < strlen(word); j++) {
            if (word[j] == word[j + 1]) {
                word[j] = '0';
            }
            
        }
        
        for (int j = 0; j < strlen(word); j++) {
            for (int k = 0; k < j - 1; k++) {
                if (word[j] == '0') {
                    break;
                }
                else if (word[k] == '0') {
                    k++;
                }

                if (word[j] == word[k]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }

        if (flag == 1) {
            count--;
        }
    }

    printf("%d", count);

    return 0;
}