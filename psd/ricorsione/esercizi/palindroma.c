#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char *substr(char *str){
	char *p = malloc(sizeof(char)*(strlen(str)-1));
	int i;
	
	for(i=1; i<=strlen(str)-2; i++){
		p[i-1]=str[i];
	}
	p[i-1]='\0';
	
	return p;
}

int palindromaIter(char *s){
	int i,j;
	
	for(i=0, j=strlen(s)-1; i<j; i++, j--){
		if(s[i]!=s[j])
			return 0;
	}
	
	return 1;
}

int palindroma(char *s){
	
	//printf("%s\n", s);
	if(strlen(s)<=1)
		return 1;
	else if(s[0]!=s[strlen(s)-1])
		return 0;
	else
		return palindroma(substr(s));
}

int main(int argc, char *argv[]){
	
	if(argc!=2){
		fprintf(stderr, "ERRORE FORMATO INPUT");
		exit(EXIT_FAILURE);
	}
	
	//printf("%s\n", substr(argv[1]));
	
	if(palindroma(argv[1]))
		printf("\nPalindroma\n");
	else
		printf("\nNon palindroma\n");
	
	return 0;
}