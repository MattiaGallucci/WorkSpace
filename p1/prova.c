#include <stdio.h>

int f (char s[], char t[]) {
	int i,j;
		
	for (i=0; s[i] !='.'; i++)
		for (j=0; t[j] !='.'; j++)
	if (s[i]==t[j]) 
	return i+1;
	
	return -1;
}
int main(void) {
	char a[]={'b','u','o','n','.'};
	char b[]={'n','a','t','a','l','e','.'};
	char c[]={'e','s','a','m','e','.'};
	char d[]={'s','t','u','d','i','a','.'};
	
	printf("Valore della chiamata: %d\n", f(a,b));
	printf("Valore della chiamata: %d\n", f(a,c));
	printf("Valore della chiamata: %d\n", f(a,d));
	printf("Valore della chiamata: %d\n", f(d,c));
	
	return 0;
}