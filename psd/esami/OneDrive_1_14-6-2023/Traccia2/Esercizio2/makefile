link: btree.o item-int.o list.o main.o
	gcc btree.o item-int.o list.o main.o -o main.exe

btree.o:
	gcc -c btree.c

item-int.o:
	gcc -c item-int.c

list.o:
	gcc -c list.c

main.o:
	gcc -c main.c

clean:
	rm -f *.o *.exe