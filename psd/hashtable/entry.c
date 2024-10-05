#include <stdlib.h>
#include "entry.h"
#include "key.h"
#include "item.h"

struct entry{
	Key key;
	Item value;
};


Entry newEntry(Key s, Item i){
	Entry c=malloc(sizeof(struct entry));
	
	c->key=s;
	c->value=i;
	
	return c;
}


Key getKey(Entry c){
	if(c == NULL)
		return NULL;
	else
		return c->key;
}


Item getValue(Entry c){
	if(c == NULL)
		return NULL;
	else
		return c->value;
}