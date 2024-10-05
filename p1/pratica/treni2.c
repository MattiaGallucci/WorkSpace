#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NOME_FILE "orari2.txt"
#define LLEN 256

void invalid_format (char *prog) {
	fprintf(stderr, "Uso %s <1>"
	              "\nUso %s <hh:mm> <hh:mm>", prog, prog);
}

int controllo_input (char *s) {
	for (; *s; s++)
	{
		if (*s == '1')
		{
			s++;
			if (*s == '\0')
				return 1;
		}
	}
	return 2;
}

int hh_to_mm (int h) {
	return (h * 60);
}

int mm_to_hh (int m) {
	return (m / 60);
}

int main (int argc, char *argv[]) {
	
	FILE *fp;
	char line[LLEN+1], hp_file[10], mp_file[10], ha_file[10], ma_file[10], hp_out[5], mp_out[5], ha_out[5], ma_out[5];
	int input_type, cambi, h1_user, m1_user, h2_user, m2_user, m1, m2, m1_file, m2_file, hp, mp, ha, ma, min_m=99999, gap_m, min_h, cambi_out, gap_m_out;
	
	
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
	
	input_type = controllo_input(argv[1]);
	
	while (fgets(line, sizeof(line), fp))
	{
		sscanf(line, "%[^:]:%[^-] - %[^:]:%s %d", hp_file, mp_file, ha_file, ma_file, &cambi);
		// printf("Partenza: %s:%s \n", hp_file, mp_file);
		// printf("Arrivo: %s:%s \n", ha_file, ma_file);
		// printf("Cambi: %d \n", cambi);
		
		if (input_type == 1)
		{
			if (cambi == 0)
				printf("%s:%s %s:%s\n", hp_file, mp_file, ha_file, ma_file);
		}
		
		if (input_type == 2)
		{
			sscanf(argv[1], "%d:%d", &h1_user, &m1_user);
			sscanf(argv[2], "%d:%d", &h2_user, &m2_user);
			
			m1 = (hh_to_mm(h1_user)) + m1_user;
			m2 = (hh_to_mm(h2_user)) + m2_user;
			
			hp = atoi(hp_file);
			mp = atoi(mp_file);
			ha = atoi(ha_file);
			ma = atoi(ma_file);
			// printf("%d:%d\n", hp, mp);
			// printf("%d:%d\n", ha, ma);
			
			m1_file = (hh_to_mm(hp)) + mp;
			m2_file = (hh_to_mm(ha)) + ma;
			
			if(m1_file >= m1 && m2_file <= m2)
			{
				printf("%s:%s %s:%s %d\n", hp_file, mp_file, ha_file, ma_file, cambi);
				
				gap_m = m2_file - m1_file;
				
				if(gap_m < min_m)
				{
					min_m = gap_m;
					strcpy(hp_out, hp_file);
					strcpy(mp_out, mp_file);
					strcpy(ha_out, ha_file);
					strcpy(ma_out, ma_file);
					cambi_out = cambi;
					gap_m_out = min_m;
				}
			}
		}
	}
	
	// printf("%d:%d %d:%d\n", h1_user, m1_user, h2_user, m2_user);
	// printf("%d\n", m1);
	// printf("%d\n", m2);
	
	if (input_type == 2)
		printf("%s:%s %s:%s %d (%d:%d)\n", hp_out, mp_out, ha_out, ma_out, cambi, mm_to_hh(gap_m_out), gap_m_out%60);
	
	fclose(fp);
	return 0;
}
