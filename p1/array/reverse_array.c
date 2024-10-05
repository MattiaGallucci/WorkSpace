#include<stdio.h>

#define N 5

int main(void) {
	
	int num[N], i, tmp;
	
	printf("Inserisci %d numeri: ", N);
	for (i=0; i < N; i++)
		scanf("%d", &num[i]);
	
	for (i=0; i < N/2; i++)
	{
		tmp = num[i];
		num[i] = num[N-1-i];
		num[N-1-i] = tmp;
	}
	
	printf("\nIl reverse è: ");
	for (i=0; i < N; i++)
		printf("%d ", num[i]);
	
	return 0;
}