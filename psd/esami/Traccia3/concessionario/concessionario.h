#include "auto.h"

typedef struct catalogo *Catalogo;

Catalogo createCatalogo();
void addAuto(Catalogo cat, Auto a);
void printCatalogo(Catalogo);