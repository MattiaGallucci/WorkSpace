#include <stdio.h>

#define N 5

void inputArray(int a[], int n)
{
	int i;
	for(i=0; i < n; i++)
		scanf("%d", &a[i]);
}

void selectionSort(int a[], int n)
{
	int i, minIndex;
	
	for (i=0;i<n-1;i++)
	{
		minIndex = findMin(a+i,n-i) + i;
		swap(&a[i], &a[minIndex]);
	}
}

int findMin(int a[], int n)
{
	int i, minIndex = 0;

	for (i=1; i<n;i++)
		if (a[i] < a[minIndex])
			minIndex = i;

	return minIndex;
}

void swap(int *a, int *b){
	int temp=*a;
	*a=*b;
	*b=temp;
}

void printArray(int a[], int n)
{
	int i;
	for (i=0; i < n; i++)
		printf("%d ", a[i]);
}

int main(){

	int a[N];

	inputArray(a, N);

	//printf("%d", a[findMin(a, N)]);

	selectionSort(a, N);

	printArray(a, N);

	return 0;
}