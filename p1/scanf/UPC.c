#include<stdio.h>
int main(void) {
	int i1, i2, i3, i4, i5 , i6, i7, i8, i9, i10, i11, sum1, sum2, mult;
	
	printf("\nInserisci il codice di 11 cifre: ");
	scanf("%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d", &i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8, &i9, &i10, &i11);
	
	sum1 = i1 + i3 + i5 + i7 + i9 + i11;
	sum2 = i2 + i4 + i6 + i8 + i10;
	mult = ((sum1 * 3) + sum2) - 1;
	
	printf("\nLa check digit è : %d", 9 - (mult % 10));
	return 0;
}


//ALTERNATIVA

/* 
int d,i1, i2, i3, i4, i5, j1, j2, j3, j4, j5, first_sum, second_sum, total;
 
 printf("Inserisci la prima cifra singola: ");
 scanf("%1d", &d);
 
 printf("Inserisci il primo gruppo di 5 cifre: ");
 scanf("%1d%1d%1d%1d%1d", &i1, &i2, &i3, &i4, &i5);
 
 printf("Inserisci il secondo gruppo di 5 cifre: ");
 scanf("%1d%1d%1d%1d%1d", &j1, &j2, &j3, &j4, &j5);
 
 first_sum = d + i2 + i4 + j1 + j3 + j5;
 second_sum = i1 + i3 + i5 + j2 + j4;
 total = 3 * first_sum + second_sum;
 
 printf("Check Digit: %d\n", 9 - ((total - 1) % 10));
 
 */