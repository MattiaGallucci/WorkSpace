#include <stdio.h>
#include <stdlib.h>

#define LEN 10

void inputArray(int a[], int n){
	int i;
	for(i = 0; i < n; i++) {
		printf(">> ");
		scanf("%d", &a[i]);
	}
}

void printArray(int a[], int n){
	int i;
	for(i = 0; i < n; i++) {
		printf("%d ", a[i]);
	}
}

int partition(int arr[], int primo, int ultimo){
	int pivot=arr[primo];
	int i=primo-1, j=ultimo+1;
	
	while(1)
	{ 
		do
		{
			j--;
		}while(arr[j] > pivot);
		
		do
		{
			i++;
		}while(arr[i] < pivot);
		
		if(i >= j)
			return j;
		
		swap(arr+i, arr+j);	
	}
}

void qSort(int arr[], int primo, int ultimo){
	int pivot;
	
	if(primo < ultimo)
	{
		pivot = partition(arr, primo, ultimo);
		
		qSort(arr, primo, pivot);
		qSort(arr, pivot+1, ultimo);
	}
}

void quickSort(int arr[], int n){
	qSort(arr, 0, n-1);
}

int main(){
	int arr[LEN];

	inputArray(arr, 5);
	
	quickSort(arr,5);
	
	printArray(arr, 5);
	
	return 0;
}