//ASCII <=> character converter

#include <iostream.h>
#include <stdlib.h>
#include <iomanip.h>
int menu();
int main()
{
    const int numels = 1000;
    char values[numels];
    int number;
    int range, rangeStart, rangeEnd;
    int i, j;
    // Shameless self-promotion
    cout << "||===============================================||\n"
    << "|| Program to display ASCII characters and values||\n"
    << "|| Developped by celab||\n"
    << "||===============================================||\n";
    while(1)    
    {
         switch(menu())  
         {
            case 1:   
            {
                cout << "Enter an ASCII value whose character you wish to see: ";
                cin >> number;
                // Convert from ascii code to character symbol
                values[0] = number;
                cout << "The ASCII value " << number
                << " represents " << values[0] << endl;
                break;
            }
            case 2:   
            {
                cout << "Enter two numbers between which you want to see all\n"
                << "the ASCII values:\n"
                << "Note: If there are control characters within your range,\n"
                << "(like 'ESC') the formatting of the output will be messed up.\n";
                cin >> rangeStart >> rangeEnd;
                range = rangeEnd - rangeStart;
                
                // Initialize array with the characters
                for(i = 0; i <= range; i++)
                    values[i] = rangeStart + i;
                    // Loop to display the characters in rows of 5 columns each
                for(i = 0; i <= range;)
                {
                    for(j = 0; (j < 5)&&(i <= range); j++)
                    {
                        cout << setw(6) << "[" << rangeStart++ << "]";
                        cout << setw(3)<< values[i];
                        i++;
                    }
                    cout << endl;
                }
                break;
            }
            case 3:  
            {
                cout << "Enter the character:\n";
                cin.get(values[0]);
                // Convert from character to ascii code
                number = values[0];
                cout << "The ASCII value for '" << values[0]
                << "' is " << number << endl;
                
                break;
            }
            default:
            exit(1);                      
         }       
    }
    return 0;
}
// Menu function
int menu()   
{
    int selection;
    cout << endl
    << "1)Find an ASCII symbol\n"
    << "2)Display all the ASCII characters between a range of values\n"
    << "3)Find the ASCII value of a character\n"
    << "Any other key to quit.\n";
    cin >> selection;
    cin.get(); // Clear the enter key out of the buffer
    cout << endl;
    return selection;
}



