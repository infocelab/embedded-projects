#include<reg51.h>
sbit led = P2^0;
sbit module = P0^0;
void msDelay(unsigned int x)
{
     unsigned int i,j;
     for(i=0;i<x;i++)
     for(j=0;j<1275;j++);
}
void main()
{
     while(1)
     {
P2=0x00;
P0=0xFF;
 
           if( module == 1)
           {
           led = 1;
           msDelay(1000);
           led = 0;
           msDelay(100);
 
           }
     }
}
 