#include <stdio.h>

typedef int Bool;

int main(void) {
	
	Bool cifre[10] = {0};
	int digit, i;
	long n;
	
	printf("Inserisci un numero: ");
	scanf("%ld", &n);
	
	while (n > 0)
	{
		digit = n % 10;
		cifre[digit]++;
		n /= 10;
	}
	
	printf("\nCifre ripetute: \n");
	for (i = 0; i < 10; i++)
		if (cifre[i] >= 2)
			printf("%d si ripete %d volte\n", i, cifre[i]);
	
	return 0;
}