int : item_int selection_sort_ric 
	gcc item_int.o selection_sort_ric.o -o ssortric.exe

str : item_str selection_sort_ric 
	gcc item_str.o selection_sort_ric.o -o array.exe
	
item_int :
	gcc -c item_int.c

item_str :
	gcc -c item_str.c

selection_sort_ric : 
	gcc -c selection_sort_ric.c

clean : 
	rm -f *.o *.exe

