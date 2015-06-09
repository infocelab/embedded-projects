// Name: Prime Factorization
// Description:This program takes an integer number and returns the number's prime factors

#include <iostream>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
//initialising variables
int myNumber;
bool tryAgain = false;
bool validAnswer;
int myNumberOne;
int count = 0;
//get number for check
int putInNumber()
{
    	cout << "Input your number to find the factors for that is less than 2000000000" << endl;
    	cin >> myNumberOne;
    	return( myNumberOne );
}
//see if user wants to retry
bool retry()
{
    do
    {
        cout << endl << " Try again? [y/n] ";
        char answer;
        cin >> answer;
        switch( answer )		//check answer
        {
            case 'Y':
            case 'y':
            validAnswer = true;
            tryAgain = true;
            break;
            case 'n':
            case 'N':
            validAnswer = true;
            tryAgain = false;
            break;
            default:		//see if answer is valid
            cout << "Invalid entry, please try again. ";
            validAnswer = false;
            break;
        }
    }
    while( !validAnswer );
    return( tryAgain );
}
int main()
{			//core loop
    do
    {
        putInNumber();		//ask for number
        int myNumber = myNumberOne;		//make a copy of the number
        int factors[ 2000 ];		//make a list to hold the factors
        int count = 0 ;
        
        
        for(int s = 0; s < 2000; s++)
        {
            factors[s] = 0;
        }
        int myPrime;	//make a var to check for prime
        int i = 1;		//start check at 2
        do
        {		//prime checking loop
           i++;
           myPrime = myNumber % i;		//check for primality
           if( i == myNumber )
           {		//end check if we get to our number
              factors[ count++ ] = myNumber;		//store our number
              break;
           }
           if( 0 == myPrime )
           {
               myNumber = myNumber / i;		//make a new number to test
               cout << " Your number was divisible by " << i << " now checking " << myNumber << "." << endl;
               factors[ count ] = i;		//store the factor
               count++;		//increase count for later
               i = 1;		//reset to check from 2 again
               continue;
           }
        }
        while( i < myNumberOne );		//end loop
        cout << "Your factors are:" << endl;		//display factors
        for(int u = 0; u < count; u++)
        {		
           if( factors[u] == 0 )
           {		//do not show zeros
              continue;
           }
           cout << factors[u] << " ";		//acuallly show the factors
        }
        retry();
    }
    while( tryAgain );		//repeat if user wants to
}	


