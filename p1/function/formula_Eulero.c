#include <stdio.h>

int f (int n, int m)
{
	int r;
	
	r = n%m;
	
	return (r <= m/2)? n-r: n-r+m;
}

int is_prime (unsigned long int n)
{
	if (n<2)
		return 0;
	
	int d;
	
	for (d=2; d*d <= n; d++)
		if (n%d == 0)
			return 0;
	
	return 1;
}

double pi (unsigned long int n) 
{
	
	double prod = 1;
	
	for (unsigned long int i=3; n>0; i+=2)
		if (is_prime(i))
		{
			prod *= (i + 0.0) / f(i,4);
			n--;
		}
	
	return prod*4;
}	

int main(void) {
	
	unsigned long int n;
	
	printf("Inserisci un intero: ");
	scanf("%lu", &n);
	
	printf("\n%f", pi(n));
	
	return 0;
}