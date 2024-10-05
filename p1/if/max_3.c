/*questo programma confronta 3 numeri e trova il maggiore*/

#include<stdio.h>
int main(void) {
	
	int i, j, k;
	
	printf("Inserisci 3 numeri interi: ");
	scanf("%d %d %d", &i, &j, &k);
	
	if (i > j && i > k) 
		 printf("%d è il maggiore", i);
	 else if (j > i && j> k)
		  printf("%d è il maggiore", j);
	else printf("%d è il maggiore", k);
	   
	return 0;
}

//ALTERNATIVA

/*
	int i, j, k;
	
	printf("Inserisci 3 numeri interi: ");
	scanf("%d %d %d", &i, &j, &k);
	
	(i > j && i > k) ? printf("%d è il maggiore", i) : (j > i && j>k) ? printf("%d è il maggiore", j) : printf("%d è il maggiore", k);
*/