link: list.o main.o item.o stack.o
	gcc list.o main.o item.o stack.o -o main.exe

main.o:
	gcc -c main.c

item.o:
	gcc -c item.c
	
stack.o:
	gcc -c stack.c
	
list.o:
	gcc -c list.c

clean:
	rm -f *.o main.exe

