#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "auto.h"

struct automobile{
	char *targa;
	int imm;
	char *modello;
	int anno;
};

Auto initAuto(char *targa, int imm, char *modello, int anno){
	Auto a = malloc(sizeof(struct automobile));
	a->targa = strdup(targa);
	a->imm = imm;
	a->modello = strdup(modello);
	a->anno = anno;
	
	return a;
}

char* targa(Auto s){
	char *targa = malloc(sizeof(char) * (1+strlen(s->targa)));
	strcpy(targa, s->targa);
	return targa;
}

int imm(Auto s){
	return s->imm;
}

char* modello(Auto s){
	char *modello = malloc(sizeof(char) * (1+strlen(s->modello)));
	strcpy(modello, s->modello);
	return modello;
}

int anno(Auto s){
	return s->anno;
}