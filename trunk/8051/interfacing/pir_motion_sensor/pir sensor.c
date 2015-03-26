#include<reg51.h>
sbit led = P2^0;
sbit pir = P0^0;
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
          if( pir == 1)
          {
           led = 1;
           msDelay(1000);
           led = 0;
           msDelay(100);
           }
     }
}
 