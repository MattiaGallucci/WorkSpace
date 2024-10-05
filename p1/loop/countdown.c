#include<stdio.h>
int main(void) {
	
	int x;
	
	printf("Da dove vuoi partire: ");
	scanf("%d", &x);
	
	while (x>0)
	{
		printf("%d\n", x);
		--x;	
	}
	
	printf("VAI\n");
	return 0;
}