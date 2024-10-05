#include <stdio.h>
#include "btree.h"
#include "item.h"



int main( void )
{
	BTree a, b, c, d, e, f, g, h, i;
	i=buildTree(NULL,NULL,"14)");
	h=buildTree(NULL,NULL,"((11");
	d=buildTree(h,i,"+");
	e=buildTree(NULL,NULL,"1)");
	b=buildTree(d,e,"-");
	f=buildTree(NULL,NULL,"(6");
	g=buildTree(NULL,NULL,"2)");
	c=buildTree(f,g,"*");
	a=buildTree(b,c,"/");
	
	/*printf("PREORDER: ");
	preOrder(a);
	
	printf("\nPOSTORDER: ");
	postOrder(a);*/
	
	printf("\nINORDER: ");
	inOrder(a);
	
	return 0;
}