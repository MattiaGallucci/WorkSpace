#include<stdio.h>

int main(void) {
	
	int num, div, q, r, rev;
	
	printf("Inserisci un intero a 2 cifre: ");
	scanf("%d", &num);
	
	q = num / 10;
	r = num % 10;
	
	rev = (r * 10) + q;
	
	printf("\nIl reverse è: %.2d", rev);
	
	return 0;
}

//ALTERNATIVA 1 

/*
	int num, q, r, rev;
	
	printf("Inserisci un intero a 2 cifre: ");
	scanf("%d", &num);
	
	
	printf("\nIl reverse è: %d%d", num % 10, num / 10);
*/

//ALTERNATIVA 2

/*
	int num1, num2, rev;
	
	printf("Inserisci un numero a 2 cifre positivo: ");
	scanf("%1d%1d", &num1, &num2);
	
	printf("\nIl reverse del numero inserito è: %d%d\n", num2, num1);
*/