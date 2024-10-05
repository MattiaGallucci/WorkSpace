#include<stdio.h>
int main(void) {
	
	int n, d=2;
	
	printf("Inserisci un numero: ");
	scanf("%d", &n);
	
	for (; d<n; d++) 
	{
		if (n%d == 0)
			break;
	}
	if (d<n)
		printf("%d non è primo", n);
	else
		printf("%d è primo", n);
	
	return 0;	
}