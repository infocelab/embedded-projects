// Name: Hotel Database
// Description:Lets the user make reservations, view, and pay for a hotel room and stores the data to a file...
#include<stdio.h>
#include<conio.h>
#include<iostream>
#include<fstream.h>
#include<iomanip.h>
#include<string.h>
#include<windows.h>
struct hotel_database
{
    char name[256];
    char address[19];
    char city[29];
    char state[13];
    char zip[14];
    char phone[16];
    char description[31];
    short customer, day, decision, quantity;
    float cost;
    float retail_price;
};
void load_data(hotel_database data);
void disply_data(hotel_database data);
void special_data(hotel_database data);
void billing(hotel_database data);
int main()
{
    hotel_database data;
    int choice;
    cout << ".............................." << endl;
    cout << ".HOTEL DATABASE." << endl;
    cout << ".." << endl;
    cout << ".." << endl;
    cout << ".." << endl;
    cout << ". (1)Reservations." << endl;
    cout << ". (2)Room Specials." << endl;
    cout << ". (3)Billing Service ." << endl;
    cout << ". (4)Exit." << endl;
    cout << ".." << endl;
    cout << ".............................." << endl;
    cout << "\n";
    cout << "What would you like to do: ";
    cin >> choice;
    while((choice <1)||(choice  > 4))
    {
        cout << "Invalid Choice! " << endl;
        cout << "Choice: ";
        cin >> choice;
    }
    switch(choice)
    {
        case 1:
        load_data(data);
        break;
        case 2:
        special_data(data);
        break;
        case 3:
        billing(data);
        break;
        case 4:
        exit(0);
        break;
    }
    return 0;
}
void load_data(hotel_database data)
{
    int i = 0;
    cout << "\n";
    cout << "-Customer Account-" << endl;
    cout << "\n";
    cout << "Name: " << endl;
    cin >> data.name;
    cout << "\n";
    cout << "Address: " << endl;
    cin >> data.address;
    cout << "\n";
    cout << "City: " << endl;
    cin >> data.city;
    cout << "\n";
    cout << "State: " << endl;
    cin >> data.state;
    cout << "\n";
    cout << "Zip Code: " << endl;
    cin >> data.zip;
    cout << "\n";
    cout << "Phone Number: " << endl;
    cin >> data.phone;
    cout << "\n";
    while((data.decision < 1)||(data.decision > 2))
    {
        cout << "Which room would you like:" << endl;
        cout << "[1]Non-Smoking [2]Smoking: ";
        getch();
        cin >> data.decision;
    }
    if(data.decision == 1)
    {
        cout << "Room Type: Non-Smoking" << endl;
        cout << "\n";
    }
    if(data.decision == 2)
    {
        cout << "Room Type: Smoking" << endl;
        cout << "\n";
    }
    cout << "How many days are you going to be here: ";
    cin >> data.day;
    cout << "\n";
    cout << "How many people are staying: ";
    cin >> data.customer;
    for(i=0;i<4;i++)
    {
        cout << "Sending Account...." << endl;
        i++;
        Sleep(950);
    }
    disply_data(data);
    main();
}
void disply_data(hotel_database data)
{
    ofstream file;
    file.open("Account.txt", ios::app);
    if(file)
    {
        file << data.name << endl;
        file << data.address << endl;
        file << data.city << endl;
        file << data.state<< endl;
        file << data.zip << endl;
        file << data.phone<< endl;
        file << "Decision: " << data.decision << endl;
        file << "Days: " << data.day << endl;
        file << "People: "<< data.customer << endl;
        cout << "\n";
        cout << "\n";
        cout << "Go to Account.txt" << endl;
    }
    else
    {
        cout << "An error occurred while opening the file" << endl;
    }
    file.close();
}
void special_data(hotel_database data)
{
    int i = 0;
    for(i=0;i<2;i++)
    {
        strcpy(data.description, "5 Nights/half price");
        data.quantity = 2;
        data.cost = 259.95;
        data.retail_price = 400.55;
        cout << "\n";
        cout << "Room Specials\n";
        cout << "\n";
        cout << "Description: " << data.description << endl;
        cout << "Quantity: " << data.quantity << endl;
        cout << "Regular Price: " << data.cost << endl;
        cout << "Sales Price: " << data.retail_price * 0.4 << endl;
        i++;
        cout << "\n";
        Sleep(12000);
    }
    cout << "\n";
    cout << "\n";
    main();
}
void billing(hotel_database data)
{
    int i = 0;
    short num;
    cout << "How would you like to purchase your room " << endl;
    cout << "[1]Bill Me [2]Credit Card: ";
    cin >> data.decision;
    if(data.decision == 1)
    {
        for(i = 0;i < 2;i++)
        {
            cout << "\n";
            cout << "Processing Information...." << endl;
            i++;
            Sleep(12000);
        }
        cout << "\n";
        cout << "Thank you, for staying at the Jungle Hotel." << endl;
        cout << "You will recieve your bill by mail!" << endl;
    }
    if(data.decision == 2)
    {
        cout << "Enter your pin number: ";
        cin >> num;
        for(i = 0;i < 2;i++)
        {
            cout << "\n";
            cout << "Please Wait...." << endl;
            i++;
            Sleep(12000);
        }
        cout << "\n";
        cout << "Thank you, for staying at the Jungle Hotel." << endl;
        cout << "Your Credit Card Company will be notified soon." << endl;
    }
}
		
		
