link: btree item list main
	gcc btree.o item.o list.o main.o -o btree.exe

btree.o:
	gcc -c btree.c

item.o:
	gcc -c item-int.c

list.o:
	gcc -c list.c

main.o:
	gcc -c main.c

clean:
	rm -f *.o *.exe