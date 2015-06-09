// Name: No. Of Odd And Even Digits In A Number

#include<iostream.h>
#include<conio.h>
int main()
{
    int n,m,rev=0,a=0,b=0;
    system("cls");
    cout<<"Enter any integer number=";
    cin>>n;
    while(n!=0)
    {
        m=n%10;
        rev=rev*10+m;
        if(rev%2==0)
        a++;
        else
        b++;
        n=n/10;
    }
    cout<<endl<<"The no. of even digits="<<a;
    cout<<endl<<"The no. of odd digits="<<b;
    getch();
    return 0;
}

		
		
