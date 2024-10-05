#include<stdio.h>

#define VOLUME ((4.0f/3.0f)*(3.14f))

int main(void) {
	
	int r;
	float v;
	
	printf("Inserisci la misura del raggio della sfera: ");
	scanf("%d", &r);
	
	v = VOLUME*(r * r * r);
	
	printf("Il volume di una sfera di raggio %d è: %f\n", r, v);
	
	return 0;
}