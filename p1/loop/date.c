#include<stdio.h>
int main(void) {
	
	int d, m, y, d1, m1, y1;
	
	printf("Inserisci una data (dd/mm/yyyy), 0/0/0 per terminare: ");
	scanf("%d /%d /%d", &d, &m, &y);
	
	d1 = d;
	m1 = m;
	y1 = y;
		
	do 
	{
		printf("Inserisci una data (dd/mm/yyyy), 0/0/0 per terminare: ");
		scanf("%d /%d /%d", &d, &m, &y);
		
		if ((d<=d1 && d!=0) && (m<=m1 && m!=0) && (y<=y1 && y!=0)) 
		{
			d1 = d;
			m1 = m;
			y1 = y;
		}
	
	} while (d != 0 && m != 0 && y !=0);
	
	printf("\nLa data più piccola è: %d/%d/%d", d1, m1, y1);
	
	return 0;
}