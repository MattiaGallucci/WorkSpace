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
	Song s = initSong(title, "", 0,0);
	removeListItem(p->songs, s);
}

void printPlaylist(Playlist p){
	printf("Playlist: %s", p->name);
	printList(p->songs);
	printf("\n");
}

void find_min(List songs, int index, int *index_min){
	Song min = getListItemPos(songs, index);
	*index_min = index; 
	for(int i = *index_min+1; i< sizeList(songs); i++){
		Song s = getListItemPos(songs, i);
		if(gradimento(s) < gradimento(min)){
			min = s;
			*index_min = i;
		}
	}
	return ;
}

void swap(List songs, int i, int j){
	Song s1 = getListItemPos(songs, i);
	Song s2 = getListItemPos(songs, j);
	//scambio
	Song tmp = s1;
	removeListItemPos(songs,i);
	addListItem(songs, s2, i);
	removeListItemPos(songs, j);
	addListItem(songs, tmp, j);
}

Playlist sortByGradimento(Playlist p){
	// selection sort 
	List songs = p->songs;
	int *min_pos= malloc(sizeof(int));
	for(int i = 0; i < sizeList(songs); i++){
		find_min(songs, i, min_pos);
		swap(songs, i, *min_pos);
	}
	return p;
}