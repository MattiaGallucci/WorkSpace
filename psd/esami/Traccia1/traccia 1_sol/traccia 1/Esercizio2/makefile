es2: btree list item stack main
	gcc item-int.o stack.o list.o btree.o main.o -o es2.out

btree: 
	gcc -c btree.c
list:
	gcc -c list.c
item:
	gcc -c item-int.c

main:
	gcc -c main.c

stack:
	gcc -c stack.c
clean: 
	rm -rf  *.o *.out