//write into text file

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>
int main ( void )
{
    char name[20];   
    int  number;
    FILE *f;
    f = fopen("b.txt", "a");
    printf("\nNew contact name: ");
    scanf("%s", &name);
    printf("New contact number: ");
    scanf("%i", &number);
    fprintf(f, "%s\n Number is: %d \n\n", name, number);
    fclose(f);
    getch();
    return 0;
}
