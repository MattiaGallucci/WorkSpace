#include <stdio.h>
#include "btree.h"
#include "item.h"

int main( void )
{
	BTree h, a, c, d, l, p, s, o, q;
	BTree z, x, y, j, i, f, n, w, u;
	int found;
	Item search;
	
	d=buildTree(NULL,NULL,"d");
	o=buildTree(NULL,NULL,"o");
	q=buildTree(NULL,NULL,"q");
	p=buildTree(NULL,NULL,"p");
	s=buildTree(NULL,NULL,"s");
	l=buildTree(o,q,"l");
	a=buildTree(d,l,"a");
	c=buildTree(p,s,"c");
	h=buildTree(a,c,"h");
	
	u=buildTree(NULL, NULL, "u");
	w=buildTree(NULL, NULL, "w");
	i=buildTree(w, u, "i");
	f=buildTree(NULL, NULL, "f");
	n=buildTree(NULL, NULL, "n");
	j=buildTree(n, NULL, "j");
	y=buildTree(i, f, "y");
	x=buildTree(NULL, j, "x");
	z=buildTree(x, y, "z");
	
	
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
	*/
	printf("\n\nInserisci l'elemento da cercare: ");
	search = inputItem();
	found = searchItem(h, search);
	printf("\nTrovato? %d", found);
	
	
	printf("\nIl massimo è: ");
	//outputItem(maxValue(h));
	
	printf("\nStampa per livello: ");
	perLevel(z);
	
	printf("Uguali? %d", isEqual(h, h));
	
	return 0;
}