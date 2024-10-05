#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "orari.txt"
#define LLEN 256

void invalid_format (char *prog) {
	fprintf(stderr, "Uso %s <s/t>"
	              "\nUso %s <p/t> <hh:mm>", prog, prog);
}

int controllo_input (char *s) {
	if (*s == 'p')
		return 2;
	else
		return 3;
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	int input_type, cambi, m1_file, m_file, m1_user, m_user, gap, min_gap=999999, gap_out;
	char line[LLEN+1], dir[3], hp[5], mp[5], ha[5], ma[5], ha_user[5], ma_user[5], h1_out[5], h2_out[5], m1_out[5], m2_out[5];
	
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
	
	while(fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%s %[^:]:%s %[^:]:%s %d", dir, hp, mp, ha, ma, &cambi);
		// printf("Direzione: %s \n", dir);
        // printf("Partenza: %s:%s \n", hp, mp);
        // printf("Arrivo: %s:%s \n", ha, ma);
        // printf("Cambi: %d \n", cambi);
		
		if (input_type == 1)
		{
			if (strcmp(argv[1], dir) == 0)
				printf("%s:%s %s:%s %d\n",hp, mp, ha, ma, cambi);
		}
		
		if (input_type == 2)
		{
			sscanf(argv[2], "%[^:]:%s", ha_user, ma_user);
			m_user = atoi (ma_user) + (60 * (atoi(ha_user))); // printf("%d\n", m_user);
			
			if (strcmp(argv[1], dir) == 0)
			{
				m_file = atoi(ma) + (60 * (atoi(ha)));
				m1_file = atoi(mp) + (60 * (atoi(hp)));
				if (m_file < m_user)
				{
					gap = m_user - m_file;
					if (gap < min_gap)
					{
						min_gap = gap;
						strcpy(h1_out, hp);
						strcpy(m1_out, mp);
						strcpy(h2_out, ha);
						strcpy(m2_out, ma);
						gap_out = m_file - m1_file;
					}
				}
			}
		}
		if (input_type == 3)
		{
			sscanf(argv[2], "%[^:]:%s", ha_user, ma_user);
			m_user = atoi (ma_user) + (60 * (atoi(ha_user))); // printf("%d\n", m_user);
			
			if (strcmp(argv[1], dir) == 0)
			{
				m_file = atoi(ma) + (60 * (atoi(ha)));
				m1_file = atoi (mp) + (60 * (atoi(hp)));
				if (m_file < m_user)
				{
					gap = m_user - m_file;
					if (gap < min_gap)
					{
						min_gap = gap;
						strcpy(h1_out, hp);
						strcpy(m1_out, mp);
						strcpy(h2_out, ha);
						strcpy(m2_out, ma);
						gap_out = m_file - m1_file;
					}
				}
			}
		}
	}
	
	if (input_type == 2)
		printf("%s:%s %s:%s %d", h1_out, m1_out, h2_out, m2_out, gap_out);
	
		if (input_type == 3)
		printf("%s:%s %s:%s %d", h1_out, m1_out, h2_out, m2_out, gap_out);
	
	fclose(fp);
	return 0;
}