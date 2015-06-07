
//INCLUDE files for :PizzaDeliverySystem...

#include<string.h>
#include<iostream.h>
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>

class AbstractPizza
{
    protected:
    unsigned int price;
    int olives;
    int mushrooms;
    float flour;
    int onion;
    int cheese;
    int tomatoes;
    int chicken;
    int beef;
    public:
    virtual void bake()=0;
    virtual int returnprice()=0;
    //	virtual ~AbstractPizza();
};


class ChickenTikkaPizza : public AbstractPizza
{
    public:
    ChickenTikkaPizza();
    void bake();
    int returnprice()
    { 
        return price;
    }
};


ChickenTikkaPizza::ChickenTikkaPizza()
{
    price= 450;
    olives=20;
    mushrooms=20;
    flour=2;
    onion=5;
    cheese=2;
    tomatoes= 4;
    chicken= 2;
    beef=3;  
}
void ChickenTikkaPizza::bake()
{
    olives=10;
    mushrooms=15;
    flour=1;
    onion=3;
    cheese=1;
    tomatoes= 2;
    chicken= 1;
    beef=3;
    cout<<"\n\nYour Pizza is ready to be delivered, Thanks for coming, Please do come again";
}

class BeefRoastPizza : public AbstractPizza
{
    public:
    BeefRoastPizza();
    int returnprice()
    {
        return price;
    }
    void bake();
};


BeefRoastPizza::BeefRoastPizza()
{
    price=415;
    olives=20;
    mushrooms=20;
    flour=2;
    onion=5;
    cheese=2;
    tomatoes= 4;
    chicken= 2;
    beef=3;
}
void BeefRoastPizza::bake()
{
    olives=10;
    mushrooms=15;
    flour=1;
    onion=3;
    cheese=1;
    tomatoes= 2;
    chicken= 2;
    beef=1;
    cout<<"\n\nYour Pizza is ready to be delivered, Thanks for coming, Please do come again";
}

class FourSeasonPizza : public AbstractPizza
{
    public:
    FourSeasonPizza();
    int returnprice()
    {
         return price;
    }
    void bake();
};

FourSeasonPizza::FourSeasonPizza()
{
    price= 475;
    olives=20;
    mushrooms=20;
    flour=2;
    onion=5;
    cheese=2;
    tomatoes= 4;
    chicken= 2;
    beef=3;
}
void FourSeasonPizza::bake()
{
    olives=10;
    mushrooms=15;
    flour=1;
    onion=3;
    cheese=1;
    tomatoes= 2;
    chicken= 1;
    beef=1;
    cout<<"\n\nYour Pizza is ready to be delivered, Thanks for coming, Please do come again";
}
class HawiianPizza : public AbstractPizza
{
    public:
    HawiianPizza();
    int returnprice()
    {
         return price;
    }
    void bake();
};
HawiianPizza::HawiianPizza()
{
    price=420;
    olives=20;
    mushrooms=20;
    flour=2;
    onion=5;
    cheese=2;
    tomatoes= 4;
    chicken= 2;
    beef=3;
}
void HawiianPizza::bake()
{
    olives=10;
    mushrooms=15;
    flour=1;
    onion=3;
    cheese=1;
    tomatoes= 2;
    chicken= 1;
    beef=1;
    cout<<"\n\nYour Pizza is ready to be delivered, Thanks for coming, Please do come again";
}
class person
{
    private:
    char Name[15];
    char SirName[15];
    char PoBox[15];
    char HouseNum[15];
    char StreetNum[15];
    char Sector[15];
    char City[15];
    char PhoneNumber[15];
    char Country[15];
    public:
    void input();
    void display();
};
void person::input()
{
    cout<<"\nPlease enter your first name:\t\t";
    gets(Name);
    cout<<"Please enter your surname:\t\t";   
    gets(SirName);
    cout<<"Please enter Your P.O Box Number:\t";
    gets(PoBox);
    cout<<"Please enter your House Number:\t\t";
    gets(HouseNum);
    cout<<"Please enter your Street Number:\t";
    gets(StreetNum);
    cout<<"Please enter your Sector:\t\t";
    gets(Sector);
    cout<<"Please enter your Phone Number:\t\t";
    gets(PhoneNumber);
}
void person::display()
{
    cout<<"\n\nThank You for coming, "<< Name<<" "<<SirName<<" \n\nPlease enter 'n' to quit and any other character to \ncontinue ordering pizzas:";
}
class creditcard
{
    private:
    unsigned int ExpiryMonth;
    unsigned int ExpiryYear;
    unsigned long MaxSize;
    unsigned long CurrentSize;
    unsigned long CreditCardNumber;
    public:
    creditcard();
    creditcard(unsigned int month, unsigned int year, unsigned long ccnumber);
    int compare(creditcard ca);
    void input();
    unsigned long ReturnCurrentSize()
    {
             return CurrentSize;
    }
};

