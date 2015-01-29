//PROG. Version 11.10.23.17
 
// interfacing ds1307 with 80C51
 
#include<reg51.h>
 
/* pins used for external h/w */
 
sbit RS=P0^0; //connect p0.0 to rs pin of lcd
 
sbit EN=P0^1; //connect p0.1 to en pin of lcd
 
sbit SCL=P1^4; //i2c clock pin
 
sbit SDA=P1^5; //i2c data pin   
 
sbit SET=P1^0; //set button pin
 
sbit INR=P1^2; //increment button pin
 
/* some required define(s)*/
 
#define delay_us _nop_(); //generates 1 microsecond delay
 
#define LCD P2 //port2 connected to LCD data pins
 
#define SCLHIGH  SCL=1;
 
#define SCLLOW   SCL=0;
 
#define SDAHIGH  SDA=1;
 
#define SDALOW   SDA=0;
 
/*various functions used in whole program*/
 
void _nop_(void);
 
void init_lcd(void);
 
void cmd_lcd(unsigned char);
 
void write_lcd(unsigned char);
 
void display_lcd(unsigned char *);
 
void delay_ms(unsigned int); 
 
void init_rtc(void);
 
void set_rtc(void);
 
void strt_msg(void);
 
void start(void);
 
void stop(void);
 
void send_byte(unsigned char);
 
unsigned char receive_byte(unsigned char);
 
void write_i2c(unsigned char,unsigned char,unsigned char);
 
void set_value(void);
 
void stpwtch(void);
 
unsigned char read_i2c(unsigned char,unsigned char); 
 
//Give time here to set initial values to ds 1307 as specified in timekeeper register 
unsigned char clock[]={0x00,0x59,0x23,0x04,0x20,0x10,0x11};
//clock[]={seconds,minutes,hours,day_of_week,date,month,year};
 
unsigned char stp[]={0x00,0x00,0x00};
//stopwatch initial value
 
unsigned char *s[]={"SUN","MON","TUE","WED","THU","FRI","SAT"};
 
unsigned char slave_ack,add=0,c,k,sas;
 
unsigned int num;
 
 
void main(void)
{
init_lcd();
 
strt_msg();
 
//COMMENT THIS SECTION WHILE TRANSFRING PROGRAM SECOND TIME IN H/W
init_rtc();
 
//always do this
while(1)
{
 
if(SET==0)
set_value();
 
c=read_i2c(0xd0,0x02);//read hours register and display on LCD
/* IMP rtc ds 1307 understands BCD no.sys. our 8051 uC understands HEX no.sys.
 and LCD requires ASCII data,,,,,,,,,,,,,,,,,,
 e.g. lets consider if data read from 1307 is 12 (BCD) i.e. 0001 0010 (BIN)
 so 8051 consider it as 18 (DECIMAL)
 x1=(18/16)+48=49(ASCII) i.e. lcd will show 1 and
 x2=(18%16)+48=50(ASCII) i.e. lcd will show 2
 i.e. 12 on lcd                                        */
write_lcd((c/16)+48);
write_lcd((c%16)+48);
write_lcd(':');
sas = c & 0x20;
 
 
c=read_i2c(0xd0,0x01);//read minutes register and display on LCD
write_lcd((c/16)+48);
write_lcd((c%16)+48);
write_lcd(':');
 
c=read_i2c(0xd0,0x00);//read seconds register and display on LCD
write_lcd((c/16)+48);
write_lcd((c%16)+48);
write_lcd(' ');                         
 
display_lcd(s[read_i2c(0xd0,0x03)]);//read day register and display 
//write_lcd(*s[read_i2c(0xd0,0x03)]);
 
cmd_lcd(0xc0);// Go to starting position of 2nd line of LCD
 
c=read_i2c(0xd0,0x04);//read date register and display on LCD
write_lcd((c/16)+48);
write_lcd((c%16)+48);
write_lcd('/');
 
c=read_i2c(0xd0,0x05);//read month register and display on LCD
write_lcd((c/16)+48);
write_lcd((c%16)+48);
write_lcd('/');
 
write_lcd('2'); //write 1st 2 digits of year bcoz only last 2 bits are stored in rtc
write_lcd('0');
c=read_i2c(0xd0,0x06);//read year register and display on LCD
write_lcd((c/16)+48);
write_lcd((c%16)+48);
 
write_lcd(32);   //THIS SECTION SHOWS am/pm
if(sas == 0x20)
{
display_lcd("AM");
//write_lcd(49);
}
else
{
//write_lcd(48);
  display_lcd("PM");
}
 
delay_ms(110);
cmd_lcd(0x01); // Go to starting position of 1st line of LCD 
}
    
}
 
 
 
