#include <stdio.h>

#define LEN 10

void inputArray(int a[], int n){
	int i;
	for(i=0; i<n; i++)
		scanf("%d", &a[i]);
}

void insertSortArray(int a[], int *n, int val){
	int i;
	for(i=*n; i>0 && val<a[i-1]; i--)
		a[i] = a[i-1];
	
	a[i] = val;
	
	(*n)++;
}

void insertSort(int a[], int n){
	int i=1;
	while(i<n)
		insertSortArray(a, &i, a[i]);
}

void printArray(int a[], int n){
	int i;
	for (i=0; i < n; i++)
		printf("%d ", a[i]);
}

int main(){

	int a[LEN], n=5, val;
	
	inputArray(a, n);
	
	scanf("%d", &val);
	
	insertSortArray(a, &n, val);
	//printArray(a, n);
	//printf("\n");
	insertSort(a, n);
	
	printArray(a, n);
	
	
	return 0;
}