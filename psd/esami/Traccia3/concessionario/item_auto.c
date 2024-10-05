#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "auto.h"
#include <string.h>
/*
Item inputItem(){
	printf("Non usare inputItem(). Non richiedere input da tastiera.\n");
	return initSong("titolo di prova", "artista di prova", 120, 11);
}
*/
void outputItem(Item item){
	Auto s = item;
	printf("\nTarga: %s - Modello: %s - Immatricolazione: %d - Anno: %d\n", targa(s), modello(s), imm(s), anno(s));
}

int cmpItem(Item item1, Item item2){
	Auto s1 = item1;
	Auto s2 = item2;
	return strcmp(targa(s1), targa(s2));
}
