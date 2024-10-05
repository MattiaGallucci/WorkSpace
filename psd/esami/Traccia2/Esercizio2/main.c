#include <stdio.h>
#include "btree.h"

int height(BTree bt){
	if(isEmptyTree(bt))
		return 0;
	
	heightBTree(bt);
}

int* sumByLevel(BTree bt){
	if(isEmptyTree(bt))
		return NULL;
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
	BTree bt;
	
	int x=1;
	BTree fsx = buildTree(NULL, NULL, &x);
	
	int y=5;
	BTree fdx = buildTree(NULL, NULL, &y);
	
	int z=9;
	BTree fsol = buildTree(NULL, NULL, &z);
	
	int i=3;
	BTree sasx = buildTree(fsx, fdx, &i);
	
	int a=7;
	bt = buildTree(sasx, fsol, &a);
	
	printHeightAndSumByLevel(bt);
	
	// da scrivere
}

