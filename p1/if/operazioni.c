#include<stdio.h>
int main(void)
{
	int x, y, c;
	printf("Inserisci due interi: ");
	scanf("%d %d", &x, &y);
	
	printf("\n\nOperazioni disponibili: ");
	printf("\n\n1 = somma\t2 = differenza\n");
	printf("3 = prodotto\t4 = modulo\t5 = divisione\n\n");
	
	printf("\nInserisci un codice: ");
	scanf("%d", &c);

	
	switch (c){
		case 1:
			printf("La loro somma è: %d", x+y);
			break;
		case 2:
			printf("La loro differenza è: %d", x-y);
			break;
		case 3:
			printf("Il loro ptodotto è: %d", x*y);
			break;
		case 4:
			printf("Il loro modulo è: %d", x%y);
			break;
		case 5:
			printf("Il loro quoziente è: %d", x/y);
			break;
		default:
			printf("Valore non valido");
			break;
	}
	return 0;
}