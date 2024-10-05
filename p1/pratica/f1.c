#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "classifica2.txt"
#define LLEN 256
#define EXIT exit(EXIT_FAILURE)

void invalid_format (char *prog) {
	fprintf(stderr, "Uso %s <Cognome/prefisso>"
	              "\nUso %s <punti minimi> <punti massimi>", prog, prog);
}

void pulisci (char *s) {
	
	char *f=s;
	
	while (*f != '\0')
		f++;
	f--;
	while ((*f == ' ') || (*f == '\t'))
		f--;
	f++;
	*f = '\0';
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	char line[LLEN+1], nome[15], cognome[15], naz[5], scuderia[50], pilota[80], nome_out[15], cognome_out[15], naz_out[5];
	int pt, input_type, min_pt, max_pt, out_pt;
	
	if((fp=fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s", NOME_FILE);
		EXIT;
	}
	
	if (argc < 2 || argc > 3)
	{
		invalid_format(argv[0]);
		EXIT;
	}
	
	if (argc == 2)
		input_type = 1;
	else
		input_type = 2;
	// printf("%d", input_type);
	
	while(fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%s %s %s %d %[^\n]", nome, cognome, naz, &pt, scuderia);
		pulisci(nome);
		// printf("%s %s %s %d %s\n", nome, cognome, naz, pt, scuderia);
		
		if (input_type == 1)
		{
			if (strncmp(argv[1], cognome, strlen(argv[1])) == 0)
				printf("%s %s %s %d", nome, cognome, scuderia, pt);
		}
		
		if (input_type == 2)
		{
			min_pt = atoi(argv[1]); // printf("%d", min_pt);
			max_pt = atoi(argv[2]); // printf("%d", max_pt);
			
			if (pt > min_pt && pt < max_pt)
			{
				strcpy(nome_out, nome);
				strcpy(cognome_out, cognome);
				strcpy(naz_out, naz);
				min_pt = pt;
				out_pt = pt;
			}
		}
	}
	
	if (input_type == 2)
		printf("%s %s %s %d", nome_out, cognome_out, naz_out, out_pt);
	
	fclose(fp);
	return 0;
}