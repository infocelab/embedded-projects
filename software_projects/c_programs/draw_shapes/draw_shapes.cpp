// Name: Draw Shapes
// Description:Draws a shape with user entered size, character, and shape. Demonstrates using menus, choices, loops, and input manipulation. Please vote!

#include <iostream.h>
void line (char ch, int how_many, bool newline);
void solid_sqr(char ch, int size);
void open_sqr(char ch, int size);
void solid_tri(char ch, int size);
void open_tri(char ch, int size);
void solid_diamond(char ch, int size);
void option(char ch, int size);
void letter(char ch);
int main()
{
   	int choice;
   	char ch;
   	int size;
   	do
   	{
   		cout<<"you have the following choices : \n";
   		cout<<"\t1) solid square \n";
		cout<<"\t2) open square \n";
		cout<<"\t3) solid triangle \n";
		cout<<"\t4) open triangle \n";
		cout<<"\t5) solid diamond \n";
		cout<<"\t6) option \n";
		cout<<"\t7) letter \n";//h
		cout<<"\t9) quit \n";
		cout<<"what choice do you want? ";
		cin>>choice;
		if (choice>=1 && choice<=7)
   		{
			cout<<"what character? ";
			cin>>ch;
		}
  		if (choice>=1 && choice<=6)
		{
			cout<<"what size? ";
			cin>>size;
		}
		cout<<endl<<endl;
		switch (choice)
  		{
   			case 1: solid_sqr(ch, size);break;
  			case 2: open_sqr(ch, size);break;
   			case 3: solid_tri(ch, size);break;
			case 4: open_tri(ch, size);break;
			case 5: solid_diamond(ch, size);break;
			case 6: option (ch, size);break;
			case 7: letter (ch);break;
			case 9: cout<<"goodbye \n";break;
			default : cout<<"bad choice - try again \n";break;
   		}
   		cout<<endl<<endl;
     }
     while (choice != 9);
         return 0;
}
void line (char ch, int how_many, bool newline)
{
   	for(int ind=1; ind <= how_many; ind++)
	cout<<ch<<' ';
  	if (newline) cout<<endl;
}
void open_sqr (char ch, int size)
{
	line (ch,size,true); // top row
	for (int ind=1; ind <= size -2; ind++)// does the size-2 middle rows
   	{
		line (ch,1, false);// first character of middle row
		line (' ', size -2 , false );// size-2 empty spaces
		line (ch,1, true); // last character of middle row
	}
	line (ch,size,true); // bottom row
}
void solid_sqr( char ch, int size) // needs a for loop calling the line function
{
    for (int ind=1; ind <=size; ind++)
  	{
   		line (ch,size, true);
   	}
}
void solid_tri (char ch, int size) // needs a for loop calling the line function (middle
// parameter needs to change
{
	for (int ind=1; ind <=size; ind ++)
   	{
    	line (ch, ind, true);
    }
}
void open_tri (char ch, int size)
{
    line (ch, 1, true);
    line (ch, 2, true);
    for (int ind=3; ind <=size-1; ind ++)
    {
        line (ch, 1, false);
        line (' ', ind-2, false);
        line (ch, 1,true);
    }
    line (ch, size, true);
}
void solid_diamond(char ch, int size)
{
    int nbrsp;
    int nbrch;
    nbrsp=size-1;
    nbrch=1;
    for (int ind=1; ind <= size; ind++)
    {
        line(' ',nbrsp, false);
        line(ch, nbrch, true);
        nbrsp--;
        nbrch+=2;
    }
    nbrsp=1;
    nbrch-=4;
    for (int ind=1; ind <= size; ind++)
    {
        line(' ',nbrsp, false);
        line(ch, nbrch, true);
        nbrsp++;
        nbrch-=2;
    }
}
void option(char ch, int size)
{
    int nbrsp=size-2;
    int nbrfsp=0;
    for (int ind=size/2; ind>0; ind--)
    {
        line(' ',nbrfsp, false);
        line(ch,1,false);
        line(' ',nbrsp, false);
        line(ch,1,true);
        nbrsp-=2;
        nbrfsp++;
    }
    for (int ind=size/2; nbrfsp>=0; ind++)
    {
        line(' ',nbrfsp, false);
        line(ch,1,false);
        line(' ',nbrsp, false);
        if (ind!=size/2)
        line(ch,1,true);
        else
        line(' ', 1,true);
        nbrsp+=2;
        nbrfsp--;
    }
}
void letter(char ch)
{
    int nbrsp=5;
    for (int ind=1; ind <=4; ind++)
    {
        line(ch,1, false);
        line(' ',nbrsp, false);
        line(ch,1, true);
    }
    line(ch, nbrsp+2,true);
    for (int ind=1; ind <=4; ind++)
    {
    line(ch,1, false);
    line(' ',nbrsp, false);
    line(ch,1, true);
    }
    
}
    

