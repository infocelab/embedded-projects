#include <iostream.h>
#include <iomanip.h>
#include <conio.h>
class	bank
{
    char name[20];
    int acno;
    char actype[20];
    int bal;
    public :
    void opbal(void);
    void deposit(void);
    void withdraw(void);
    void display(void);
};
void bank :: opbal(void)
{
    cout<<endl<<endl;
    cout<<"Enter Name :";
    cin>>name;
    cout<<"Enter A/c no. :";
    cin>>acno;
    cout<<"Enter A/c Type :";
    cin>>actype;
    cout<<"Enter Opening Balance:";
    cin>>bal;
}
void bank :: deposit(void)
{
    cout<<"Enter Deposit amount :";
    int deposit=0;
    cin>>deposit;
    deposit=deposit+bal;
    cout<<"\nDeposit Balance = "<<deposit;
    bal=deposit;
}
void bank :: withdraw(void)
{
    int withdraw;
    cout<<"\nBalance Amount = "<<bal;
    cout<<"\nEnter Withdraw Amount :";
    cin>>withdraw;
    bal=bal-withdraw;
    cout<<"After Withdraw Balance is "<<bal;
}
void bank :: display(void)
{
    cout<<endl<<endl<<endl;
    cout<<setw(50)<<"DETAILS"<<endl;
    cout<<setw(50)<<"name "<<name<<endl;
    cout<<setw(50)<<"A/c. No. "<<acno<<endl;
    cout<<setw(50)<<"A/c Type "<<actype<<endl;
    cout<<setw(50)<<"Balance "<<bal<<endl;
}
int main()
{
    bank o1;
    int choice;
    do
	{
   		cout<<"\n\nChoice List\n\n";
   		cout<<"1) To assign Initial Value\n";
        cout<<"2) To Deposit\n";
        cout<<"3) To Withdraw\n";
        cout<<"4) To Display All Details\n";
        cout<<"5) EXIT\n";
        cout<<"Enter your choice :-";
        cin>>choice;
        switch(choice)
        {
            case 1: o1.opbal();
            			break;
            case 2: o1.deposit();
            			break;
           	case 3: o1.withdraw();
            			break;
            case 4: o1.display();
            			break;
            case 5: exit(0);
        }
    }
    while(1);
    return 0;
}
   // end;


	
		
