#include<stdio.h>
int main(void) {
	
	int num, r1, r2, r3, r4, r5;
	
	printf("Inserisci un numero da 0 a 32767: ");
	scanf("%5d", &num);
	
	r1 = num % 8;
	num /= 8;
	
	r2 = num % 8;
	num /= 8;
	
	r3 = num % 8;
	num /= 8;
	
	r4 = num % 8;
	num /= 8;
	
	r5 = num % 8;
	num /= 8;
	
	printf("\nIn base 8 equivale a: %d%d%d%d%d", r5, r4, r3, r2, r1);
	
	return 0;
}

//ALTERNATIVO

/*
	int num, r1, r2, r3, r4, r5, q1, q2, q3, q4, q5;
	
	printf("Inserisci un numero tra 0 e 32767: ");
	scanf("%5d", &num);
	
	q1 = num / 8;
	r1 = num % 8;
	
	q2 = q1 / 8;
	r2 = q1 % 8;
	
	q3 = q2 / 8;
	r3 = q2 % 8;
	
	q4 = q3 / 8;
	r4 = q3 % 8;

	q5 = q4 / 8;
	r5 = q4 % 8;
	
	
	printf("In base 8 equivale a: %d%d%d%d%d\n", r5, r4, r3, r2, r1);
*/