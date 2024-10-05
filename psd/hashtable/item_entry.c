#include "item.h"
#include "entry.h"

int cmpItem(Item t1,Item t2){
	Entry e1=t1,e2=t2;
	Key k1=getKey(e1),k2=getKey(e2);
	
	if(equals(k1,k2))
		return 0;
	else
		return -1;
}