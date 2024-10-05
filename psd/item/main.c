#include "array.h"
#include "item.h"

#define LEN 10

int main(void){
	
	Item numbers[LEN];
	int n = 5;
	
	inputArray(numbers, n);
	bubbleSort(numbers, n);
	printArray(numbers, n);
	
	return 0;
}