#include <stdio.h>
#include <stdlib.h>
#include "bst.h"
#include "item.h"

struct node{
	Item value;
	struct node *left;
	struct node *right;
};

BST newBST(){
	return NULL;
}

int isEmptyBST(BST bst){
	if(bst == NULL)
		return 1;
	else
		return 0;
}

BST getLeft(BST bst){
	if(isEmptyBST(bst))
		return NULL;
	
	return bst->left;
}

BST getRight(BST bst){
	if(isEmptyBST(bst))
		return NULL;
	
	return bst->right;
}

Item getItem(BST bst){
	if(isEmptyBST(bst))
		return NULL;
	
	return bst->value;
}

Item search(BST bst, Item item){
	if(isEmptyBST(bst))
		return NULL;
	
	if(cmpItem(item, bst->value) > 0)
		return search(bst->right, item);
	
	else if(cmpItem(item, bst->value) < 0)
		return search(bst->left, item);
	
	else
		return bst->value;
}

Item min(BST bst){
	if(isEmptyBST(bst))
		return NULL;
	
	while(bst->left != NULL) 
		bst = bst->left;
	
	return bst->value;
}
Item max(BST bst){
	if(isEmptyBST(bst))
		return NULL;
	
	while(bst->right != NULL) 
		bst = bst->right;
	
	return bst->value;
}

void insertBST(BST *bst, Item item){
	if(isEmptyBST(*bst))
	{
		*bst = malloc(sizeof(struct node));
		
		(*bst)->value = item;
		(*bst)->left = NULL;
		(*bst)->right = NULL;
	}
	
	else if(cmpItem(item, (*bst)->value) > 0)
		insertBST(&((*bst)->right), item);
	
	else if(cmpItem(item, (*bst)->value) < 0)
		insertBST(&((*bst)->left), item);
}

Item deleteBST(BST *bst, Item i){
	if(isEmptyBST(*bst))
		return NULL;
	
	int cmp = cmpItem(i, (*bst)->value);
	
	if(cmp > 0)
		return deleteBST(&((*bst)->right),i);
	
	else if(cmp < 0)
		return deleteBST(&((*bst)->left),i);
	
	else
	{
		if(isEmptyBST((*bst)->right))
		{
			Item copia = (*bst)->value;
			BST bstCopia = *bst;

			(*bst) = (*bst)->left;

			free(bstCopia);

			return copia;
		}
		
		else if(isEmptyBST((*bst)->left))
		{
			Item copia = (*bst)->value;
			BST bstCopia = *bst;
			
			(*bst) = (*bst)->right;

			free(bstCopia);

			return copia;
		}
		
		else
		{
			Item maxBst = max((*bst)->left);
			Item copia = (*bst)->value;

			(*bst)->value = maxBst;

			deleteBST(&((*bst)->left),maxBst);

			return copia;
		}
	}
}

void printPerLevel(BST bst)
{
	
}