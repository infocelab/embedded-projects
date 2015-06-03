
// Name: Grading Book
// Description:It averages the students test scores

#include<stdio.h>

#include<conio.h>
#include <iostream.h>
const int target = 204;
void verification();
void grading_book();
void logg_out();
int main()


 {
    verification();
    grading_book();
    logg_out();
    return 0;
}
void verification()


    {
    int t;
    cout << "...................................Grading Book................................." << endl;
    cout << "Teacher please enter your code name: ";
    cin >> t;
    cout << endl;
    if(t == target)


        {
        cout << "Welcome "<< t <<" to the Grading Book!";
    }
    else


        {
        cout << "Sorry! Please report to the principals office for your code name";
    }
    cout << endl;
}
void grading_book()


    {
    int i = 0;
    int g, divisor, average;
    cout << endl;
    for(i = 0;i < 10;i++)


        {
        cout << "Please enter the grade: ";
        cin >> g;
    }
    cout << endl;
    cout << "Please enter the divisor: ";
    cin >> divisor;
    average = g/divisor;
    cout << endl;
    cout << "Students Average is: "<< average << endl;
}
void logg_out()


    {
    int x;
    cout << endl;
    do


        {
        cout << "Teacher please logg out: ";
        cin >> x;
    }while((x > target)||(x < target));
    if(x == target)


        {
        cout << x << " has been logged out!" << endl;
        cout << endl;
        cout << "GoodBye!!!"<< endl;
        if((x > target)||(x < target))


            {
            cout << "Invalid Password!";
        }
    }
    cout << endl;
}
	
		
