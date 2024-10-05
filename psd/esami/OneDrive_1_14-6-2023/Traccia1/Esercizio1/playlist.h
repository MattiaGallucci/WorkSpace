#include "list.h"
#include "song.h"

typedef struct playlist *Playlist;

Playlist createPlaylist(char* name);
void addSong(Playlist, Song);
void removeSong(Playlist, char*);
void printPlaylist(Playlist);
int findmin(List songs);
Playlist sortByGradimento(Playlist);