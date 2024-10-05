#include <stdio.h>
#include <stdlib.h>

int aggancio_inverso (char *s, char *t, char *z) {
	char *ps=s, *pt=t, *pz=z;
	
	while (*ps)
		ps++;
	ps--;
	
	while (*ps == *pt)
	{
		ps--;
		pt++;
	}
	// printf("%s\n", ps);
	// printf("%s", pt);
	
	while (s <= ps)
	{
		if (*s == *z)
		{
			s++;
			z++;
		}
		else
			return 0;
	} // printf("%s\n", s);
	  // printf("%s\n", z);
	
	while (*pt)
	{
		if (*pt == *z)
		{
			pt++;
			z++;
		}
		else
			return 0;
	}
	
	return 1;	
}

int main (int argc, char *argv[]) {
	
	if (aggancio_inverso(argv[1], argv[2], argv[3]))
		printf("%s è l'aggancio inverso di %s e %s\n", argv[3], argv[1], argv[2]);
	else
		printf("%s non è l'aggancio inverso di %s e %s\n", argv[3], argv[1], argv[2]);
}