#include <stdio.h>

int main(void) {
	
	int i;
	char ch;
	
	printf("Inserisci un intero: ");
	scanf("%d", &i);
	getchar(); //l'utente batterà invio ma verrà prso comunque in considerazione essendo nel buffer !!!
	printf("Inserisci un comando: ");
	ch = getchar();
	printf("ciao\n");
	
	return 0;
}