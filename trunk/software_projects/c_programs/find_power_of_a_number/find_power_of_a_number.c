// Name: Find Power of a Number
#include <stdio.h>
#include <conio.h>
void main()
{
    int a,b;
    system("cls");
    printf ("\nEnter the numbers : ");
    scanf ("%d",&a);
    printf ("\nEnter its power : ");
    scanf ("%d",&b);
    printf ("\n%d to the power of %d is : ",a,b);
    printf ("%d",power(a,b));
    getch();
}
power(x,y)
{
    int ans=1;
    if (y==0)
    ans = 1;
    else
    ans = x * power(x,y-1);
    return(ans);
}
		
		
