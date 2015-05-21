#define F_CPU 1000000UL  //Define clock speed
#include <avr/io.h> //include input output header file
#include <util/delay.h> // include the delay header file


int main(void)
{
   DDRD = 0b00000001; //set the data direction register to o/p
   while(1)
  {
    DDRD =_BV(PD0);    //led is connected to pin 14(PD0)
	_delay_ms(500);
	DDRD &= ~_BV(PD0);
	_delay_ms(500);
  }
}
