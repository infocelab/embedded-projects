#include<reg51.h>
sbit led1 = P2^0;
sbit led2 = P2^1;
sbit led3 = P2^2;
sbit led4 = P2^3;
sbit led5 = P2^4;
sbit module1 = P0^0;
sbit module2 = P0^1;
sbit module3 = P0^2;
sbit module4 = P0^3;
sbit module5 = P0^4;
sbit ldr = P0^5;

#define on 0
#define off 1

void msDelay(unsigned int x)
{
     unsigned int i,j;
     for(i=0;i<x;i++)
     for(j=0;j<875;j++);
}
void main()
{
	int count=0;
P2=0x00;
P0=0xFF;
	led1 = off;
	led2 = off;
	led3 = off;
	led4 = off;
	led5 = off;
	led1 = on;
	msDelay(100);
    while(1)
     {
			 if(ldr == 1 ) // sunlight present
			 {
         	led1 = off;
        	led2 = off;
        	led3 = off;
        	led4 = off;
        	led5 = off;
			 }
			 else  // dark
			 {
				 count=0;
          if( module1 == 1)
          {
					 count++;
           }
					 if( module2 == 1)
          {
						 count++;
           }
					 if( module3 == 1)
           {
						  count++;
           }
					 if( module4 == 1)
           {
						  count++;
           }
					 if( module5 == 1)
           {
						  count++;
           }
					led1 = off;
        	led2 = off;
        	led3 = off;
        	led4 = off;
        	led5 = off;
					 if(count <=3)
					 {
						 led1=on;
						 led3=on;
						 led5=on;
					 }
					 else
					 {
						 led1=on;
						 led2=on;
						 led3=on;
						 led4=on;
						 led5=on;
						 
					 }
					 msDelay(50);
				 }	 
     }
}
 