#include<stdio.h>

#define N 10

int main(void) {
	
	int a[N], i;
	
	printf("Inserisci %d numeri: ", N);
	for (i = 0; i < N; i++)
		scanf("%d", &a[i]);
	
	printf("\nIl reverse è: ");
	for (i = N - 1; i >= 0; i--)
		printf("%d ", a[i]);
	printf("\n");
	
	return 0;
}