// Name: Generation of Salary Slip

#include<stdio.h>
#include<conio.h>
void main()
{
    FILE * ptr;
    char name[20];
    int i,n;
    int mon,date,year,salary,cno;
    ptr=fopen("salary.txt","w");
    printf ("Enter the total number of employee :");
    scanf ("%d",&n);
    for(i=0;i<n;i++)
    {
        printf ("\nEnter the Name : ");
        scanf ("%s",name);
        printf ("\nEnter the ID No.: ");
        scanf ("%d",&cno);
        printf ("\nEnter the Day (1-31): ");
        scanf ("%d",&date);
        printf ("\nEnter the Month (1-12) : ");
        scanf ("%d",&mon);
        printf ("\nEnter the Year (yyyy) : ");
        scanf ("%d",&year);
        printf ("\nEnter the Salary: ");
        scanf ("%d",&salary);
        printf("\n-----------------------------------------------\n");
        fprintf(ptr,"%s %d %d %d %d\n",name,cno,date,mon,year,salary);
    }
    fclose(ptr);
    ptr=fopen("salary.txt","r");
    printf ("\n\t\t\tSalary Slip\n\n");
    while(feof(ptr)==0)
    {
        printf ("\n-----------------------\n");
        printf ("\nName: %s",name);
        printf ("\nID No. : %d",cno);
        printf ("\nDate: %d",date);
        printf ("\nMonth: %d",mon);
        printf ("\nYear: %d",year);
        printf ("\nSalary : %d",salary);
        printf ("\n-----------------------\n");
        fscanf(ptr,"%s %d %d %d %d %d\n",name,&cno,&date,&mon,&year,&salary);
    }
    getch();
    fclose(ptr);
}
		
		
