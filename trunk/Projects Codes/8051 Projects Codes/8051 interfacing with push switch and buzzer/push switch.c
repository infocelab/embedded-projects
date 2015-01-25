#include<reg52.h> /* special function register declarations   */
                  /* for the intended 8051 derivative         */
#include<stdio.h> /* prototype declarations for I/O functions */

sbit buzzer_pin = P2^0;     //Defining LED PIN
sbit switch_pin = P0^0;  //Defining Switch PIN

void Delay(int); //Function prototype declaration
void main (void) 
{
   switch_pin = 0; // Making Switch PIN input
   buzzer_pin = 1;    //Making LED pin output

   while(1)     //infinite loop 
   {
      if(switch_pin == 1) //If switch pressed
      {
	 buzzer_pin = 0; //LED ON
	 Delay(1000); //Delay
	 buzzer_pin = 1; //LED OFF	
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