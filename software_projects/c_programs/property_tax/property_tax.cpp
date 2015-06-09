// Name: Property Tax v1.0
// Description:Gives property tax % based upon property

#include <iostream>
#include <iomanip>
#include <cstdlib>
using namespace std;
int Property_Input();
int Property_Type(int);
int Property_Tract();
double Get_Rate(int, int);
int main()
{
    int first_question,
    second_question,
    tract,
    result;
    cout << setprecision(2)
    << setiosflags(ios::fixed)
    << setiosflags(ios::showpoint);
    //Collect data from user
    first_question = Property_Input();
    second_question = Property_Type(first_question);
    result = Get_Rate(first_question, second_question);
    tract = Property_Tract();
    cout << endl << endl;
    return 0;
}
double Get_Rate(int first_question, int second_question)
{
    double rate;
    double wow;
    
    cout << endl;
    if ((first_question == 1) && (second_question == 1))
    {
        cout << "Rate: 3.2%";
        wow = .032;
    }
    else if ((first_question == 1) && (second_question == 2))
    {
        cout << "Rate: 4.1%";
        wow = .041;
    }
    else if ((first_question == 2) && (second_question == 1))
    {
        cout << "Rate 5.3%";
        wow = .053;
    }
    else if ((first_question == 2) && (second_question == 2))
    {
        cout << "Rate: 6.2%";
        wow = .062;
    }
    return wow;
}
int Property_Input()
{
    int type;
    cout << endl;
    cout << "Enter the property type(1 for a home, 2 for a commerical property): ";
    cin >> type;
    if ((type != 1) && (type !=2))
    {
        cout << endl;
        cout << "Incorrect property type! " << endl;
        exit(1);
    }
    else
    return type;
}
int Property_Type(int first_question)
{
    int kind;
    cout << endl;
    if (first_question == 1) 
    {
        cout << "1 for primary resident, 2 for non-primary residence: ";
        cin >> kind;
    }
    else if (first_question == 2) 
    {
        cout << "1 for property contains building, 2 for property contains only land: ";
        cin >> kind;
    }
    return kind;
}
int Property_Tract()
{
    int answer;
    cout << endl << endl;
    cout << "Enter the property tract number: ";
    cin >> answer;
    return answer;
}


