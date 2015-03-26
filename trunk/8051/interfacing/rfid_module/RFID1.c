#include<reg51.h>

sbit RS=P3^7;
sbit EN=P3^6;
sbit R=P3^2;
sbit bz=P1^7;

void Rxmsg(void);
void lcdinit(void);
void lcdData(unsigned char l);
void lcdcmd(unsigned char k);
void DelayMs(unsigned int count); 
void sucessRx(void);
void unknown(void);
void display(unsigned char s, t);

void welcome(void);
 
void main()
{
unsigned char i=0;
unsigned int j=0;
unsigned char c[15];

TMOD=0x20;		  // Configure the serial port to 9600 baud rate
TH1=0xFD;
SCON=0X50;
TR1=1;
R=0;
lcdinit();
welcome();
bz=1;

while(1)
{
back:

for(i=0;i<15;i++)			  //command to recv data
{
c[i]=0xFF;
}
																    
while(RI==0);

for(i=0;i<15;i++)			  //command to recv data
{
j=0;
while(RI==0)
{
if(j>=1000)
goto timeout;
j++;
}
c[i]=SBUF;
RI=0;
}

timeout:
for(i=0;i<15;i++)
{
if(c[i]=='F' && c[i+1]=='E' && c[i+2]=='0' && c[i+3]=='0' && c[i+4]=='5' && c[i+5]=='E' && c[i+6]=='4' && c[i+7]=='E' && c[i+8]=='c' && c[i+9]=='7'&& c[i+10]=='2'&& c[i+11]=='9')
{
sucessRx();
DelayMs(1000); 
R=1;
bz=0;
DelayMs(1000);
R=0;
bz=1;
DelayMs(1000);
lcdinit();
DelayMs(100);
welcome();

goto back;
}
}
unknown();
DelayMs(2000); 
bz=0;
DelayMs(2000);
bz=1;
DelayMs(1000);
lcdinit();
DelayMs(100);
welcome();
}
}

void sucessRx()
{
unsigned int i=0;
unsigned char c[]="ACCESS GRANTED";

lcdcmd(0x01);
DelayMs(10);
lcdcmd(0x80);
DelayMs(10);

while(c[i]!='\0')
{
lcdData(c[i]);
i++;
}
}

void unknown(void)
{
unsigned int i=0;
unsigned char c[]="ACCESS DENIED";

lcdcmd(0x01);
DelayMs(10);
lcdcmd(0x80);
DelayMs(10);

while(c[i]!='\0')
{
lcdData(c[i]);
i++;
}
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
    while(count) {
        i = 115; 			 // 115	exact value
		while(i>0) 
		i--;
        count--;
    }
}

void welcome(void)
{
unsigned int i=0;
unsigned char c[]="WELCOME TO RFID";	 
unsigned char d[]="SECURITY SYSTEM";

lcdcmd(0x01);
DelayMs(10);
lcdcmd(0x80);
DelayMs(10);

while(c[i]!='\0')
{
lcdData(c[i]);
i++;
}

lcdcmd(0xc0);

i=0;
while(d[i]!='\0')
{
lcdData(d[i]);
i++;
}
}	

