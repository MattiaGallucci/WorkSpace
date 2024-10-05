#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "playlist.h"
#include "list.h"
#include "song.h"

struct playlist{
	char *name;
	List songs;
};

Playlist createPlaylist(char* name){
	Playlist p = malloc(sizeof(struct playlist));
	p->name = strdup(name);
	p->songs = newList();
	return p;
}

void addSong(Playlist p, Song s){
	addHead(p->songs, s);
}

void removeSong(Playlist p, char *title){
	Song s = initSong(title, "", 0, 0);
	removeListItem(p->songs, s);
}

void printPlaylist(Playlist p){
	printf("Playlist: %s", p->name);
	printList(p->songs);
	printf("\n");
}

void swap(List songs, int i, int l){
	Song s1 = getListItem
}

void sortByGradimento(Playlist pl){
	List songs = p->songs;
	int *min_pos = malloc(sizeof(int));
	
	for(int i=0; i<sizeList(songs); i++){
		find_min(songs, i, min_pos);
		swap(songs, i, *min_pos);
	}
	return p;
}

void reversePlaylist(Playlist pl){
	reverseList(pl->songs);
}