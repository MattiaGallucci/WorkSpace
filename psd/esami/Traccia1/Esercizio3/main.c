#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "item.h"
#include "stack.h"

#define LLEN 100

void addToStack(Stack s, char *frase){
	char *p;
	int index=0;
	
	for(p=frase; *p != '\0'; index=0)
	{
		char *a = malloc(sizeof(char) * 15);
		
		while(*p != ' ' && *p != '\n')
		{
			a[index] = *p;
			index++;
			p++;
		}
		push(s, a);
		p++;
	}
}

int main() { // non modificare/spostare questa riga
	srand(time(NULL)); // non modificare/spostare questa riga
	
	FILE *fp;
	char line[LLEN], stringa[150], parametro[150];
	int i;
	Stack s=newStack();
	
	if((fp=fopen("input.txt", "r")) == NULL){
		fprintf(stderr, "Impossibile aprire il file\n");
		exit(EXIT_FAILURE);
	}
	
	while(fgets(line, LLEN, fp))
	{	
		sscanf(line, "%s %[^\n]", parametro, stringa);
		
		addToStack(s, stringa);
		
		printf("Elemento parametro: %s\n", parametro);
		printf("Stack originale: \n");
		printStack(s);
		printf("\n");
		printf("\n\n");
		
		
		
		while(!isEmptyStack(s))
			pop(s);
	}
	
	fclose(fp);
	return 0;
}
