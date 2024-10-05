/*questo programma calcola il volume di un parallelepipedo di dim inserite dall'utente*/

#include<stdio.h>

int main(void) {

 int h,w,b, volume;

 printf("inserisci il valore dell'altezza\n");
 scanf("%d", &h);

 printf("inserisci il valore della profondità\n");
 scanf("%d", &w);

 printf("inserisci il valore della base\n");
 scanf("%d", &b);

 volume=h*w*b;
 
 printf("\nil volume è: %d\n", volume);


 return 0;
}