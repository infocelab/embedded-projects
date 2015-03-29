// this code sets up counter2 for an 8kHz Fast PWM wave @ 16Mhz Clock


#include <avr/io.h>

//Global variables and definition
#define PULSE_WIDTH 0x40

void pwm_start(){
	OCR1AL = PULSE_WIDTH;	//Load Pulse width
	OCR1AH = 0;
	DDRD |= (1<<5);		//PortD.5 as o/p
	TCCR1A = 0x81;		//8-bit, Non-Inverted PWM
	TCCR1B = 1;		//Start PWM
}


int main(void)
{

/*
    DDRB |= (1 << DDB3);
    // PB3 is now an output

    OCR2 = 128;
    // set PWM for 50% duty cycle


    TCCR2 |= (1 << COM21);
    // set none-inverting mode

    TCCR2 |= (1 << WGM21) | (1 << WGM20);
    // set fast PWM Mode

    TCCR2 |= (1 << CS21);
    // set prescaler to 8 and starts PWM

*/
pwm_start();
    while (1)
    {
        // we have a working Fast PWM
    }
}
