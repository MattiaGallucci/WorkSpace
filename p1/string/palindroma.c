#include <stdio.h>
#include <stdlib.h>

int palindroma (char *s);

int main(int argc, char *argv[]) {
	
	if (argc != 2)
		return -1;
	
	printf("%d", palindroma(argv[1]));
	
	return 0;
}

int palindroma (char *s)
{
	char *p = s;
	
	while (*p != '\0')
		p++;
	
	for (p = p-1; s < p; s++, p--)
	{
		while (*s == ' ')
			s++;
		while (*p == ' ')
			p--;
		if (*s != *p)
			return 0;
	}
	
	return 1;
}