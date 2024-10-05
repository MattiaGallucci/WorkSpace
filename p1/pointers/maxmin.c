#include <stdio.h>

#define N 10

void max_min (int a[], int n, int *max, int *min);

int main (void) {
	
	int b[N], i, big, small;
	
	printf("Inserisci %d numeri: ", N);
	for (i=0; i<N; i++)
		scanf("%d ", &b[i]);
	
	max_min(b, N, &big, &small);
	
	printf("\nMaggiore: %d", big);
	printf("\nMinore: %d", small);
	
	return 0;
}

void max_min (int a[], int n, int *max, int *min) {
	
	int i;
	
	*max = *min = a[0];
	
	for (i=1; i<n; i++)
	{
		if (a[i] > a[0])
			*max = a[i];
		else if (a[i] < a[0])
			*min = a[i];
	}
	
}
