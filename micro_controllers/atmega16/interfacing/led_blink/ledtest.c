#define F_CPU 1000000UL  //Define clock speed
#include <avr/io.h> //include input output header file
#include <util/delay.h> // include the delay header file


int main(void)
{
   DDRC = 0b00000001; //set the data direction register to o/p
   while(1)
  {
    DDRC =_BV(PC0);    //led is connected to pin 14(PD0)
	_delay_ms(500);
	DDRC &= ~_BV(PC0);
	_delay_ms(500);

	DDRC =_BV(PC1);    //led is connected to pin 14(PD0)
	_delay_ms(500);
	DDRC &= ~_BV(PC1);
	_delay_ms(500);

	DDRC =_BV(PC2);    //led is connected to pin 14(PD0)
	_delay_ms(500);
	DDRC &= ~_BV(PC2);
	_delay_ms(500);
  }
}
