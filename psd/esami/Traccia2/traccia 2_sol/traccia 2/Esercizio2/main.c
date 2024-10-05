#include <stdio.h>
#include "btree.h"

int max(int a, int b){
	return a > b? a : b;
}

int height(BTree bt) {
	if(isEmptyTree(bt)){
		return 0;
	}
	else{
		return 1 + max(height(getLeft(bt)), height(getRight(bt)));
	}
	// da scrivere
}
// versione ricorsiva 
void sumByLevel(BTree bt, int cur_height, int* sum){
	if(bt== NULL){
		return ;
	}
	else{
		// Ogni nodo conosce la propria altezza
		int* val = getBTreeRoot(bt);
		sum[cur_height] += *val; 
		cur_height += 1;
		sumByLevel(getLeft(bt),cur_height, sum);
		// Se l'altezza corrente è maggiore dell'altezza massima trovata aggiorniamo l'altezza
		sumByLevel(getRight(bt), cur_height, sum);
	}
	return ;
	// da scrivere
}

void printHeightAndSumByLevel(BTree bt) {
	printf("Albero:\n");
	printTree(bt);
	int h = height(bt);
	int sums[h];
	for(int i = 0; i < h; i++)
		sums[i]=0;
	printf("Altezza albero: %d\n", h);

	printf("Somma nodi per ogni livello: ");
	sumByLevel(bt, 0, sums);

	for(int i = 0; i < h; i++) {
		printf("%d ", sums[i]);
	}
	printf("\n\n");
}

int main(){
	// Albero random
	BTree random = newRandomTree(8);
	printTree(random);
	printHeightAndSumByLevel(random);
	// da scrivere
}

