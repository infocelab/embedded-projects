#include<reg52.h>							 //including sfr registers for ports of the controller
#include<lcd.h>

//LCD Module Connections
sbit RS = P0^0;                                                                   
sbit EN = P0^1;                            
sbit D0 = P2^0;
sbit D1 = P2^1;
sbit D2 = P2^2;
sbit D3 = P2^3;
sbit D4 = P2^4;
sbit D5 = P2^5;
sbit D6 = P2^6;
sbit D7 = P2^7;

sbit enter = P0^2;
sbit exit = P0^3;
//End LCD Module Connections
void Delay(int a)
{
    int j;
    int i;
    for(i=0;i<a;i++)
    {
        for(j=0;j<100;j++)
        {
        }
    }
}

char toChar(int a)
{
switch(a)
	{
		case 1:
		return '1';
		break;
		case 2:
		return '2';
		break;
		case 3:
		return '3';
		break;
		case 4:
		return '4';
		break;
		case 5:
		return '5';
		break;
		case 6:
		return '6';
		break;
		case 7:
		return '7';
		break;
		case 8:
		return '8';
		break;
		case 9:
		return '9';
		break;
		case 0:
		return '0';
		break;
		
	}

}
void main()
{
	int i,j,k,l;
	int count=0;
	char c;
	enter=1;
	exit=1;
	Lcd8_init(); 
  Lcd8_Clear();
	Lcd8_Set_Cursor(1,1);
	Lcd8_Write_String("Welcome:");
	Lcd8_Set_Cursor(2,1);
	c=toChar(count);
	Lcd8_Write_Char(c);
				
  while(1)
  { 
		if(enter == 1)
		{
			Lcd8_Clear();
			Lcd8_Set_Cursor(1,1);
	    Lcd8_Write_String("Welcome");
			count++;
			if(count == 999)
				count=0;
			Delay(500);
		}
    if(exit == 1)
		{
			Lcd8_Clear();
			Lcd8_Set_Cursor(1,1);
	    Lcd8_Write_String("Thanks");
			count--;
			if(count == -1)
				count=0;
			Delay(500);
		}
		i=count;
		j=i%10;
    k=i/10;
    l=i/100;
    k=k-l*10;
    Lcd8_Set_Cursor(2,3);
		c=toChar(j);
		Lcd8_Write_Char(c);
		
    Lcd8_Set_Cursor(2,2);
		c=toChar(k);
		Lcd8_Write_Char(c);
      
    Lcd8_Set_Cursor(2,1);
		c=toChar(l);
		Lcd8_Write_Char(c);
  }
}




