#include <stdio.h>
#include "utils.h"
#include "item.h"

void inputArray(Item a[], int n){
	int i;
	
	for(i = 0; i < n; i++)
		a[i] = inputItem();
}

void bubbleSort(Item a[], int n){
	int i,j;
	
	for(i=1; i<n; i++)
		for(j=0; j<n-i; j++)
			if(cmpItem(a[j], a[j+1]) > 0)
				swap(&a[j], &a[j+1]);
}

void printArray(Item a[], int n){
	int i;
	
	for(i = 0; i < n; i++)
		outputItem(a[i]);
}