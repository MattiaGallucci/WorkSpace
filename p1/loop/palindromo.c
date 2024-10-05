#include<stdio.h>
int main(void) {
	
	int numero, limite, inverso, copia;
	
	printf("Inserisci un intero: ");
	scanf ("%d", &limite);
	
	for (numero = 0; numero <= limite; numero++) 
	{
	copia = numero; //salvo il numero per i controlli successivi
	inverso = 0; // calcoliamo l'inverso del numero
	while (numero > 0) 
	{
		inverso = inverso*10 + numero%10;
		numero /= 10; //escludo proprio l’ultima cifra appena trattata
	}
	if (copia == inverso)
	{ //numero è palindromo
		printf("%d\n", copia);
	}
	numero = copia;
	}
	
	return 0;
}