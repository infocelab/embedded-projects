// Description:This code will assigns flight seat to arrays and display it using if/else do/while switch/case

#include <iostream>
#include <stdlib.h>
#include <iostream>
#include <stdlib.h>
using namespace std;
int arrayfirstclass[5];	
int arrayeconomy[5];
//function
void assignfirst(void);
void assigneconomy(void);
void display(void);
//array count
int maxfirst = 0;
int maxeconomy = 0;
int eadd; // array counter
int fadd; // arrasy counter
//////////////////////////////////////////////////////////////
int main() // main start the program with
{
    int oneortwo = 1;
    cout << ">>>>>>>>>>>>>>>WELCOME TO HAMDI AIRLINE<<<<<<<<<<<<<<<<<<<\n\n";
    cout << "Enter 1. for first class seat\n"
    << "Enter 2. for Economy.\n"
    << "Enter 3. to display seats.\n"
    << "Enter 4. to exit the program\n";
    cin >> oneortwo;
    switch (oneortwo)
    { // start switch
        case 1:
        	assignfirst();
        case 2:
        	assigneconomy();
        case 3:
        	display();
        case 4:
        	exit(0);
        default:
        	main();
    } // end switch
    return(0);
}

void assignfirst()
{
    char doyou1;
    char moreorno1;
    int firstclassname;
    do
    {
      	if(maxfirst >= 6)
        {
            cout << ">>>>>>>>>>>>>>>>>The first class is full...<<<<<<<<<<<<<<<<<<<\n";
            cout << "<<<<<<<<<<<<<<<<<Next flight is at 12:30 PM>>>>>>>>>>>>>>>>>>>\n";
            cout << ">>>>>>>>>>>>>>>>>Do yo want the economy seat?<<<<<<<<<<<<<<<<<\n";
            cin >> doyou1;
            switch (doyou1)
        	 {
               	 case 'y':
               	 case 'Y':
                 assigneconomy(); // function
                 break;
                 default:
                 main();
             } // end switch
       	} //end do while
        cout << "<<<<<<<<<<<<<<<<You are in First Class Seat>>>>>>>>>>>>>>\n";
        cout << "1.To assign seat\n";
        cout << "2.To go back\n";
        cin >> firstclassname;
        if(firstclassname == 1)
        { // start if
             maxfirst++;
        	 arrayfirstclass[fadd++] = 1;
        	 cout << "Want to add more first class? y/n\n";
             cin >> moreorno1;
             switch (moreorno1)
             {
                 case 'y':
                 case 'Y':
            	 assignfirst(); // goto function
                 default:
                 main();
             } //start switch
        } // end if
        else
        {
           	 main();
        }
    } 
    while(moreorno1 == 'y');
} 

void assigneconomy()
{
    char doyou2;
    char moreorno;
    int economyname; 
    //arrayfirstclass[maxfirst];
    do
    {
       	if(maxeconomy >= 6)
        {
            cout << ">>>>>>>>>>>>>The Economy is full...<<<<<<<<<<<<<<\n";
            cout << "<<<<<<<<<<<<<Next flight is at 12:30 PM>>>>>>>>>>>>>>\n";
            cout << ">>>>>>>>>>>>>Do you first class Seat?<<<<<<<<<<<\n";
            cin >> doyou2;
            switch (doyou2)
            {
               	 case 'y':
               	 case 'Y':
            	 assignfirst(); // go to function
              	 break;
               	 default:
                 main();
            } //end do while
       	} //end switch
        cout << ">>>>>>>>>>You are in Economy Seat<<<<<<<<<<<<<\n";
        cout << "1.To assign seat\n";
        cout << "2.To go back\n";
        cin >> economyname;
        if(economyname == 1)
        { // start if
            maxeconomy++; // incrmnet add + 1 every time
            arrayeconomy[eadd++] = 1;
            cout << "want to add more economy class? y/n\n";
            cin >> moreorno;
            switch(moreorno)
            { // star switch
                case 'y':
                case 'Y':
                	assigneconomy();
                default:
                	 main();
            } // end switch
        } // end if
        else
        { // else end
            main();
        } //end else
    } while(moreorno == 'y');
} 
////////////////////////////////////////////////////////////////////
void display (void)
{
	int seat = 1;
	int seat1 = 1;
	cout << "<<<<<<<<<<<<<<5 seats of first class>>>>>>>>>>>>>\n";
	for(int i = 1; i <= 5; i++) // loop
   	{ // start loop
    	cout << "Seat: " << seat++ << ">>> ";
       	if(arrayfirstclass[i] == 0)
        {
       		cout << arrayfirstclass[i] << " Empty " << endl;
  		}
   		else 
       	{ // start else
        	cout << arrayfirstclass[i] << " Full " << endl;
       	} // end else
   	} // end loop
 	cout << ">>>>>>>>>>5 seats of economy<<<<<<<<<<<<<<\n";
	for(int j = 1; j <= 5; j++)
   	{ // start loop
       	cout << "Seat: " << seat1++ << ">>> ";
       	if(arrayeconomy[j] == 0)
        { // start if
   		    cout << arrayeconomy[j] << " Empty " << endl;
        } // end if
        else
       	{ // star else
         	cout << arrayeconomy[j] << " Full " << endl;
       	} // end else
    } // end loop
    main();
}
// these things dose not need cooment it just straight forward
	
		
