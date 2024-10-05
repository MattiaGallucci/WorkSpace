#include <stdio.h>
#include <stdlib.h>

int estrazione(char *s, char *t, char *z) {
	
	char *ps, *pt, *pss, *ptt, *pz=z;
	int len=0;
	
	while (*s == *t)
	{
		len++;
		s++;
		t++;
	}
	
	if(len == 0)
		return 0;
	
	ps = s;
	pt = t;
	
	while (*s)
		s++;
	while (*t)
		t++;
	
	while (*s == *t)
	{
		len--;
		s--;
		t--;
	}
	
	if (len >= 0)
		return 0;
	
	pss = s;
	ptt = t;
	
	while (ps <= pss)
		*z++ = *ps++;

	while (pt <= pt)
		*z++ = *pt++;
	
	if (z == pz)
		return 0;
	
	*z = '\0';
	
	return 1;
}

int main (int argc, char  *argv[]) {
	
	if (argc != 3)
	{
		fprintf(stderr, "Uso %s <str1> <str2>\n", argv[0]);
		exit(EXIT_FAILURE);
	}
	
	char z[100];
	
	if (estrazione(argv[1], argv[2], z))
		printf("%s\n", z);
	
	return 0;
}