#include <stdio.h>

#define true 1
#define false 0

int primo(int n)
{
	int d;
	
	if (n <= 1)
		return false;
	for (d=2; d*d<=n; d++)
		if (n%d == 0)
			return false;
		return true;
}

int main(void)
{
	
	int n;
	
	printf("Inserisci un numero: ");
	scanf("%d", &n);
	
	if (primo(n))
		printf("\nE' primo");
	else
		printf("\nNon è primo");
	
	return 0;
}