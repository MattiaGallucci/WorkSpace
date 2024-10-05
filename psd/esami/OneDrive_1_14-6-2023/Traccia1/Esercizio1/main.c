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

	// completare
	Playlist pl0=createPlaylist("Brani preferiti");
	
	Song s0, s1, s2, s3, s4;
	s0=initSong("Titanium", "Dave", 207);
	s1=initSong("Danger", "Metro", 325);
	s2=initSong("Gangster", "YT", 240);
	s3=initSong("Hot", "YT", 439);
	s4=initSong("Healing", "Tion", 240);
	
	addSong(pl0, s0);
	addSong(pl0, s1);
	addSong(pl0, s2);
	addSong(pl0, s3);
	addSong(pl0, s4);
	
	printPlaylist(pl0);
}
