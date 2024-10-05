#include <stdio.h>
#include <stdlib.h>

void eliminaSpazi(char *s, char *s1){
	int i, j;
	
	for (i=0,j=0; ; i++)
	{
		if (s[i] != ' ')
		s1[j++] = s[i];
		if (s[i] == '\0')
		break;
	}
}

void masTomin(char *s){
	int i;
	for (i=0; ; i++)
	{
		if(s[i] >= 'A' && s[i] <= 'Z' && s[i] != '\0')
			s[i] += 32;
		if(s[i] == '\0')
			break;
	}
}

int palindroma(char *s, char *p){
	
	if (*s != *p)
		return 0;
	
	else
	{
		if (*s == ' ')
			palindroma(s+1, p);
		else if (*p == ' ')
			palindroma(s, p-1);
		
		if (*s == '\0')
			return 1;
		
		else
			palindroma(s+1, p-1);
	}
}

int main(){
	
	char s[100], s1[100];

	printf("Inserisci la frase:\n");
	scanf("%[^\n]", &s);
	
	eliminaSpazi(s, s1);
	masTomin(s1);
	
	char *p=s1;

	while (*p != '\0')
		p++;
	p -= 1;
	
	if(palindroma(s1, p) == 0)
		printf("Non è palindroma\n");
	else
		printf("E' palindroma\n");
		
	return 0;
}