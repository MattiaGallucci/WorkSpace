#include <stdlib.h>
#include <stdio.h>
#include "concessionario.h"
#include "auto.h"

int main(){
	
	Catalogo c = createCatalogo();
	
	Auto a0 = initAuto("EX325AM", 2014, "Panda", 2010);
	Auto a1 = initAuto("SM824AM", 2017, "C3", 2011);
	Auto a2 = initAuto("ZX743MM", 2010, "Renout", 2007);
	Auto a3 = initAuto("GH312KK", 2004, "Ferrari", 2002);
	Auto a4 = initAuto("UA525SD", 2020, "Lambo", 2019);
	Auto a5 = initAuto("EE902AS", 2016, "Bugatti", 2015);
	
	addAuto(c, a0);
	addAuto(c, a1);
	addAuto(c, a2);
	addAuto(c, a3);
	addAuto(c, a4);
	addAuto(c, a5);
	
	printCatalogo(c);
	
	removeAuto(c);
	
	return 0;
}