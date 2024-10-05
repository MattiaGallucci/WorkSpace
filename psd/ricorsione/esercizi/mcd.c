#include<stdio.h>
#include<stdlib.h>

int mcd(int a, int b){
	if(b==0)
		return a;
	else{
		return mcd(b, a%b);
	}
}

int mcdIt(int a, int b){
	int r;
	
	while(b!=0){
		r=a%b;
		a=b;
		b=r;
	}
	
	return a;
}

int main(int argc, char *argv[]){
	int a, b;
	
	if(argc!=3 ){
		fprintf(stderr, "ERRORE FORMATO INPUT");
		exit(EXIT_FAILURE);
	}
	
	a=atoi(argv[1]);
	b=atoi(argv[2]);
	
	printf("\nMassimo comune divisore tra %d e %d: %d\n", a, b, mcdIt(a, b));
	
	return 0;
}