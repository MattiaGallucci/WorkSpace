#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "auto.h"
#include "list.h"
#include "concessionario.h"

struct catalogo{
	List macchine;
};

Catalogo createCatalogo(){
	Catalogo cat = malloc(sizeof(struct catalogo));
	cat->macchine = newList();
	return cat;
}

void addAuto(Catalogo cat, Auto a){
	addHead(cat->macchine, a);
}

void printCatalogo(Catalogo cat){
	printList(cat->macchine);
	printf("\n");
}

void removeAuto(Catalogo cat){
	
}