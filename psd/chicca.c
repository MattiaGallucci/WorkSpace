#include <stdio.h>

int main(){
	
	char s;
	
	printf("La smetti di fare la scena? (s/n) ");
	s = getchar();
	
	switch(s){
		case ('s'):
			printf("\nGrazie chiccaaaaaaaaa scusa TVB :D");
			break;
			
		case ('n'):
			printf("\n>:(");
			break;
}
	return 0;
}