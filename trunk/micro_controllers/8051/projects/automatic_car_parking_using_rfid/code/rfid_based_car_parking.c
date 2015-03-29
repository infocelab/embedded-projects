//Automatic RFID Based Vehicle Parking System
#include<reg51.h>
#include<string.h>

sbit START_POINT=P1^3;
sbit TERMINATE_POINT=P1^4;

sbit STOP_START_POINT=P1^5;	
sbit STOP_TERMINATE_POINT=P1^6;

sbit S1=P3^2;
sbit S2=P3^3;

sbit rc1=P1^1;
sbit rc2=P1^2;

sbit BUZZPORT=P1^7;

sbit RS=P3^7;
sbit EN=P3^6;

void lcdinit();
void lcdData(unsigned char l);
void lcdcmd(unsigned char k);
void buzzer(unsigned int time);
void DelayMs(unsigned int count); 
void display(unsigned char s,t,u);
void Welcome(unsigned char c[],unsigned char d[]);
void ConvertAndDisplay(unsigned int value1,unsigned char c[]);
void dcMotor();
void exit_dcMotor();

void main()
{
unsigned char i=0,j=0,result=0;
unsigned int count;
unsigned char c[15];
unsigned char d[]="42006B1BB8";

signed int amount2=900;

TMOD=0x20;		  // To configure the serial port at 9600 baud rate
TH1=0xFD;
SCON=0X50;
TR1=1;

S1=1;
S2=1;

BUZZPORT=0;
START_POINT=0;
TERMINATE_POINT=0;

lcdinit();
Welcome("AUTOMATIC RFID","CAR PARKING");
DelayMs(1000);

while(1)
{
known:
Welcome("AUTOMATIC RFID","CAR PARKING");
DelayMs(100);

while(S1==0 && S2==0);

if(S2==1)
{
  		while(S2==1);
		if(count>0)
		{
		 count--;
		 ConvertAndDisplay(count,"Thanks for Visit");
		 DelayMs(1000);
			exit_dcMotor();
		 goto known;
	    }
	  	else
		{
		  count=0;
		  ConvertAndDisplay(count,"Thanks for Visit");
			 DelayMs(1000);
			exit_dcMotor();
				 goto known;
	    }
}

if(S1==1)
{
while(S1==1);
for(i=0;i<12;i++)
{
c[i]=0xFF;
}
ConvertAndDisplay(count,"Please Show Card");
DelayMs(100);
while(RI==0);

for(i=0;i<12;i++)			  //command to recv data
{
j=0;
while(RI==0)
{
if(j>=1000)
goto timeout;
DelayMs(1);
j++;
}
c[i]=SBUF+48;
RI=0;
}
timeout:
//result=strncmp(c,d,10);
if(c[7] == '"' && c[8] == 'R' && c[9] == 'f' && c[10] == 'J' && c[11] == '0')
{
result=0;	
}
else
{
	result=1;
}
if(count > 10)
{

		Welcome("Parking is Full","Sorry for Inconvenience");
		buzzer(500);
		DelayMs(1000);
		goto known;
}
else if(result==0)
{
lcdinit();

Welcome("VEHICAL Amount ","Detected:100");
DelayMs(3000);
amount2-=100;
if(amount2>0)
{
ConvertAndDisplay(amount2,"Balance Amount");
dcMotor();
DelayMs(1000);
}
else
{
  amount2=0;
  Welcome("VEHICAL Amount ","BALANCE NIL");
  buzzer(500);
  Welcome("Recharge Your","Card Please");
  while(rc1==1&&rc2==1);
  {		if(rc1==0)
  	{
   		while(rc1==0);
		amount2=900;
		Welcome("Card is recharged","with amount 900");
		DelayMs(2000);
    }
  if(rc2==0)
  {
   	while(rc2==0);
	amount2=500;
	Welcome("Card is recharged","with amount 500");
			DelayMs(2000);
  }
}
}
if(amount2<=400)
{
  Welcome("VEHICAL Amount ","BALANCE LOW");
  buzzer(200);
}
DelayMs(1000);

count++;
lcdcmd(0x01);
DelayMs(10);
ConvertAndDisplay(count,"Number of Cars");
DelayMs(2000);
goto known;
}
else if(result!=0)
{
		Welcome("Card not Matched","Plz Cnt Security");
		buzzer(1000);
		DelayMs(2000);
}
}
}
}

