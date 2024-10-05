#include <stdio.h>
#include <stdlib.h>

int stesso_ordine (char *s, char *t);

int main (int argc, char *argv[]) {
	
	if (argc != 3)
		return -1;
	
	printf("%d", stesso_ordine(argv[1], argv[2]));
	
	return 0;
}

int stesso_ordine (char *s, char *t) {
	
	for (; *t != '\0'; s++, t++)
	{
		if (*t == *s)
			;
		if (*t != *s)
			s++;
		if (*s == '\0')
			return 0;
	}
	
	return 1;
}