// this code sets up counter2 for an 8kHz Fast PWM wave @ 16Mhz Clock


#include <avr/io.h>


int main(void)
{
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


    while (1)
    {
        // we have a working Fast PWM
    }
}
