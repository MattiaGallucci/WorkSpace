#include "item.h"
#include "list.h"
#include <stdio.h>

int main(void)
{
	List l = newList();
	Item item;
	Item found;
	int i, pos;
	for (i = 0; i < 5; i++)
	{
		Item item = inputItem();
		addHead(l, item);
	}

	printList(l);
	printf("\n");

	/*List clone=cloneList(l);
	printList(clone);*/
	
	selectionSort(l);
	printList(l);

	return 0;
}