#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(void){
	int x=-2;
	
	printf("%d", ((x*x)-(2*x)-12));
	
	return 0;
}



/*
	int voti, n, sum=0, sup=0;
	float media;
	
	printf("Metti i voti e -1 per terminare: ");
	scanf("%d", &voti);
	
	while(voti!=-1) {
		if (voti>60)
			++sup;
		sum+=voti;
		++n;
		scanf("%d", &voti);		
	}
	
	media = (sum*1.0)/n;
	
	printf("La media è: %.2f\n", media);
	printf("%d studenti hanno superato la prova.", sup);
*/

/***************************************************************************************************/

/*
	int num, sum=0, n=0;
	float media;
	
	printf("interi e -1 per terminare: ");
	scanf("%d", &num);
	
	while (num!=-1) {
		sum+=num;
		++n;
		media=(sum*1.0)/n;
		printf("La media è: %.2f", media);
		printf("\ninteri e -1 per terminare: ");
		scanf("%d", &num);
	}
*/

/******************************************************************************************/

/*
	int num, pari=0, dispari=0;
	
	printf("Metti num e -1 per terminare: ");
	scanf("%d", &num);
	
	while (num!=-1) {
		if (num%2==0)
			++pari;
		else 
			++dispari;
		scanf("%d", &num);
	}
	
	printf("\nCi sono %d numeri pari e %d numeri dispari.", pari, dispari);
*/

/*****************************************************************************************************/

/*
	int n, m;
	
	printf("Inserisci 2 interi n e m: ");
	scanf("%d %d", &n, &m);
	
	
	
	printf("%d", (n%m==0));
*/

/******************************************************************************************************/

/*
	int anno;
	
	printf("Inserisci l'anno (YYYY): ");
	scanf("%d". &anno);
	
	
	
	printf("%d", (anno%400==0));
*/

/**********************************************************************************************************/

/*
	int i, sum=0;
	
	for (i=0; i<10; i++) {
		if (i%2)
			continue;
		sum += i;
	}
	
	printf("%d\n", sum);
*/

/********************************************************************************************************/

/*
	int num, d=2;
	
	printf("VAI: ");
	scanf("%d", &num);
	
	while ((d*d) <= num) 
	{
		if (num%d == 0)
			break;
		d++;
	}
	printf ("non è primo");
*/

/*********************************************************************************************************************/

/*int n, resto, flag=0, conv=0, pot=1;
	
	printf("Inserisci un numero: ");
	scanf("%d", &n);
	
	do 
	{
		flag++;
		n /= 2;
	} while (n/2 != 0);
	
	do 
	{
		pot *=10;
		flag--;
	}while (flag!=0);
	
	printf("%d", pot);
	
	while (pot >= 0)
	{
		resto = n%2;
		n/=2;
		conv = conv + (resto * pot);
		pot/=10;
	}
	
	printf("%d", conv);
*/

/**************************************************************************************************************************/

/*int i, a[ ] = {2, 1, 5, 8, 9, 0};
	
	for (i = 0; i < 6; i++) {
		a[i]++;
	}
	
	for (i = 0; i < 6; i++) {
		printf("%d ", a[i]);
	}
*/