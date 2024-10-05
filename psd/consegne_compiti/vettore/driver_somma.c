#include <stdio.h>
#include <stdlib.h>
#include "vettore.h"

#define LEN 10

int main(void){

	FILE *fp_input, *fp_oracolo, *fp_output;
	int i, sum_array, sum_oracolo, test;;
	char line_in[LEN], line_oracolo[LEN];
	
	{ //TEST APERTURA FILE
	if((fp_input=fopen("input_somma.txt", "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire input_somma.txt\n");
		exit(EXIT_FAILURE);
	}	
	
	if((fp_oracolo=fopen("oracolo_somma.txt", "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire oracolo_somma.txt\n");
		exit(EXIT_FAILURE);
	}	
	
	if((fp_output=fopen("output_somma.txt", "w")) == NULL)
	{
		fprintf(stderr, "Non posso aprire output_somma.txt\n");
		exit(EXIT_FAILURE);
	}
	}
	
	for (i=0;  fgets(line_in, LEN, fp_input) != NULL; i++)
	{
		sum_array = char_to_int(line_in); //printf("sum_array = %d\n", sum_array);
		
		fgets(line_oracolo, LEN, fp_oracolo);
		sscanf(line_oracolo, "%d", &sum_oracolo); //printf("sum_oracolo: %d\n", sum_oracolo);
		
		fprintf(fp_output, "Somma ottenuta: %d\nSomma prevista: %d\n", sum_array, sum_oracolo);
		
		if (sum_array == sum_oracolo)
			test = 1;
			
		//n_input = input_array_str(arr_input, line);
		
		
		//n_oracolo = input_array_str(arr_oracolo, line);
		
		
		
		//test = compare_array(arr_input, arr_oracolo, n_input, n_oracolo);
		
		fprintf(fp_output, "Test case %d: %d\n", i, test);
	}
	
	fclose(fp_input);
	fclose(fp_output);
	fclose(fp_oracolo);
	
	return 0;
}