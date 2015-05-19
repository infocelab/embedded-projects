#define F_CPU 1000000UL
#define input
#include <avr/io.h>
#include <util/delay.h>
//Define functions
//======================
void ioinit(void);
void stop(void);
void rotate_right(void);
void rotate_left(void);
//======================
int main (void)
{
   ioinit(); //Setup IO pins and defaults
   while (1)
   {
              
              
			   rotate_left();
               stop();
               _delay_ms(50000);
			   rotate_right();
			   stop();
               _delay_ms(50000);
               
             
      
   }
   
 }
 
void ioinit (void)
{
    DDRC = 0b00011000; //set the data direction register to o/p
    PORTC = 0b00000000; //Enable internal pudown  
}
 
 void stop(void)
{
    PORTC = 0b00000000;
    PORTC = 0b00000000;
   _delay_ms(500000);
}
void rotate_left(void)
{
     PORTC = 0b00010000;
	 PORTC = 0b00001000;
	_delay_ms(550000);
}
 
void rotate_right(void)
{
    PORTC = 0b00001000;
    PORTC = 0b00010000;
   _delay_ms(550000);
}
