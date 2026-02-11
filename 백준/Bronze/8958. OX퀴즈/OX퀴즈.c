#include<stdio.h>


int main()


{


    int i, j;


    


    int testcase;//몇줄 입력할건지


 


    scanf(" %d", &testcase);


 


    for (i = 0; i < testcase; i++)//줄


    {


        int cnt = 0, total = 0;//o점수count,한 줄의o점수 총합


        char game[80];//ox를 받을 배열


        scanf(" %s", &game);//ox입력받음


        for (j = 0; j < strlen(game); j++)//문자열의 길이만큼


        {


            if (game[j] == 'O')


            {


                cnt++;


                total = total + cnt;//한줄의 총점수계산


            }


            if (game[j] == 'X')


            {


                cnt = 0;//cnt 초기화


            }


        }


        printf("%d\n", total);//바로출력하게수정


    }


 


}




