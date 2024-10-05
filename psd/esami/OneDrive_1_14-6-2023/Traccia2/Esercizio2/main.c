#include <stdio.h>
#include "btree.h"

int max(int a, int b){
	return a>b ? a : b;
}

int height(BTree bt) {
	if(isEmptyTree(bt))
		return 0;
	// da scrivere
	else if(!getLeft(bt) && !getRight(bt))
		return 0;
	
	else
		return 1 + max(height(getLeft(bt)), height(getRight(bt)));
}

int* sumByLevel(BTree bt){
	if(isEmptyTree(bt))
		return NULL;
	int *s[height(bt)];
	s[1]=getBTreeRoot(bt);
	s++;
	*s=sumByLevel(getLeft(bt))+sumByLevel(getRight(bt));
	return *s;
	// da scrivere
}

void printHeightAndSumByLevel(BTree bt) {
	printf("Albero:\n");
	printTree(bt);
	int h = height(bt);
	printf("Altezza albero: %d\n", h);
	printf("Somma nodi per ogni livello: ");
	int* sums = sumByLevel(bt);

	for(int i = 0; i <= h; i++) {
		printf("%d ", sums[i]);
	}
	printf("\n\n");
}

int main(){
	// printHeightAndSumByLevel(aTree);
	// da scrivere
	BTree a, b, c, d, e;
	
	int e1=5, d1=1, c1=9, b1=3, a1=7;
	e=buildTree(NULL, NULL, &e1);
	d=buildTree(NULL, NULL, &d1);
	c=buildTree(NULL, NULL, &c1);
	b=buildTree(d, e, &b1);
	a=buildTree(b, c, &a1);
	
	printHeightAndSumByLevel(a);
	
	
}

