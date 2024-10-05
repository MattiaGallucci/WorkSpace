song :	list.o main.o song.o item-song.o playlist.o
	gcc list.o main.o song.o item-song.o playlist.o -o playlist.exe
	
list.o :
	gcc -c list.c
	
main.o :
	gcc -c main.c
	
song.o :
	gcc -c song.c

item-song.o :
	gcc -c item-song.c
	
playlist.o :
	gcc -c playlist.c
	
clean: 
	rm -f *.o *.exe
