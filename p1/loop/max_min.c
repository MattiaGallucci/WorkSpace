#include<stdio.h>

int main(void) {
	
	int intero, max, min, somma=0;
	
	printf("inserisci i numeri e poi digita 0 per finire: ");
	scanf("%d", &intero);
	
	min = max = somma = intero;
	
	while (intero != 0) 
	{
		somma += intero;
		if (intero > max)
			max = intero;
		if (intero < min)
			min = intero;
		scanf("%d", &intero);
	}
	
	printf("Somma: %d\n", somma);
	printf("Min: %d\n", min);
	printf("Max: %d\n", max);
	
	return 0;
}


//ALTERNATIVA

/*int main(void) {
	
	int intero, n, max, min, somma;
	
	printf("Inserisci il numero di interi che vuoi digitare: ");
	scanf("%d", &n);
	
	printf("Inserisci un intero: ");
	scanf("%d", &intero);
	
	min = max = somma = intero;
	
	for (int i = 2; i <= n; i++)
	{
		printf("Inserisci il numero: ");
		scanf("%d", &intero);
		somma += intero;
		
		if (intero < min)
			min = intero;
		if (intero > max)
			max = intero;	
	}
	
	printf("Somma: %d\n", somma);
	printf("Min: %d\n", min);
	printf("Max: %d\n", max);

	return 0;
}
*/