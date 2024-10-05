#include <stdio.h>
#include <stdlib.h>

int metatesi (char *s, char *t) {
	
	char *ps, *pt;
	
	while(*s == *t && *s)
	{
		s++;
		t++;
	}
	if (*s == '\0')
		return 0;
	
	if (*s != *(t+1) || *(s+1) != *t)
		return 0;
	
	s += 2;
	t += 2;
	
	while (*s == *t && *s)
	{
		s++;
		t++;
	}
	
	if (*s != *t)
		return 0;
	else
		return 1;
	
}

int main (int argc, char *argv[]) {
	
	if (metatesi (argv[1], argv[2]))
		printf("Ciao\n");
	
	return 0;
}