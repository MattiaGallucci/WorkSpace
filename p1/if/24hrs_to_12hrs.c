#include<stdio.h>
int main(void) {
	
	int hr, mn, pm, am;
	
	printf("Inserisci l'orario in formato 24 ore: ");
	scanf("%d:%d", &hr, &mn);
	
	if (mn >= 00 && mn <= 59 && hr >= 00 && hr <= 24)
	{
	if (hr >= 13 && hr <= 24)
	{pm = hr - 12;
		printf("\nL'equivalente in formato 12 ore è: %d:%,2d PM", pm, mn);
		
	}else if (hr > 0 && hr <= 12)
	{am = hr;
	    printf("\nL'equivalente in formato 12 ore è: %d:%.2d AM", am, mn);
	
	}else if ( hr == 00)
	{printf("\nL'equivalente in formato 12 ore è: 12:%.2d PM", mn);
	
	}}else
	{printf("\nChe cazzo hai inserito");
	}
	
	return 0;
}