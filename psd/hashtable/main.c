#include "item.h"
#include "list.h"
#include "hashtable.h"

#include <stdio.h>
#define SIZE 5

int main(void)
{
	HashTable h=newHashtable(SIZE);

	for(int i=0; i<SIZE; i++)
	{
		Key k=inputKey();
		Item it=inputItem();
		Entry e=newEntry(k,it);
		insertHash(h,e);
	}
	
	printf("inserisci chiave da cercare: ");
	
	Key k2=inputKey();
	Entry e2=searchHash(h,k2);

	if(e2 != NULL)
		outputItem(getValue(e2));
	else
		printf("non trovato");
	
	return 0;
}