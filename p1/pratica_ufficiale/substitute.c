#include <stdio.h>
#include <stdlib.h>

void substitute (char *s1, char *s2, int m) {
	
	int len1=0, len2=0;
	
	for (;*s1; s1++)
		len1++;
	s1 -= len1;
	
	s1 += (m-1);
	
	for(; *s2; s2++)
		len2++;
	s2 -= len2;
	
	if (len1-len2 > m)
	{
		for (; *s2; s1++, s2++)
		{
			*s1 = *s2;
		}
	}
}

int main (int argc, char *argv[]) {

	int x;
	
	x = atoi(argv[3]);
	
	substitute(argv[1], argv[2], x);
	
	printf("%s", argv[1]);
	
	return 0;
}