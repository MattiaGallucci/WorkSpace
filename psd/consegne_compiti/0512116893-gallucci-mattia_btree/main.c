#include <stdio.h>
#include "btree.h"
#include "item.h"



int main( void )
{
	BTree h,a,c,d,l,p,s,o,q;
	int x, y;
	
	d=buildTree(NULL,NULL,"d");
	o=buildTree(NULL,NULL,"o");
	q=buildTree(NULL,NULL,"q");
	p=buildTree(NULL,NULL,"p");
	s=buildTree(NULL,NULL,"s");
	l=buildTree(o,q,"l");
	a=buildTree(d,l,"a");
	c=buildTree(p,s,"c");
	h=buildTree(a,c,"h");
	
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
	inOrderIT(h);
	
	return 0;
}