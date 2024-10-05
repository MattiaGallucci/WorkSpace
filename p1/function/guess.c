#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 100

int secret_num;

void initialize_num(void);
void new_secret_num(void);
void read_guesses(void);

int main(void) {
	
	char c;
	
	printf("Indovina il numero tra 1 e %d.\n", MAX);
	
	initialize_num();
	
	do
	{
		new_secret_num();
		printf("\nNumero scelto.\n\n");
		
		read_guesses();
		
		printf("\nVuoi rigiocare? (Y/N)\n");
		scanf(" %c", &c);
		printf("\n");
	} while (c == 'y' || c == 'Y');
	
	return 0;
}

void initialize_num(void) {
	
	srand((unsigned) time (NULL));
}

void new_secret_num(void) {
	
	secret_num = rand() % MAX +1;
}

void read_guesses(void) {
	
	int guess, num_guess=0;
	
	for (;;) 
	{
		num_guess++;
		
		printf("Inserisci il tuo numero: ");
		scanf("%d", &guess);
		
		if (guess == secret_num)
		{
			printf("\n****************************\n");
			printf("*                          *\n");
			printf("*       HAI VINTO!!!       *\n");
			printf("*                          *\n");
			printf("****************************\n");
			printf("\nNumeri di tentativi: %d\n", num_guess);
			return;
		}
		else if (guess < secret_num)
			printf("Troppo piccolo; riprova.\n\n");
		else
			printf("Troppo grande; riprova\n\n");
	}
}