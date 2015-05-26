#include<avr/io.h>
#define	F_CPU	1000000
#include<util/delay.h>             /* _delay_ms (millisecond delay) and _delay_us (microsecond delay)*/
int main(void)
{
    int i;

	DDRD=0x00;                    /*All the 8 pins of PortD are declared as input (DTMF Decoder is connected)*/
	
	DDRB=0x0f;                    /*PB0,PB1,PB2 and PB3 pins of PortB are declared as output ( i/p1,i/p2,i/p3,i/p4 pins of DC Motor Driver are connected )*/
		
	unsigned char mobile_input;   /*Variable declarations*/
	         
	while(1)                      /*Start of infinite loop*/
	{
		mobile_input=PIND & 0x78;  /*Reading DTMF decoder output value and masking its lower 4 bits*/ 
		
		if(mobile_input == 0x08)  /*Checking DTMF values to move the robot in direction*/
		{
			PORTB=0x0A;           /* Robot will move in forward direction*/
     		_delay_ms (2000);     /*give a two second delay*/
		
		}
		else if(mobile_input == 0x10)
		{
			PORTB=0x05;
			/*Robot will move in backward direction*/
		
			_delay_ms (2000);     /*give a two second delay*/
		
		}
		else if(mobile_input == 0x20)
		{
			PORTB=0x02;          /*Robot will move in left direction*/
			_delay_ms (2000);     /*give a two second delay*/
			
		}
		else if(mobile_input == 0x60)
		{
			PORTB=0x08;           /*Robot will move in Right direction*/
			_delay_ms (2000);     /*give a two second delay*/
			
		}
		else if(mobile_input == 0x50)
		{
			PORTB=0x0f;           /*Robot will stop*/
			_delay_ms (2000);     /*give a two second delay*/
			
		}
		else
		{	
			;
			/*Null statement*/
		}
	}
}
/*End of Program*/
