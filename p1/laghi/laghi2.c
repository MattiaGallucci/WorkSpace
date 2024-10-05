#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "laghi.txt"
#define LLEN 256 //ATTENZIONE: VALUTARE LA MASSIMA LUNGHEZZA DI UNA LINEA
#define SLEN 50

void print_invalid_format (char *prog) {
	fprintf(stderr, "Uso: %s <lago> \
				   \nUso: %s <area> <+/->\n", prog, prog);
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

int main (int argc, char *argv[])
{
	
	FILE *fp;
	char line[LLEN+1];	// +1 = '\0'
	char nome[SLEN+1], regioni[2*SLEN+1], to_return[SLEN+1];	//nome lago, regioni 
	int alt, prof, area, max_area = -1, input_type, alt_input, segno;
	
	//controllo file apertura
	if ((fp=fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire il file %s\n", NOME_FILE);
		exit(EXIT_FAILURE);
	}
	
	//controllo su argc
	if (argc > 3 || argc < 2)
	{
		print_invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	
	if (argc == 2)
		input_type = 1;
	else
	{
		input_type = 2;
		alt_input = atoi(argv[1]);
		if (!strcmp (argv[2], "+"))
			segno = 1;
		else if (!strcmp (argv[2], "-"))
			segno = -1;
		else
		{
			print_invalid_format(argv[0]);
			exit(EXIT_FAILURE);
		}
		
	}
	
	//inizio programma
	while (fgets (line, sizeof(line), fp) )
	{
		sscanf(line,"%[^0123456789] %d %d %d %[^\n]", nome, &area, &alt, &prof, regioni);
		pulisci(nome);
		printf("%s %d %d %d %s\n", nome, area, alt, prof, regioni);
		
		if (input_type == 1)
		{
			if (strcmp(argv[1], nome) == 0)
				printf("%s %s\n", nome, regioni);
		}
		
		else if (input_type == 2)
		{
			if (segno == 1)
			{
				if (alt > alt_input)
				{
					if (area > max_area)
					{
						sprintf(to_return, "%s %d", nome, area);
						max_area = area;
					}
				}
			}
			else if (alt < alt_input)
			{
				if (area > max_area)
				{
					sprintf(to_return, "%s %d", nome, area);
					max_area = area;
				}
			}
		}
	}
	
	if (input_type == 2)
		printf("%s\n", to_return);
	
	fclose(fp);
	return 0;
}