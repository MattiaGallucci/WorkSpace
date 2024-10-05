#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

#define N 30
/*
Item charToItem(char c){
	char *p = malloc(sizeof(char));
	*p = c;
	return p;
}

char itemToChar(Item p){
	char *c = malloc(sizeof(char));
	char ch;
	
	c = p;
	ch = *c;
	return ch;
}*/

int isOpen(char c){
	if(c == '(' || c == '[' || c == '{')
		return 1;
	else
		return 0;
}

int isClosed(char c){
	if(c == ')' || c == ']' || c == '}')
		return 1;
	else
		return 0;
}

int corrisponde(char c, char s){
	if( (c=='(' && s==')') || (c=='[' && s==']') || (c=='{' && s=='}') )
		return 1;
	
	else
		return 0;
}

int isBalanced(char *c){
	Stack s=newStack();
	// Item it;
	for(; *c != '\0'; c++)
	{
		if(isOpen(*c))
		{
			// it = charToItem(*c);
			push(s, (Item)*c);
		}
		
		else if(isClosed(*c))
		{
			// it = charToItem(*c);
			if(corrisponde((char)top(s), *c))
				pop(s);
			
			else
				return 0;
		}
	}
	if (isEmptyStack(s))
		return 1;
}

int main() {
	char exp1[N]="(1+[x+{5+4}-7])";
	char exp2[N]="(1+2";
	char exp3[N]="(2+[3*4+{5])";
	char exp4[N]="";
	char exp5[N]="[";
	
	printf("1) Valuto: %s\n", exp1);
	if (isBalanced(exp1))
		printf("L' espressione e' bilanciata\n\n");
	else
		printf("L'espressione non e' bilanciata\n\n");

	printf("2) Valuto: %s\n", exp2);
	if (isBalanced(exp2))
			printf("L' espressione e' bilanciata\n\n");
	else
			printf("L'espressione non e' bilanciata\n\n");

	printf("3) Valuto: %s\n", exp3);
	if (isBalanced(exp3))
			printf("L' espressione e' bilanciata\n\n");
	else
			printf("L'espressione non e' bilanciata\n\n");

	printf("4) Valuto: %s\n", exp4);
	if (isBalanced(exp4))
			printf("L' espressione e' bilanciata\n\n");
	else
			printf("L'espressione non e' bilanciata\n\n");

	printf("5) Valuto: %s\n", exp5);
	if (isBalanced(exp5))
			printf("L' espressione e' bilanciata\n\n");
	else
			printf("L'espressione non e' bilanciata\n\n");
}
