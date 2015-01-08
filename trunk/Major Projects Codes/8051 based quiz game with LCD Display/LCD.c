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
sbit motor_pin_1 = P3^5;
sbit motor_pin_2 = P3^6;
char ans[2];
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
ask_question(int q)
{
	int j=0;
	switch(q)
	{
		 case 1:
				Lcd8_Set_Cursor(1,1);
				Lcd8_Write_String("question 1");   
				Lcd8_Set_Cursor(2,1);
				Lcd8_Write_String("1) sds 2)dfg 3)xdgdf 4)xdvxd"); 
		    ans[0]='2';
		 break;
		 case 2:
				Lcd8_Set_Cursor(1,1);
				Lcd8_Write_String("question 2");   
				Lcd8_Set_Cursor(2,1);
				Lcd8_Write_String("1) sds 2)dfg 3)xdgdf 4)xdvxd"); 
		    ans[0]='1';
		 break;
		case 3:
				Lcd8_Set_Cursor(1,1);
				Lcd8_Write_String("question 3");   
				Lcd8_Set_Cursor(2,1);
				Lcd8_Write_String("1) sds 2)dfg 3)xdgdf 4)xdvxd"); 
		    ans[0]='4';
		break;
			case 4:
				Lcd8_Set_Cursor(1,1);
				Lcd8_Write_String("question 4");   
				Lcd8_Set_Cursor(2,1);
				Lcd8_Write_String("1) sds 2)dfg 3)xdgdf 4)xdvxd"); 
		    ans[0]='4';
		break;
	}

for(j=0;j<15;j++)
{
		  Delay(1000);
			Lcd8_Shift_Left();
}

}

void main()
{
 int flag=0, i=0, qno=1;
 char c,p;
 char key[2];

	
 Lcd8_Init();

Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("welcome to quiz game");
Lcd8_Set_Cursor(2,1);
Lcd8_Write_String("Press #");
while(1)
{
Delay(100);
while(!(c = Read_Keypad()));
if (c == '#')
{
Lcd8_Clear();
ask_question(qno);
flag = 1;
i=0;
}
else if (flag == 1)
{
key[i] = c;
i++;

if( i == 1)
{
Delay(200);
if(key[0] == ans[0])
{
Lcd8_Clear();
Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Correct Answer");
	qno++;
	if(qno == 5)
		qno=1;
}
else
{
Lcd8_Clear();
Lcd8_Set_Cursor(1,1);
Lcd8_Write_String("Wrong Answer");  
}
Delay(1000);
flag =0;
Lcd8_Set_Cursor(2,1);
Lcd8_Write_String("Press #");
i=0;
}
}
}
}
