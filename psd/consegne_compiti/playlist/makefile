link : item.o item_song.o playlist.o song.o list.o main.o
	gcc item.o item_song.o playlist.o song.o list.o main.o -o playlist.exe

main.o : 
	gcc -c main.c
	
playlist.o :
	gcc -c playlist.c
	
song.o :
	gcc -c song.c
	
item.o :
	gcc -c item.c
	
list.o :
	gcc -c list.c
	
item_song.o :
	gcc -c item_song.c

clean : 
	rm -f *.o *.exe