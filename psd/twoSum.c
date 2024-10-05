#include <stdio.h>
#include <stdlib.h>

#define N 5

int main(void){
    int arr[10], index[2048]={0};
    int sum, comp;

    printf("Inserisci %d numeri: ", N);
    for(int i=0; i<N; i++){
        scanf("%d", &arr[i]);
    }

    /*printf("\nArray inserito: ");
    for(int i=0; i<N; i++){
        printf("%d ", arr[i]);
    }*/

    printf("\nInserisci numero: ");
    scanf("%d", &sum);

    for(int i=0; i<N; i++){
        if(arr[i] <= sum) {
            comp = sum - arr[i];
            
            if(index[arr[i]]==0) {
                index[comp] = i+1;
            }
            else
                printf("\nIl complemento di %d e' %d nella cella %d", arr[i], comp, index[arr[i]]-1);
        }
        
    }

}