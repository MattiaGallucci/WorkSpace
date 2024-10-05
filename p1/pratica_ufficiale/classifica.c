#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NOME_FILE "classifica.txt"
#define LLEN 256

void invalid_format (char *prog) {
	fprintf(stderr, "Uso %s <Squadra>"
	              "\nUso %s <int> <int>"
				  "\nUso %s <-a/-d> <int>", prog, prog, prog);
}

int controllo_input(char *s) {
	if (*s >= '0' && *s <= '9')
		return 2;
	s++;
	if (*s == 'a')
		return 3;
	else if (*s == 'd')
		return 4;
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
	int input_type, punti, game, win, draw, loss, goal_fatti, goal_subiti, a, b, max_goal=0, goal_out, min_goal=999;
	char line[LLEN], squadra[20], squadra_out[20];
	
	{ // controllo apertura
	if((fp = fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s\n", NOME_FILE);
		exit(EXIT_FAILURE);
	}
	}
	
	{ // controllo argc
	if (argc < 2 || argc > 4)
	{
		invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	}
	
	{ // input_type
	if (argc == 2)
		input_type = 1;
	else
		input_type = controllo_input(argv[1]);
	// printf("\n%d\n\n", input_type);
	}
	
	{ // programma
	while (fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%[^,], %d %d %d %d %d %d %d", squadra, &punti, &game, &win, &draw, &loss, &goal_fatti, &goal_subiti);
		pulisci(squadra);
		// printf("%s %d %d %d %d %d %d %d\n", squadra, punti, game, win, draw, loss, goal_fatti, goal_subiti);
		
		if (input_type == 1)
		{
			if (strcmp(argv[1], squadra) == 0)
				printf("%s %d", squadra, punti);
		}
		
		if (input_type == 2)
		{
			a = atoi(argv[1]);
			b = atoi(argv[2]);
			
			if (punti >= a && punti <= b)
				printf("%s %d\n", squadra, punti);
		}
		
		if (input_type == 3)
		{
			a = atoi(argv[2]);
			
			if (punti >= a)
			{
				if (goal_fatti >= max_goal)
				{	
					max_goal = goal_fatti;
					strcpy(squadra_out, squadra);
					goal_out = goal_fatti;
				}
			}
		}
	
		if (input_type == 4)
		{
			a = atoi(argv[2]);
			
			if (punti >= a)
			{
				if (goal_subiti <= min_goal)
				{	
					min_goal = goal_subiti;
					strcpy(squadra_out, squadra);
					goal_out = goal_subiti;
				}
			}
		}
	}
	}
	
	{ //stampa finale
	if (input_type == 3)
		printf("%s, goal fatti: %d", squadra_out, goal_out);
	
	if (input_type == 4)
		printf("%s, goal subiti: %d", squadra_out, goal_out);
	}
	
	fclose (fp);
	return 0;
}