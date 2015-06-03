
// Name: Magic Square

#include<stdio.h>
#include<conio.h>
void magic(int n)


    {
    int i,j,k,l,key,square[50][50];
    if (n%2==0)


        {
        printf ("\nThe size of the Magic Square is EVEN");
    }
    else


        {
        for (i=0;i<n;i++)


            {
            for (j=0;j<n;j++)
            square[i][j]=0;
        }
        square[0][(n-1)/2]=1;
        i=0;
        j=(n-1)/2;
        for (key=2;key<=n*n;key++)


            {
            if (i>=1)
            k=i-1;
            else
            k=n-1;
            if (j>=1)
            l=j-1;
            else
            l=n-1;
            if (square[k][l]>=1)
            i=(i+1)%n;
            else


                {
                i=k;
                j=l;
            }
            square[i][j]=key;
        }
        for (i=0;i<n;i++)


            {
            for (j=0;j<n;j++)


                {
                printf ("\t%d",square[i][j]);
            }
            printf ("\n");
        }
    }
}
void main()


    {
    int num;
   // clrscr();
    printf ("\nEnter the size of the magic square : ");
    scanf ("%d",&num);
    magic(num);
    getch();
}
	
		
