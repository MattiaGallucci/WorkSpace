str-int: list.o main.o item_int.o key-string.o hashtable.o entry.o item_entry.o
	gcc list.o main.o item_int.o key-string.o hashtable.o entry.o item_entry.o -o main.exe

list.o :
	gcc -c list.c

main.o :
	gcc -c main.c

key-string.o:
	gcc -c key-string.c

hashtable.o:
	gcc -c hashtable.c

entry.o:
	gcc -c entry.c

item_int.o :
	gcc -c item_int.c

item_entry.o :
	gcc -c item_entry.c

clean:
	rm -f *.o *.exe
