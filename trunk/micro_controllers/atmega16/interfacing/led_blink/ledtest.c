#define F_CPU 1000000UL  //Define clock speed
#include <avr/io.h> //include input output header file
#include <util/delay.h> // include the delay header file


int main(void)
{
   DDRD = 0b00100000; //set the data direction register to o/p
   while(1)
  {
    DDRD =_BV(PD5);
	_delay_ms(500);
	DDRD &= ~_BV(PD5);
	_delay_ms(500);
  }
}
