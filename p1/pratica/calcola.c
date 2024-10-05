#include <stdio.h>
#include <stdlib.h>

int calcola_int (char *s) {
	
	int n=0, l=0, pot=1;
	char *ps=s, *pss=s;
	
	for(; *s; s++)
	{
		while (*ps != '+' && *ps != '-')
		{
			while (*pss >= '0' && *pss <= '9')
			{
				l++;
				pss++;
			}
			
			for(l; l>0; l--)
				pot = pot*10;
			pot /=10;
			
			for (; ps<pss; ps++, pot/10)
			{
				n += ((((int) *ps) - 48) * (pot));
			}
		}
		ps++;
	}printf("%d", n);
}


int main (int argc, char *argv[]) {
	
	int x;
	
	x = calcola_int(argv[1]);
	
	printf("\nOUT %d", x);
	
	return 0;
}