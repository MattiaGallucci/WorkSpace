#include <stdio.h>
#include <stdlib.h>

void inverti_cifre (char *s);

int main (int argc, char *argv[]) {
	
	if (argc != 2)
	{
		fprintf(stderr, "\nUso: %s <stringa>\n", argv[0]);
		return 1;
	}
	
	inverti_cifre (argv[1]);
	printf("\n%s\n", argv[1]);
	
	return 0;
}

void inverti_cifre (char *s) {
	
	char *p, *q;
	char ch;
	
	while (*s)
	{
		if (*s < '0' || *s > '9')
			s++;
		else
		{
			q = s;
			while (*s && (*s >= '0' && *s <= '9'))
				s++;
			p = s-1;
			while (q < p)
			{
				ch = *p;
				*p-- = *q;
				*q++ = ch;
			}
		}
	}
	
}