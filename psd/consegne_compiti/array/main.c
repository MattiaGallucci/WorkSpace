#include <stdio.h>
#include "vettore.h"

#define MAXELEM 100
#define N 10

int main(int argc, char *argv[]){
	
	int a[N], i=0, elem, trovato, input, pos, n=10, val, sort, nInsert;
	char s, line[N];
	int *new;
	
	do {
		
	if (!i)
	{
		printf("\nInserisci la lettera associata all'operazione che intendi eseguire:\n\n"
			"i: Input\n" //i = input
			"o: Output\n" //o = output
			"e: Ricerca elemento\n" //e = elemento
			"m: Ricerca minimo" // m = minimo
			"s: Ordinamento\n" // s = sort
			"d: Eliminazione elemento\n" // d = delete
			"a: Inserisci elemento\n" // a = add
			"x: Esci\n\n" // x = exit
			"Operazione: ");
	} i++;
	
	s = getchar(); printf("\n");
	
	switch (s)
	{
		case 'i':
			inputArray(a, N);
			input = 1;
			break;
		
		case 'o':
			if (input)
			{
					printArray(a, N);
					printf("\n");
			}
			else
				printf("Inserisci prima i numeri\n");
			
			break;
			
		case 'e':
			if (input)
			{
				printf("Inserisci l'elemento da cercare: ");
				scanf("%d", &elem);
				
				trovato = ricerca(a, N, elem);
				if (trovato == -1)
					printf("Elemento non trovato\n");
				else
					printf ("L'elemento si trova nella cella numero %d", trovato+1);
			}
			else
				printf("Inserisci prima i numeri\n");
			
			break;
			
		case 'm':
			if (input)
			{
				findMin(a, N);
			}
			else
				printf("Inserisci prima i numeri\n");
			
			break;
			
		case 's':
			if (input)
			{
				bubbleSort(a, N);
			}
			else
				printf("Inserisci prima i numeri\n");
			
			break;
			
		case 'd':
			if (input)
			{
				printf("Inserisci la posizione dell'elemento da eliminare: ");
				scanf("%d", &pos);
				
				pos--;
				elimina(a, &n, pos);
			}
			else
				printf("Inserisci prima i numeri\n");
			
			break;
			
		case 'a':
			
			// printf("Inserisci %d numeri e premi invio:\n", N);
			// sscanf("%[^\n]", line);
			
			// sort = 1;
			
			printf("Inserisci il numero da inserire: ");
			scanf("%d", &val);
			
			new = input_array_dyn(&nInsert, line);
			
			insertSortArray(new, &nInsert, val);
			insertSort(new, nInsert);
			
			break;
	}
	
	if (i)
		printf("\nOperazione: ");
	
	getchar();
	}while(s != 'x');
	
	return 0;
}