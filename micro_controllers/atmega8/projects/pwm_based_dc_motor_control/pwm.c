//********************************************************
//   *********** PWM DC MOTOR CONTROL *************
//********************************************************
//Controller:    ATmega8 (1MHz internal Crystal)
//Compiler:        CodeVision
//Author:        CC Dharmani, Chennai(India)
//Date:            Nov 2008
//********************************************************
//this program uses two of the three PWM channels (OC1A & OC1B)
//of the ATmega8, for controlling speed & direction of DC motor 

#include <mega8.h>
#include <delay.h>
/* quartz crystal frequency [Hz] */
#define xtal 1000000L

#define increaseButton_PRESSED             !(PIND & 0x40)
#define increaseButton_OPEN                      (PIND & 0x40)
#define decreaseButton_PRESSED             !(PIND & 0x80)
#define decreaseButton_OPEN                      (PIND & 0x80)
#define DIRECTION_FORWARD                   !(PIND & 0x20)
#define DIRECTION_REVERSE                    (PIND & 0x20)
#define STOP_MOTOR                            TCCR1B = 0x00; TCCR1A = 0x00
#define START_MOTOR                            TCCR1B = 0x09
#define set_FORWARD                            TCCR1A = 0x81
#define set_REVERSE                            TCCR1A = 0x21

//defining macros for setting minimum and maximum PWM counter values
//and step-size for controlling the voltage applied to MOSFETs base
#define COUNTER_LOWER_LIMIT                    0x0090
#define COUNTER_UPPER_LIMIT                    0x00f8
#define    STEP_SIZE                            0x0008

void port_init(void)
{
 PORTB = 0x00; 
 DDRB  = 0x06; //PWM pins OC1A & OC1B defined as outputs
 PORTC = 0x00; 
 DDRC  = 0x00;
 PORTD = 0xE0; //internal pull-up enabled for three pins connected to switches
 DDRD  = 0x00;
}

//TIMER1 initialize - prescale:1
//PWM Frequency: 1KHz
void timer1_init(void)
{
 TCCR1B = 0x00; //stop
 TCNT1H = 0xFC; //setup
 TCNT1L = 0x18;
 OCR1A  = COUNTER_LOWER_LIMIT;
 OCR1B  = COUNTER_LOWER_LIMIT;
 ICR1H  = 0x03;
 ICR1L  = 0xE8;
 TCCR1A = 0x81; //set forward; OC1A connected, OC1B disconnected
 TCCR1B = 0x09; //start Timer
}

//call this routine to initialize all peripherals
void init_devices(void)
{
 #asm("cli");//stop errant interrupts until set up
 //disable all interrupts
 port_init();
 timer1_init();

 MCUCR = 0x00;
 GICR  = 0x00;
 TIMSK = 0x00; //timer interrupt sources
 #asm("sei"); //re-enable interrupts
 //all peripherals are now initialized
}


//************************ main ***************************

void main(void)
{
 unsigned int counter = COUNTER_LOWER_LIMIT;
 unsigned char dir = 0, dir1 = 0;
 
 init_devices();
 
 while(1)
 {
   CHECK_PB:
   while(increaseButton_OPEN && decreaseButton_OPEN)    
   {                             //loop here until any push-button is pressed
     if(DIRECTION_FORWARD)        //check for Direction control switch status
          dir = 0;
      else
          dir = 1;
      if(dir != dir1)            //chenge direction if switch position has changed
      {
          STOP_MOTOR;
          delay_ms(500);
          if(dir == 0)
         set_FORWARD;
          else
         set_REVERSE;
          START_MOTOR;
       dir1 = dir;
     }  
   }     
     
   if(increaseButton_PRESSED)            //Speed-increase push-button is pressed
   {
     delay_ms(20);                          //key debouncing delay after key-pressed
     if(increaseButton_OPEN) goto CHECK_PB;
     while(increaseButton_PRESSED);      //wait here till the push-button is kept pressed
     delay_ms(20);                        //key debouncing delay after key released
     
     if(counter >= COUNTER_UPPER_LIMIT) //if speed is already maximum, don't do anything
        counter = COUNTER_UPPER_LIMIT;
     else    
        counter += STEP_SIZE;              //increase speed by a fixed step
     
     OCR1A = counter;
     OCR1B = counter;
   }
   else                                             //speed-decrease push-button is pressed
   {
     delay_ms(20);                          //key debouncing delay after key-pressed
     if(decreaseButton_OPEN) goto CHECK_PB;
     while(decreaseButton_PRESSED);      //wait here till the push-button is kept pressed
     delay_ms(20);                        //key debouncing delay after key released
     
     if(counter <= COUNTER_LOWER_LIMIT)    //if speed is already minimum, don't do anything
        counter = COUNTER_LOWER_LIMIT;
     else    
        counter -= STEP_SIZE;              //reduce speed by a fixed step
     
     OCR1A = counter;
     OCR1B = counter;
   }
     
 }
}

//******************************  END  ***************************************
            