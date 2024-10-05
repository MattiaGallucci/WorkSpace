#include "item.h"
#include "queue.h"
#include <stdio.h>

int main(void)
{
	Queue q = newQueue();
	
	int i;
	
	for(i=0; i<5; i++)
		enqueue(q, inputItem());
	
	printf("\nQueue: ");
	printQueue(q);
	/*
	for(i=0; i<6; i++){
		dequeue(q);
		printf("\nQueue: ");
		printQueue(q);
	}*/
	
	return 0;
}