#include "item.h"

typedef struct node *BTree;

BTree newTree();
int isEmptyTree(BTree);
BTree buildTree(BTree, BTree, Item);
Item getBTreeRoot(BTree);
BTree getLeft(BTree);
BTree getRight(BTree);

BTree newRandomTree(int);

void printTree(BTree);

int max(int, int);
int heightBTree(BTree);
int *sumTree(BTree);