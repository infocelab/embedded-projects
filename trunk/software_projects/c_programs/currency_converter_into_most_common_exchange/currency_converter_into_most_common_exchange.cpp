
// Name: Recursive function to exchange coins
// Description:C++ program that reads an integer which represents a cash 
/*amount in pennies. The program should compute and print out the 
total number of ways this amount can be represented using the 
standard US coins - penny, nickel, dime, quarter, half dollar
and dollar.*/

#include <iostream.h>
#include <stdlib.h>
class exchangeClass
{
    private:
    int coinPenny,
    coinNickel,
    coinDime,
    coinQuarter,
    coinHalfDollar,
    coinDollar;
    public:
    //+ ******************************************************************
    //+ Constructor
    exchangeClass();
    //+ ******************************************************************
    //+ Destructor
    ~exchangeClass();
    //+ ******************************************************************
    //+ Recursive function to find all possible ways to make exchange for
    //+ the values in userAmount.
    void makeChange ( int, int, int, int[], int&, int );
    //+ ******************************************************************
    //+ Function to find the best exchange way and print out to the
    //+ screen. It'd not print all the possible ways.
    void makeCalculate ( int );
};
//+ ************************** Constructor ***************************
exchangeClass :: exchangeClass()
{
    coinPenny = coinNickel = coinDime =
    coinQuarter = coinHalfDollar =
    coinDollar = 0;
}
//+ ************************** Destructor ****************************
exchangeClass :: ~exchangeClass()
{
    // Leave empty
    // There is no dynamic variables
}
//+ ******************** makeChange function *************************
//+ Recursive function to find all possible ways to make exchange for
//+ the values in userAmount.
void exchangeClass :: makeChange ( int coinsLeft, int userAmount,
int numCoinsUsed,
int coinValues[],
int& numSolutions,
int numCoins )
{
    int coinPos;// To calculate array position of coin being used
    if (coinsLeft == 0) // If no more coins are left
    return;
    else if (userAmount < 0)// If amount to make change for is negative
    return;
    else if (userAmount == 0)// If solution is found
    {
        numSolutions++;
        return;
    }
    // Find the other combinations using the coin
    coinPos = numCoins - coinsLeft;
    numCoinsUsed++;
    makeChange(coinsLeft, userAmount - coinValues[coinPos], numCoinsUsed, coinValues, numSolutions, numCoins);
    // Find the other combinations not using the coin
    numCoinsUsed--;
    makeChange(coinsLeft - 1, userAmount, numCoinsUsed, coinValues, numSolutions, numCoins);
}
//+ ************************ makeCalculate function ********************
//+ Function to find the best exchange way and print out to the screen.
//+ It'd not print all the ways.
void exchangeClass :: makeCalculate( int userAmount )
{
    // Loop to calculate dollar
    for ( coinDollar = 0 ; userAmount >= 100 ; coinDollar++ )
    userAmount = userAmount - 100;
    // Loop to calculate half dollar
    for ( coinHalfDollar = 0 ; (userAmount < 100) && (userAmount >= 50) ; coinHalfDollar++ )
    userAmount = userAmount - 50;
    // Loop to calculate quarter
    for ( coinQuarter = 0 ; (userAmount < 50) && (userAmount >= 25) ; coinQuarter++ )
    userAmount = userAmount - 25;
    // Loop to calculate dime
    for ( coinDime = 0 ; (userAmount < 25) && (userAmount >= 10) ; coinDime++ )
    userAmount = userAmount - 10;
    // Loop to calculate nickel
    for ( coinNickel = 0 ; (userAmount < 10) && (userAmount >= 5) ; coinNickel++ )
    userAmount = userAmount - 5;
    // Loop to calculate penny
    for ( coinPenny = 0 ; (userAmount < 5) && (userAmount >= 1) ; coinPenny++ )
    userAmount = userAmount - 1;
    // Print the best combination
    cout << "\nFollowing is one of the most common exchange:\n\n";
    cout << "Dollar: " << coinDollar << endl;
    cout << "Half Dollar: " << coinHalfDollar << endl;
    cout << "Quarter: " << coinQuarter << endl;
    cout << "Dime : " << coinDime << endl;
    cout << "Nickel: " << coinNickel << endl;
    cout << "Penny : " << coinPenny << endl << endl;
}
int main ( )
{
    const int numCoins = 6; // Number of allowable coins, change if
    // necessery. It makes it easier to
    // upgrade in the future
    int coinsUsed, // List of coins used
    numCoinsUsed = 0,// Number of coins used
    numSolutions = 0,// Number of ways to make change
    userAmount; // Amount to make change for
    // Object declaration - class.h
    exchangeClass objectDeclaration;
    // Array of coins values to choose from
    // NOTE: Change only when constant numCoins is changed
    int coinValues[numCoins] = { 100, 50, 25, 10, 5, 1};
    // Print welcome message
    cout << endl;
    cout << "********************************************************\n";
    cout << "This program exhaustively searches through all possible\n";
    cout << "combinations of coins values and to find the best way to\n";
    cout << "make change for a specified amount.\n";
    cout << "********************************************************\n";
    // Loop will always true if user enters a positive integer
    while ( true )
    {
        // Get input from user - userAmount
        cout << "\n\tEnter 0 to terminate the program.\n";
        cout << "\tPlease enter the amount of cents to make change for: ";
        cin >> userAmount;
        // Program termination if cin failed! - userAmount
        if ( !cin )
        {
            cout << "\n\tInvalid Input. Please try again.\n\n";
            return false;
        }
        // Program termination if user enters 0 as input - userAmount
        else if ( userAmount == 0 )
        {
            cout << "\n\tGoodbye!\n\n";
            return false;
        } 
        		// Program termination if user enters negative amount - userAmount
        		else if ( userAmount < 0 )
          		{
            			cout << "\n\tInvalid Input. Please try again.\n\n";
            			return false;
          		}
                // Prevent duplication of values from recursive function - numSolutions
                numSolutions = 0;
                // Call recursive function
                objectDeclaration.makeChange ( numCoins, userAmount, numCoinsUsed, coinValues, numSolutions, numCoins );
                // Display results
                cout << "\nNumber of possible combinations: " << numSolutions << endl;
                // Call makeCalculate function to calculate the most common combination
                // of coins exchange methods.
                objectDeclaration.makeCalculate ( userAmount );
    } // end while loop
} // end main function

		
		
