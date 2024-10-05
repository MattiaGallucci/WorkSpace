#include <stdio.h>
#include "btree.h"
#include "item.h"

int occurences(BTree a, Item i, int *num){
	if(isEmptyTree(a))
		return 0;
	
	if(cmpItem(getBTreeRoot(a), i) != 0)
	{
		occurences(getLeft(a), i, num);
		occurences(getRight(a), i, num);
	}
	else
	{
		*num += 1;
		occurences(getLeft(a), i, num);
		occurences(getRight(a), i, num);
	}
}

int main( void )
{
	BTree a, b, c, d, e, f, g, h, i, j;
	Item it;
	int num=0;
	j=buildTree(NULL,NULL, "5");
	i=buildTree(NULL,NULL, "5");
	h=buildTree(NULL,NULL, "9");
	d=buildTree(NULL,NULL, "3");
	f=buildTree(NULL,NULL, "7");
	e=buildTree(h, i, "2");
	g=buildTree(j, NULL, "5");
	b=buildTree(d, e, "4");
	c=buildTree(f, g, "9");
	a=buildTree(b, c, "5");

	printf("Inserisci l'item da cercare: ");
	it=inputItem();
	printf("Item: ");
	outputItem(it);
	printf("\n");

	occurences(a, it, &num);
	printf("Occorrenze: %d", num);

	return 0;
}