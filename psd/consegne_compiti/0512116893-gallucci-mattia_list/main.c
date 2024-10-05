#include "item.h"
#include "list.h"
#include <stdio.h>

int main(void)
{
	List l = newList();
	Item item;
	int i;
	int *pos;
	
	for (i = 0; i < 5; i++)
	{
		Item item = inputItem();
		addHead(l, item);
	}
	
	printList(l);
	printf("\n");
	
	// STAMPA RICORSIVA
	printListRec(l);
	printf("\n");
	
	// RICERCA ELEMETNO RICORSIVO
	printf("Inserisci l'elemento da cercare: ");
	Item search = inputItem();
	searchListRec(l, search, pos);
	printf("Trovato in posizione %d", *pos);
	
	// OCCORRENZE ITEM
	printf("Inserisci l'elemento da contare: ");
	Item count = inputItem();
	printf("Numero di occorrenze: %d\n", countItemListRec(l, count));
	
	// ELIMINA LISTA RICORSIVO
	destroyListRec(l);
	if(isEmpty(l))
		printf("Lista vuota");
	else
		printf("Non va");

	return 0;
}