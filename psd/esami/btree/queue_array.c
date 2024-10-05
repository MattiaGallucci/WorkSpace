#include <stdlib.h>
#include "queue.h"
#define MAXQUEUE 50

struct queue {
	Item arr[MAXQUEUE];
	int head;
	int tail;
};

Queue newQueue()
{
	Queue q = malloc(sizeof(struct queue));
	q->head = 0;
	q->tail = 0;
	return q;
}

int isEmptyQueue(Queue q)
{
	if (q->head == q->tail)
		return 1;
	
	else return 0;
}

int enqueue(Queue q, Item item)
{
	if ((q->tail + 1) % MAXQUEUE == q->head)
		return 0;
	
	q->arr[q->tail] = item;
	q->tail = (q->tail + 1) % MAXQUEUE;
	
	return 1;
}

Item dequeue(Queue q)
{
	if (isEmptyQueue(q) == 1)
		return NULL;
	
	Item item = q->arr[q->head];
	
	q->head = (q->head + 1) % MAXQUEUE;
	
	return item;
}

void printQueue(Queue q)
{
	int i;
	
	for (i = q->head; i != q->tail; i = (i + 1) % MAXQUEUE)
		outputItem(q->arr[i]);
	
}