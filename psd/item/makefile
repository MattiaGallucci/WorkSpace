int : array utils item_int main 
	gcc array.o utils.o item_int.o main.o -o array.exe

str : array utils item_str main 
	gcc array.o utils.o item_str.o main.o -o array.exe

array :
	gcc -c array.c

utils :
	gcc -c utils.c

item_int :
	gcc -c item_int.c

item_str :
	gcc -c item_str.c

main : 
	gcc -c main.c

clean : 
	rm -f *.o *.exe

