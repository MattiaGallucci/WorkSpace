#include "item.h"
#include "stack.h"
#include <stdio.h>

int main(void)
{
	Stack s=newStack();
	int i;
	
	for(i=0; i<5; i++)
		push(s,inputItem());
	
	printf("\nStack: ");
	printStack(s);
	
	for(i=0; i<6; i++){
		pop(s);
		printf("\nStack: ");
		printStack(s);
	}

	return 0;
}