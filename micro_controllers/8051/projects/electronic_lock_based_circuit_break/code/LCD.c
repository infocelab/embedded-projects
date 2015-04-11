#include<reg52.h> //including sfr registers for ports of the controller
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
//End LCD Module Connections

//Keypad Connections
sbit R1 = P1^0;
sbit R2 = P1^1;
sbit R3 = P1^2;
sbit R4 = P1^3;
sbit C1 = P1^4;
sbit C2 = P1^5;
sbit C3 = P1^6;
sbit C4 = P1^7;
//End Keypad Connections
sbit relay = P3^2;
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

char Read_Keypad()
{
  C1=1;
  C2=1;
  C3=1;
  C4=1;
  R1=0;
  R2=1;
  R3=1;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '1';}
  if(C2==0){Delay(100);while(C2==0);return '2';}
  if(C3==0){Delay(100);while(C3==0);return '3';}
  if(C4==0){Delay(100);while(C4==0);return 'A';}
  R1=1;
  R2=0;
  R3=1;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '4';}
  if(C2==0){Delay(100);while(C2==0);return '5';}
  if(C3==0){Delay(100);while(C3==0);return '6';}
  if(C4==0){Delay(100);while(C4==0);return 'B';}
  R1=1;
  R2=1;
  R3=0;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '7';}
  if(C2==0){Delay(100);while(C2==0);return '8';}
  if(C3==0){Delay(100);while(C3==0);return '9';}
  if(C4==0){Delay(100);while(C4==0);return 'C';}
  R1=1;
  R2=1;
  R3=1;
  R4=0;
  if(C1==0){Delay(100);while(C1==0);return '*';}
  if(C2==0){Delay(100);while(C2==0);return '0';}
  if(C3==0){Delay(100);while(C3==0);return '#';}
  if(C4==0){Delay(100);while(C4==0);return 'D';}
  return 0;
}

void main()
{
 int flag=0, i=0;
 char c,p;
char pass[4];
char org_pass[4];
relay=1;
org_pass[0]='1';
org_pass[1]='2';
org_pass[2]='3';
org_pass[3]='4';
	
 Lcd8_Init();

Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Electronic Lock");
Lcd8_Set_Cursor(2,1);
Lcd8_Write_String("Press # or *");
while(1)
{
Delay(100);
while(!(c = Read_Keypad()));
if (c == '*')
{
Lcd8_Clear();
Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Change Password:");   
flag = 2;
i=0;
}
else if (flag == 2)
{
	org_pass[i] = c;
	i++;
	Lcd8_Set_Cursor(2,i);
	Lcd8_Write_String("*");
	if( i == 4)
	{
		Lcd8_Set_Cursor(1,1);
		Lcd8_Write_String("Electronic Lock");
		Lcd8_Set_Cursor(2,1);
		Lcd8_Write_String("Press # or *");
		flag =0;
		i=0;
	}
}
if (c == '#')
{
Lcd8_Clear();
Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Enter Password:");   
flag = 1;
i=0;
}
else if (flag == 1)
{
pass[i] = c;
i++;
 Lcd8_Set_Cursor(2,i);
Lcd8_Write_String("*");

if( i == 4)
{
Lcd8_Set_Cursor(2,i);
Lcd8_Write_String("*");
Delay(200);

if(pass[0] == org_pass[0] && pass[1] == org_pass[1] && pass[2] == org_pass[2] && pass[3] == org_pass[3])
{
Lcd8_Clear();
Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Correct Pass");
relay=~relay;
}
else
{
Lcd8_Clear();
Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Wrong Pass:");  
}
Delay(1000);
flag =0;
Lcd8_Set_Cursor(2,1);
Lcd8_Write_String("Press # or *");
i=0;
}
}
}
}
