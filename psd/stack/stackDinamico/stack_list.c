#include "stack.h"
#include "list.h"
#include "item.h"
#include <stdlib.h>

struct stack{
    List l;
};

Stack newStack(){
    Stack s=malloc(sizeof(struct stack));
    s->l=newList();
    return s;
}

int isEmptyStack(Stack s){
    return isEmpty(s->l);
} 

int push(Stack s, Item a){
    addHead(s->l,a);
    return 1;
} 

int pop(Stack s){
    if (removeHead(s->l)==NULL)
        return 0;
    else
        return 1;
} 

Item top(Stack s){
    return getHead(s->l);
} 

void printStack(Stack s){
    printList(s->l);
}