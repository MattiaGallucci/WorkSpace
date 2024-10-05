/*questo programma converte i gradi fahrenheit in gradi centrigradi*/
#include<stdio.h>

#define FREEZING_PT 32.0f
#define SCALE_FACTOR (5.0f/9.0f)

int main(void) {
	float fahrenheit1, fahrenheit2, fahrenheit3, celsius1, celsius2, celsius3;
	
	printf("Inserisci la prima temperatura in Fahrenheit: ");
	scanf("%f", &fahrenheit1);
	
	printf("Inserisci la seconda temperatura in Fahrenheit: ");
	scanf("%f", &fahrenheit2);
	
	printf("Inserisci la terza temperatura in Fahrenheit: ");
	scanf("%f", &fahrenheit3);
	
	celsius1 = (fahrenheit1 - FREEZING_PT) * SCALE_FACTOR;
	celsius2 = (fahrenheit2 - FREEZING_PT) * SCALE_FACTOR;
	celsius3 = (fahrenheit3 - FREEZING_PT) * SCALE_FACTOR;
	
	printf("\nLe equivalenti in Celsius sono: \n");
	
	printf("\t%.3f°F\t%.3f°C\n", fahrenheit1, celsius1);
	printf("\t%.3f°F\t%.3f°C\n", fahrenheit2, celsius2);
	printf("\t%.3f°F\t%.3f°C\n", fahrenheit3, celsius3);
	
	return 0;
 }