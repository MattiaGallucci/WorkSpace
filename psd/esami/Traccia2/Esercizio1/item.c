#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "item.h"
#define MAX 100

Item inputItem () {
  char *a=malloc(sizeof(char)*MAX);
  scanf("%s",a);
  return a;
}

void outputItem (Item a) {
  char *stringa=a;
  printf("%s\t",stringa);
}

int compareItem (Item a1, Item a2){
  char *stringa1=a1;
  char *stringa2=a2;
  return strcmp(stringa1,stringa2);
}
