#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "btree.h"
#include "queue.h"
#include "stack.h"

struct node
{
	Item value;
	struct node *left;
	struct node *right;
};

BTree newTree()
{
	return NULL;
}

int isEmptyTree(BTree btree)
{
	if(btree==NULL)
		return 1;
	else 
		return 0;
}

BTree buildTree(BTree left, BTree right, Item value)
{
	BTree btree=malloc(sizeof(struct node));
	btree->left=left;
	btree->right=right;
	btree->value=value;
	return btree;
}

Item getBTreeRoot(BTree btree)
{
	if(isEmptyTree(btree))
		return NULL;
	else 
		return btree->value;
}

BTree getLeft(BTree btree)
{
	if(isEmptyTree(btree))
		return NULL;
	else 
		return btree->left;
}

BTree getRight(BTree btree)
{
	if(isEmptyTree(btree))
		return NULL;
	else
		return btree->right;
}

void preOrder(BTree btree)
{
	if(!isEmptyTree(btree))
	{
		outputItem(btree->value);
		preOrder(btree->left);
		preOrder(btree->right);
	}
}

void postOrder(BTree btree)
{
	if(!isEmptyTree(btree))
	{
		postOrder(btree->left);
		postOrder(btree->right);
		outputItem(btree->value);
	}
}

void inOrder(BTree btree)
{
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
	BTree left, right, temp, node=btree;
	int i;
	
	push(s, btree);
	
	while(!isEmptyStack(s))
	{
		temp = top(s);
		
		if((right = getRight(temp)) != NULL)
		{
			if(right == node)
			{
				while(temp != btree->left)
				{
					outputItem(temp);
					node = temp;
					pop(s);
					temp = top(s);
				}
				outputItem(temp);
				pop(s);
				temp = top(s);
				if((right = getRight(temp)) != NULL)
					push(s, right);
			}
			else
				push(s, right);
		}
		
		if((left = getLeft(temp)) != NULL)
			push(s, left);
		
		if((right == NULL) && (left == NULL))
		{
			outputItem(temp->value);
			node = temp;
			pop(s);
		}
	}
}

void inOrderIT(BTree btree){
	Stack s=newStack();
	BTree left, right, temp;
	
	push(s, btree);
	
	while(!isEmptyStack(s))
	{
		temp = top(s);
		
		if((right = getRight(temp)) != NULL)
		{
			pop(s);
			push(s, right);
			push(s, temp);
		}
		
		if((left = getLeft(temp)) != NULL)
			push(s, left);
		else
		{
			outputItem(temp->value);
			pop(s);
			if(!isEmptyStack(s))
			{
				temp = top(s);
				outputItem(temp->value);
				pop(s);
			}
			
			if(top(s) == btree)
			{
				temp = top(s);
				outputItem(temp->value);
				pop(s);
			}
		}
	}
}