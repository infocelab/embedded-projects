#include <REGX52.H>									//Header file
#include<string.h>
sbit RS=P0^0;										//RS pin of LCD is connected with 8th pin of Port 3
sbit EN=P0^1;										//EN pin of LCD is connected with 7th pin of Port 3
sbit wr=P3^5;										//Wr pin of ADC is connected with 6th pin of Port 3
#define LCD P2										//Lcd is connected with PORT 2
#define Temp P1										//ADC is connected with PORT 1
unsigned char d;
void delay(unsigned int x)							// Delay program
{
unsigned int i,j;
for(i=0;i<=x;i++)
for(j=0;j<=100;j++);
}
void cmd(unsigned char x)						   //Command function for Lcd to send commands from Microcontroller
{												   // RS pin of Lcd should be low
LCD=x;
RS=0;
EN=1;
delay(10);
EN=0;
}
void dat(unsigned char x)						// Data fuction for lcd to send data from Microcontroller
{												//RS pin of Lcd should be high
LCD=x;
RS=1;
EN=1;
delay(10);
EN=0;
}												//This is the function to send the string to LCD
void message(unsigned char *p)
{
unsigned char c,m;
c=strlen(p);
for(m=0;m<=c;m++)
{
dat(p[m]);
}
}
Lcd_deg()					   //Degree display function in LCD
{
cmd(64);  					//Address where values of the first custom character is stored
dat(4);
dat(17);
dat(17);
dat(4);
dat(0);
dat(0);
dat(0);
dat(0);
cmd(0xC8);  //Address of the location where the character is to be displayed
dat(0);  // Displaying the character created at address 0x64 
delay(10);
}												 
adc()											 //Adc function for conversion
{
unsigned char d1,d2,d3;						  //Should Make wr from '0' to '1' to convert analog to digital
wr=0;
wr=1;
d=(((Temp)/5)*3);								  //To convert 255 to 153
d1=d%10;										  //To convert unit digit, 10th digit, 100th digit
d2=((d/10)%10);
d3=d/100;
cmd(0xc0);										  //Conversion of int to ASCII to display in LCD
dat(d3+0x30);
dat(d2+0x30);
dat(d1+0x30);
//Lcd_deg();										// To display degree in LCD
}
void main()										//Make P2 and P3 ports are outputs
{
P0=0x00;
P2=0x00;										
P3=0x00;										 //Command for choosing 16x2 Lcd
cmd(0x38);										//Command for choosing Right shift
cmd(0x06);										//Command for display without cursor(Means cursor OFF)
cmd(0x0c);										//Message to display to LCD
message(" Welcome to");					//Command to goto next line. Choosing second coloumn of lcd
cmd(0xc0);
message("CELab");
delay(2000);
cmd(0x80);
message("Underground cable");					//Command to goto next line. Choosing second coloumn of lcd
cmd(0xc0);
message("Fault Finder");
delay(2000);
cmd(0x01);
d=0;
while(1)										//infinite loop
{
cmd(0x80);
message("R->S1 S2 S3 S4");
cmd(0xc0);
if(d > 145)
	message("   F  -  -  - ");
else if(d > 70)
	message("   -  F  -  - ");
else if(d > 45 )
    message("   -  -  F  - ");
else if(d > 30)
	message("   -  -  -  F ");
else if(d < 10)
	message("   -  -  -  - ");
adc();								//ADC function call
}
}