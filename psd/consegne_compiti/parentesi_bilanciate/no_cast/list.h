#include "item.h"

typedef struct list *List;

List newList();
int isEmpty(List);
void addHead(List, char);
int removeHead(List);
int getHead(List);
int sizeList(List);
void printList(List); 
//
Item searchListItem(List, Item, int *);
Item removeListItem(List, Item);
Item removeListPos(List, int);
int addListPos(List, Item, int);
int addListTail(List, Item);
void reverseList(List);
List cloneList(List);
List cloneListItem(List);
