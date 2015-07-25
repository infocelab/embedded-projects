#include <avr/io.h>
#include <avr/delay.h>
#define F_CPU 8000000

#define led PORTA^0

unsigned int del=100; //use for delay function

void delay(void)
{

_delay_ms(del/80);

}
                                                                           
void main()
{                                           
	DDRA^0=1; //setting the input port

	while(1)
	{
		led=0;
		delay();
		led=1; 
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
