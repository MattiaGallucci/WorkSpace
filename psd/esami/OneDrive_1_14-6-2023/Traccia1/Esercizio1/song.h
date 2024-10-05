typedef struct song *Song;

Song initSong(char* title, char* artist, int duration);
char* title(Song);
char* artist(Song);
int duration(Song);