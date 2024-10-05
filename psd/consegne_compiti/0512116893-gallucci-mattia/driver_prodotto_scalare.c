#include <stdio.h>
#include <stdlib.h>
#include "vettore.h"

#define LEN 10

int main(int argc, char *argv[]){
	
	FILE *fp_input_uno, *fp_input_due, *fp_oracolo, *fp_output;
	char line_in_uno[LEN], line_in_due[LEN], line_oracolo[LEN];
	int i, time=1, oracolo, test;
	
	{ //TEST APERTURA FILE
	if((fp_input_uno=fopen(argv[1], "r")) == NULL)
	{
		fprintf(stderr, "1: Non posso aprire %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}	
	
	if((fp_input_due=fopen(argv[2], "r")) == NULL)
	{
		fprintf(stderr, "2: Non posso aprire %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}
	
	if((fp_oracolo=fopen(argv[3], "r")) == NULL)
	{
		fprintf(stderr, "3: Non posso aprire %s\n", argv[3]);
		exit(EXIT_FAILURE);
	}	
	
	if((fp_output=fopen("output_prodotto_scalare.txt", "w")) == NULL)
	{
		fprintf(stderr, "4: Non posso aprire output_prodotto_scalare.txt\n");
		exit(EXIT_FAILURE);
	}
	}
	
	if ((fgets(line_in_uno, LEN, fp_input_uno) && fgets(line_in_due, LEN, fp_input_due)) != 0)
	{	
		for (i=0; i<LEN; i++)
		{
			time *= prodotto_scalare(line_in_uno+i, line_in_due+i);
		} //printf("time: %d\n", time);
		
		fgets(line_oracolo, LEN, fp_oracolo);
		sscanf(line_oracolo, "%d", &oracolo);
		
		fprintf(fp_output, "Prodotto scalare ottenuto: %d\nProdotto scalare previsto: %d\n", time, oracolo);
		
		if (oracolo == time)
			test = 1;
		
		fprintf(fp_output, "Test case 0: %d\n", test);
	}
	
	fclose(fp_input_uno);
	fclose(fp_input_due);
	fclose(fp_output);
	fclose(fp_oracolo);
	return 0;
}