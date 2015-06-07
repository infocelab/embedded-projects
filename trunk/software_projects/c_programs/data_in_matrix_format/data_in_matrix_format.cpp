// Name: Data Matrix

#include <iostream.h>
#include <iomanip.h>
#include <conio.h>
#define row 50
#define col 50

int main()
{
    void data_entry_matrix(int,int);
    system("cls");
    cout<<"\n\n\tEnter Number of rows you want to enter:-";
    int rows;
    cin>>rows;
    cout<<"\n\n\tEnter Number of Column You want to enter:-";
    int cols;
    cin>>cols;
    data_entry_matrix(rows,cols);
    getch();
    return 0;
}
void data_entry_matrix(int r, int c)
{
    system("cls");
    int matrix[row][col];
    cout<<"\n\n\t\tEnter Your Data for Matrix "<<r<<"x"<<c<<"\n\n\n\t";
    //for input
    for(int i=0;i<r;i++)
    {
      	for(int j=0;j<c;j++)
        {
            cin>>matrix[i][j];
        }
    }
    cout<<endl<<endl<<endl;
    //for display
    cout<<"\n";
    for(int i=0;i<r;i++)
    {
      	for(int j=0;j<c;j++)
        {
            cout<<setw(5)<<matrix[i][j];
        }
        cout<<endl;
    }
}

	
		
