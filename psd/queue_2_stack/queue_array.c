#include <stdio.h>
#include <stdlib.h>

#include "queue.h"
#include "stack.h"
#include "item.h"

#define MAXQUEUE 50

struct queue{
	Stack s1;
	Stack s2;
};

Queue newQueue(){
	Queue q = malloc(sizeof(struct queue));
	
	if(!q)
		return NULL;
	
	q->s1 = newStack();
	q->s2 = newStack();
	return q;
}

int isEmptyQueue(Queue q){
	return isEmptyStack(q->s1);
}

int enqueue(Queue q, Item item){
	return push(q->s1, item);
}

int enqueue2(Queue q, Item item){
	push(q->s2, item);
	
	return 1;
}

Item dequeue(Queue q){
	if(isEmptyQueue(q))
		return NULL;
	
	Item temp1, temp2;
	
	while(!isEmptyStack(q->s1))
	{
		temp1 = top(q->s1);
		pop(q->s1);
		
		if(!isEmptyStack(q->s1))
			push(q->s2, temp1);
	}
	
	while(!isEmptyStack(q->s2))
	{
		temp2 = top(q->s2);
		pop(q->s2);
		push(q->s1, temp2);
	}
	return temp1;
}

void printQueue(Queue q){
	Item temp;
	
	while(!isEmptyStack(q->s1))
	{
		temp = top(q->s1);
		pop(q->s1);
		push(q->s2, temp);
	}
	
	printStack(q->s2);
	
	while(!isEmptyStack(q->s2))
	{
		temp = top(q->s2);
		pop(q->s2);
		push(q->s1, temp);
	}
}
/*
void printQueue(Queue q){
	Item it;
	
	if(isEmptyQueue(q))
		printStack(q->s2);
	else
	{
		it=top(q->s1);
		pop(q->s1);
		push(q->s2, it);
		printQueue(q);
	}
	
}*/

/*
void printQueue(Queue q){
	printStack(q->s1);
}*/