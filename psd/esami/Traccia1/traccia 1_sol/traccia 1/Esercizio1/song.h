typedef struct song *Song;

Song initSong(char* title, char* artist, int duration, int gradimento);
char* title(Song);
char* artist(Song);
int duration(Song);
int gradimento(Song);