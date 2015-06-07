
// files for :Convert Hex,dec,oct
// Description:Converts an inputed number to Hex, dec, or oct.

#include <iostream>
#include <iomanip>
#include <conio.h>// for clrscr() & getche() functions...
#include <stdlib.h> // for exit() function...
#include <string>
const int ESC = 27; // Used for escape sequince
using namespace std;
int main()
{
    int key = 0;
    int choise = 0;
    long number;
    string ss;
    while(key != ESC)
    {
        cout << "Choose Your Number Base\n";
        cout << "\n\t1. Hexadecimal.";
        cout << "\n\t2. Octal.";
        cout << "\n\t3. Decimal.";
        cout << "\n\t4. Exit.\n\t";
        cin >> choise;
        cin.get();
        switch(choise)
        {
            case 1: 
            
                system("cls");
                cout << "Enter a Hex number: ";
                getline(cin,ss);
                cout << "\n value in octal = "<<endl;
                cout << oct << int(ss[0]) << endl;
                cout << " value in decimal = "<<endl;
                cout << dec << int(ss[0]) << endl;
            break;
            case 2: 
                system("cls");
                cout << "Enter a Octal number: ";
                getline(cin,ss);
                cout << "\nvalue in hex = "<<endl;
                cout << hex << int(ss[0]) << endl;
                cout << " value in decimal = "<<endl;
                cout << dec << int(ss[0]) << endl;
            break;
            case 3: 
                system("cls");
                cout << "Enter a dec number: ";
                getline(cin,ss);
                cout << "\n value in octal = "<<endl;
                cout << oct << int(ss[0]) << endl;
                cout << "\nvalue in hex = "<<endl;
                cout << hex << int(ss[0]) << endl;
            break;
            case 4: 
                system("cls");
                cout << "Program terminated by user...";
                exit(0);
            break; //Unreachable code.... 
            default :
                system("cls");
                cout << "ERROR ~ Invalid selection\n\n";
            break;
        }
        cout << "Press any key to continue or 'Esc' to exit";
        key = getch();
        system("cls");
    }
    cout << "Program terminated by user...";
    return 0;
}



