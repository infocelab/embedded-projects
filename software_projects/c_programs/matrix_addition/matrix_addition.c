// Name: Matrix Addition

#include<stdio.h>
#include<conio.h>
void main()
{
    int m,n,i,j,count,a[10][10],b[10][10],c[10][10];
    count=0;
    printf ("\nEnter the size of matrix : ");
    printf ("\nRows : ");
    scanf ("%d",&m);
    printf ("Columns : ");
    scanf ("%d",&n);
    printf ("Enter elements of the I matrix : \n");
    for (i=1;i<=m;i++)
    {
        for (j=1;j<=n;j++)
        {
            scanf ("%d",&a[i][j]);
        }
        printf ("\n");
    }
    printf ("\nEnter elements of the II matrix : \n");
    for (i=1;i<=m;i++)
    {
        for (j=1;j<=n;j++)
        {
            scanf ("%d",&b[i][j]);
        }
        printf ("\n");
    }
    printf ("\nAddition of two matrix \n");
    for (i=1;i<=m;i++)
    {
        count++;
        for (j=1;j<=n;j++)
        {
            count++;
            c[i][j]=a[i][j]+b[i][j];
            count++;
            printf ("%6d ",c[i][j]);
        }
        count++;
        printf ("\n");
    }
    count++;
    printf ("\nTIME COMPLEXITY : %d ",count);
    getch();
}
		            
