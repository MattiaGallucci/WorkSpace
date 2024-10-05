#include <stdio.h>
#include "vettore.h"

#define LEN 10

int main(){

	int a[LEN];
	int n=5;
	
	inputArray(a, n);
	findMin(a, n);
	printf("Count: %d\n", adaptiveBubbleSort(a, n));
	printf("Somma: %d\n", sumArray(a, n));
	printArray(a, n);
	
	return 0;
}