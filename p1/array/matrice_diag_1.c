#include <stdio.h>

#define N 5

int main(void) {
	
	int a[N][N] = {{0}}, row, col;
	
	printf("\n");
	
	for (row=0; row<N; row++)
	{
		for (col=0; col<N; col++)
		{
			if (row == col)
				a[row][col]=1;
			printf("%d ", a[row][col]);
		}
		printf("\n");
	}

	return 0;
}