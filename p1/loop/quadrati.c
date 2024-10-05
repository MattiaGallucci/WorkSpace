#include<stdio.h>
int main(void) {
	
	int a=1, n;
	
	printf("Dove arrivare: ");
	scanf("%d", &n);
	
	while (a<=n) 
	{
		printf("%d\n", a*a);
		a++;
	}
	
	return 0;
}