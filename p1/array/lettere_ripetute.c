#include <stdio.h>

#define false 0

typedef int Bool;

int main(void) {
	
	Bool lettere[26] = {false};
	int i;
	char ch;
	
	printf("Scrivi un messaggio: ");
	ch = getchar();
	
	while ((ch = getchar()) != '\n')
	{
		if (('A' <= ch) && (ch <= 'Z'))
			ch = ch - 'A' + 'a';
		ch = ch - 'a';
		lettere[ch] ++;
	}
	
	printf("\nLettere ripetute ");
	for (i = 0; i < 26; i++)
		if (lettere[i] >= 2)
		{
			printf("\n%c ", i + 'a');
			printf("si ripete %d volte", lettere[i]);
		}
		
	return 0;
}