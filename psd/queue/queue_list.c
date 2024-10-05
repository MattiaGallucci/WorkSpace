#include <stdlib.h>
#include "queue.h"
#include "list.h"

struct queue
{
	List l;
};

Queue newQueue()
{
	Queue q = malloc(sizeof(struct queue));
	q->l = newList();
	return q;
}

int isEmptyQueue(Queue q)
{
	return isEmpty(q->l);
}

int enqueue(Queue q, Item item)
{
	return addListTail(q->l, item);
}

Item dequeue(Queue q)
{
	return removeHead(q->l);
}

void printQueue(Queue q)
{
	printList(q->l);
}