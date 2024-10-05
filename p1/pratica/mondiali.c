#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "albo.txt"
#define LLEN 256
#define SLEN 50

void invalid_format (char *prog) {
	fprintf(stderr, "Uso %s <Nazionale>"
				  "\nUso %s <max>", prog, prog);
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	char line[LLEN+1], naz[50], in_oro[5], in_arg[5], in_bro[5], in_quarto[5], out_naz[50];
	int oro, arg, bro, quarto, input_type, podio, med, max=0;
	
	if ((fp=fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s\n", NOME_FILE);
		exit(EXIT_FAILURE);
	}
	
	if (argc < 2 || argc > 4)
	{
		invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	
	if (argc == 2)
		input_type = 1;
	else if (argc == 3)
	{
		input_type = 2;
		if (!strcmp(argv[2], "oro"))
			med = 1;
		if (!strcmp(argv[2], "argento"))
			med = 2;
		if (!strcmp(argv[2], "bronzo"))
			med = 3;
		
	}
	
	while (fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%[^-0123456789] %s %s %s %s", naz, in_oro, in_arg, in_bro, in_quarto);
		oro = atoi(in_oro);
		arg = atoi(in_arg);
		bro = atoi(in_bro);
		quarto = atoi(in_quarto);
		
		// printf("Naz: %s \n", naz);
		// printf("Oro: %d \n", oro);
		// printf("Arg: %d \n", arg);
		// printf("Bro: %d \n", bro);
		// printf("Qua: %d \n", quarto);
		
		if (input_type == 1)
		{
			if (strncmp(argv[1], naz, strlen(argv[1])) == 0)
			{
				podio = oro+arg+bro;
				printf("%s %d %d %d %d (%d)", naz, oro, arg, bro, quarto, podio);
			}
		}
		
		if (input_type == 2)
		{
			if (med == 1)
			{
				if (oro > max)
				{
					max = oro;
					strcpy(out_naz, naz);
				}
				else if (oro == max)
				{
					strcat(out_naz, naz);
					strcat(out_naz, " ");
				}
			}
			else if (med == 2)
			{
				if (arg > max)
				{
					max = arg;
					strcpy(out_naz, naz);
				}
				else if (arg == max)
				{
					strcat(out_naz, naz);
					strcat(out_naz, " ");
				}
			}
			else if (med == 3)
			{
				if (bro > max)
				{
					max = bro;
					strcpy(out_naz, naz);
				}
				else if (bro == max)
				{
					strcat(out_naz, naz);
					strcat(out_naz, " ");
				}
			}
		}
	}
	
	if (input_type == 2)
		printf("%s %d", out_naz, max);
	
	fclose(fp);
	return 0;
}