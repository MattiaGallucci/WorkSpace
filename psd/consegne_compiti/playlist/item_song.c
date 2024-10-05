#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "song.h"
#include "playlist.h"
#include "list.h"
#include "item.h"
#include "item_song.h"

Item inputItemSong(){
	char title[20];
	char artist[20];
	int duration;
	
	printf("\nTitle: ");
	fflush(stdin);
	scanf("%[^\n]", title);
	
	printf("Artist: ");
	fflush(stdin);
	scanf("%[^\n]", artist);
	
	printf("Duration: ");
	fflush(stdin);
	scanf("%[^\n]", duration);
	
	return initSong(title, artist, duration);
}

void outputItemSong(Item item){
	Song s = item;
	printf("\n%s - %s (%d sec.)", artist(s), title(s), duration(s));
}

int cmpItemSong(Item item1, Item item2){
	Song s1 = item1;
	Song s2 = item2;
	
	return strcmp(title(s1), title(s2));
}