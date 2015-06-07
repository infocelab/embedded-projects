// Name: Charecter with Design
/*
        1
        2
        3
        4
1 2 3 4 5 6 7 8 9 10
        6
        7
        8
        9
        10
*/

#include<stdio.h>
#include<stdlib.h>
int main( int argc,char * argv[])
{
    int i; 
    for(i=1;i<=4;i++)
    {
        printf("\t");
        printf("%d\n",i);
    }
    for(i=1;i<=10;i++)
    {
        printf("%d ",i);
    }
    printf("\n");
    for(i=6;i<=10;i++)
    {
        printf("\t");
        printf("%d\n",i);
    } 
    printf("\n");
    system("pause"); 
    return 0;
}

	
		
