#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#include "playlist.h"
#include "song.h"

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
	Playlist pl0 = createPlaylist("Playlist vuota");
	Playlist pl1 = createPlaylist("Playlist con una canzone");
	Playlist pl2 = createPlaylist("Playlist con due canzoni");
	Playlist pl4 = createPlaylist("Playlist con quattro canzoni");
	Playlist pl5 = createPlaylist("Playlist con cinque canzoni con gradimento casuale");
	
	
	addSong(pl1, initSong("A", "A", 180, 80));
	reversePlaylist(pl1);
	
	addSong(pl2, initSong("B", "B", 180, 70));
	addSong(pl2, initSong("C", "C", 180, 80));
	reversePlaylist(pl2);
	
	addSong(pl4, initSong("E", "E", 180, 40));
	addSong(pl4, initSong("F", "F", 180, 90));
	addSong(pl4, initSong("G", "G", 180, 60));
	addSong(pl4, initSong("H", "H", 180, 60));
	reversePlaylist(pl4);
	
	addSong(pl5, initSong("J", "J", 180, 76));
	addSong(pl5, initSong("K", "K", 180, 14));
	addSong(pl5, initSong("L", "L", 180, 36));
	addSong(pl5, initSong("M", "M", 180, 1));
	addSong(pl5, initSong("N", "N", 180, 100));
	reversePlaylist(pl5);
	
	stampaEordina(pl0);
	stampaEordina(pl1);
	stampaEordina(pl2);
	stampaEordina(pl4);
	stampaEordina(pl5);
	
	return 0;
}
