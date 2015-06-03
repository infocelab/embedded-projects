
//**************************************
//INCLUDE files for :B.M.I Calculator
//**************************************
#include <iostream>
using namespace std;
int main()


    {
    float a, b, c, d;
    cout<<"B.M.I | Imperial (Metric)\n\n";
    cout<<"Please enter your bodymass in KiloGrams: ";
    cin>> a;
    cin.ignore();
    cout<<"\n\n";
    cout<<"Please enter your height in Metres: ";
    cin>> b;
    cin.ignore();
    c = b * b;
    d = a / c;
    cout<<"\n\n";
    cout<<"Your B.M.I is "<< d;


        if ( d < 18.5 ) {
        cout<<"\n\n";
        cout<<"You need to eat more food!";
    }


        else if ( d < 24.9 ) {
        cout<<"\n\n";
        cout<<"You are normal! Congratulations";
    }


        else if ( d < 29.5 ) {
        cout<<"\n\n";
        cout<<"You're overweight ... You need to exercise!";
    }


        else if ( d > 30 ) {
        cout<<"\n\n";
        cout<<"You're rated obese! Better exercise for better health and watch your diet too!";
    }
    cout<<"\n\n";
    cout<<"This program never intended to OFFEND people!";
    cin.get();
}

		
