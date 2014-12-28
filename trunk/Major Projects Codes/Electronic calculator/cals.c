#include<reg52.h> //including sfr registers for ports of the controller
#include<lcd.h>
#include <stdio.h>
#include <string.h>
#include <math.h>
char lookup(int);  //prototype declaration of a function to find ASCII code for digits

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
// For Development Board
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
  if(C1==0){Delay(100);while(C1==0);return '0';}
  if(C2==0){Delay(100);while(C2==0);return '1';}
  if(C3==0){Delay(100);while(C3==0);return '2';}
  if(C4==0){Delay(100);while(C4==0);return '3';}
  R1=1;
  R2=0;
  R3=1;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '4';}
  if(C2==0){Delay(100);while(C2==0);return '5';}
  if(C3==0){Delay(100);while(C3==0);return '6';}
  if(C4==0){Delay(100);while(C4==0);return '7';}
  R1=1;
  R2=1;
  R3=0;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '8';}
  if(C2==0){Delay(100);while(C2==0);return '9';}
  if(C3==0){Delay(100);while(C3==0);return '.';}
  if(C4==0){Delay(100);while(C4==0);return '*';}
  R1=1;
  R2=1;
  R3=1;
  R4=0;
  if(C1==0){Delay(100);while(C1==0);return '+';}
  if(C2==0){Delay(100);while(C2==0);return '-';}
  if(C3==0){Delay(100);while(C3==0);return '/';}
  if(C4==0){Delay(100);while(C4==0);return '=';}
  return 0;
}

//For Made Circuit Project
/* char Read_Keypad()
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
  if(C4==0){Delay(100);while(C4==0);return '+';}
  R1=1;
  R2=0;
  R3=1;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '4';}
  if(C2==0){Delay(100);while(C2==0);return '5';}
  if(C3==0){Delay(100);while(C3==0);return '6';}
  if(C4==0){Delay(100);while(C4==0);return '_';}
  R1=1;
  R2=1;
  R3=0;
  R4=1;
  if(C1==0){Delay(100);while(C1==0);return '7';}
  if(C2==0){Delay(100);while(C2==0);return '8';}
  if(C3==0){Delay(100);while(C3==0);return '9';}
  if(C4==0){Delay(100);while(C4==0);return '*';}
  R1=1;
  R2=1;
  R3=1;
  R4=0;
  if(C1==0){Delay(100);while(C1==0);return '=';}
  if(C2==0){Delay(100);while(C2==0);return '0';}
  if(C3==0){Delay(100);while(C3==0);return '.';}
  if(C4==0){Delay(100);while(C4==0);return '/';}
  return 0;
} */

int power(int p, int d)
{
	int i=0, result=1;
	for(i=0;i<d;i++)
	{
		result *= p;
	}
	return result;
}

int Convert(char str[9])
{
    unsigned int result =0,i=0,j=0,k=0;
		int len=strlen(str);

		for(i=0,j=len-1;i<len;i++,j--)
    {
			result += ((int)str[i] - 48) * power(10,j);
    }
   return result;
}

void tostring(char str[],int num)
{
    int i, rem, len=0, n;
 
    n = num;
    while (n!=0)
    {
        len++;
        n/=10;
    }
    for (i=0;i<len;i++)
    {
        rem=num%10;
        num=num/10;
        str[len - (i + 1)] = rem + '0';
    }
	  str[len] = '\0';
}

void main()
{
	char input[16],val1[9],val2[9],ch1;
  unsigned int v1=0,v2=0, ans=0;
  int i=0,j=0,k=0, oper=0;
  char c;
  Lcd8_init();
	Lcd8_Set_Cursor(1,1);
	Lcd8_Write_String("Made Calculator");
	Delay(2000);
 
	while(1)
	{
		while(!(c = Read_Keypad()));
		if(i == 0)
		{
					Lcd8_Clear();
		}
		input[i]=c;
		Lcd8_Set_Cursor(1,i++);
		Lcd8_Write_Char(c);
		if(c == '=')
		{
			  j=0;
				k=0;
			  
				while(input[j])
				{
          if(input[j] == '+')
					{						
						oper=1;
						break;
					}
          else if(input[j] == '-')
					{						
						oper=2;
						break;
					}
					else if(input[j] == '*')
					{						
						oper=3;
						break;
					}
          else if(input[j] == '/')
					{						
						oper=4;
						break;
					}
					val1[k]=input[j];
					j++;
					k++;
					
				}
				val1[k]='\0';
				
				
				j++;
				k=0;
				while(input[j] != '=')
				{
					val2[k]=input[j];
					j++;
					k++;
				}
				val2[k]='\0';
     
				v1=Convert(val1);
				
				v2=Convert(val2);
				
				switch(oper)
				{
					case 1:
						ans =v1+v2;
					oper=0;
					i=0;
						break;
					case 2:
						ans =v1-v2;
					oper=0;
					i=0;
						break;
					case 3:
						ans =v1*v2;
					oper=0;
					i=0;
						break;
					case 4:
						ans =v1/v2;
					oper=0;
					i=0;
						break;
				}
				tostring(input,ans);
				j=0;
				while(input[j] != '\0')
				{
					Lcd8_Set_Cursor(2,j);
				  ch1=input[j];
				  Lcd8_Write_Char(ch1);
				  Delay(100);
					j++;
        }
				
				
		}

		Delay(100);
		
	}
}

char lookup(int no)
{
char cha;
switch(no)
{
case 0:
cha='0';
break;
case 1:
cha='1';
break;
case 2:
cha='2';
break;
case 3:
cha='3';
break;
case 4:
cha='4';
break;
case 5:
cha='5';
break;
case 6:
cha='6';
break;
case 7:
cha='7';
break;
case 8:
cha='8';
break;
case 9:
cha='9';
break;
}
return cha;
}