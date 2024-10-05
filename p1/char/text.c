#include <stdio.h>

int main(void) {
	
	int c=0;
	char ch;
	
	printf("Inserisci le cifre: ");
	ch = getchar();
	
	while (ch != '\n')
	{
		if (ch >= '0' && ch <= '9')
			c++;
		ch = getchar();
	}
	
	printf("\nCifre: %d", c);
	
	return 0;
}