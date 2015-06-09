// Name: Nth Element in Fibonacci Series

#include<stdio.h>
#include<conio.h>
fib(int n);
int count=0;
void main()
{
    int a,c;
    system("cls");
    printf ("\nEnter the nth number of terms :");
    scanf ("%d",&a);
    c=fib(a);
    printf ("\nThe %d element in fibonacci series is : %d\n",a,c);
    printf ("\nTIME COMPLEXITY : %d",count);
    getch();
}
fib (int n)
{
    int c,r,b,i;
    count=count+1;
    if (n<=1)
    {
        count=count+1;
        return (n);
    }
    else
    {
        r=-1;
        count=count+1;
        b=1;
        count=count+1;
        for (i=1;i<=n;i++)
        {
            c=r+b;
            count=count+1;
            count=count+1;
            r=b;
            count=count+1;
            b=c;
        }
        count=count+1;
    }
    count=count+1;
    return (c);
}
		
		
