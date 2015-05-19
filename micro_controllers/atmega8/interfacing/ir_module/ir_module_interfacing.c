#define F_CPU 1000000UL
#define input
#include <avr/io.h>
#include <util/delay.h>
//Define functions
//======================
void ioinit(void);
void led_on(void);
void led_off(void);
//======================
int main (void)
{
   ioinit(); //Setup IO pins and defaults
   while (1)
   {
      if(bit_is_set(PINC,4))    // Check IR module is sensed or not
      {
                 
               _delay_ms(1000);
			   led_on();        //turn on the led 
               _delay_ms(20000);//wait a while
			   led_off();       //turn on the led 
               
                 
      }
   }
 }
 
void ioinit (void)
{
   DDRC = 0b11101111; //Pin 27 of MCU as input
   PORTC = 0b00010000; //Enable internal pudown of pin 27
}
 
void led_off(void)
{
   PORTC |= _BV(PC5); //Pin 28 of MCU as output
}
 
void led_on(void)
{
   PORTC &= ~_BV(PC5);
}
