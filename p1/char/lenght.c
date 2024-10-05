#include <stdio.h>

int main(void){
	
	int len=0, vocali=0, spazio=0;
	char ch;
	
	printf("Inserisci un messaggio: ");
	
	while ((ch = getchar()) != '\n') {
		len++;
		if (('A' <= ch) && (ch <= 'Z'))
			ch = ch - 'A' + 'a';
		switch(ch) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				vocali++;
				break;
			 case ' ':
				spazio++;
				break;
		}
	}
	
	printf ("Il numero dei caratteri è %d\n", len);
	printf ("Il numero dei caratteri esclusi gli spazi è %d\n", (len - spazio));
	printf ("Il numero delle vocali è %d\n", vocali);

	return 0;
}

/*int len = 0;
	
	printf("Inserisci un messaggio: ");
	while (getchar() != '\n')
		len++;
	printf("Il tuo messaggio è di %d caratteri.\n", len);
*/