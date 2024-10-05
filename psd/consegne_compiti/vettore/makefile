link : utils.o vettore.o main.o
	gcc utils.o vettore.o main.o -o vettore.exe
	
driver: utils.o vettore.o driver.o
	gcc utils.o vettore.o driver.o -o driver.exe
	
driver_somma: utils.o vettore.o driver_somma.o
	gcc utils.o vettore.o driver_somma.o -o driver_somma.exe

driver_prodotto_scalare: utils.o vettore.o driver_prodotto_scalare.o
	gcc utils.o vettore.o driver_prodotto_scalare.o -o driver_prodotto_scalare.exe
	
driver_somma_i: utils.o vettore.o driver_somma_i.o
	gcc utils.o vettore.o driver_somma_i.o -o driver_somma_i.exe

utils.o :
	gcc -c utils.c
	
vettore.o :
	gcc -c vettore.c
	
main.o :
	gcc -c main.c
	
driver_somma.o :
	gcc -c driver_somma.c
	
driver_prodotto_scalare.o :
	gcc -c driver_prodotto_scalare.c
	
driver_somma_i.o :
	gcc -c driver_somma_i.c
	
clean:
	rm -f utils.o vettore.o main.o driver_somma.o driver_prodotto_scalare.o driver_somma_i.o vettore.exe driver_somma.exe driver_prodotto_scalare.exe driver_somma_i.exe