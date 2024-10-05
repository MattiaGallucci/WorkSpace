#include <stdlib.h>
#include "stack.h"
#include "item.h"
#define MAXSTACK 50
#define START_DIM 10
#define ADD_DIM 5

struct stack
{
    Item *elements;
    int top;
    int dim;
};

Stack newStack(){
    Stack s=malloc(sizeof(struct stack));
    if(s==NULL) return NULL;
    s->top=0;
    
    s->elements=malloc(sizeof(Item)*START_DIM);
    //CHECK
    if(s->elements==NULL)return NULL;

    s->dim=START_DIM;
    return s;
} 

int isEmptyStack(Stack s){
    return s->top==0;
}

int push(Stack s, Item i)
{  
    Item *temp;
    if (s->top==s->dim)
    { 
       temp=realloc(s->elements,sizeof(Item)*(s->dim+ADD_DIM));
       //check

       if(temp==NULL) return 0;
       else 
       {
         s->elements=temp;
         s->dim+ADD_DIM;
         //printf("Chcek -> Spazio esteso a %d \n",s->dim);
       }

    }
    s->elements[s->top]=i;
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
    return s->elements[s->top-1];
}

void printStack(Stack s){
    int i;
    for(i=s->top-1;i>=0;i--)
        outputItem(s->elements[i]);
}
