#include<stdio.h>
int main(void) {
	
	int n, prec=1, corrente=1, fib, i;
	
	printf("Inserisci l'n-esimo numero della sequenza di Fibonacci: ");
	scanf("%d", &n);
	
	if (n==1 || n==2)
		printf("Fib(1) = 1");
	else {
		for(i=3; i<=n; i++) {
			fib=prec+corrente;
			prec=corrente;
			corrente=fib;
		}
		printf("\nFib(%d) = %d", n, fib);
	}
	return 0;
}