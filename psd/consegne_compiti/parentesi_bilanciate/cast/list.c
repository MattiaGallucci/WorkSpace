#include "list.h"
#include <stdlib.h>
#include <stdio.h>
#include "item.h"

struct list
{
    int size;
    struct node *head;
};

struct node
{
    Item value;
    struct node *next;
};

List newList()
{
    List l = malloc(sizeof(struct list));
    l->size = 0;
    l->head = NULL;
    return l;
}

int isEmpty(List l)
{
    if (l->size == 0)
        return 1;
    else
        return 0;
}

void addHead(List l, Item a)
{
    struct node *n = malloc(sizeof(struct node));
    n->next = l->head;
    n->value = a;
    l->head = n;
    l->size++;
}

Item removeHead(List l)
{
    if (isEmpty(l))
    {
        return NULL;
    }
    struct node *t = l->head;
    l->head = t->next;
    Item v = t->value;
    free(t);
    l->size--;
    return v;
}

Item getHead(List l)
{
    if (isEmpty(l))
    {
        return NULL;
    }
    return l->head->value;
}