/*questo programma calcola la media di tot voti*/

#include<stdio.h>
int main(void) {
	
	int voto, n=0;
	float sum=0, media;
	
	printf("Inserisci i voti da 0 a 100 e digita -1 per inviare: ");
	scanf("%d", &voto);
	
	while (voto != -1)
	{
		sum += voto;
		n++;
		scanf("%d", &voto);
	}
	
	media = sum/n;
	
	if (media > 60)
	{
		printf("La media è %.2f, classe valida", media);
	}
	else 
	{
		printf("La media è %.2f, classe non valida", media);

	}
	


	
	
	return 0;
}

//ALTERNATIVA

/*
    int voto, n, sum;
	float media;
	
	printf("Inserisci quanti voti vuoi caricare: ");
	scanf("%d", &n);
	
	for (int i = 1; i <= n; i++)
	{
		printf("Inserisci il voto: ");
		scanf("%d", &voto);
		sum += voto;
	}
	
	media = (sum * 1.0)/n;
	
	if (media > 60)
	{
		printf("La media è %.2f, classe valida", media");
	}
	else 
	{
		printf("La media è %.2f, classe non valida", media);
	}
	
*/
