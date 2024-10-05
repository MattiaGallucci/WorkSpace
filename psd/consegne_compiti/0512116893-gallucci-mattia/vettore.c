#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "utils.h"

void inputArray(int a[], int n){
	int i;
	
	for(i=0; i<n; i++)
		scanf("%d", &a[i]);
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

void findMin(int a[], int n){
	int i=0, min=999999999;
	
	for (i; i<n; i++)
	{
		if (a[i] < min)
			min = a[i];
	}
	
	printf("Il minimo è %d\n", min);
}

int sumArray(int a[], int n){
	int sum=0, i;
	
	for(i=0; i<n; i++)
	{
		sum += a[i];
	}
	
	return sum;
}

int input_array_str(int *arr, char *line){
	int i=0, n=0, counter=0;
	
	while (sscanf(line, "%d%n", &arr[i], &n) == 1)
	{
		printf("Numero letto: %d\nCaratteri letti: %d", arr[i], n);
		line += n;
		i++;
	}
	
	return i;
}

int compare_array(int *input, int *oracolo, int n_input, int n_output){
	int i;
	
	if (n_input == n_output)
	{
		for (i=0; i<n_output; i++)
		{
			if (input[i] == oracolo[i])
				continue;
			else return 0;
		}
	}
	
	return 1;
}

int char_to_int(char a[]){
	int v=0;
	
	if (*a >= '0' && *a <= '9')
		v += *a-'0';
	
	return v;
}

int prodotto_scalare(char a[], char b[]){
	int sum=0;
	
	if ((*a >= '0' && *a <= '9') && (*b >= '0' && *b <= '9'))
		sum += ((*a-'0') + (*b-'0'));
	else return 1;
	
	return sum;
}