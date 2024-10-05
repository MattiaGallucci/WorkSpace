#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 80

char* greatest_word (char *s, char *parola_max);

int main(void) {
	
	char ch, a[N+1], parola[N+1];
	int i=0;
	
	printf("Inserisci una frase: ");
	while ((ch = getchar()) != '\n')
	{
		if (i<N)
			a[i] = ch;
		i++;
	}
	
	a[i] = '\0';
	
	char *ris = greatest_word(a, parola);
	
	printf("\nLa parola massima è: ");
	puts(ris);
	
	return 0;
	
}

char* greatest_word (char *s, char *parola_max) {
	
	char *p = s;
	
	for (; *s; s++)
	{
		if (*s == ' ')
		{
			*s = '\0';
			if (strcmp(p, parola_max) > 0)
				strcpy (parola_max, p);
			p = s+1;
		}
		
	}
	
	if (strcmp(p, parola_max) > 0)
		return p;
	else
		return parola_max;
}