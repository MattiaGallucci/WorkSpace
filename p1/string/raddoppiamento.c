#include <stdio.h>
#include <stdlib.h>

int raddoppiamento (char *s, char *t);

int main (int argc, char *argv[]) {
	
	if (argc != 3)
		return -1;
	
	printf("%d", raddoppiamento(argv[1], argv[2]));
	
	return 0;
}

int raddoppiamento (char *s, char *t) {
	
	int n=0;
	
	for (; *s != '\0'; s++, t++)
	{
		if (*s != *t)
		{
			s++;
			n += 1;
		}
	}
	
	if (n == 1)
		return 1;
	else
		return 0;
	
}