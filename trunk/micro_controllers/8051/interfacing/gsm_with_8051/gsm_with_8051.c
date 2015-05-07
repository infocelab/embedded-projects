#include <REG51.H>         /* special function register declarations   */
#include <stdio.h>         /* prototype declarations for I/O functions */
#include<lcd.h>
sbit sensor=P0^7;          /* Sensor connected to port 0 7th pin number */
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
 
void serial_init(void);
unsigned int j;
//Setup the serial port for 9600 baud at 11.0592MHz.
//-------------------------------------------------
void serial_init(void)
{
   SCON = 0x50;                 /* SCON: mode 1, 8-bit UART, enable rcvr */
   TMOD |= 0x20;               /* TMOD: timer 1, mode 2, 8-bit reload */
   TH1   = 0xFD;              /* TH1: reload value for 9600 baud @ 11.0592MHz*/
   TR1   = 1;                /* TR1: timer 1 run*/
   TI   = 1;                /* TI:   set TI to send first char of UART*/
}
 
 
//Delay Routine start here
void delay1(int n)
{
   int i;
   for(i=0;i<n;i++);
}
 
void delay2(int n)
{
   int i;
  for(i=0;i<n;i++)
  delay1(1000);
}
 
//-------------------------------------
// Main program starts here
//-------------------------------------
void main(void)
{
	          serial_init();                        //serial initialization
	          Lcd8_init();
            P0=0x00;
	          while(1)
						{
			  	  Lcd8_Set_Cursor(1,1);
	          Lcd8_Write_String("Welcome To GSM");
						Lcd8_Set_Cursor(2,1);
		        Lcd8_Write_String(".Module Test.");
						Delay(1000);
						if(sensor==1)
						{	
            Lcd8_Clear();	
            Lcd8_Write_String("Message sending...");
						Delay(1000);
            printf("AT+CMGF=1%c",13);
	          delay2(20);                           
            printf("AT+CMGS=\"7827855025\"%c",13);//Text Mode| hex value of 13 is 0x0D (CR ) 
	          delay2(20);                           //Type your mobile number Eg : "9884467058"
            printf("This is Message From GSM Modem");      //Type text as u want         
	          delay2(20);                                 
            printf("%c",0x1A);                    //line feed command 
	          delay2(20);
						}	
           else
	
			   	  {
					  Lcd8_Clear();
						Lcd8_Set_Cursor(1,1);
	          Lcd8_Write_String("msg not sending");
						Delay(1000);
						Lcd8_Clear();
					  Lcd8_Set_Cursor(1,1);
	          Lcd8_Write_String("Welcome To My");
						Lcd8_Set_Cursor(2,1);
		        Lcd8_Write_String("....Home...");
						Delay(1000);
				    }
					}						
           
			 Delay(500);
}
 

