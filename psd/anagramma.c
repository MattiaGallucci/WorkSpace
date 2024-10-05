#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    int arr[26] = {0};
    char *p = argv[1];
    char *s = argv[2];

    for(p; *p != '\0'; p++){
        arr[*p - 'a']++;
    }

    for(s; *s != '\0'; s++){
        arr[*s - 'a']--;
    }

    for(int i = 0; i < 26; i++){
        if(arr[i] != 0){
            printf("Non sono anagrammi\n");
            return 0;
        }
    }

    printf("Sono anagrammi\n");
    
}