// Name: Change calculator in number of quarters, nickels, dimes and pennies.

#include <iostream.h>
int main()
{
    int total=0;
    int quart=0;
    int dime=0;
    int nick=0;
    int pen=0;
    char choice='y';
    while(choice == 'y' || choice == 'Y')
    {
        cout << "Enter the total (in cents): ";
        cin >> total;
        quart = total/25;
        total = total - (quart * 25);
        dime = total/10;
        total = total - (dime * 10);
        nick = total/5;
        total = total - (nick * 5);
        pen = total;
        cout << "The change is:" << endl;
        if(quart != 0)
        cout << "" << quart << " qaurters." << endl;
        if(dime != 0)
        cout << "" << dime << " dimes." << endl;
        if(nick != 0)
        cout << "" << nick << " nickels." << endl;
        if(pen != 0)
        cout << "" << pen << " pennies." << endl;
        cout << "Run program again? <y/n>: ";
        cin >> choice;
    }
    return 0;	
}

