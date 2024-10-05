#include "item.h"

typedef struct stack *Stack;

Stack newStack(); 
int isEmptyStack(Stack); 
int push(Stack, char);
int pop(Stack);
char top(Stack);
void printStack(Stack);
