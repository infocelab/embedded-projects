// Name: Currency Calculator
// Description:This program will convert currency from American Dollars to any currency you want.

#include "iostream.h"
#include "string.h"
#include "conio.h"
#include "iomanip.h"
int main()
{
    double american_dollar;
    double converted_currency;
    double factor;
    int choice;
    char currency[11];
    //Ask user for the currency to be converted
    cout << "What is the currency (in American dollars) to be converted? ";
    cin >> american_dollar;
    //Display the menu of conversion options
    cout << "\nTo what countries currency would you like to convert the American dollars?\n"; 
    cout << "1 - Canadian Dollar\n"; 
    cout << "2 - Euro \n"; 
    cout << "3 - British Pound\n";
    cout << "Enter the number of the currency you want to convert to: ";
    cin >> choice;
    //Use a switch to set the conversion factor
    switch(choice)
    {
        case 1:
        factor = 0.770712;
        strcpy(currency, "Canadian Dollars");
        break;
        case 2:
        factor = 1.23949;
        strcpy(currency, "Euro");
        break;
        case 3:
        factor = 1.7996;
        strcpy(currency, "British Pound");
        break;
        default:
        factor = 0;
        break;
    }
    if (factor == 0) //Check for illegial selection
    {
         cout << "Error -- That Is Not A Selection -- No Result Calculated!\n";
    }
    else //If not illegial, do the conversion and print the outputs  
    {
        converted_currency = american_dollar * factor;
        cout.setf (ios::fixed);
        cout << setprecision(3) << american_dollar << " dollars = " << converted_currency << " " << currency << endl;
    }
    getch();
    return 0;
}

		
		
