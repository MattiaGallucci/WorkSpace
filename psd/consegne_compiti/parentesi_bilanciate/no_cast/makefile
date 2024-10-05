str : list item_str stack_list main 
	gcc list.o item_str.o stack_list.o main.o -o stack.exe

item_str :
	gcc -c item_str.c

stack_list:
	gcc -c stack_list.c

main : 
	gcc -c main.c

list :
	gcc -c list.c

clean : 
	rm -f *.o *.exe

