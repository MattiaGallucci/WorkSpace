#include "key.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>


#define N 20

int equals(Key s1, Key s2){
	char *c1=s1,*c2=s2;
	
	if(strcmp(c1,c2) == 0)
		return 1;
	else return 0;
}

int hashValue(Key v, int m){
	char *vs=v;
	int h = 0, a = 128;
	
	for (; *vs != '\0'; vs++)
		h = (h*a + *vs) % m;
	
	return h;
}

Key inputKey(){
	char *st=malloc(sizeof(char)*N);
	
	scanf("%s",st);
	
	return st;
}

void outputKey(Key c){
	char *c1=c;
	
	printf("%s",c1);
}