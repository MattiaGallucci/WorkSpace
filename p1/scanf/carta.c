/*questo programma calcola come pagare con il minor numero di carte da 20, 10 ,5, 1*/

#include<stdio.h>
int main(void) {
	
	int cifra;
	
	printf("Inserisci l'ammontare intero: ");
	scanf("%d", &cifra);
 
	
	printf("\nNumero di carte da 20 euro: %d\n", cifra / 20);
	cifra  %= 20;
	
	printf("Numero di carte da 10 euro: %d\n", cifra / 10);
	cifra %= 10;
	
	printf("Numero di carte da 5 euro: %d\n", cifra / 5 );
	cifra %=  5;
	
	printf("Numero di carte da 1 euro: %d\n", cifra);
	
	return 0;
}