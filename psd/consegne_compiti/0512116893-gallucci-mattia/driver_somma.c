#include <stdio.h>
#include <stdlib.h>
#include "vettore.h"

#define LEN 10

int main(int argc, char *argv[]){

	FILE *fp_input, *fp_oracolo, *fp_output;
	int i, sum_array=0, sum_oracolo, test;;
	char line_in[LEN], line_oracolo[LEN];
	
	{ //TEST APERTURA FILE
	if((fp_input=fopen(argv[1], "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}	
	
	if((fp_oracolo=fopen(argv[2], "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}	
	
	if((fp_output=fopen("output_somma.txt", "w")) == NULL)
	{
		fprintf(stderr, "Non posso aprire output_somma.txt\n");
		exit(EXIT_FAILURE);
	}
	}
	
	if ((fgets(line_in, LEN, fp_input)) != 0)
	{
		for (i=0; i<LEN; i++)
		{
			sum_array += char_to_int(line_in+i); //printf("sum_array = %d\n", sum_array);
		}
		
		fgets(line_oracolo, LEN, fp_oracolo);
		sscanf(line_oracolo, "%d", &sum_oracolo); //printf("sum_oracolo: %d\n", sum_oracolo);
		
		fprintf(fp_output, "Somma ottenuta: %d\nSomma prevista: %d\n", sum_array, sum_oracolo);
		
		if (sum_array == sum_oracolo)
			test = 1;
		
		fprintf(fp_output, "Test case 0: %d\n", test);
	}
	
	fclose(fp_input);
	fclose(fp_output);
	fclose(fp_oracolo);
	
	return 0;
}