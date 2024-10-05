#include <stdio.h>
#include <stdlib.h>

int main(){
	
	
	int *a, n, i;
	float media;
	
	printf("Quanti valori? ");
	scanf("%d", &n);
	printf("\n");
	
	a = (int *) calloc(n, sizeof(int));
	
	for (i=0; i<n; i++)
	{
		printf("Elemento %d: ", i+1);
		scanf("%d", &a[i]);
	}
	
	media=0;
	for (i=0; i<n; i++)
		media = media+a[i];
	
	media/=n;
	
	printf("\nLa media è %.2f", media);
	
	return 0;
}