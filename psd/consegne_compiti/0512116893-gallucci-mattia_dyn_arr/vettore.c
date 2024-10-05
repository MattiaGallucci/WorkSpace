#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int conta_spazi(char *a){
	int count=0, i;
	
	for (i=0; a[i] != '\0'; i++)
	{
		if (a[i] == ' ')
			count++;
	}
	
	return count;
}

int *input_array_dyn(int *size, char *line){
	int i=0, n=0;
	
	*size = conta_spazi(line) + 1;
	
	int *arr = malloc((*size) * sizeof(int));
	
	if (arr == NULL)
	{
		fprintf(stderr, "Non posso allocare %d bytes\n", ((*size) * sizeof(int)));
		exit(EXIT_FAILURE);
	}
	
	while (sscanf(line, "%d%n", &arr[i], &n) == 1)
	{
		line += n;
		i++;
	}
	
	return arr;
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