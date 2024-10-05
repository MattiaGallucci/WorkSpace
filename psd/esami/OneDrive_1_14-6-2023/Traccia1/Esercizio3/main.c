#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "item.h"
#include "stack.h"

void addToStack(Stack s, char *stringa){
	char *p, *i;
	for(p=stringa; *p!='\0'; p++);
	p--;
	
	for(i=stringa; p>=i; p--){
		push(s, p);
	}
}

int main() { // non modificare/spostare questa riga
	srand(time(NULL)); // non modificare/spostare questa riga
	
	FILE *fp;
	char line[200], parametro[20], stringa[100];
	
	if((fp=fopen("input.txt", "r")) == NULL)
		exit(EXIT_FAILURE);
	
	while(fgets(line, 200, fp))
	{
		Stack s;
		sscanf(line, "%s %[^\n]", parametro, stringa);
		
		addToStack(s, stringa);
		printf("Parametro: %s\nStringa: %s\nStack: ", parametro, stringa);
		printStack(s);
		printf("\n");
		printf("\n");
		
		char *z=parametro;
		while(!isEmptyStack(s))
		{
			char *it=top(s);
			pop(s);
			if(*it!= ' ')
			{
				char *out=malloc(sizeof(char) *15);
				if(compareItem(z, it) == 0)
				{
					z++;
					out[];
				}
				if(compareItem(z, it) < 0)
					while(*it!=' ')
					pop(s);
			}
		}
		
	}
	fclose(fp);
}
