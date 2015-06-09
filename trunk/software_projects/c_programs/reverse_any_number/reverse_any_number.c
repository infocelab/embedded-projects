
#include <stdio.h>
#include <conio.h>
void main ()
{
    int n,s=0;    
    printf ("Enter a number :");
    scanf ("%d",&n);
    while (n!= 0)
    {
        s = (10 * s) + n % 10;
        n = n / 10;
    }
    printf ("The Reversed Number is %d",s);
    getch ();
}
		
		
