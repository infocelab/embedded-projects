
// Name: Easy calculator

#include <iostream.h>	
int add(float x, float y);
int subs(float x, float y);
int multi(float x, float y);
int div(float x, float y);
int main()
{ 	 
    int input;
    float x, y;
    cout<<" CALCULATOR"<<endl<<endl;
    cout<<"CHOOSE YOUR OPERATION:"<<endl;
    cout<<"1. Addition"<<endl;
    cout<<"2. Substraction"<<endl;
    cout<<"3. Multiplication"<<endl;
    cout<<"4. Division"<<endl;
    cin>>input;	 
    switch (input)	
    {	
        case 1: add(x, y);
        break;
        case 2: subs(x, y);
        break;
        case 3: multi(x, y);
    	break;	
        case 4: div(x, y);
        break;
        default:
        cout<<"Error, bad input, quitting";	
    }
}
int add(float x, float y)
{
    float a;
    cout<<"Please input two numbers to be added: ";
    cin>>x>>y;
    a=x+y;
    cout<<"The result of your addition is "<<a<<endl;
    //cout<<"By PP (Purrsoft© 2002)"<<endl<<endl;
    cout<<"Press 'enter' to quit";
    cin.get();
    cin.get();
    return 0;
}
int subs(float x, float y)
{
    float b;
    cout<<"Please input two numbers to be substracted: ";
    cin>>x>>y;
    b=x-y;
    cout<<"The result of your substration is "<<b<<endl;
    //cout<<"By PP (Purrsoft© 2002)"<<endl<<endl;
    cout<<"Press 'enter' to quit";
    cin.get();
    cin.get();
    return 0;
}
int multi(float x, float y)
{
    float c;
    cout<<"Please input two numbers to be multiplied: ";
    cin>>x>>y;
    c=x*y;
    cout<<"The result of your multiplication is "<<c<<endl;
    //cout<<"By PP (Purrsoft© 2002)"<<endl<<endl;
    cout<<"Press 'enter' to quit";
    cin.get();
    cin.get();
    return 0;
}
int div(float x, float y)
{
    float d;
    cout<<"Please input two numbers to be divided: ";
    cin>>x>>y;
    d=x/y;
    cout<<"The result of your division is "<<d<<endl;
    //cout<<"By PP (Purrsoft© 2002)"<<endl<<endl;
    cout<<"Press 'enter' to quit";
    cin.get();
    cin.get();
    return 0;
}
