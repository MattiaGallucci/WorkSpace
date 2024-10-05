#include <stdio.h>
#include <stdlib.h>
#include "punto.h"

int main(){
	
	int n, i, m;
	float x, y, dx, dy, dis, max_dis;
	Punto p1, p2, centro;
	Punto *p;
	
	printf("Inserisci le coordinate del punto 1:\n");
	scanf("%f", &x);
	scanf("%f", &y);
	p1 = creaPunto(x, y);
	
	printf("Inserisci le coordinate del punto 2:\n");
	scanf("%f", &x);
	scanf("%f", &y);
	p2 = creaPunto(x, y);
	
	printf("distanza: %.1f\n", distanza(p1, p2));
	
	printf("Inserisci due numeri deltaX e deltaY da sommare al punto 1:\n");
	scanf("%f", &dx);
	scanf("%f", &dy);
	
	p1 = spostaPunto(p1, dx, dy);
	printf("Nuovo punto: %.1f %.1f\n", ascissa(p1), ordinata(p1));
	
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
	
	return 0;
}