#include <stdio.h>
 
int main()
{
    int C;
    scanf("%d", &C);
    for(int i = 0; i < C; i++)
    {
        int N, score[1000], sum = 0, cnt = 0, pass = 0;;
        scanf("%d", &N);
        for(int j = 0; j < N; j++)
        {
            scanf("%d", &score[j]);
            sum += score[j];
            cnt++;
        }
        for(int j = 0; j < cnt; j++)
        {
            float avg = (float)sum/cnt;
            
            if(avg < score[j]) pass++;
        }
        printf("%.3f%%\n", (float)pass/cnt*100);
    }
    return 0;
}
