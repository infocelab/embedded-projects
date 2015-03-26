#include<reg52.h> /* special function register declarations   */
                  /* for the intended 8051 derivative         */
#include<stdio.h> /* prototype declarations for I/O functions */

sbit LED1_pin = P2^0;     //Defining LED PIN
sbit LED2_pin = P2^1;     //Defining LED PIN
sbit mic1_pin = P0^0;  //Defining mic PIN
sbit mic2_pin = P0^1;  //Defining mic PIN

void Delay(int); //Function prototype declaration
void main (void) 
{
   mic1_pin = 0; // Making mic PIN input
   LED1_pin = 1;    //Making LED pin output
	mic2_pin = 0; // Making mic PIN input
   LED2_pin = 1;    //Making LED pin output

   while(1)     //infinite loop 
   {
      if(mic1_pin == 1) //If mic high
      {
	 LED1_pin = 0; //LED ON
	 Delay(1000); //Delay
	 LED1_pin = 1; //LED OFF	
      }
			  if(mic2_pin == 1) //If mic high
      {
	 LED2_pin = 0; //LED ON
	 Delay(1000); //Delay
	 LED2_pin = 1; //LED OFF	
      }
   }
}

void Delay(int k)
{
    int j;
    int i;
    for(i=0;i<k;i++)
    {
        for(j=0;j<100;j++)
        {
        }
    }
}