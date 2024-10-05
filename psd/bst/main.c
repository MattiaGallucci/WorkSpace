#include <stdio.h>
#include "bst.h"
#include "item.h"

int main( void )
{
	int a[] = {20, 10, 30, 5, 15, 25, 40, 3, 6, 13, 35};
	Item item;
	
	BST t=newBST();
	
	for(int i=0; i < (sizeof(a)/sizeof(int)); i++)
		insertBST(&t, &a[i]);

	printf("Valore da eliminare= ");
	item=inputItem();
	deleteBST(&t,item);
	
	printf("Max= ");
	outputItem(max(t));
	
	printf("\nMin= ");
	outputItem(min(t));
	
	printf("\n");
	return 0;
}