#include "item.h"
#include "queue.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char itemToChar(Item it){
	char *x=malloc(sizeof(char));
	char ch;
	
	x=it;
	for(; *x!='\0'; x++)
		ch=*x;
	return ch;
}

Item charToItem(char c){
    char *x=malloc(sizeof(char) * 2);
	x[0]=c;
	x[1]='\0';
	return x;
}

int main(void)
{
	Queue q = newQueue();
	char s[100];
	
	printf("Inserisci la stringa: ");
	scanf("%s", s);
	printf("Stringa inserita: %s", s);
	
	char *p;
	Item it;
	/*for(int i=0; s[i]!='\0'; i++)
	{
		it = charToItem(s[i]);
		enqueue(q, it);
	}*/
	
	for(int i=0; i<strlen(s); i++)
	{
		char *p=malloc(sizeof(char));
		*p=s[i];
		enqueue(q, p);
	}
	
	/*printf("\nQueue: ");
	printQueue(q);
	printf("\n");*/
	
	int z=0, j;
	char ch;
	printf("\nReverse: ");
	z = reverseQueue(q);
	printf(" %d", z);
	/*printf("\nQueue: ");
	printQueue(q);
	printf("\n");
	for(j=0; !isEmptyQueue(q); j++)
	{
		it=dequeue(q);
		s[j] = itemToChar(it);
	}
	s[j]='\0';
	printf("\nNuova stringa: %s", s);
	printf(" %d", z);
	printf("\n");*/
	
	return 0;
}