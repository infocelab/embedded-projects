//Profile Creator

#include <iostream.h>
#include <fstream.h>

int age, heightin, heightft;
char firstname[30];
char lastname[30];
char gender[7];
ofstream foo("profiles.txt");
int main () 
{
    //Start questioning
    cout << "Enter your first name:\n";
    cin >> firstname;
    cout << "Enter your last name:\n";
    cin >> lastname;
    cout << "Enter your gender (male or female):\n";
    cin >> gender;
    cout << "Enter your age:\n";
    cin >> age;
    cout << "Enter your height (feet only) :\n";
    cin >> heightft;
    cout << "Enter your height (inches only) :\n";
    cin >> heightin;
    //Start confimation
    cout << "-" << firstname << lastname << "\n";
    cout << "-" << gender << "\n";
    cout << "- Age = " << age << "\n";
    cout << "-" << heightft << "' " << heightin << "''\n";
    foo << "Name: " << firstname << " " << lastname << "\n";
    foo << "Gender/Sex: " << gender << "\n";
    foo << "Age: " << age << "\n";
    foo << "Height: " << heightft << "' " << heightin << "''\n";
    cout << "Thank you, your new profile is being created...\n";
    cout << "This program was made by Pat Underwood, you can get more of his software at \nhttp://patu.iwarp.com\n";
    return 0;
}

	
		
