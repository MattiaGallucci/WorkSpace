#include <stdio.h>
#include <stdlib.h>

int bifronte (char *s, char *t);

int main (int argc, char *argv[]) {
	
	if (argc != 3)
		return -1;
	
	printf("%d", bifronte(argv[1], argv[2]));
	
	return 0;
}

int bifronte (char *s, char *t) {
	
	while (*t != '\0')
		t++;
	
	for (t = t-2; *s != '\0'; s++, t--)
	{
		if (*s != *t)
			return 0;
	}
	
	return 1;
}