typedef struct punto *Punto;

Punto creaPunto(float x, float y);
float ascissa(Punto p);
float ordinata(Punto p);
float distanza(Punto p1, Punto p2);
Punto spostaPunto(Punto p, float dx, float dy);
Punto centroide(Punto sequenza[], int size);
int minDis(Punto sequenza[], int size, float dis);
float maxDis(Punto sequenza[], int size);