void start(void) //starts i2c, if both SCK & SDA are idle
{ 
if(SCL==0) //check SCK. if SCK busy, return else SCK idle
return;
if(SDA==0) //check SDA. if SDA busy, return else SDA idle
return;
 
SDALOW //High to Low transition on data line SDA makes d start condition
delay_us
 
SCLLOW  //clock low   
delay_us
}
 
 
void stop(void) //stops i2c, releasing the bus
{        
SDALOW //data low
SCLHIGH //clock high
delay_us
SDAHIGH //Low to High transition on data line SDA makes d stop condition
delay_us
}
 
 
void send_byte(unsigned char c) //transmits one byte of data to i2c bus
{
unsigned mask=0x80;
do   //transmits 8 bits
{
if(c&mask) //set data line accordingly(0 or 1)
SDAHIGH //data high
else
SDALOW  //data low
 
//generate colck
SCLHIGH   //clock high
delay_us
 
SCLLOW   //clock low
delay_us
 
mask/=2;  //shift mask
}while(mask>0);
 
SDAHIGH  //release data line for acknowledge
SCLHIGH  //send clock for acknowledge
delay_us
slave_ack=SDA; //read data pin for acknowledge
SCLLOW  //clock low
delay_us
}
 
unsigned char receive_byte(unsigned char master_ack) //receives one byte of data from i2c bus
{
unsigned char c=0,mask=0x80;
do   //receive 8 bits
{
SCLHIGH //clock high
delay_us
 
if(SDA==1) //read data
c|=mask;    //store data
   SCLLOW   //clock low
   delay_us
   mask/=2; //shift mask
}while(mask>0);
 
if(master_ack==1)
SDAHIGH //don't acknowledge
else
SDALOW //acknowledge
 
    SCLHIGH //clock high
    delay_us
   
    SCLLOW //clock low
    delay_us
 
SDAHIGH //data high
 
return c;
}
 
 
void write_i2c(unsigned char device_id,unsigned char location,unsigned char c)
//writes one byte of data(c) to slave device(device_id) at given address(location)
{
do
{
start();       //starts i2c bus
send_byte(device_id);   //select slave device
if(slave_ack==1)   //if acknowledge not received, stop i2c bus
stop();
}while(slave_ack==1); //loop until acknowledge is received
 
send_byte(location); //send address location
send_byte(c); //send data to i2c bus
stop(); //stop i2c bus
}
 
 
unsigned char read_i2c(unsigned char device_id,unsigned char location)
//reads one byte of data(c) from slave device(device_id) at given address(location)
{
unsigned char c;
do
{
start();   //starts i2c bus  
send_byte(device_id); //select slave device
if(slave_ack==1) //if acknowledge not received, stop i2c bus
stop();
}while(slave_ack==1); //loop until acknowledge is received
 
send_byte(location);  //send address location     
stop(); //stop i2c bus
start(); //starts i2c bus  
send_byte(device_id+1); //select slave device in read mode
c=receive_byte(1); //receive data from i2c bus
stop(); //stop i2c bus
return c;
}
 
 
void init_lcd(void)
//initialize lcd
{                           
delay_ms(10); //delay 10 milliseconds
 
cmd_lcd(0x0e); //lcd on, cursor on
delay_ms(10);
 
cmd_lcd(0x38); //8 bit initialize, 5x7 character font, 16x2 display
delay_ms(10);
 
cmd_lcd(0x06); //right shift cursor automatically after each character is displayed
delay_ms(10);
 
cmd_lcd(0x01); //clear lcd
delay_ms(10);
 
cmd_lcd (0x80);
}
 
 
void cmd_lcd(unsigned char c)
//transmit command or instruction to lcd
{
EN=1;
RS=0; //clear register select pin
LCD=c; //load 8 bit data
EN=0; //clear enable pin
delay_ms(2); //delay 2 milliseconds
}
 
 
void write_lcd(unsigned char c)
//transmit a character to be displayed on lcd
{
EN=1; //set enable pin
RS=1; //set register select pin
LCD=c;  //load 8 bit data
EN=0; //clear enable pin
delay_ms(2); //delay 2 milliseconds
}
 
 
void display_lcd(unsigned char *s)
//transmit a string to be displayed on lcd
{
while(*s)
write_lcd(*s++);
}
 
 
void delay_ms(unsigned int i)
//generates delay in milli seconds
{
unsigned int j;
while(i-->0)
{
for(j=0;j<500;j++)
{
    ;
}
}
}   
 
 
void set_value(void)
//this function used for setting time using SET & INC buttons or pins
{
cmd_lcd(0x80);
display_lcd("WELCOME TO TIME");
cmd_lcd(0xC0);
display_lcd(" SET WIZARD !!!");
delay_ms(300);
cmd_lcd(0x01);
cmd_lcd(0x80);
display_lcd(" SET YOUR RTC ?");
cmd_lcd(0xC0);
display_lcd("YES        NEXT");
while(1)
{
if(SET==0)
{
set_rtc();
break;
}
if(INR==0)
{
cmd_lcd(0x01);
stpwtch();
break;
}
}
}
 
