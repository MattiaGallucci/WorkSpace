#include <stdio.h>
#include <stdlib.h>

#define LEN 10

void inputArray(int a[], int n) {
	int i;
	for(i = 0; i < n; i++) {
		printf(">> ");
		scanf("%d", &a[i]);
	}
}

void printArray(int a[], int n) {
	int i;
	for(i = 0; i < n; i++) {
		printf("%d ", a[i]);
	}
}

void merge(int *arr1, int *arr2, int n1, int n2, int *arr){
 	int i, j, k;
	int temp[n1+n2];
	
	for(i=0, j=0, k=0; i<n1 && j<n2; k++)
	{
		if(arr1[i] <= arr2[j])
		{
			temp[k] = arr1[i];
			i++;
		}
		
		else
		{
			temp[k] = arr2[j];
			j++;
		}
	}
	
	for(; i < n1; k++, i++)
		temp[k] = arr1[i];
	
	for(; j < n2; k++, j++)
		temp[k] = arr2[j];
	
	for(k = 0; k<(n1+n2); k++)
		arr[k] = temp[k];
}

void  mergeSort(int arr[], int n){
	if(n > 1) 
	{
		mergeSort(arr, n/2);
		mergeSort(arr+n/2, n-n/2);
		merge(arr , arr+n/2 ,n/2, n-n/2, arr);
	}
}

int main(){
	int arr[LEN];

	inputArray(arr, 5);
	
	mergeSort(arr,5);
	
	printArray(arr, 5);
	
	return 0;
}