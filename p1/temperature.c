#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#define NOME_FILE "temperature.txt"
#define LLEN 256

char *dec_tempo (char *tm, char *str) {
	
	int count=0;
	
	if (*tm == 'p')
		strcpy(str,"piovoso");
	else if (*tm == 's')
		strcpy(str,"soleggiato");
	else
	{
		while(*tm == 'n')
		{
			count++;
			tm++;
		}
		if (*tm != '\0' || count > 3)
			strcpy(str, "errore");
		if (count == 1)
			strcpy(str,"nubi sparse");
		else if (count == 2)
			strcpy(str,"poco nuvoloso");
		else if (count == 3)
			strcpy(str,"molto nuvoloso");
	}
	
	return str;
	
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	int input_type;
	char str_tempo[5], citta[20], tempo[5], line[LLEN], output_citta[20];
	int min, max, cur, output_max=100, output_min=100;
	
	if ((fp=fopen(NOME_FILE, "r") == NULL)
		fprintf(stderr, "Non posso aprire il file %s\n", NOME_FILE);
	
	if (argc == 1)
		input_type = 1;
	else if (argc == 2)
		input_type = 2;
	else if (argc == 3 && strcmp(dec_tempo(argv[1], str_tempo), "errore"))
	{
		if (!strcmp(argv[2], "max"))
			input_type = 3;
		else if (!strcmp(argv[2], "min"))
			input_type = 4;
		else
		{
			printf("Input %s non riconosciuto\n", argv[2]);
			return 1;
		}
	}
	
	while(fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%s %d %d %d %s", citta, &min, &max, &cur, tempo);
		
		if (input_type == 1)
			printf("%s %d %d %d\n", citta, min, cur, max);
		else if (input_type == 2)
		{
			if (!strcmp(citta, argv[1]))
				printf("%s %d %s\n", citta, cur, dec_tempo(tempo, str_tempo));
		}
		else if (input_type == 3)
		{
			if (!strcmp(argv[1], tempo))
				if (cur > output_max)
				{
					output_max = cur;
					strcpy(output_citta, citta);
				}
		}
		else if (input_type == 4)
		{
			if (!strcmp(argv[1], tempo))
				if (cur > output_min)
				{
					output_min = cur;
					strcpy(output_citta, citta);
				}
		}
	}
	
	printf("temp %s: %s\n", argv[2], output_citta);
	
	
	fclose(fp);
	return 0;
}