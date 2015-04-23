#include<reg52.h> /* special function register declarations   */
                  /* for the intended 8051 derivative         */
#include<stdio.h> /* prototype declarations for I/O functions */

sbit LED_pin = P2^0;     //Defining LED PIN
sbit switch_pin = P3^1;  //Defining Switch PIN

void Delay(int); //Function prototype declaration
void main (void) 
{
   switch_pin = 0; // Making Switch PIN input
   LED_pin = 0;    //Making LED pin output

   while(1)     //infinite loop 
   {
      if(switch_pin == 1) //If switch pressed
      {
		LED_pin = 1; //LED ON
		Delay(1000); //Delay
		LED_pin = 0; //LED OFF	
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