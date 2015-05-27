// Program to Interface Humidity sensor with 8051 Microcontroller
#include<reg51.h>
sfr lcd_data_pin=0xA0;//p2 port
sbit rs=P0^0;
sbit rw=P0^2;
sbit en=P0^1;
sbit wr= P3^3;
sbit rd= P3^4;
sbit intr= P3^5;
sfr input_port=0x90; //p1 port
unsigned int number=0;
unsigned char humidity,lcd,key=0;
 
void delay(unsigned char count)
{
unsigned char i;
unsigned int j;
for(i=0;i<count;i++)
for(j=0;j<1275;j++);
}
 
void lcd_command(unsigned char comm)
{
lcd_data_pin=comm;
en=1;
rs=0;
rw=0;
delay(1);
en=0;
}
 
void lcd_data(unsigned char disp)
{
lcd_data_pin=disp;
en=1;
rs=1;
rw=0;
delay(1);
en=0;
}
 
lcd_dataa(unsigned char *disp)
{
unsigned char x;
for(x=0;disp[x]!=0;x++)
{
lcd_data(disp[x]); 
}
}
 
void lcd_ini()
{
lcd_command(0x38);   // for using 8-bit 2 row LCD 
delay(50);
lcd_command(0x0F);        // for display on cursor blinking
delay(50);
lcd_command(0x0C);
delay(50);
lcd_command(0x80);
delay(50);   
}
 
void lcd_display(unsigned int val)
{  
unsigned char flg=0;
lcd_command(0xC7);
if(val==0)
lcd_data('0');
while(val>0)
{   
lcd=val%10;
val=val/10;
lcd_command(0xC7-flg);
lcd_data(lcd+'0');
flg++;  
}
  
}
 
void display()
{
key++;
number=number+input_port;
if(key==11)
{
number=number/key;
number=number*10;
number=number/25;
humidity=number-3;
lcd_display(humidity);
key=0;
number=0;
}
}
 
void adc()
{
rd=1;
wr=0;
delay(2);
wr=1;
while(intr==1);
rd=0;
display();
delay(2);
intr=1;
}
 
void main()
{
lcd_ini();
lcd_dataa("%Rel.Humidity:");
while(1)
{
adc();
}
}