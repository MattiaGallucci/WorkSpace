#include<stdio.h>
int main(void)
{
	int m1, d1, y1, m2, d2, y2;
	int codice;
	
	do {
	printf("Inserisci la prima data (dd/mm/yy): ");
	scanf("%d /%d /%d", &d1, &m1, &y1);
	
	printf("Inserisci la seconda data (dd/mm/yy): ");
	scanf("%d /%d /%d", &d2, &m2, &y2);

	if (d1!=d2 || m1!=m2 || y1!=y2)
	{	if (y1>y2) 
		{
			printf("\n%d/%d/%d viene prima di %d/%d/%d\n", d2, m2, y2, d1, m1, y1);
		}
		if (y2>y1)
		{
			printf("\n%d/%d/%d viene prima di %d/%d/%d\n", d1, m1, y1, d2, m2, y2);
		}
		if (y1==y2)
		{
			if (m1>m2) 
			{
				printf("\n%d/%d/%d viene prima di %d/%d/%d\n", d2, m2, y2, d1, m1, y1);
			}
			if (m2>m1)
			{
				printf("\n%d/%d/%d viene prima di %d/%d/%d\n", d1, m1, y1, d2, m2, y2);
			}
			if (m1==m2)
			{
				if (d1>d2) 
				{
					printf("\n%d/%d/%d viene prima di %d/%d/%d\n", d2, m2, y2, d1, m1, y1);
				}
				if (d2>d1)
				{
					printf("\n%d/%d/%d viene prima di %d/%d/%d\n", d1, m1, y1, d2, m2, y2);
				}
			}
		}
	}
	else
		printf("\nLe date sono uguali\n");
	
	printf("\nVuoi giocare ancora? (SI=1, NO=0) ");
	scanf("%d", &codice);
}   while (codice == 1);
	
	return 0;
}