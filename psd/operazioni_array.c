/************************************* ELIMINAZIONE DI UN ELEMENTO *************************************/

/* la precondizione: 0 <= pos < *n deve essere controllata dalla funzione chiamante */
void elimina(int a[], int *n, int pos)
{
	int i;
	
	for (i = pos; i < (*n)-1; i++)
		a[i] = a[i+1]; // shift a sinistra
	
	(*n)--;
}

/************************************* RICERCA DI UN ELEMENTO *************************************/

int ricerca(int a[], int n, int elem)
{
	int i= 0; /* indice dell’array*/
	int trovato= 0; /* nello schema di visita indica che è stato trovato*/
	
	while(i < n && !trovato) /* visita finalizzata*/
	{	
		if (a[i] == elem)
			trovato = 1; /* permette di uscire dal ciclo*/
		
		else i++; /* se non trovato incrementa l’indice*/
	}
	/* se trovato restituisce la posizione i dell’elemento
	altrimenti restituisce -1 */
	
	return (trovato? i : -1);
}

/************************************* RICERCA DI UN ELEMENTO CON SHORT-CIRCUIT EVALUATION *************************************/

int ricercaord(int a[], int n, int elem)
{
	int i = 0;
	
	while(i < n && a[i] < elem) // visita finalizzata
		i++;
	
	return (a[i] == elem? i: -1);
}

/************************************* RICERCA DI UN ELEMENTO CON SHORT-CIRCUIT EVALUATION *************************************/

int ricercabin(int num, int arr[], int n){
	int begin = 0, end = n-1, center;
	
	while(end >= begin)
	{
		center = (begin+end)/2;
		
		if(num == arr[center])
			return center;
		
		else if (num < arr[center])
			end = center -1;
		
		else if (num > arr[center])
			begin = center + 1;
	}
	return -1;
}