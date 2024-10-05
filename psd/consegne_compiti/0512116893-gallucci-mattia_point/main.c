#include <stdio.h>
#include <stdlib.h>
#include "punto.h"

int main(){
	
	char s;
	int n, i, m;
	float x, y, dx, dy, dis, max_dis;
	Punto p1, p2, centro;
	Punto *p;
	
	printf("\n1: Inserisci 2 punti\n"
		   "2: Calcola distanza di 2 punti\n"
		   "3: Somma numeri al punto\n"
		   "4: Calcola centro di un insieme di numeri\n"
		   "5: Individua le coppie di punti la cui distanza è minore di una desiderata\n"
		   "6: Individua la coppia di punti che ha distanza maggiore\n"
		   "0: Esci\n\n");
	
	do
	{
		printf("Operazione: ");
		s = getchar(); printf("\n");
		
		switch (s)
		{
			case ('1'):
				printf("Inserisci le coordinate del punto 1:\n");
				scanf("%f", &x);
				scanf("%f", &y);
				p1 = creaPunto(x, y);
				
				printf("Inserisci le coordinate del punto 2:\n");
				scanf("%f", &x);
				scanf("%f", &y);
				p2 = creaPunto(x, y);
				break;
				
			case ('2'):
				printf("\nDistanza: %.1f\n", distanza(p1, p2));
				break;	
				
			case ('3'):
				printf("Inserisci le coordinate del punto 1:\n");
				scanf("%f", &x);
				scanf("%f", &y);
				p1 = creaPunto(x, y);
				
				printf("Inserisci due numeri deltaX e deltaY da sommare al punto 1:\n");
				scanf("%f", &dx);
				scanf("%f", &dy);
				
				p1 = spostaPunto(p1, dx, dy);
				printf("Nuovo punto: %.1f %.1f\n", ascissa(p1), ordinata(p1));
				break;
				
			case ('4'):
				printf("Quanti punti vuoi inserire: ");
				scanf("%d", &n);
				p = calloc(n, sizeof(float));
				
				for (i=0; i<n; i++)
				{
					printf("Punto %d: ", i+1);
					scanf("%f %f", &x, &y);
					p[i] = creaPunto(x, y);
				}
				
				centro = centroide(p, n);
				printf("\nCentroide: %.1f %.1f\n", ascissa(centro), ordinata(centro));
				break;
				
			case ('5'):
				printf("Quanti punti vuoi inserire: ");
				scanf("%d", &n);
				
				if (n < 2)
					printf ("\nInserisci minimo 2 punti\n");
				else
				{
					p = calloc(n, sizeof(float));
					
					for (i=0; i<n; i++)
					{
						printf("Punto %d: ", i+1);
						scanf("%f %f", &x, &y);
						p[i] = creaPunto(x, y);
						
					}
					
					printf("\nInserisci la distanza massima che i punti devono avere: ");
					scanf("%f", &dis);
					printf("\n");
					
					if(dis != 0)
					{
						m = minDis(p, n, dis);
						printf("\nLe coppie sono %d\n", m);
					}
					else
						printf("Riprova con una distanza diversa da 0\n");
				}
				break;
				
			case ('6'):
				printf("Quanti punti vuoi inserire: ");
				scanf("%d", &n);
				
				if (n < 2)
					printf ("\nInserisci minimo 2 punti\n");
				else
				{
					p = calloc(n, sizeof(float));
					
					for (i=0; i<n; i++)
					{
						printf("Punto %d: ", i+1);
						scanf("%f %f", &x, &y);
						p[i] = creaPunto(x, y);
						
					}
					
					max_dis = maxDis(p, n);
				}
				break;
				
		}
		getchar();
	}while (s != '0');
	
	return 0;
}