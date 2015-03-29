/*****************************************************
This program was produced by the
CodeWizardAVR V2.04.6 Evaluation
Automatic Program Generator
© Copyright 1998-2010 Pavel Haiduc, HP InfoTech s.r.l.
http://www.hpinfotech.com

Project : LED_BLINK
Version : 
Date    : 24-03-2015
Author  : Shankar
Company : celab
Comments: 


Chip type               : ATmega16
Program type            : Application
AVR Core Clock frequency: 8.000000 MHz
Memory model            : Small
External RAM size       : 0
Data Stack size         : 256
*****************************************************/

#include <mega8.h>
#include <delay.h>
#define LED PORTB.0
#define ON  1
#define OFF 0


// Declare your global variables here

void main(void)
{
DDRD  = 0xff ;
PORTD = 0x00 ;

while (1)
      {
      // Place your code here 
      LED = ON;
      delay_ms(1000);
      LED = OFF;
      delay_ms(1000);

      }
}
