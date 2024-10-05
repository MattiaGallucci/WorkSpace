#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inputArray(int a[], int n){
	int i;
	
	printf("Inserisci %d numeri e premi invio:\n", n);
	
	for(i=0; i<n; i++)
		scanf("%d", &a[i]);
	
}

void printArray(int a[], int n){
	int i;
	
	for (i=0; i < n; i++)
		printf("%d ", a[i]);
}

int ricerca(int a[], int n, int elem){
	int i=0, trovato=0;
	
	while (i<n && !trovato)
	{
		if (a[i] == elem)
			trovato = 1;
		else i++;
	}
	
	return (trovato? i : -1);
}

void findMin(int a[], int n){
	int i=0, min=999999999;
	
	for (i; i<n; i++)
	{
		if (a[i] < min)
			min = a[i];
	}
	
	printf("Il minimo è %d\n", min);
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

void elimina(int a[], int *n, int pos){
	int i;
	
	for (i= pos; i< (*n)-1; i++)
		a[i] = a[i+1]; // shift a sinistra
	
	(*n)--;
}

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