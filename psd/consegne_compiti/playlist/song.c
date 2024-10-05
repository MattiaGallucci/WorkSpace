#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "song.h"
#include "playlist.h"
#include "list.h"
#include "item.h"

struct song{
	char *title;
	char *artist;
	int duration;
};

Song initSong(char *title, char *artist, int duration){
	Song s = malloc(sizeof(struct song));
	s->title = strdup(title);
	s->artist = strdup(artist);
	s->duration = duration;
	return s;
}

char *title(Song s){
	char *title = malloc(sizeof(char) * (1+strlen(s->title)));
	strcpy(title, s->title);
	return title;
}

char *artist(Song s){
	char *artist = malloc(sizeof(char) * (1+strlen(s->artist)));
	strcpy(artist, s->artist);
	return artist;
}

int duration(Song s){
	return s->duration;
}