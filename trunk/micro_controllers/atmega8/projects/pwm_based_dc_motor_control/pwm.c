// this code sets up counter2 for an 8kHz Fast PWM wave @ 16Mhz Clock


#include <avr/io.h>
#include <util/delay.h>
//Global variables and definition
int pulse_width=80;

void ioinit(void);
void led_on(void);
void led_off(void);

void pwm_start(){
    DDRB |= (1 << DDB3);
    // PB2 is now an output

    OCR2 = pulse_width;
    // set PWM for 50% duty cycle


    TCCR2 |= (1 << COM21);
    // set none-inverting mode

    TCCR2 |= (1 << WGM21) | (1 << WGM20);
    // set fast PWM Mode

    TCCR2 |= (1 << CS21);
    // set prescaler to 8 and starts PWM
}


int main(void)
{
	    pwm_start();

    while (1)
    {

	  if (bit_is_clear(PINC, 3)) // 26 pin
      {
	     led_on();
         _delay_ms(1000);
         led_off();
	    _delay_ms(500);
         if(pulse_width < 255)
		{
        pulse_width += 10;
	    OCR2 = pulse_width; 
		_delay_ms(2000);
   		}
        else
		{
           pulse_width=255;
		}
	  }	
	  else if (bit_is_clear(PINC, 2))  // 25 pin
      {
	     led_on();
         _delay_ms(1000);
         led_off();
	    _delay_ms(500);
         if(pulse_width > 10)
		{
        pulse_width -= 10;
	    OCR2 = pulse_width; 
		_delay_ms(2000);
   		}
        else
		{
           pulse_width=0;
		}
	  }	
      _delay_ms(100);
    }
}


void ioinit (void)
{
   DDRC = 0b11110111; //Pin 26 of MCU as input
   PORTC = 0b00001000; //Enable internal pullup of pin 26
}

void led_on(void)
{
   PORTC |= _BV(PC5); //Pin 28 of MCU as output
}
 
void led_off(void)
{
   PORTC &= ~_BV(PC5);
}
 
