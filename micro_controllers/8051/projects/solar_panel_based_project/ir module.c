#include<reg51.h>
#define on 0
#define off 1
sbit led0 = P2^0;
sbit led1 = P2^1;
sbit led2 = P2^2;
sbit led3 = P2^3;
sbit led4 = P2^4;

sbit ir_module_1 = P0^0;
sbit ir_module_2 = P0^1;
sbit ir_module_3 = P0^2;
sbit ir_module_4 = P0^3;
sbit ir_module_5 = P0^4;

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
	led0 = on;
    while(1)
     {
          if( ir_module_1 == 1)
          {
           led1= on;
           led0= off;
        	}
					else if( ir_module_2 == 1)
          {
           led2= on;
           led1= off;
      		}
					else if( ir_module_3 == 1)
          {
           led3= on;
           led2= off;
      		}
					else if( ir_module_4 == 1)
          {
           led4= on;
           led3= off;
      		}
					else if( ir_module_5 == 1)
          {
           led1= on;
           led4= off;
      		}
				  msDelay(10);
     }
}