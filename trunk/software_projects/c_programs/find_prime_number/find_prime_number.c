// Name: Generate N Prime Numbers

#include <stdio.h>
#include<conio.h>
void main()
{
    int n,i=2,j,x;
    printf("\n Enter The Limit Of Prime Numbers : ");
    scanf("%d", &n);
    while (i<=n+1)
    {
        x=0;
        for (j=2;j<i-1;j++)
        {
            if ((i%j)==0)
            x++;
        }
        if(x==0)
        {
            printf("%d\t ",i);
            i++;
        }
        if (x>0)
        {
            n++;
            i++;
        }
    }
    getch();
}
	
		
