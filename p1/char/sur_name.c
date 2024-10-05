#include <stdio.h>

int main(void) {
	
	char ch, nome, cognome;
	
	printf("Inserisci nome e cognome: ");
	scanf(" %c", &nome);
	
	while (getchar() != ' ')
		;
	while ((ch=getchar()) != '\n')
	{
		if(ch != ' ')
			putchar(ch);
	}
	
	printf(", %c.", nome);
	
	return 0;
}