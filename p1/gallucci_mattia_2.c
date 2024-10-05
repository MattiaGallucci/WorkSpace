#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NOME_FILE "moons.txt"
#define LLEN 256

{ // FUNZIONI
void invalid_format (char *prog) {
	fprintf(stderr, "Uso: %s <satellite>"
	              "\nUso: %s <anno>"
				  "\nUso: %s d <anno>", prog, prog, prog);
}

int controllo_input (char *s) {
	if (*s >= '0' && *s <= '9')
		return 2;
	return 1;
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

void dis_convert (char *s) {
	for(; *s; s++)
	{
		if (*s == ',')
			*s = '0';
	}
}
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	int input_type, max_dis=0;
	long int min_dis = 999099909990999, dis_file;
	char line[LLEN], nome[20], anno[7], dis[20], dia[10], scopritore[30], anno_in[7], line1_out[50], line2_out[50];
	
	{ // CONTROLLI
	{ // controllo apertura file
	if ((fp=fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s\n", NOME_FILE);
		exit(EXIT_FAILURE);
	}
	}
	
	{ // controllo argomenti
	if (argc < 2 || argc > 3)
	{
		invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	}
	
	{ // controllo input
	if (argc == 3)
		input_type = 3;
	else
		input_type = controllo_input(argv[1]);
	// printf("%d", input_type);
	}
	}
	
	{ // inizio programma
	while (fgets(line, sizeof(line), fp))
	{
		sscanf (line, "%s %s %s %s %[^\n]", nome, anno, dis, dia, scopritore);
		pulisci(nome); // NON VA!!!
		// printf("nome:%s anno:%s dis:%s dia:%s scopritore:%s\n", nome, anno, dis, dia, scopritore);
		// printf("%s", line);
		if (input_type == 1)
		{
			if (strncmp(argv[1], nome, strlen(argv[1])) == 0)
			{
				printf("%s (%s) %s\n", nome, anno, scopritore);
			}
		}
		
		if (input_type == 2)
		{
			sscanf(argv[1], "%s", anno_in);
			
			if (!strcmp(anno_in, anno))
			{
				printf("%s, %s (diametro = %s km)\n", nome, scopritore, dia);
			}
		}
		
		if (input_type == 3) // PROBLEMI CON input_type = 3
		{
			sscanf(argv[1], "%s", anno_in);
			dis_convert(dis); // printf("%s ", dis);
			dis_file = atoi(dis); // printf("%ld\n", dis_file);
			
			// *************** NON FUNZIONA!!! *******************
			
			if (strcmp(anno_in, anno) == NULL) 
			{
				if (dis_file < min_dis)
				{
					// MANCA FUNZIONE PER RIMETTERE ','
					
					min_dis = dis_file;
					strcpy(line1_out, nome);
					strcat(line1_out, " ");
					strcpy(line1_out, dis);
					strcat(line1_out, " ");
					strcpy(line1_out, dia);
				}
				
				if (dis_file > max_dis)
				{
					// MANCA FUNZIONE PER RIMETTERE ','
					
					max_dis = dis_file;
					strcpy(line2_out, nome);
					strcat(line2_out, " ");
					strcpy(line2_out, dis);
					strcat(line2_out, " ");
					strcpy(line2_out, dia);
				}
			}
			
		}
	}
	}
	
	if (input_type == 3)
		printf("%s\n"
	           "%s\n", line1_out, line2_out);
	
	fclose (fp);
	return 0;
}