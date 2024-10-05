#include <stdio.h>
#include "btree.h"
#include "stack.h"
#include <stdlib.h>

// scrivere *in questo file*:
// - heightAndNumNodes
// - preorder

void calcHeightAndNodes(BTree bt, int *nodes, int *height, int cur_height){
	if(bt == NULL){
		return ;
	}
	else{
		*nodes += 1;
		// Ogni nodo conosce la propria altezza
		cur_height += 1;
		calcHeightAndNodes(getLeft(bt), nodes, height, cur_height);
		// Se l'altezza corrente è maggiore dell'altezza massima trovata aggiorniamo l'altezza
		*height = cur_height > *height ? cur_height : *height;
		calcHeightAndNodes(getRight(bt), nodes, height, cur_height);
	}
}

int* heightAndNumNodes(BTree bt){
	int* hn = malloc(sizeof(int)*2);
	hn[0]=0;
	hn[1]=0;
	calcHeightAndNodes(bt, &hn[0], &hn[1], 0);
	return hn;
}

void preorder(BTree bt){
	Stack s = newStack();
	
	if(!isEmptyTree(bt))
		push(s, bt);
	else{
		printf("vuoto\n");
	}

	while (!isEmptyStack(s))
	{
		BTree curr_node = top(s);
		outputItem(getBTreeRoot(curr_node));
		pop(s);
		BTree right =  getRight(curr_node);
		if(right != NULL)
			push(s,right);
		BTree left =  getLeft(curr_node);
		if(left != NULL)
			push(s, left);
	}
}

void printHeightNumNodesAndPreorder(BTree bt) {
	printf("Albero:\n");
	printTree(bt);
	int* hn = heightAndNumNodes(bt);
	// if(hn) printf("Altezza albero: %d\nNumero nodi albero: %d\n", hn[0], hn[1]);
	printf("Numero nodi: %d, Altezza: %d\n", hn[0], hn[1]);
	printf("\n\n");
	printf("Visita preorder iterativa: ");
	preorder(bt);
	printf("\n\n");
}

int main(){
	BTree aTree;
	//foglia 2
	int x = 1;
	BTree b = newTree();
	BTree c = newTree();
	BTree f2 = buildTree(b, c, &x);

	int new = 1;
	BTree np1 = newTree();
	BTree np2 = newTree();
	BTree np3 = buildTree(np1, np2, &new);
	//foglia 3
	int y = 5;
	BTree e = newTree();
	BTree f = newTree();
	BTree f3 = buildTree(e, np3, &y);

	 
	// albero radicato 9
	int z = 9;
	aTree = buildTree(f2, f3, &z);
	// foglia 1
	int w = 3;
	BTree h = newTree();
	BTree i = newTree();
	BTree f1 = buildTree(h,i, &w); 
	// radice
	int q = 7;
	aTree = buildTree(f1, aTree, &q);

	printHeightNumNodesAndPreorder(aTree);
	// Albero vuoto
	BTree voidTree = newTree();
	printHeightNumNodesAndPreorder(voidTree);

	// Albero con un solo nodo
	BTree rootTree;
	rootTree = buildTree(e,f, &w);
	printHeightNumNodesAndPreorder(rootTree);

	// Albero random
	BTree random = newRandomTree(8);
	printHeightNumNodesAndPreorder(random);
}

