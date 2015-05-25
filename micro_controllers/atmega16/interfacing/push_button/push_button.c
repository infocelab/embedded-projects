#define F_CPU 1000000UL  //Define clock speed
#include<avr/io.h>
#include<util/delay.h>
int main (void)
{
    // set all pins on PORTB for output
    DDRD = 0xFF;
    
    // set port pin PORTC2 as input and leave the others pins 
    // in their originally state (inputs or outputs, it doesn't matter)
    DDRC &= ~(1 << PC2);        // see comment #1
    //PORTC=0xFB;
    while (1) 
    {
        if (PINC & (1<<PC2))    // see comment #2
	    	PORTD &= ~(1<<PD0);
             
        else
            PORTD |= (1<<PD0); 
    }
    return 0;
}
