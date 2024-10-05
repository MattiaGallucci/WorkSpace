#include<stdio.h>
int main(void) {
	int n, e, a, res=1;
	
	printf("Inserisci il valore della base: ");
	scanf("%d", &a);
	
	printf("Inserisci il valore dell'esponente: ");
	scanf("%d", &n);
	
	e=n;
	
	while (n>0) 
	{
		res = res*a;
		n--;
	}
	
	printf("\n%d alla %d è uguale a %d\n", a, e, res);

	return 0;
}