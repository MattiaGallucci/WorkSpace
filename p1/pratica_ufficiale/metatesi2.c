#include <stdio.h>
#include <stdlib.h>

int metatesi (char *s, char *t) {
	
	int ls=0, lt=0;
	char *ps=s, *pt=t;
	
	for (;*ps, *pt; ps++, pt++)
	{
		ls++;
		lt++;
	}
		
	if (ls == lt)
	{
		while (*s == *t)
		{
			s++; t++;
		}
		
		ps = s; pt = t;
		ps++; pt++;
		
		if (*ps == *t)
		{
			s += 2;
			t += 2;
		}
		
		for (; *s == *t; s++, t++)
			;
		
		if (*s != *t)
			return 0;
		else
			return 1;
	}
}

int main (int argc, char *argv[]) {
	
	if (metatesi (argv[1], argv[2]))
		printf("Ciao\n");
	
	return 0;
}