#include <stdio.h>

#define LEN 10

void inputArray(int a[], int n){
	int i;
	for(i=0; i<n; i++)
		scanf("%d", &a[i]);
}

void swap(int *a, int *b){
	int temp=*a;
	*a=*b;
	*b=temp;
}

void bubbleSort(int a[], int n){
	int i, j;
	for(i=1; i<n; i++)
	{
		for(j=0; j<n-i; j++)
		{
			if(a[j] > a[j+1])
				swap(&a[j], &a[j+1]);
		}
	}
}

void printArray(int a[], int n){
	int i;
	for (i=0; i < n; i++)
		printf("%d ", a[i]);
}

int main(){

	int a[LEN];
	int n=5;
	
	inputArray(a, n);
	
	bubbleSort(a, n);
	
	printArray(a, n);
	
	return 0;
}