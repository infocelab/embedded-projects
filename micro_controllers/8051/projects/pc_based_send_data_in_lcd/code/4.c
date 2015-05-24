#include<reg52.h>							 //including sfr registers for ports of the controller
#include<lcd.h>
#include <stdio.h>  

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
void main()
{
	int i=0, c=1, j;
	char str[20];
 
	
	/*------------------------------------------------
Setup the serial port for 2400 baud at 11.0592MHz.
------------------------------------------------*/

    SCON  = 0x50;                /* SCON: mode 1, 8-bit UART, enable rcvr      */
    TMOD |= 0x20;               /* TMOD: timer 1, mode 2, 8-bit reload        */
    TH1   = 0xFD;                /* TH1:  reload value for 2400 baud @ 11.0592MHz   */
    TR1   = 1;                  /* TR1:  timer 1 run                          */
    TI    = 1;                  /* TI:   set TI to send first char of UART    */
	
	Lcd8_init();

  while(1)
  { 
   while(c==1)
	 {
        
		scanf("%c",&str[i]);
		
		//Lcd8_Set_Cursor(1,i++);
	  //Lcd8_Write_String(str);
		 if(str[i]=='*')
		 {
			 
			 c=0;
		 }
		  i++;
	 }
	
	   c=1;
	   i=0;
	  Lcd8_Clear();
	  Delay(200);
		Lcd8_Write_String(str);
	 for(j=0;j<20;j++)
	 {
		 str[j]='\0';
	 }
}
//Lcd8_Write_String(str);
		
}




