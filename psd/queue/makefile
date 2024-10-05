int : list item_int queue_array main 
	gcc list.o item_int.o queue_array.o main.o -o queue.exe

str : item_str queue_array main 
	gcc item_str.o queue_array.o main.o -o queue.exe

item_int :
	gcc -c item_int.c

item_str :
	gcc -c item_str.c

queue_list:
	gcc -c queue_list.c

queue_array:
	gcc -c queue_array.c

main : 
	gcc -c main.c

list :
	gcc -c list.c

clean : 
	rm -f *.o *.exe

