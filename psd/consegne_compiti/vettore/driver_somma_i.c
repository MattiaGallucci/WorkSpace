#include <stdio.h>
#include <stdlib.h>
#include "vettore.h"

#define LEN 10

int main (void) {
	
	FILE *fp_input_uno, *fp_input_due, *fp_oracolo, *fp_output;
	char line_in_uno[LEN], line_in_due[LEN], line_oracolo[LEN];
	int i, sum=0, oracolo, test, sum_array[LEN];
	
	{ //TEST APERTURA FILE
	if((fp_input_uno=fopen("input_uno_somma_i.txt", "r")) == NULL)
	{
		fprintf(stderr, "1: Non posso aprire input_uno_somma_i.txt\n");
		exit(EXIT_FAILURE);
	}	
	
	if((fp_input_due=fopen("input_due_somma_i.txt", "r")) == NULL)
	{
		fprintf(stderr, "2: Non posso aprire input_due_somma_i.txt\n");
		exit(EXIT_FAILURE);
	}
	
	if((fp_oracolo=fopen("oracolo_somma_i.txt", "r")) == NULL)
	{
		fprintf(stderr, "3: Non posso aprire oracolo_somma_i.txt\n");
		exit(EXIT_FAILURE);
	}	
	
	if((fp_output=fopen("output_somma_i.txt", "w")) == NULL)
	{
		fprintf(stderr, "4: Non posso aprire output_somma_i.txt\n");
		exit(EXIT_FAILURE);
	}
	}
	
	if ((fgets(line_in_uno, LEN, fp_input_uno) && fgets(line_in_due, LEN, fp_input_due)) != 0)
	{
		for (i=0; i<LEN; i++)
		{
			if ((*line_in_uno != ' ') && (*line_in_due != ' '))
			{
				sum_array[i] = char_to_int(line_in_uno+i) + char_to_int(line_in_due+i); printf("sum: %d\n", sum_array[i]);
			}
			else
				continue;
		}
		for(i=0; i<LEN; i++)
			printf("%d ", sum_array[i]);
	}
	
	fclose(fp_input_uno);
	fclose(fp_input_due);
	fclose(fp_output);
	fclose(fp_oracolo);
	return 0;
}