#include <stdio.h>
#include <stdlib.h>

int fact(int n)
{
    if(n == 0) 
        return 1;
    else 
        return n * fact(n-1);
}

int factIt(int n)
{
    int i, f=1;
    for(i=1; i<=n; i++)
        f*=i;
    
    return f;
}

int main(int argc, char *argv[])
{
    int res, n;

    if(argc != 2)
    {
        fprintf(stderr, "Errore nell'inserimento.\n");
        exit(EXIT_FAILURE);
    }

    n = atoi(argv[1]);

    if(n<0)
    {
        printf("Errore. Il numero deve essere un intero non negativo.\n");
        exit(EXIT_FAILURE);
    }
    else
    {
        res = factIt(n);
        printf("Risultato:\t%d.", res);
    }

    return 0;
}

