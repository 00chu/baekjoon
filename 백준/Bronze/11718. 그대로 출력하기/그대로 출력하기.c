#include <stdio.h>

int main(void) {
    int N = 0;
    char sentence[100] = "";

    while (scanf("%c", &sentence) != EOF) {
        printf("%s", sentence);
    }

    return 0;
}