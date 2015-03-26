#include<reg52.h>
sbit LEFT_FORWARD   =P2^3;
sbit RIGHT_FORWARD  =P2^1;
sbit LEFT_BACKWARD  =P2^2;
sbit RIGHT_BACKWARD =P2^4;

sbit Left_sensor  = P0^1;
sbit Right_sensor = P0^0;
void stop()
{
                    LEFT_FORWARD = 1;
                    LEFT_BACKWARD =1;
                    RIGHT_FORWARD = 1;
                    RIGHT_BACKWARD =1;
}

void msDelay(unsigned int x)
{
     unsigned int i,j;
     for(i=0;i<x;i++)
     for(j=0;j<1275;j++);
}
	
void main() 
{
  P0= 0x00;                         // Configure PORT3 as input
  P2 = 0xFF;                        // Initial PORT2 value
  stop();
  while(1)
  {
    if(Left_sensor == 1  && Right_sensor == 1  )  // both on white
    {
                    stop();
                   msDelay(10);
                    LEFT_FORWARD =0;
                    RIGHT_FORWARD =0;
                    msDelay(100);
    }
    else if(Left_sensor == 0  && Right_sensor == 0 )  // both on black
    {
                    stop();
                    msDelay(100);
    }
    else if(Right_sensor == 0)  // moving left
    {
                    stop();
                    msDelay(10);
                    LEFT_BACKWARD =0;
                    RIGHT_FORWARD =0;
                    msDelay(100);
    }
    else if(Left_sensor == 0)  // moving right
    {
                    stop();
                    msDelay(10);
                    LEFT_FORWARD =0;
                    RIGHT_BACKWARD =0;
                   msDelay(100);
    }
  }
}
