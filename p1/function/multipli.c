/*Scrivere una funzione f(n,m) che prenda in input n > 0 e m > 0 e
restituisca il multiplo di m più vicino a n*/

#include <stdio.h>

int f(int n, int m) {
	
	int x, y;
	
	x = n/m;
	y = m * x;
	
	if (n-y <= x)
		return y;
	else
		return y+=m;
}	

int main(void) {

	int n, m;
	
	printf("Inserisci il primo numero: ");
	scanf("%d", &n);
	printf("Inserisci il secondo numero: ");
	scanf("%d", &m);
	
	printf("\nIl multiplo di %d più vicino a %d è %d", m, n, f(n,m));
	
		
	return 0;
}
