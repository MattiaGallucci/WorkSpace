#include <stdio.h>
#include <stdlib.h>

#include "vettore.h"

int main(){
	int n;
	int *a;
	char line[100];
	
	printf("Inserisci il vettore: ");
	scanf("%[^\n]", line);
	
	a = input_array_dyn(&n, line);
	bubbleSort(a, n);
	printArray(a, n);
	
	return 0;
}