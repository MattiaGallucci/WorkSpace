str : btree item_int queue_array stack_array list main 
	gcc btree.o  item_int.o queue_array.o stack_array.o list.o main.o -o btree.exe

btree :
	gcc -c btree.c 

item_int :
	gcc -c item_int.c
	
queue_array:
	gcc -c queue_array.c
	
stack_array:
	gcc -c stack_array.c

list:
	gcc -c list.c

main :
	gcc -c main.c

clean :
	rm -f *.o *.exe