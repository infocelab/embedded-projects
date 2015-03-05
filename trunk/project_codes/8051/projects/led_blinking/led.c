#include<reg51.h>
sbit led=P2^0;
void delay( unsigned int x)
{
   unsigned int i,j;
   for(i=0;i<x;i++)
   for(j=0;j<1275;j++);
}
void main()
{
  P2=0x00;
  led=1;
  delay(50);
  led=0;
  delay(50);
}