creditcard::creditcard()
{
    MaxSize= 20000;
    CurrentSize= rand() %20000;
}
int creditcard::compare(creditcard ca)
{
    if(ExpiryMonth==ca.ExpiryMonth && ExpiryYear==ca.ExpiryYear && CreditCardNumber==ca.CreditCardNumber)
    return(1);
    else
    return(0);
}
void creditcard::input()
{
    cout<<"\n\t**********Enter Credit Card Information**********";
    cout<<"\n\nPlease enter the Credit Card Number\t";
    cin>>CreditCardNumber;
    ExpiryMonth=0;
    while(!(ExpiryMonth>=1 && ExpiryMonth<=12))  
    {
        cout<<"Please enter that expiry month( between 1 and 12)\t";
        fflush(stdin);
        cin>>ExpiryMonth;
    }
    cout<<"Please enter the expiry year\t\t";
    cin>>ExpiryYear;
}


creditcard::creditcard(unsigned int month, unsigned int year, unsigned long ccnumber)
{
    ExpiryMonth= month;
    ExpiryYear= year;
    CreditCardNumber=ccnumber;
}


class order
{
    private:
    person p1;
    creditcard c1;
    static int OrderNumber;
    public:
    void incrementordernumber()
    { 
         OrderNumber++; 
    }
    int returnordernumber()
    {
        return OrderNumber; 
    }
    unsigned long returnc1size()
    { 
        return(c1.ReturnCurrentSize()); 
    }
    void c1input()
    { 
         c1.input(); 
    }
    int comparecredit(creditcard ca)
    {
        return(c1.compare(ca));
    }
    void inputperson()
    { 
         p1.input(); 
    }
    void displayperson()
    { 
         p1.display();
    }
    void menu();
    };
int order::OrderNumber=0;
void order::menu()
{
    cout<<"\n\n\n\n\n\t\t***************MENU****************";
    cout<<"\n\t\t*1) Chicken Tikka Pizza....Rs. 450*";
    cout<<"\n\t\t*2) Beef Roast Pizza.......Rs. 415*";
    cout<<"\n\t\t*3) Four Season............Rs. 475*";
    cout<<"\n\t\t*4) Hawaiian Pizza.........Rs. 420*";
}
main()
{
    char option;
    AbstractPizza* ap1;
    while( option != 'n' )
    {
        order o2;
        o2.incrementordernumber();
        o2.menu();
        int choice;
        cout<<"\n\t\t********ORDER NUMBER:\t"<<o2.returnordernumber()<<"**********\n";
        choice=5;
        while(!(choice>=1 && choice<=4))
            {
                cout<<"\nPlease Enter Your Choice between 1 & 4:\t\t";
                cin>>choice;
            }
            switch(choice)
            {
        case(1):
                ap1= new ChickenTikkaPizza;
        break;
        case(2):
                ap1= new BeefRoastPizza;
        break;
        case(3):
                ap1= new FourSeasonPizza;
        break;
        case(4):
                ap1= new HawiianPizza;
        break;
        }
        o2.inputperson();
        char choice2='l';
              
        do
        {
            cout<<"\nPlease enter c to pay via credit card and p to pay via cash:\t";
            fflush(stdin);
            cin>>choice2;
        }
        while(!(choice2=='c' || choice2=='p'));
        if(choice2=='c')      
        {
            o2.c1input();
            creditcard cca(12, 2004, 1111222);
            creditcard ccb(12, 2004, 1234567);
            creditcard ccc(12, 2004, 9876543);
            creditcard ccd(12, 2004, 1212121);
            system("cls");
            if( ( o2.comparecredit(cca) || o2.comparecredit(ccb) || o2.comparecredit(ccc) || o2.comparecredit(ccd) ) && ( o2.returnc1size() >= ap1->returnprice() ) )
            {
                cout<<"\n\n\n\n\n\n****Your Account Balance\t"<<o2.returnc1size()<<"\n****Your Order Cost\t\t"<<ap1->returnprice()<<"\n****Balance after transaction\t"<<o2.returnc1size()-ap1->returnprice() ;
                ap1->bake();
            }
            else
            {
                if(!( o2.comparecredit(cca) || o2.comparecredit(ccb) || o2.comparecredit(ccc) || o2.comparecredit(ccd) ))
                cout<<"\n\n\n\n\n\nINVALID CREDIT CARD NUMBER , ORDER COULD NOT BE PROCESSED";
                else if(! ( o2.returnc1size() >= ap1->returnprice() ) )
                cout<<"\n\n\n\n\n\nINSUFFICIENT FUNDS , ORDER COULD NOT BE PROCESSED";
            }
        }
        else
            cout<<"\nThanks for paying by CASH";
        choice2='l';
        o2.displayperson();
        fflush(stdin);
        option=getch();
    }
    delete ap1;
    return 0;
}



