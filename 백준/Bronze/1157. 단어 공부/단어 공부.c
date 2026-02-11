#include <stdio.h>

int main(void)
{
	char str[1000001];
	gets(str);

	int i, j, max = 0, idx = 0;
	int abcCnt[26] = { 0, };					

	for (i = 0; str[i] != '\0'; i++)
	{
		for (j = 'a'; j <= 'z'; j++)			  
		{
			if (j == str[i])
			{
				abcCnt[j - 97]++;
				break;
			}
		}
		for (j = 'A'; j <= 'Z'; j++)		
		{
			if (j == str[i])
			{
				abcCnt[j - 65]++;
				break;
			}
		}
	}

	for (i = 0; i < 26; i++)
	{
		if (max < abcCnt[i])					
		{
			max = abcCnt[i];
			idx = i;
		}
		else if (max == abcCnt[i])			
		{
			idx = '?';
		}
	}
	putchar((idx == '?') ? '?' : idx + 65);	

	return 0;
}
