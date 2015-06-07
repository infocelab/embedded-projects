// Name: Dates To Days, Seconds Converter 
// Description:Convert the difference of two dates in the form of days and seconds...

#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
#include<iostream.h>
int main()
{
    system("cls");
    // date splitter variables
    char last[14],current1[14],a[3],b[3],c[5],a1[3],b1[3],c1[5];
    int i,j=3,k=6;
    const char * number;
    //for counting days variables
    long int yr1, yr2, mon1, mon2, day1, day2, result, result1, result2, result3, result4, result5, result6;
    const int DaysInYear[13] = {0,31,59,90,120,151,181,212,243,273,304,334,365};
    long int sec;
    printf("Enter Last Date Should Be Like '25/04/2001' :- ");
    gets(last);
    printf("\nEnter Curernt Date Should Be Like '25/04/2001' :- ");
    gets(current1);
    //split Process
    for(i=0;i<=1;i++)
    {
        a[i]=last[i];
        b[i]=last[j];
        a1[i]=current1[i];
        b1[i]=current1[j];
        j++;
    }
    for (i=0;i<=3;i++)
    {
        c[i]=last[k];
        c1[i]=current1[k];
        k++;
    }
    a[2]='\0';
    b[2]='\0';
    c[4]='\0';
    a1[2]='\0';
    b1[2]='\0';
    c1[4]='\0';
    number=a;
    day1 = atoi(number);
    number =b;
    mon1=atoi(number);
    number=c;
    yr1=atoi(number);
    number=a1;
    day2 = atoi(number);
    number=b1;
    mon2 = atoi(number);
    number=c1;
    yr2 = atoi(number);
    result = yr2-yr1;
    result1 = mon2-mon1;
    result2 = day2-day1;
    result3 = result*365;
    result4 = result1[DaysInYear];
    result5 = result3+result4+result2;
    for(i=yr1;i<=yr2;i++)
    {
        // for calculating leap year
        if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
        result5=result5+1;
    }
    sec=result5 * 3600 * 24;
    printf("\nTotal Days :- %ld ",result5);
    printf("\nSeconds :- %lu ",sec);
    getch();          
    return 0;
}



