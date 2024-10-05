/*questo programma calcola le commissioni di un venditore*/
#include<stdio.h>
int main(void) {
	
	float vl;
	
	printf("Inserisci il valore di scambio: € ");
	scanf("%f", &vl);
	
	if (vl < 2500)
		printf("Commissioni : €%f", (30 + (0.017f * vl)));
	else if (vl > 2500 && vl < 6250)
		printf("Commissioni : €%f", (56 + (0.0066f * vl)));	
	else if (vl > 6250 && vl < 20000)
		printf("Commissioni : €%f", (76 + (0.0034f * vl)));
	else if (vl > 20000 && vl < 50000)
		printf("Commissioni : €%f", (100 + (0.0022f * vl)));
	else if (vl > 50000 && vl < 500000)
		printf("Commissioni : €%f", (155 + (0.0011f * vl)));
	else
		printf("Commissioni : €%f", (256 + (0.0009f * vl)));
	
	
	
	
	return 0;
}