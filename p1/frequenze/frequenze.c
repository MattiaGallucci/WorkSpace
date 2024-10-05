#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NOME_FILE "frequenze.txt"
#define LLEN 256
#define PLEN 50

void gestisci_errore_file (void);

void print_invalid_format (char *prog);

int controlla_input_type (char *s);

int main (int argc, char *argv[]) {
	
	FILE *fp;
	int input_type;
	char line[LLEN+1], stazione[PLEN+1], stazione_freq_vicina[PLEN+1];
	float freq, gap, min_gap = 1000.0f;
	
	if ((fp=fopen(NOME_FILE, "r")) == NULL)
		gestisci_errore_file();
	
	if (argc != 2)
	{
		print_invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	
	input_type = controlla_input_type(argv[1]);
	
	while (fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%[^,], %f", stazione, &freq);
		
		if (input_type == 1)
		{		
			if (strncmp(argv[1], stazione, strlen(argv[1])) == 0)
				printf("\n%s %.2f", stazione, freq);
		}
		else
		{
			gap = freq - atof(argv[1]);
			if (gap < 0)
				gap = -gap;
			if (gap < min_gap)
			{
				min_gap = gap;
				sprintf(stazione_freq_vicina, "%s %.2f", stazione, freq);
			}
		}
	}
	
	if (input_type == 2)
		printf("%s", stazione_freq_vicina);
	
	
	fclose(fp);
	return (0);
}

void gestisci_errore_file (void){
	fprintf(stderr, "Non posso aprire il file  %s\n", NOME_FILE);
		exit(EXIT_FAILURE);
}

void print_invalid_format (char *prog) {
	fprintf(stderr, "Uso: %s <stazione>"
				  "\nUso: %s <frequenza>\n", prog, prog);
}

int controlla_input_type (char *s) {
	for(; *s; s++)
	{
		if((*s < '0' || *s > '9') && *s != '.')
			return 1;
	}
	return 2;
}