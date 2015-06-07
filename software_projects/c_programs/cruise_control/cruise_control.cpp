// Name: Cruise Control
// Description:It allows the user to delete 1-55 spaces on screen and then a boat begins to sail.

#include<iostream.h>
#include<stdlib.h>
#include<windows.h>
#include<stdio.h>
void Cruiser(int mov, int y);
void Crusier(int mov, int y)
{
    mov = 0;
    do
    {
        cout << "Enter a number to represent the amount of spaces to skip.\n";
        cout << "(Min:1/Max:55): ";
        cin >> mov;
        system("cls");
    }
    while((mov < 1)||(mov > 55));
        Sleep(1000);
    for(mov;mov <= mov;mov++)
    {
        for(y = 0;y <= mov;y++)
        {
            printf("%s", " ");
        }
        cout << " _____" << endl;
        for(y = 0;y <= mov;y++)
        {
            printf("%s", " ");
        }
        cout << "/ | | \\ " << endl;
        for(y = 0;y <= mov;y++)
        {
            printf("%s", " ");
        }
        cout << "|__|_|__| " << endl;
        for(y = 0;y <= mov;y++)
        {
            printf("%s", " ");
        }
        cout << "||" << endl;
        for(y = 0;y <= mov;y++)
        {
              printf("%s", " ");
        }
        cout << " ______||_" << endl;
        for(y = 0;y <= mov;y++)
        {
            printf("%s", " ");
        }
        cout << " \\_______/" << endl;
        Sleep(500);
        system("cls");
    }
}
int main()
{
    int i, j;
    int mov = 0, y = 0;
    for(i = 0; i < 18;i++)
    {
        cout << '\xb2';
    }
    cout << endl;
    cout << '\xb2' << " Cruise Control " << '\xb2';
    cout << endl;
    for(j = 0; j < 18;j++)
    {
        cout << '\xb2';
    }
    cout << endl << endl;
    Crusier(mov,y);
    return 0;
}


