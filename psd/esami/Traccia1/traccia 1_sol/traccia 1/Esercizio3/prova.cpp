#include <stdio.h>

int main(void)
{

    char *input = "abc def ghi ";
    char split_input[sizeof input];
    int n;

    while (sscanf(input," %s%n", split_input, &n) == 1) {
        printf("[%s]\n", split_input);
        input += n;
    }
}