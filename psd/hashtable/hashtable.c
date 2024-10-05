#include <stdlib.h>
#include "hashtable.h"
#include "list.h"
#include "entry.h"
#include "key.h"

struct hashtable{
	int size;
	List *entries;
};

HashTable newHashtable(int size){
	HashTable h=malloc(sizeof(struct hashtable));
	
	h->size=size;
	h->entries=malloc(sizeof(List)*size);
	
	for(int i=0;i<size;i++)
		h->entries[i]=newList();
	
	return h;
}

int insertHash(HashTable h, Entry en){
	Key k=getKey(en);
	int index=hashValue(k,h->size);
	
	addHead(h->entries[index],en);
	
	return 1;
}

Entry searchHash(HashTable h, Key k){
	int pos;
	int index=hashValue(k,h->size);
	Entry e=newEntry(k,NULL);
	
	return searchListItem(h->entries[index],e,&pos);
}

Entry deleteHash(HashTable h, Key k){
	int index=hashValue(k,h->size);
	Entry e=newEntry(k,NULL);
	
	return removeListItem(h->entries[index],e);
}