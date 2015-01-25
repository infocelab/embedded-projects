/*Code written by 
Anshuman Bezborah
BTech,4th year,SRM University
chennai*/
#include<pic.h>
#include<math.h>
#include"lcd.h"
#include"delay.h"

void disp(float); // prototype declaration of a function to display a float number
char lookup(int);  //prototype declaration of a function to find ASCII code for digits

void main()     // main program begins
{
unsigned int x,y,c=0x100,z,i;
float p,tmpr,f;
lcd_init();
ADCON0=0;     //ADC channel-1 (AN0) is selected,A/D clock=Fosc/4 
TRISA=1;
ADCON1=0xCE;  //RA0 configured as ananlog (AN0),A/D result Right justified,A/D clock=Fosc/4
ADCON0=ADCON0|1;  //ADC is turned on

/**********************************************/
lcd_goto(0);
lcd_puts(" Welcome");
DelayMs(3000);   //pause a second
ADCON0=ADCON0|4;  //A/D conversion begins
i=0;
while(i++ < 1000)         
{
if(ADCON0==0x01)
break;
}					//A/D conversion ends
x=ADRESH;     //ADC result higher 2 bits
y=ADRESL;     //ADC result lower 8 bits
PIR1=PIR1&~64;  //ADC interrupt flag is cleared
z=x*c+y;       //combined 10 bit number formation
f=z;           //unsigned to float conversion
p=(f*5)/1023;    //equivalent voltage calculation from ADC output   
tmpr=p*100;      //sensor output voltage to degree Celsius conversion
if(tmpr > 25.0)
{
	TRISB=0x10;
}
else
{
	TRISB=0x00;
}
disp(tmpr);      //call of disp(float) to display the temperature
DelayMs(1000);   //pause a second
/***********************************************/

while(1)          //infinite loop
{
	ADCON0=ADCON0|4;  //A/D conversion begins
	i=0;
	while(i++ < 10000)         
	{
		if(ADCON0==0x01)
		break;
	}					//A/D conversion ends
	x=ADRESH;     //ADC result higher 2 bits
	y=ADRESL;     //ADC result lower 8 bits
	PIR1=PIR1&~64;  //ADC interrupt flag is cleared
	z=x*c+y;       //combined 10 bit number formation
	f=z;           //unsigned to float conversion
	p=(f*5)/1023;    //equivalent voltage calculation from ADC output   
	tmpr=p*100;      //sensor output voltage to degree Celsius conversion
	disp(tmpr);      //call of disp(float) to display the temperature
	DelayMs(1000);   //pause a second
}
}                 //main program ends

void disp(float num)
{
int x1,x2,x3,x4,n,temp;
 static float f1;
char ch1,ch2,ch3,ch4,dot='.';
n=num;
temp=num;
x1=n%10;
n=n/10;
x2=n%10;
if(x2 >= 4)
{
  RB0=1;
}
else
{
  RB0=0;
}
n=n/10;
x3=n%10;
f1=num-temp;
x4=f1*10;
ch1=lookup(x3);
ch2=lookup(x2);
ch3=lookup(x1);
ch4=lookup(x4);
lcd_goto(0);
lcd_putch(ch1);
lcd_putch(ch2);
lcd_putch(ch3);
lcd_putch(dot);
lcd_putch(ch4);
lcd_puts(" deg celsu");
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
