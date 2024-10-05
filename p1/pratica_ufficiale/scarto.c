#include <stdio.h>
#include <stdlib.h>

char *scarto (char *s, char *t) {
	
	char *ps=s, *pt=t, *p_toreturn;
	
	for (; *t && *s == *t; s++, t++)
		;
	if (*s == *t)
		return NULL;
	
	if (*s == *(t+1))
	{
		t++;
		p_toreturn = ps;
	}
	else if (*(s+1) == *t)
	{
		s++;
		p_toreturn = pt;
	}
	
	for (; *t && *s == *t; s++, t++)
		;
	return (*s == *t)? p_toreturn: NULL;
	
	
}

int main (int argc, char *argv[]) {
	char *p;
	
	if ((p=scarto(argv[1], argv[2])) != NULL)
		printf("%s\n", p);
	
	return 0;
}