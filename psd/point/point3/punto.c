#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "punto.h"

struct punto{
	float x;
	float y;
};

Punto creaPunto(float x, float y){
	Punto p = malloc(sizeof(struct punto));
	p->x = x;
	p->y = y;
	
	return p;
}

float ascissa(Punto p){
	return p->x;
}

float ordinata(Punto p){
	return p->y;
}

float distanza(Punto p1, Punto p2){
	float dx = (p1->x - p2->x) * (p1->x - p2->x);
	float dy = (p1->y - p2->y) * (p1->y - p2->y);
	
	return sqrt(dx + dy);
}

Punto spostaPunto(Punto p, float dx, float dy){
	p->x = p->x + dx;
	p->y = p->y + dy;
}

Punto centroide(Punto sequenza[], int size){
	int i;
	float sumx = 0.0, sumy = 0.0;
	
	for (i=0; i<size; i++)
	{
		sumx += sequenza[i]->x;
		sumy += sequenza[i]->y;
	}
	
	sumx /= size;
	sumy /= size;
	
	return creaPunto(sumx, sumy);
}

int minDis(Punto sequenza[], int size, float dis){
	int i, j, m=0;
	
	for (i=0; i<size; i++)
	{
		for (j=1; j<size; j++)
		{
			if ( (sequenza[i] != sequenza[j]) && ((distanza(sequenza[i], sequenza[j])) < dis) )
			{
				m++;
				printf("Coppia numero %d: (%.1f, %.1f) (%.1f, %.1f) ha distanza %.1f\n", m, ascissa(sequenza[i]), ordinata(sequenza[i]), ascissa(sequenza[j]), ordinata(sequenza[j]), (distanza(sequenza[i], sequenza[j])));
			}
		}
	}
	
	return m;
}

float maxDis(Punto sequenza[], int size){
	Punto p1_out, p2_out;
	int i, j;
	float dis=-9999999999;
	
	for (i=0; i<size; i++)
	{
		for (j=1; j<size; j++)
		{
			if ((sequenza[i] != sequenza[j]) && ((distanza(sequenza[i], sequenza[j])) > dis))
			{
				dis = (distanza(sequenza[i], sequenza[j]));
				p1_out = sequenza[i];
				p2_out = sequenza[j];
			}
		}
	}
	printf("\nLa distanza massima è %.1f tra i punti (%.1f, %.1f) (%.1f, %.1f)\n",dis, ascissa(p1_out), ordinata(p1_out), ascissa(p2_out), ordinata(p2_out));
	
	return dis;
}