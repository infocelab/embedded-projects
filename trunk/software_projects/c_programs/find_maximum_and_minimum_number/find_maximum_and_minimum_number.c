// Name: Find Maximum and Minimum Number

#include<stdio.h>
#include<conio.h>
int a[50];
void maxmin(int i,int j,int *max,int *min)
{
    int mid,max1,min1;
    if (i==j)
    {
        *max=a[i];
        *min=a[j];
    }
    else if (i==j-1)
    {
        if (a[i]<a[j])
        {
            *max=a[j];
            *min=a[i];
        }
        else
        {
            *max=a[i];
            *min=a[j];
        }
    }
    else
    {
        mid=(i+j)/2;
        maxmin(i,mid,max,min);
        maxmin(mid+1,j,&max1,&min1);
        if (*max<max1) *max=max1;
        if (*min>min1) *min=min1;
    }
}
void main()
{
    int num,i,max,min;   
    printf ("\n\t\t\tMAXIMUM & MINIMUM\n\n");
    printf ("\nEnter the total number of numbers : ");
    scanf ("%d",&num);
    printf ("Enter the numbers : \n");
    for (i=1;i<=num;i++)
    {
        scanf ("%d",&a[i]);
    }
    maxmin(1,num,&max,&min);
    printf ("\nMaximum : %d",max);
    printf ("\nMinimum : %d",min);
    getch();
}
	
		
