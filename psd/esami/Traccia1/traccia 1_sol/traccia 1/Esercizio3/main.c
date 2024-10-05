#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "stack.h"
#include "item.h"

// void reverse(FILE* fp, char** final){
// 	char buf[200];
// 	while(fgets(buf, 200, fp) != NULL )
//     {
// 		char param[10];
// 		// parse the first word as parameter (nota leggere tutte le parole con sscanf in while e metterle nello stack poi toglierle dallo stack e inserirle in final)
// 		sscanf(buf, "%s", param);
// 		// printf("param: %s\n", param);
// 		int i;
// 		// quando ho in input solo il parametro arrivo fino alla fine della frase (controllo \0)
// 		for(i = 0; buf[i] != ' ' && buf[i] !='\0'; ++i){

// 		}
// 		// per saltare lo spazio
// 		i++;
// 		char **p = malloc(sizeof(char *) * 100);
// 		for(int k = 0; k < 100; k++)
// 			p[k] = malloc(sizeof(char)*100);
// 		int n_word=0;
// 		int j=-1;
// 		while(buf[i]!='\0'){
// 			j++;
// 			if(buf[i] == ' ' || buf[i] == '\n' || buf[i]=='\r'){
// 				p[n_word][j] = '\0';
// 				n_word++;
// 				j=-1;
// 			}
// 			else {
// 				p[n_word][j]= buf[i];
// 			}
// 			i++;
// 		}
// 		// for(int z = 0; z < n_word; z++)
// 		// 	printf("%s\n",p[z]);
// 		Stack stack = newStack();
// 		for(int i = 0; i < n_word; i++){
// 			// printf("%s\n", p[i]);
// 			push(stack, p[i]);
// 		}

// 		char **rev = malloc(sizeof(char *) * n_word);
// 		for(int k = 0; k < 100; k++)
// 			rev[k] = malloc(sizeof(char)*100);
// 		for(int i = 0; i < n_word; i++){
// 			rev[i] = top(stack);
// 			pop(stack);
// 		}
// 		j = 0;
// 		for(int i = 0; i < n_word; i++){
// 			for(int k = 0; rev[i][k] !='\0';k++, j++){
// 				final[n_phrase][j] = rev[i][k];
// 				// printf("%c\n", rev[i][0]);
// 			}
// 			final[n_phrase][j++]=' ';
// 		}	
// 		final[n_phrase][j]='\0';
// 		n_phrase++;	
// 	}

// }
// extract the first parameter
void extractParam(char *buf, char *param){
	char *sentence = buf;
	char *p = param;

	int isRandom = 0;
	while(*sentence!='\0' && *sentence !=' '){
		if(*sentence == '!'){
			strcpy(param,randomItem());
			isRandom=1;
		}
		else{	
			*p = *sentence;
		}
		p++;
		sentence++;
	}
	
	if(isRandom==0)
		*p='\0';
}


void addSentenceToStack(Stack s, char *sentence){
	int step = 0;
	// skip the first word
	while(*sentence != ' ' && *sentence != '\0')
		sentence++;
	
	for(char *p=sentence; *p !='\0';step=0){
		char * word = malloc(sizeof(char) * 15);
		int isRandom=0;
		while(*p != ' ' && *p !='\r' && *p !='\n'){
			if(*p=='!'){
				strncpy(word, randomItem(),3);
				isRandom=1;
			}
			else
				word[step]= *p;
			step++;
			p++;
		}
		if(isRandom==0)
			word[step]='\0';
		push(s, word);
		p++;
		
	}
	
}

void printAndCheck(Stack s, char *param){
	// outputItem(param);
	printf("Parametro: ");
	outputItem(param);
	printf("\n");
	printf("Stack originale: ");
	printStack(s);
	printf("\n");
	if(isEmptyStack(s))
		printf("Stack invertito: ");
	else{
		// printStack(s);
		printf("Stack invertito: ");
		
		
		Stack reverse_stack = newStack();
		while(!isEmptyStack(s))
		{
			char *word = top(s);
			if(strncmp(word, param, strlen(param))>0){
				push(reverse_stack, word);
			}
			pop(s);
		}
		s = reverse_stack;
		printStack(s);
		
		
	}
		// printf("\n");
	// while(isEmptyStack(s)){

	// }
}


int main() { // non modificare/spostare questa riga
	srand(time(NULL)); // non modificare/spostare questa riga

	
	FILE *fp = fopen("input.txt", "r");
	// mettere tutto in una funzione  che ritorna un array di frasi reverse e poi le stampi
	// char **final = malloc(sizeof(char *) * 100);
	// for(int i = 0; i < 100; i++)
	// 	final[i] = malloc(sizeof(char) * 1500);

	char *buf = malloc(sizeof(char)*1500);
	while(fgets(buf, 1500, fp)){
		Stack s = newStack();
		buf[strcspn(buf, "\n\r")] = '\0';  // truncate string at the first of \n or \r
		char *param = malloc(sizeof(char) * 15);
		extractParam(buf, param);
		addSentenceToStack(s, buf);
		printAndCheck(s,param);
		printf("\n\n");
		free(param);
		free(s);

	}
	

	


}
