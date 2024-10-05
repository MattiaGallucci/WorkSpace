#include <stdio.h>
#include "btree.h"
#include "item.h"
#include "list.h"

int isBst(BTree bt) {
	if (isEmptyTree(bt))
		return 1;
	
	Item r=getBTreeRoot(bt);
	BTree left = getLeft(bt);
	BTree right = getRight(bt);
	
	if(left != NULL)
	{
		Item sx=getBTreeRoot(left);
		printf("\nr: "); outputItem(r);
		printf("\nsx: "); outputItem(sx);
		if(cmpItem(sx, r)<0)
			isBst(left);
		else
			return 0;
	}
	
	if(right != NULL)
	{
		Item rx=getBTreeRoot(right);
		printf("\nr: "); outputItem(r);
		printf("\nrx: "); outputItem(rx);
		if(cmpItem(rx, r)>0)
			isBst(right);
		else
			return 0;
	}
	
	if(left==NULL && right==NULL)
		return 1;
}


int main( void )
{
	BTree a, b, c, d, e;
	BTree z, x, y, j, i, f, n, w, u;
	int found;
	Item search, pivot;
	List lista=newList();
	
	int a1=7, b1=3, c1=9, d1=5, e1=1;
	
	d=buildTree(NULL,NULL,&e1);
	e=buildTree(NULL,NULL, &d1);
	c=buildTree(NULL,NULL,&c1);
	b=buildTree(d,e,&b1);
	a=buildTree(b,c,&a1);
	
	/*d=buildTree(NULL,NULL,"1");
	e=buildTree(NULL,NULL, "5");
	c=buildTree(NULL,NULL,"9");
	b=buildTree(d,e,"3");
	a=buildTree(b,c,"7");*/
	
	printf("\nPREORDER: ");
	preOrder(a);
	
	if(isBst(a))
		printf("SI");
	else
		printf("NO");
	
	/*
	printf("\nPREORDER: ");
	preOrder(h);
	
	printf("\nPOSTORDER: ");
	postOrder(h);
	
	printf("\nINORDER: ");
	inOrder(h);
	
	printf("\n\nAltezza: %d", heightTree(h));
	
	printf("\nNumero di nodi: %d", numeroNodi(h));
	
	printf("\nStampa per livello: ");
	perLevel(h);
	
	printf("\n\nPREORDER iterativo: ");
	preOrderIT(h);
	
	printf("\nPOSTORDER iterativo: ");
	//postOrderIT(h);
	
	printf("\nINORDER: ");
	//inOrderIT(h);
	
	printf("\n\nInserisci l'elemento da cercare: ");
	search = inputItem();
	found = searchItem(h, search);
	printf("\nTrovato? %d", found);
	
	
	printf("\nIl massimo è: ");
	//outputItem(maxValue(h));
	
	printf("\nStampa per livello: ");
	perLevel(z);
	
	printf("Uguali? %d", isEqual(h, h));
	
	printf("Inserisci l'elemento pivot: ");
	pivot = inputItem();
	printf("\nQuesti sono gli elementi minori del pivot: ");
	lessThan(h, pivot);
	
	printf("Inserisci l'elemento pivot: ");
	pivot = inputItem();
	lista = lessThanKey(h, pivot);
	printList(lista);*/
	
	return 0;
}