es2: btree list item main
	gcc item-int.o  list.o btree.o main.o -o es2.out

btree: 
	gcc -c btree.c
list:
	gcc -c list.c
item:
	gcc -c item-int.c

main:
	gcc -c main.c
clean: 
	rm -rf  *.o *.out