// Name: calendar
// Description:This code displays calendar for years after 2000.

#include<stdio.h>
#include<conio.h>
#include<time.h>
main()
{ 
    int col;
    //stores days for every month
    int mdays[12]={31,28,31,30,31,30,31,31,30,31,30,31};
    int year,mon,dayc=0,mont=0;
    printf("enter any year after 1999\n");
    scanf("%d",&year);//takes year input
    printf("enter the month\n");
    scanf("%d",&mon);//takes month input
    //determing whether leap year or not
    if(year%100==0)
    {
        if(year%400==0)
        mdays[1]=29;
        else mdays[1]=28;
    }
    else mdays[1]=28;
    if(year%4==0)
    mdays[1]=29;
    else mdays[1]=28;
    //the jan 1st of 1999 is saturday
    int kday=5;
    //deciding the starting day for the year entered
    for(int syear=1999;syear<year;syear++)
    {
        if(syear%4==0)
        {
            
            if(syear%100==0)
            {
                if(syear%400==0)
                kday=kday+2;
                else kday++;
            }
            else kday=kday+2;
        }
        else kday++;
        if(kday==7)
        kday=0;
        if(kday==8)
        kday=1;
    }
    //matrix for storing calenter
    int cal[5][7];
    //starting calculation from first months of the year entered
    //upto month entered
    for(int mont=0;mont<mon-1;mont++)
    {
        dayc=dayc+mdays[mont];
    }
    dayc=dayc%7;
    kday=kday+dayc;
    kday=kday%7;
    for(int frow=0;frow<7;frow++)
    cal[0][frow]=0;
    int days=1;
    for(int row=0;row<5;row++)
    {
        for(col=kday;col<7&&days<=mdays[mont];col++)
        {
            cal[row][col]=days;
            if(days<mdays[mont]&row==4&col==6)
            {
                row=-1;
            }
            if(days==mdays[mont]&row==4&col<7)
            {
                for(int com=col;com<7;com++)
                cal[4][com]=0;
            }
            days++;
        }
        kday=0;
    }
    printf("sun\tmon\ttue\twed\tthu\tfri\tsat\n");
    for(int rowd=0;rowd<5;rowd++)
    {
        for(int cold=0;cold<7;cold++)
        {
            printf("%d\t",cal[rowd][cold]);
        }
        printf("\n");
    }
    getch();
}

	
		
