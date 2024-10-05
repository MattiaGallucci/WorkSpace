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

int adaptiveBubbleSort(int a[], int n){
	int i, j, count=0, ordered=0;
	for(i=1; i<n && !ordered; i++)
	{
		ordered=1;
		for(j=0; j<n-i; j++)
		{
			count++;
			if(a[j] > a[j+1])
			{
				swap(&a[j], &a[j+1]);
				ordered=0;
			}
		}
	}
	return count;
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
	
	printf("Count: %d\n", adaptiveBubbleSort(a, n));
	
	printArray(a, n);
	
	return 0;
}