#include<reg52.h> 
#include<stdio.h> 

sbit buzzer_pin = P2^0;     //Defining LED PIN
sbit switch_pin = P0^0;  //Defining Switch PIN

void Delay(int); //Function prototype declaration
void main (void) 
{
	P2 = 0;
	P0 = 1;
   switch_pin = 1; // Making Switch PIN input
   buzzer_pin = 0;    //Making LED pin output

   while(1)     //infinite loop 
   {
      if(switch_pin == 1) //If switch pressed
      {
	 buzzer_pin = 1; //LED ON
	 Delay(1000); //Delay
	 buzzer_pin = 0; //LED OFF	
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