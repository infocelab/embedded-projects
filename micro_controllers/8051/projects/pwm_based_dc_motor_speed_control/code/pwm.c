#include<regx52.h>
//Global variables and definition
sbit PWMPIN=P2^0;
sbit INC=P3^6;
sbit DEC=P3^7;

unsigned char pwm_width;
bit pwm_flag = 0;
 
void pwm_setup()
{
TMOD=0x20;
pwm_width = 0;
EA = 1;
ET0 = 1;
TR0 = 1;
}
 
void timer0() interrupt 1
{
  if(!pwm_flag)
    {             
     //Start of High level
    pwm_flag = 1;   //Set flag
    PWMPIN = 1;     //Set PWM o/p pin
    TH0 = pwm_width;          //Load timer
    TF0 = 0;                 //Clear interrupt flag
    return;                  //Return
     }
      else
     {   //Start of Low level
      pwm_flag = 0;   //Clear flag
      PWMPIN = 0;     //Clear PWM o/p pin
      TH0 = 255 - pwm_width;               //Load timer
      TF0 = 0; //Clear Interrupt flag
      return;  //return
      }
}
 
void delay(unsigned int c1)			// change time in micro seconds
{
	int a;
	TH0=0x9B;						// select timer 0 
	TL0=0x9B;						// to generate 100 micro second delay
	TR0=1;							// start timer							
	for(a=0;a<c1;a++)				// rotate loop between 5 to 15
	  {
		while(TF0==0);				// wait until timer overflow
		TF0=0;						// reset the flag
	  }
	TR0=0;							// stop timer 
}

void main()
{
  P3=1; // define port 3 as input port
	P2=1;
  pwm_setup();
  P3=0;
	INC=1;
	DEC=1;
	P2_1 =0;
	P2_0 = 0;
  while(1)
  {
		if( INC == 0)  // increase the speed
    {  
        pwm_width++;
				if(pwm_width >= 255)
					pwm_width=255;
    }
    if( DEC == 0) // decrease the speed
    {
				pwm_width--;
				if(pwm_width <= 0)
					pwm_width=0;
    } 
		delay(10);
 }
               
}