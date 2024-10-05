#include<stdio.h>

#define N 10

int main(void) {
	
	int num[N], i, sum, even=0, odd=0, flag=0;
	
	printf("Inserisci %d numeri interi: ", N);
	for (i = 0; i < N; i++)
		scanf("%d", &num[i]);
	
	int max = num[0], min = num[0];
	
	for (i = 0; i < N; i++)
	{
		if (num[i] > max)
			max = num[i];
		if (num[i] < min)
			min = num[i];
		if (num[i] % 2 == 0)
			even++;
		else
			odd++;
		sum += num[i];
	}
	
	for (i = 0; i < N-1; i++)
	{
		if (num[i] >= num[i+1])
			break;
	}
	if (i == N-1)
		printf("\nLa sequenza è crescente");
	
	
	printf("\nMax = %d", max);
	printf("\nMin = %d", min);
	printf("\nI numeri pari sono %d", even);
	printf("\nI numeri dispari sono %d", odd);
	printf("\nLa somma è %d", sum);
					
	return 0;
}