void Welcome(unsigned char c[],unsigned char d[])
{
unsigned int i=0;

lcdcmd(0x01);
DelayMs(10);
lcdcmd(0x80);
DelayMs(10);

i=0;
while(c[i]!='\0')
{
lcdData(c[i]);
i++;
}

lcdcmd(0xc0);
DelayMs(10);

i=0;
while(d[i]!='\0')
{
lcdData(d[i]);
i++;
}
}

void ConvertAndDisplay(unsigned int value1,unsigned char c[])
{
unsigned int i,a=0,j;
unsigned char d1,d2,d3;
for(i=0;i<value1;i++)
a=a+1;
lcdcmd(0x01);
DelayMs(10);
lcdcmd(0x80);
DelayMs(10);


j=0;
while(c[j]!='\0')
{
lcdData(c[j]);
j++;
}
d1=a%10;		//digits before desible point
a=a/10;
d2=a%10;
a=a/10;
d3=a%10;

lcdcmd(0xc0);
DelayMs(10);

display(d1,d2,d3);
}
//---------------------------------------
// Lcd initialization subroutine
//---------------------------------------
void lcdinit(void)
{
lcdcmd(0x38);
DelayMs(250);
lcdcmd(0x0E);
DelayMs(250);
lcdcmd(0x01);
DelayMs(250);
lcdcmd(0x06);
DelayMs(250);
lcdcmd(0x80);
DelayMs(250);
}

//---------------------------------------
// Lcd data display
//---------------------------------------
void lcdData(unsigned char l)
{
P2=l;
RS=1;
EN=1;
DelayMs(1);
EN=0;
return;
}

//---------------------------------------
// Lcd command
//---------------------------------------
void lcdcmd(unsigned char k)
{
P2=k;
RS=0;
EN=1;
DelayMs(1);
EN=0;
return;

}
		   
//---------------------------------------
// Delay mS function
//---------------------------------------
void DelayMs(unsigned int count) 
{  // mSec Delay 11.0592 Mhz 
    unsigned int i;		      // Keil v7.5a 
    while(count) 
	{
        i = 115; 			 // 115	exact value
		while(i>0) 
		i--;
        count--;
    }
}

void dcMotor()
{
		START_POINT=1;
		TERMINATE_POINT=0;
		DelayMs(1000);
		START_POINT=0;
		TERMINATE_POINT=0;
		DelayMs(2000);
		START_POINT=0;
		TERMINATE_POINT=1;	 
		DelayMs(1000);
		START_POINT=0;
		TERMINATE_POINT=0;	 		
}

void exit_dcMotor()
{
		STOP_START_POINT=1;
		STOP_TERMINATE_POINT=0;
		DelayMs(1000);
		STOP_START_POINT=0;
		STOP_TERMINATE_POINT=0;
		DelayMs(2000);
		STOP_START_POINT=0;
		STOP_TERMINATE_POINT=1;	 
		DelayMs(1000);
		STOP_START_POINT=0;
		STOP_TERMINATE_POINT=0;	 		
}

void display(unsigned char s,t,u)
{
s=s+0x30;			//convert each digit to equivalent ASCII value
t=t+0x30;
u=u+0x30;

//Move the cursor to position 5 on LCD
DelayMs(50);

lcdData(u);			//Display the digits one by one on LCD
DelayMs(50);
lcdData(t);
DelayMs(50);
lcdData(s);
DelayMs(50);
} 

void buzzer(unsigned int time)
{

	BUZZPORT=1;

 	DelayMs(time);

 	BUZZPORT=0;
} 
				 