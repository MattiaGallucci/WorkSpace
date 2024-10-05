#include <stdio.h>
#include <stdlib.h>

int bSearch(int *arr, int low, int high, int target){
    if(high >= low){
        int mid = (high+low)/2;

        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            return bSearch(arr, low, mid-1, target);
        }
        if(target > arr[mid]){
            return bSearch(arr, mid+1, high, target);
        }
    }
    return -1;

}

int main(){
               //0  1  2  3  4  5  6   7   8   9   10  11
    int arr[] = {1, 3, 5, 7, 8, 9, 11, 19, 20, 30, 33, 40};
    int size = sizeof(arr)/sizeof(arr[0]);
    int target = 30;

    int i = bSearch(arr, 0, size, target);
    printf("%d", i);
}