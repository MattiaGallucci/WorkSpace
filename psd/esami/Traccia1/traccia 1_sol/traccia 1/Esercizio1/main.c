#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "playlist.h"
// utilizzare questa funzione nel main per <stampare, ordinare, stampare> la playlist
// da completare riga ***
void stampaEordina(Playlist pl){
	printf("\n-- Stampa playlist originale --\n");
	printPlaylist(pl);
	printf("\n-- Stampa playlist dopo ordinamento per gradimento --\n");

	// *** inserire qui la chiamata all'operatore che ordina la playlist per gradimento
	sortByGradimento(pl);

	printPlaylist(pl);
	printf("\n\n");
}

// funzione che restituisce un numero intero tra 1 e 100
int randomInt() {
	return 1 + (rand() % 100);
}

int main() { // non modificare/spostare questa riga
	srand(time(NULL)); // non modificare/spostare questa riga
	//Creazione play list
	Playlist pl_vuota = createPlaylist("Playlist vuota");
	Playlist pl_2 = createPlaylist("Playlist 2 canzoni");
	Song s0 = initSong("A", "n1", 80, 80);
	Song s1 = initSong("B", "n1", 90, 90);

	addSong(pl_2, s0);
	addSong(pl_2, s1);


	
	Playlist pl_casuale = createPlaylist("Playlist casuale");
	Song s2 = initSong("A", "n1", randomInt(), randomInt());
	Song s3 = initSong("B", "n1", randomInt(), randomInt());
	Song s4 = initSong("C", "n1", randomInt(), randomInt());
	Song s5 = initSong("D", "n1", randomInt(), randomInt());
	Song s6 = initSong("E", "n1", randomInt(), randomInt());
	Song s7 = initSong("F", "n1", randomInt(), randomInt());
	Song s8 = initSong("G", "n1", randomInt(), randomInt());
	Song s9 = initSong("H", "n1", randomInt(), randomInt());	

	addSong(pl_casuale, s2);
	addSong(pl_casuale, s3);
	addSong(pl_casuale, s4);
	addSong(pl_casuale, s5);
	addSong(pl_casuale, s6);
	addSong(pl_casuale, s7);
	addSong(pl_casuale, s8);
	addSong(pl_casuale, s9);





	stampaEordina(pl_vuota);
	stampaEordina(pl_2);
	stampaEordina(pl_casuale);

	// completare
}
