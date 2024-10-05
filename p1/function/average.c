#include <stdio.h>

double average (double a, double b)
{
	return (a+b)/2;
}

int main(void) {
	
	double x, y, z;
	
	printf("Inserisci 3 numeri: ");
	scanf("%lf %lf %lf", &x, &y, &z);
	
	printf("\nLa media tra %g e %g è: %g\n", x, y, average(x,y));
	printf("La media tra %g e %g è: %g\n", x, z, average(x,z));
	printf("La media tra %g e %g è: %g\n", y, z, average(y,z));
	
	return 0;
}