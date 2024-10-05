#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "istat.txt"
#define LLEN 256
#define SLEN 50

void invalid_format(char *prog) {
	fprintf(stderr, "Uso %s <Regione>"
	              "\nUso %s <numero abitanti> <+ ->", prog, prog);
}

int i_type(char *s) {
	for (; *s; s++)
	{
		if (*s < '0' || *s > '9')
			return 1;
	}
	return 2;
}

int controllo_segno(char *s){
	for (; *s; s++)
	{
		if (*s == '+')
			return 1;
	}
	return 2;
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	int input_type, abitanti, num_abitanti=0, segno, in_ab;
	char line[LLEN+1], citta[SLEN+1], sigla[5], regione[SLEN+1];
	
	if ((fp=fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s", NOME_FILE);
		exit(EXIT_FAILURE);
	}
	
	if (argc < 2 || argc > 3)
	{
		invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	
	input_type = i_type(argv[1]);
	
	while (fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%s %s %[^,],%d", citta, sigla, regione, &abitanti);
		//printf("Città: %s \n", citta);
        //printf("Sigla: %s \n", sigla);
        //printf("Regione: %s \n", regione);
        //printf("Abitanti: %d \n", abitanti);
		
		if (input_type == 1)
		{
			if (strncmp(argv[1], regione, strlen(argv[1])) == 0)
			{
				printf("%s %s\n", citta, sigla);
				num_abitanti+=abitanti;
			}
		}
		
		if (input_type == 2)
		{
			segno = controllo_segno(argv[2]);
			in_ab = atoi(argv[1]);
			if (segno == 1)
			{
				if (abitanti > in_ab)
					printf("%s %d\n", citta, abitanti);
			}
			if (segno == 2)
			{
				if (abitanti < in_ab)
				printf("%s %d\n", citta, abitanti);
			}
		}
	}
	
	if (input_type == 1)
		printf("%d\n", num_abitanti);
	
	fclose(fp);
	return 0;
}