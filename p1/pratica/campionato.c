#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "classifica.txt"
#define LLEN 256
#define SLEN 30

void invalid_format(char *prog) {
	fprintf(stderr, "Uso %s <intero>"
	              "\nUso %s <v> <intero>"
				  "\nUso %s <intero> <intero>", prog, prog, prog);
}

int controllo_input (char *s) {
	if(*s == 'v')
		return 2;
	else
		return 3;
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	int input_type, win, draw, lost, goal_fatti, goal_subiti, punti, in_punti, in_win, max_goal=0, min_goal=0, max_win=0, x, y, max_punti=0;
	char line[LLEN+1], squadra[SLEN+1], max_squadra[15], min_squadra[15];
	
	if ((fp=fopen(NOME_FILE, "r")) == NULL)
	{
		fprintf(stderr, "Non posso aprire %s\n", NOME_FILE);
		exit(EXIT_FAILURE);
	}
	
	if (argc < 2 || argc > 3)
	{
		invalid_format(argv[0]);
		exit(EXIT_FAILURE);
	}
	
	if (argc == 2)
		input_type = 1;
	else
		input_type = controllo_input(argv[1]);
	
	while (fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%s %d %d %d %d %d %d", squadra, &punti, &win, &draw, &lost, &goal_fatti, &goal_subiti);
		// printf("Squadra: %s \n", squadra);
        // printf("Punti: %d \n", punti);
        // printf("Win: %d \n", win);
        // printf("Draw: %d \n", draw);
        // printf("Lost: %d \n", lost);
        // printf("Goal fatti: %d \n", goal_fatti);
        // printf("Goal subiti: %d \n", goal_subiti);
		
		if (input_type == 1)
		{
			in_punti = atoi(argv[1]);
			
			if (punti > in_punti)
				printf("%s %d\n", squadra, punti);
		}
		
		if (input_type == 2)
		{
			in_win = atoi(argv[2]);
			
			if (in_win > win)
			{
				if (goal_fatti > max_goal)
				{
					max_goal = goal_fatti;
					max_win = win;
					strcpy(max_squadra, squadra);
				}
			}
		}
		
		if (input_type == 3) 
		{
			x = atoi(argv[1]);
			y = atoi(argv[2]);
			
			if (punti >= x && punti <= y)
			{
				if (punti > max_punti)
				{
					max_punti = punti;
					strcpy(max_squadra, squadra);
					max_goal = goal_fatti;
				}
				else
				{
					strcpy(min_squadra, squadra);
					min_goal = goal_fatti;
				}
					
			}
		}
	}
	
	if (input_type == 2)
		printf("%s %d %d\n", max_squadra, max_win, max_goal);
	
	if (input_type == 3)
		printf("%s %d\n%s %d", max_squadra, max_goal, min_squadra, min_goal);
	
	fclose(fp);
	return 0;
}