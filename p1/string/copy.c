#include <stdio.h>
#include <string.h>

char *strcpy (char *s1, const char *s2);

int main (void) {
	
	char *str1, *str2;
	
	strcpy (str2, "abc");  // str2 contiene "abc"
	strcpy (str1, str2);   // str1 contiene "abc"
	
	//strcpy (str1, strcpy (str2, "abc"));
	
	printf("%s", *str1);
	
	return 0;
}