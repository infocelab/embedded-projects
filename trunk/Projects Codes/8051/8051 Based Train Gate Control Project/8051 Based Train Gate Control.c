#include<reg51.h>
sbit motor1 = P2^1;
sbit motor2 = P2^2;
sbit module1 = P0^0;
sbit module2 = P0^1;
void msDelay(unsigned int x)
{
     unsigned int i,j;
     for(i=0;i<x;i++)
     for(j=0;j<1275;j++);
}
void main()
{
P2=0x00;
P0=0xFF;
    while(1)
     {
          if( module1 == 1)
          {
          motor1 = 1;
           msDelay(100);
           motor1 = 0;
           msDelay(100);
           }
				
          if( module2== 1)
          {
           motor2 = 1;
           msDelay(100);
           motor2 = 0;
           msDelay(100);
           }	 
     }
}
 