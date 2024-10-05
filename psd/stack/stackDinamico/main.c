#include "item.h"
#include "stack.h"
#include <stdio.h>

int palindroma(Stack s){
	Item line[50];
	Item *p;
	
	printf("Inserisci la frase: ");
	scanf("[^\n]", line);
	p = &line;
	
	
	
	return 1;
}

int main(void)
{
	Stack s=newStack();
	int i;
	char *p;
	
	palindroma(s);
	
	for(i=0;i<5;i++){
		push(s,inputItem());
	}
	printf("\nStack: ");
	printStack(s);
	

	return 0;
}