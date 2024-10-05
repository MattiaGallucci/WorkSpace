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

void mergeSort(int arr[], int n){
	if (n <= 1)
    return;

    int size, left_start;
    
	for (size = 1; size < n; size = 2 * size)
	{
        for (left_start = 0; left_start < n-1; left_start += 2 * size)
		{
            int mid = left_start + size - 1;
            int right_end = (left_start + 2 * size - 1 < n - 1) ? left_start + 2 * size - 1 : n - 1;

            int n_left = mid - left_start + 1;
            int n_right = right_end - mid;

            int left[n_left], right[n_right];

            for (int i = 0; i < n_left; i++)
                left[i] = arr[left_start + i];

            for (int i = 0; i < n_right; i++)
                right[i] = arr[mid + 1 + i];

            merge(left, right, n_left, n_right, arr);
        }
    }
}

int main(){
	int arr[LEN];

	inputArray(arr, 5);
	
	mergeSort(arr,5);
	
	printArray(arr, 5);
	
	return 0;
}