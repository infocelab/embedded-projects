
//**** RESBAND
// Description:This program figures out the OHM value of resistors by their color bands (the colors are entered as numbers as shown in the screenshot).
/*(the picture of the circut was placed in the image as an example of resistors and does not exist in the program)
the program should run in most c++ compilers,
it was made in bloodshed DEV C++ 4.0*/

#include <stdio.h>
#include <iostream.h>
#include <conio.h>
int main(int argc, char *argv[])


    {
    cout<<"This program finds resistor values\n";
    cout<<"by their color bands. The colors used\n";
    cout<<"in all of the entries go as follows:\n";
    cout<<"0. Black\n1. brown\n2. Red\n3. Orange\n";
    cout<<"4. Yellow\n5. Green\n6. Blue\n7. Violet\n";
    cout<<"8. Gray\n9. White\n10. Silver\n11. Gold\n";
    cout<<"12. None\n";
    cout<<"**The first band is NOT silver or gold**\n";
    int nband1;
    int nband2;
    int nband3;
    int ntband;
    int ntbandvalue=0;
    float navalue;
    cout<<"please type the first band color number\n";
    cin>>nband1;
    cout<<"please type the second band color number\n";
    cin>>nband2;
    cout<<"please type the third band color number\n";
    cin>>nband3;
    cout<<"please type the fourth band color number\n";
    cin>>ntband;
    nband1*=10;
    navalue=nband1+nband2;
    switch(nband3)


        {
        case 0:
        navalue*=1;
        break;
        case 1:
        navalue*=10;
        break;
        case 2:
        navalue*=100;
        break;
        case 3:
        navalue*=1000;
        break;
        case 4:
        navalue*=10000;
        break;
        case 5:
        navalue*=100000;
        break;
        case 6:
        navalue*=1000000;
        break;
        case 10:
        navalue/=100;
        break;
        case 11:
        navalue/=10;
        break;
    }
    if (navalue==0)


        {
        cout<<"Please try typing the resistor values again\n";
    }
    else


        {
        cout<<"The ohm value of the resistor is:\n"<<navalue;
        cout<<" OHMS\n";
    }
    switch(ntband)


        {
        case 10:
        ntbandvalue=10;
        break;
        case 11:
        ntbandvalue=5;
        break;
        case 12:
        ntbandvalue=20;
        break;
    }
    if (ntbandvalue==0)


        {
        cout<<"Please try typing the resistor values again\n";
    }
    else


        {
        cout<<"The resistor tolerance value is:\n";
        cout<<ntbandvalue<<"%\n";
    }
    cout<<"Press enter to exit...";
    getch();
   return 0;
}
		
		
