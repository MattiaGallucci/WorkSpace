str : btree item_str queue_array stack_array main 
	gcc btree.o  item_str.o queue_array.o stack_array.o main.o -o btree.exe

btree :
	gcc -c btree.c 

item_str :
	gcc -c item_str.c
	
queue_array:
	gcc -c queue_array.c
	
stack_array:
	gcc -c stack_array.c

main :
	gcc -c main.c

clean :
	rm -f *.o *.exe