#include <stdio.h>
#include "item.h"

#define N 5

int findMin(Item a[], int n);
void selectionSort(Item a[], int n);
void selectionSortRic(Item a[], int n);
void swap(Item *a, Item *b);

void selectionSort(Item *a, int n)
{
	int i, minIndex;
	
	for (i=0;i<n-1;i++)
	{
		minIndex = findMin(a+i, n-i) + i;
		swap(&a[i], &a[minIndex]);
	}
}

int findMin(Item *a, int n)
{
	int i, minIndex = 0;

	for (i=1; i<n;i++)
		if (cmpItem(a[i], a[minIndex]) < 0)
			minIndex = i;

	return minIndex;
}

void swap(Item *a, Item *b){
	Item temp=*a;
	*a=*b;
	*b=temp;
}

int main(){

	Item a[N];
	int i;
	
	for (i=0; i<N; i++)
	{
		a[i] = inputItem();
	}

	selectionSort(a, N);
	
	for (i=0; i<N; i++)
	{
		outputItem(a[i]);
	}
	
	return 0;
}