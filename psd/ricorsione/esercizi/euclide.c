#include <stdio.h>
#include <stdlib.h>

int euclide(int a, int b){
	int r;
	
	if (a == 0)
		return a;
	
	else
	{
		r = a%b;
		if (r == 0)
			return b;
		else
		{
			a=b;
			b=r;
			return euclide(a,b);
		}
	}
}

int main(int argc, char *argv[])
{
	int mcd, a, b;
	
	if (argc != 3)
	{
		fprintf(stderr, "Errore nell'inserimento\n");
		exit(EXIT_FAILURE);
	}
	
	a = atoi(argv[1]);
	b = atoi(argv[2]);
	
	printf("\nMCD = %d\n", euclide(a,b));
	
	return 0;
}