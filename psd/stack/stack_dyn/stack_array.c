#include <stdlib.h>
#include "stack.h"
#include "item.h"
#define MAXSTACK 50

struct stack
{
    Item arr[MAXSTACK];
    int top;
};

Stack newStack(){
    Stack s=malloc(sizeof(struct stack));
    s->top=0;
    return s;
} 

int isEmptyStack(Stack s){
    return s->top==0;
}

int push(Stack s, Item a){
    if (s->top==MAXSTACK)
        return 0;
    s->arr[s->top]=a;
    s->top++;
    return 1;
}

int pop(Stack s){
    if (isEmptyStack(s))
        return 0;
    s->top--;
    return 1;
}

Item top(Stack s){
    if (isEmptyStack(s))
        return NULL;
    return s->arr[s->top-1];
}

void printStack(Stack s){
    int i;
    for(i=s->top-1;i>=0;i--)
        outputItem(s->arr[i]);
}
