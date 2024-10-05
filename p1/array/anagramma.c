#include <stdio.h>
#include <ctype.h>

int main(void) {
	
	int a[25]={0}, b[25]={0}, i, j, count, flag=0;
	char ch;
	
	printf("Inserisci la prima parola e premi invio: ");
	while ((ch=getchar()) != '\n')
	{
		if (isalpha(ch))
		{
			i = tolower(ch) - 'a';
			a[i]++;
		}
	}
	
	printf("Inserisci la seconda parola e premi invio: ");
	while ((ch = getchar()) != '\n')
	{
		if (isalpha(ch))
		{
			j = tolower(ch) - 'a';
			b[j]++;
		}
	}
	
	for (count=0; count<25; count++)
	{
		if (a[count] != b[count])
		{
			flag = 1;
			break;
		}
	}	
	
	if (flag == 1)
		printf("\nNon sono anagrammi");
	else
		printf("\nSono anagrammi");
	
	return 0;
}