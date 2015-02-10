
#include <reg52.h>                /* special function register declarations   */
                                                       /* for the intended 8051 derivative         */

#include <stdio.h>                    /* prototype declarations for I/O functions */
sbit led1=P2^0;


void Delay();                            //advance declaration of function 

/*------------------------------------------------
The main C function.  Program execution starts
here after stack initialization.
------------------------------------------------*/
void main (void) {

/*------------------------------------------------
Setup the serial port for 2400 baud at 11.0592MHz.
------------------------------------------------*/

    SCON  = 0x50;                /* SCON: mode 1, 8-bit UART, enable rcvr      */
    TMOD |= 0x20;               /* TMOD: timer 1, mode 2, 8-bit reload        */
    TH1   = 244;                /* TH1:  reload value for 2400 baud @ 11.0592MHz   */
    TR1   = 1;                  /* TR1:  timer 1 run                          */
    TI    = 1;                  /* TI:   set TI to send first char of UART    */
P2=0x00;

/*------------------------------------------------
Note that an embedded program never exits (because
there is no operating system to return to).  It
must loop and execute forever.
------------------------------------------------*/
  while (1) {   
		
			
    printf ("Hello World\n"); 		/* Print "Hello World" */  
 Delay(); 		
led1=1;		
    Delay(); 
		led1=0;
    Delay();

  }
}

void Delay(void)
{
    int j;
    
        for(j=0;j<10000;j++)
        {
        }
}