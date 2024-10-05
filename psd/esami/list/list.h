#include "item.h"

typedef struct list *List;

List newList();
int isEmpty(List);
void addHead(List, Item);
Item removeHead(List);
Item getHead(List);
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
List selectionSort(List);
struct node *minimo (struct node *p);
void swap(Item *a, Item *b);

void printListRec(List list);
Item searchListRec(List list, Item item, int *pos);
int countItemListRec(List list, Item item);
void destroyListRec(List list);

Item maxItem(struct node* , Item);
void maxList(List);