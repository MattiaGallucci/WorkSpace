#include<stdio.h>
int main(void) {
	
	int n, m, i, x, num = 1, y;
	printf("Inserisci il nuemro di righe e colonne della matrice: ");
	scanf("%d %d", &n, &m);
	
	x = m;
	y = n;
	
	while (y)
	{
		for(i = 0; i < m; i++)
		{
			printf ("%-4d\t", num);
			num+=y;
		}
		printf("\n");
		
	--y;
	}
	
/*
	int n, m, i, x, num = 1, y;
	printf("Inserisci il nuemro di righe e colonne della matrice: ");
	scanf("%d %d", &n, &m);
	
	x = m;
	y = n;
	
	while (y)
	{
		for(i = 0; i < m; i++)
		{
			printf ("%d\t", num++);
		}
		printf("\n");
	--y;
	}
*/
	
	return 0;
}