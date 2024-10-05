#include <stdio.h>
#include "punto.h"

int main(){
    float x, y;
    Punto p1, p2;

    scanf("%f", &x);
    scanf("%f", &y);
    p1 = creaPunto(x, y);

    scanf("%f", &x);
    scanf("%f", &y);
    p2 = creaPunto(x, y);
    printf("Distanza: %.1f", distanza(p1, p2));

    return 0;
}