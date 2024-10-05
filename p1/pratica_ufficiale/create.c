#include <stdio.h>
#include <stdlib.h>

void create (char *s1, char *s2, int a, int b) {
	char *p = s2;
	
	*p = '\0';
	a--;
	b--;
	
	while (*s1 && a)
	{
		s1++;
		a--;
	}
	
	if (*s1 == '\0')
		return;
	
	while (*s1 && b)
	{
		b--;
		s1++;
		s2++;
	}
	
	if (*s1 == '\0')
		return;
	
	for (; s2 >= p; s1--, s2--)
		*s2 = *s1;
	
}

int main (int argc, char *argv[]) {
	
	int a, b;
	char s2[atoi(argv[3])];
	
	a = atoi(argv[2]);
	b = atoi(argv[3]);
	
	create(argv[1], s2, a, b);
	
	printf("%s", s2);
	
	return 0;
}