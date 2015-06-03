
// Name: Magic Square
// Description:It is created for a magic square of any odd number

#include<stdio.h>
#include<conio.h>
#include<process.h>


    void main()
    {
    int a[10][10];
    int n,k,i,j;
    //scr();
    printf("enter the magic square number\n");
    scanf("%d",&n);
    if(n%2==0)


        {
        printf("This is an Even no.is not possible to find magic square\n");
        getch();
        exit(0);
    }
    for(i=0,j=n/2,k=1;k<=n*n;j++,i--)


        {
        if(i<0)
        i=n-1;
        if(j==n)
        j=0;
        a[i][j]=k;
        if(k%n==0)


            {
            i+=2;
            j-=1;
        }
        k++;
    }
    for(i=0;i<n;++i)


        {
        for(j=0;j<n;++j)
        printf("%d\t",a[i][j]);
        printf("\n");
    }
    getch();
}

	
