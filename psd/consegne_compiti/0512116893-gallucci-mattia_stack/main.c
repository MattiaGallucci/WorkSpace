#include "item.h"
#include "stack.h"
#include <stdio.h>

int isOpen (char ch){
	if (ch == '(' || ch == '[' || ch == '{')
		return 1;
	else
		return 0;
}

int isClosed(char ch){
	if (ch == ')' || ch == ']' || ch == '}')
		return 1;
	else
		return 0;
}

int isCorresponding(char ch1, char ch2){
	if ((ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}'))
		return 1;
	else
		return 0;
}

int isBalanced(char *exp){
	Stack s = newStack();
	for (; *exp != '\0'; exp++)
	{
		if (*exp < '0' || *exp > '9')
		{
			if (isOpen(*exp))
			{
				push(s, (Item)*exp);
			}
			else if(isClosed(*exp))
			{
				if(isCorresponding((char)top(s), *exp))
					pop(s);
			}
		}
	}
	if (isEmptyStack(s))
		return 1;
}

int main(void){
	
	char exp[30];
	
	printf("Inserisci espressione: ");
	scanf("%[^\n]", exp);
	
	if (isBalanced(exp))
		printf("L'espressione è bilanciata\n");
	else
		printf("L'espressione non è bilanciata\n");
	
	return 0;
}