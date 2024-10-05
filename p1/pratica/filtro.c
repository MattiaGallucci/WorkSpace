#include <stdio.h>
#include <stdlib.h>

void filtro (char *s, char c) {
	int len=0;
	char h;
	for (; *s; s++)
	{
		len++;
		if (*s == c)
		{
			*s = ' ';
		}
	}
	s--;
	for (; *s; s--)
	{
		if(*(s-1) == ' ')
		{
			h = *s;
			*s = ' ';
			s--;
			*s = h;
		}
	}
}

int main (int argc, char *argv[]) {
	
	char c;
	
	for(; *argv[2]; argv[2]++)
	{
		c = *argv[2];
	}
	filtro(argv[1], c);
	
	printf("%s", argv[1]);
	
	return 0;
}