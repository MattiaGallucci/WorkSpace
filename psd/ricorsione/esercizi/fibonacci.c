#include <stdio.h>
#include <stdlib.h>

int fibonacci(int n)
{
    if(n < 2)
        return 1;
    else
        return fibonacci(n-1)+fibonacci(n-2);
}

int fibonacciIt(int n)
{
    int i;
    int fibonacci=1, prev1=1, prev2=1;

    for(i=2; i<=n; i++)
    {
        fibonacci = prev1+prev2;
        prev1 = prev2;
        prev2 = fibonacci;
    }

    return fibonacci;
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

    //CASO NUMERO NEGATIVO
    if(n<0)
    {
        printf("Errore. Il numero deve essere un intero non negativo.\n");
        exit(EXIT_FAILURE);
    }
    else
    {
        res = fibonacciIt(n);
        printf("Risultato:\t%d.", res);
        printf("Long: %d Int: %d", sizeof(long), sizeof(int));
    }

    return 0;
}

