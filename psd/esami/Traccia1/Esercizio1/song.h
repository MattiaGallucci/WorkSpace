typedef struct song *Song;

Song initSong(char* title, char* artist, int duration, int rated);
char* title(Song);
char* artist(Song);
int duration(Song);
int rated(Song);