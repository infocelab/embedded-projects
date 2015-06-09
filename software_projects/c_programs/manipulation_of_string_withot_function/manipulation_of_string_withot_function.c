// Name: Manipulation of String without Functions

#include <stdio.h>
#include <conio.h>
#include <string.h>
void main()
{
    char str1[80],str2[80],str3[80],str4[80],str5[80];
    int i,j,k,i1,i2,p;
    printf ("\nEnter the first string : ");
    i=0;j=0;
    do
    {
        scanf("%c",&str1[i]);
        j=j+1;
        i++;
    }
    while (str1[i-1]!='\n');
    i1=j-1;
    printf ("The Length is %d ",i1);
    printf ("\n\nEnter The second string : ");
    j=0;i=0;
    do
    {
        scanf ("%c",&str2[i]);
        i=i+1;j++;
    }
    while (str2[j-1] != '\n');
    i2=i-1;
    printf ("The Length is %d\n",i2);
    p=i1+i2;
    j=0;
    if (i2==i1)
    {
        for (i=0;i<i1;i++)
        {
            if ((str1[i]==str2[i])&&(str1[i]!='\0')&&(str2[i]!='\0'))
            {
                j++;
            }
            else
            {
                j=0;
                break;
            }
        }
    }
    if (j>0)
    printf ("\n\t\tThe Strings are Equal\n");
    else
    printf ("\n\t\tThe strings are not equal\n");
    for (i=0;i<=i1;i++)
    {
        str3[i]=str1[i];
    }
    for (k=i-1,j=0;k<=p;k++)
    {
        str3[k]=str2[j];
        j++;
    }
    str3[k]='\0';
    printf ("\n\t\tThe concatenated string : %s\n",str3);
    for (i=0,k=0;i<=p;i++)
    {
        str4[i]=str3[k];
        k++;
    }
    str4[i]='\0';
    printf ("\t\tThe copied string : %s\n",str4);
    for (i=0,k=p;i<=p;i++)
    {
        str5[i]=str4[k];
        k--;
    }
    str5[i]='\0';
    printf ("\t\tThe Reversed string : %s",str5);
    getch();
}
	
		
