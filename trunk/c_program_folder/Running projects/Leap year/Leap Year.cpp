

// Name: Leap Year

#include "iostream.h"
#include "conio.h"
int year;
int main()


    {
    	cout << "Please enter the current year: ";
    	cin >> year;
    	switch (year % 4)


        	{
        	case 0:
        		if (year % 100 == 0)


            		{
            			cout << "\"Century\" years aren't leap years.";
            			if (year % 400 == 0)


                			{
                				cout << "..unless divisible by 400.\n";
                				cout << year << "'s a leap year!" << endl;
                			}
                			else
                				cout << " " << year << " isn't a leap year." << endl;
                		}
                		else
                			cout << year << " is a leap year!" << endl;
                		break;
                		
                	case 3:
                		cout << "Next year is a leap year. "; // Fall through...
                	default:
                		cout << year << " isn't a leap year." << endl;
                		break;
                	}
                	getch();
                	return 0;
            }

	
		
