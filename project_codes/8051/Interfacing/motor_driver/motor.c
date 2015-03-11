#include<reg52.h>
sbit motor_pin_1 = P3^0;
sbit motor_pin_2 = P3^1;
void msDelay(unsigned int x)
{ 
	unsigned int i,j;
	for(i=0;i<x;i++)
	for(j=0;j<1275;j++);
}

void main()
{
  P3 = 0x00;
	while(1)
  {
    motor_pin_1 = 1;
    motor_pin_2 = 0; //Rotates Motor Anit Clockwise
    msDelay(1000);
    motor_pin_1 = 1;
    motor_pin_2 = 1; //Stops Motor
    msDelay(1000);
    motor_pin_1 = 0;
    motor_pin_2 = 1; //Rotates Motor Clockwise
    msDelay(1000);
    motor_pin_1 = 0;
    motor_pin_2 = 0; //Stops Motor
    msDelay(1000);
	}
}




    
    
  
