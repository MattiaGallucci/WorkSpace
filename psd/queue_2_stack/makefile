int : list item_int stack_array queue_array main 
	gcc list.o item_int.o stack_array.o queue_array.o main.o -o queue.exe

str : list item_str stack_array queue_array main 
	gcc list.o item_str.o stack_array.o queue_array.o main.o -o queue.exe

item_int :
	gcc -c item_int.c

item_str :
	gcc -c item_str.c

stack_list:
	gcc -c stack_list.c

stack_array:
	gcc -c stack_array.c

queue_array:
	gcc -c queue_array.c

main : 
	gcc -c main.c

list :
	gcc -c list.c

clean : 
	rm -f *.o *.exe

