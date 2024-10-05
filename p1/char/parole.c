#include <stdio.h>

int main(void) {
	char ch;
	int cont_parole=0, cont_caratteri=0;

	printf("Inserisci una frase: \n");
	scanf(" %c", &ch);

	while (ch != '\n') 
	{
		if (ch == ' ') 
		{
			cont_parole++;
			while ((ch=getchar()) == ' ') 
				; //con questo ciclo scorro tutti gli spazi e quando esco, ch conserva il primo carattere non spazio
			if (ch == '\n') 
				cont_parole--; //ossia ci sono spazi dopo l'ultima parola.
		}
		else 
		{ //non sto leggendo uno spazio, incremento il contatore dei caratteri
			cont_caratteri++;
			ch=getchar();
		}
	} cont_parole++; //aggiungo 1 rispetto al numero calcolato per l’ultima parola

	printf("\nNumero parole: %d \n", cont_parole);
	printf("Numero caratteri: %d \n", cont_caratteri);
	printf("Lunghezza media: %.2f\n", (float)cont_caratteri/cont_parole);

	return 0;
}