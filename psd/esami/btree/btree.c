#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "btree.h"
#include "queue.h"
#include "stack.h"
#include "list.h"

struct node{
	Item value;
	struct node *left;
	struct node *right;
};

BTree newTree(){
	return NULL;
}

int isEmptyTree(BTree btree){
	if(btree==NULL)
		return 1;
	else 
		return 0;
}

BTree buildTree(BTree left, BTree right, Item value){
	BTree btree=malloc(sizeof(struct node));
	btree->left=left;
	btree->right=right;
	btree->value=value;
	return btree;
}

Item getBTreeRoot(BTree btree){
	if(isEmptyTree(btree))
		return NULL;
	else 
		return btree->value;
}

BTree getLeft(BTree btree){
	if(isEmptyTree(btree))
		return NULL;
	else 
		return btree->left;
}

BTree getRight(BTree btree){
	if(isEmptyTree(btree))
		return NULL;
	else
		return btree->right;
}

void preOrder(BTree btree){
	if(!isEmptyTree(btree))
	{
		outputItem(btree->value);
		preOrder(btree->left);
		preOrder(btree->right);
	}
}

void postOrder(BTree btree){
	if(!isEmptyTree(btree))
	{
		postOrder(btree->left);
		postOrder(btree->right);
		outputItem(btree->value);
	}
}

void inOrder(BTree btree){
	if(!isEmptyTree(btree))
	{
		inOrder(btree->left);
		outputItem(btree->value);
		inOrder(btree->right);
	}
}

int max(int a, int b){
	return a>b ? a : b;
}
int heightTree(BTree btree){
	if(isEmptyTree(btree))
		return 0;
	else if(!getLeft(btree) && !getRight(btree))
		return 0;
	
	else
		return 1 + max(heightTree(btree->left), heightTree(btree->right));
}

int numeroNodi(BTree btree){
	int count=1;
	
	if(isEmptyTree(btree))
		return 0;
	
	else
	{
		if(!isEmptyTree(btree->left))
			count += numeroNodi(btree->left);
		
		if(!isEmptyTree(btree->right))
			count += numeroNodi(btree->right);
	}
	return count;
}

void perLevel(BTree btree){
	Queue q = newQueue();
	BTree left, right;
	
	enqueue(q, btree);
	while(!isEmptyQueue(q))
	{
		BTree node = dequeue(q);
		outputItem(node->value);
		
		if ((left = getLeft(node)) != NULL)
			enqueue(q, left);
		if ((right = getRight(node)) != NULL)
			enqueue(q, right);
	}
}

void preOrderIT(BTree btree){
	Stack s=newStack();
	BTree left, right, temp;
	
	push(s, btree);
	
	while(!isEmptyStack(s))
	{
		temp = top(s);
		outputItem(temp->value);
		pop(s);
		
		if((right = getRight(temp)) != NULL)
			push(s, right);
		
		if((left = getLeft(temp)) != NULL)
			push(s, left);
	}
}

void postOrderIT(BTree btree){
	Stack s=newStack();
	BTree last, curr;
	
	last = NULL;
	curr = btree;
		
	while(!isEmptyStack(s) || curr)
	{
		if(curr)
		{
			push(s, curr);
			curr = getLeft(curr);
		}
		else
		{
			curr = top(s);
			if(getRight(curr) && last != getRight(curr))
				curr = getRight(curr);
			else
			{
				last = curr;
				outputItem(curr->value);
				pop(s );
				curr = NULL;
			}
		}
	}
}

void inOrderIT(BTree btree){
	Stack s=newStack();
	BTree curr;
	
	curr = btree;
	push(s, btree);
	
	while(!isEmptyStack(s) || curr)
	{
		if(curr) //discesa a sx
		{
			push(s, curr);
			curr = getLeft(curr);
		}
		else //visita e discesa a dx
		{
			curr = top(s);
			pop(s);
			outputItem(curr->value);
			curr = getRight(curr); //discesa a dx
		}
	}
}

int searchItem(BTree btree, Item item){
	if(isEmptyTree(btree))
		return 0;
	
	return (cmpItem(btree->value, item) == 0)
	       || searchItem(getLeft(btree), item)
	       || searchItem(getRight(btree), item);
}

Item compare(BTree btree, Item item){
	Item max=item;
	
	if(isEmptyTree(btree))
		return NULL;
	
	if((cmpItem(max, btree->value)) > 0)
	{
		max = btree->value;
		printf("MAX:");
		outputItem(max);
	}
	
	compare(getLeft(btree), max);
	compare(getRight(btree), max);
	return max;
}

Item maxValue(BTree btree){
	if(isEmptyTree(btree))
		return NULL;
	else
		return compare(btree, btree->value);
}

int isEqual(BTree t1, BTree t2){
	int i;
	
	if((cmpItem(t1->value, t2->value) != 0))
		return 0;
	
	i=1;
	
	isEqual((getRight(t1)), (getRight(t2)));
	isEqual((getLeft(t1)), (getLeft(t2)));
	
	return i;
}

void lessThan(BTree h, Item pivot){
	if(isEmptyTree(h))
		return;
	
	if(cmpItem(h->value, pivot) < 0)
		outputItem(h->value);
	lessThan(h->left, pivot);
	lessThan(h->right, pivot);
}

List lessThanKeyLista(BTree bt, Item it, List l){
	if(isEmptyTree(bt))
		return l;
	
	if((cmpItem(bt->value, it)) < 0)
	{
		addHead(l, bt->value);
	}
	
	lessThanKeyLista(bt->left, it, l);
	lessThanKeyLista(bt->right, it, l);
	
}

List lessThanKey(BTree bt, Item it){
	List l=newList();
	lessThanKeyLista(bt, it, l);
	return l;	
}