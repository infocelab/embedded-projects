// Name: Multiplication Table
// Description:This code will accept values from the user and them display a multiplication table. 
#include <stdio.h>
#include <conio.h>
main ()
{
    int i=0, j=0;
    int rows=0, cols=0;
    system("cls");
    printf("Enter No. of Rows: ");
    scanf("%d",&rows);
    printf("Enter No. of Columns : ");
    scanf("%d",&cols);
    printf("\n\n");
    printf("\tTHE MULTIPLICATION TABLE ");
    printf("\n\n");
    for (i = 1; i <= rows; i++)
    {
        for (j = 1; j <= cols; j++)
        printf ("%4d ", i*j);
        printf ("\n");
    }
    getche();
} 
		
