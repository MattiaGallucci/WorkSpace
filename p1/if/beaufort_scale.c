/*questo programma stima la forza del vento*/
#include<stdio.h>
int main(void){
	
	float v;
	
	printf("Inserisci la velocità del vento in nodi: ");
	scanf("%f", &v);
	
	if (v > 0) {
		if (v < 1.0f)
			printf("\nCalmo");
		else if (v <= 3.0f)
			printf("\nAria leggera");
		else if (v <= 27.0f)
			printf("\nBrezza");
		else if (v <= 47.0f)
			printf("\nBurrasca");
		else if (v <= 63.0f)
			printf("\nTempesta");
		else if (v > 63.0f)
			printf("\nUragano");
		
	} else
		printf("\nVelocità non valida");
	
	
	return 0;
}