void init_rtc()
{
while(add<=6)   //update real time clock ic i.e. ds1307 with time
{
write_i2c(0xd0,add,clock[add]);
add++;
}
}
 
void strt_msg()
{
unsigned int i,j=0;
display_lcd("Welcome to RTC");
cmd_lcd(0xc0);
display_lcd("<<<<<<<<>>>>>>>");
delay_ms(300);   //"...(#@#@#)..."
cmd_lcd(0x01);
display_lcd("SKIP INTRODUCTION");
cmd_lcd(0xc0);
display_lcd("YES           NO");
while(1)
{
if(SET==0)
{
delay_ms(40);
break;
}
if(i==1000)
{
j++;
i=0;
}
if(INR==0|j==100)
{
cmd_lcd(0x01);
display_lcd("THIS PROJECT IS");
cmd_lcd(0xc0);
display_lcd("DONE BY T.E. ELN");
delay_ms(500);
cmd_lcd(0x01);
display_lcd("<ROLL NO> <NAME>");
delay_ms(250);
cmd_lcd(0x01);
display_lcd("38 AVINASH PATIL");
cmd_lcd(0xc0);
display_lcd("44 AMIT SALUNKHE");
delay_ms(550);
cmd_lcd(0x01);
display_lcd("46 SWAPNIL SANKPAL");
cmd_lcd(0xc0);
display_lcd("48 SUMIT SHEKHAR");
delay_ms(550);
cmd_lcd(0x01);
display_lcd("49 PRANAV SHINDE");
delay_ms(300);
cmd_lcd(0x01);
display_lcd("STARTING RTC....");
cmd_lcd(0xC0);
for(i=0;i<17;i++)
{
display_lcd(".");
delay_ms(15);
}
break;
}
i++;
}
cmd_lcd(0x01);
}
 
void set_rtc()
{
    unsigned char cnt=0x00;
unsigned char q,p,i=0x00;
while(1)
{
if(SET==0x00)
{
cnt++;
delay_ms(50);
cmd_lcd(0x01); // Go to starting position of 1st line of LCD 
cmd_lcd(0xc0);
display_lcd("NEXT     INC");
cmd_lcd(0x80);
switch(cnt)
{
case 1:
  display_lcd("Minutes:");
break;
case 2:
  display_lcd("Hours  :");
break;
case 3:
  display_lcd("Day    :");
break;
case 4:
  display_lcd("Date   :");
break;
case 5:
  display_lcd("Month  :");
break;
  case 6:
  display_lcd("Year   :");
}
}
if(INR==0)
break;
if(cnt>6)
return;
}
cmd_lcd(0xc0);
display_lcd("SAVE     INC");
while(1)
{  if(INR==0)
 {
      delay_ms(10);   
  cmd_lcd(0x8A); // Go to starting position of 2nd line of LCD 
  p++;
  delay_ms(20);
   switch(cnt)
{
case 1:
if(p>59)
{
  p=0;
}
break;
case 2:
  if(p>23)
{
  p=0;
}
   break;
case 3:
  if(p>7)
{
  p=0;
}
break;
case 4:
  if(p>31)
{
  p=0;
}
break;
case 5:
  if(p>12)
{
  p=0;
}
       break;
  case 6:
  if(p>99)
{
  p=0;
}
}   
  q=(p/10)<<4;
  q=q|(p%10);
  write_lcd((q/16)+48);
  write_lcd((q%16)+48);
 }
if(SET==0)
  break;
}
write_i2c(0xD0,cnt,q);
cmd_lcd(0x01);
display_lcd("SAVING CHAGES");
cmd_lcd(0xc0);
display_lcd("PLEASE WAIT");
// delay_ms(100);
for(i=0;i<6;i++)
{
display_lcd(".");
delay_ms(40);
}
cmd_lcd(0x01);
}
 
 