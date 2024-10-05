#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "song.h"
#include "playlist.h"
#include "list.h"
#include "item.h"
#include "item_song.h"

int main(){
	
	char nome[20];
	int i;
	
	printf("Inserisci nome playlist: ");
	scanf("%[^\n]", nome);
	
	Playlist pl = createPlaylist(nome);
	
	for(i=0; i<5; i++)
	{
		Item item = inputItemSong();
	}
	return 0;
}