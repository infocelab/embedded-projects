
// Name: Calculation system: Explained
// Description:The code basicly adds 2 numbers to gether specified by there user! The purpose of this code is to show beginners some of the basics of C++ - I am also a beginner. I am 5 days(20/12/04) into a C++ cource and have applied what i have learned in those 5 days to this code. I still have along way until my final exam. But for now, here is what ive learned and im sharing it with other beginners who wants to learn! This code shows you how to use: variables, data types, classes, objects, included files, global and local variables and constants. Any feedback is welcome!

#include <iostream.h>
#include <windows.h>

const short int waiting = 5000;
//The class holds various objects to perform -
//Calculations. This is just a class name 'System'
//You can change the name to what ever you want - e.g -
//dog, cat, hello etc..
class Csystem
{
    //Public: required so that all other
    //functions have access to it. Private
    //Is used so that the class has only access to it.
    public:
    int number;
};
//Void was declaired because this function is not going to return
//any value. This function prints to the screen using the cout << "";
void FUNCTION_msg(void)
{
    cout << "**********************************" <<endl;
    cout << "\n";
    cout << "Calculation System" << endl;
    cout << "Written By celab" << endl;
    cout << "\n";
    cout << "**********************************" << endl;
}
//This function holds the program for 5 seconds using the Sleep function
//and using the global constant value 5000 mili-seconds
int FUNCTION_wait()
{
    Sleep(waiting);
    return 0;
}
//int main() - This is the default function
//called by the OS at startup
int main()
{
    //Declares Local Variables 'Value1' & 'Value2'
    long int value1;
    long int value2;
    //declares loca variable 'question'
    short int question;
    //initialize Local Variables
    value1 = 0;
    value2 = 0;
    //Call Function_msg()
    FUNCTION_msg();
    //Call FUNCTION_wait()
    FUNCTION_wait();
    //Creates a object named x from the class Csystem
    //Then initilizes the global variable 'number'
    //and assign 0 to it
    Csystem x;
    x.number = 0;
    //cout - Writes a value to the screen
    //loop: is explained later in the code
    loop:	cout << "\n	Please enter a value into variable 1: ";
    //cin gets a value from the user
    cin >> value1;
    cout << "\n\n Please enter a value into variable 2: ";
    cin >> value2;
   //Adds value1 and value2 together and assignes it to
   //x.number
   x.number = value1 + value2;
   cout << "\n\nCalculating...\n\n";
   //Displays the results to the page
   cout << "	The 2 values added together: " << x.number << "\n\n";
   //If the variables 'value1' and 'value2' no longer = 0 then
   //display message
   if ((value1 != 0) && (value2 != 0))
   {
        cout << "Do you want to perform another calculation? (1: yes / 2: No) :";
        cin >> question;
        //If the question variable = 1 the loop the program
        if (question == 1)
        {
            cout << "\n\n";
            //Goes back to the loop: statment above
            goto loop;
        }
    }
    //Else quit program
    else
    {
        return 0;
    }
    return 0;
}



