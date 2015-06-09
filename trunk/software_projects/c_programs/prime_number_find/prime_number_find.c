#include<conio.h>
#include<stdio.h>
void main()
{
    int a[50],n,i,j,k;
    printf("Enter the limit number: ");
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    a[i]=i;
    for(i=1;i<=n;i++)
    printf("\t%d",a[i]);
    a[1]=0;
    for(i=2;(i*i)<=n;i++)
    {
        if(a[i]!=0)
        {
           	for(k=2*i;k<=n;k=k+i)
           	if(a[k]!=0)
           	a[k]=0;
        }
    }
    printf("\n\n\n\n\n");
    for(i=1;i<=n;i++)
    {
        if(a[i]!=0)
        printf("\t%d",a[i]);   
    }
    getch();
}
		
		
