#include<reg51.h>
sbit ledr0=P2^0;
sbit ledy0=P2^1;
sbit ledg0=P2^2;
sbit ledr1=P2^3;
sbit ledy1=P2^4;
sbit ledg1=P2^5;
sbit ledr2=P2^6;
sbit ledy2=P2^7;
sbit ledg2=P3^4;
sbit ledr3=P3^5;
sbit ledy3=P3^6;
sbit ledg3=P3^7;
void msDelay(unsigned int x)
{
	unsigned int i,j;
	for(i=0;i<=x;i++)
	for(j=0;j<=1675;j++);
}
void main()
{
	  P2=0x00; 
		P3=0x00;
   while(1)
	 {

		ledr0=1;
		ledy2=1;
		ledg3=1;
		ledr1=1;
		
	 msDelay(1000);
		ledr0=0;
		ledy2=0;
		ledg3=0;
		ledr1=0;	 
		msDelay(5); 
		ledr0=1;
		ledy3=1;
		ledg2=1;
		ledr1=1; 
		 msDelay(1000); 
		ledr0=0;
		ledy3=0;
		ledg2=0;
		ledr1=0;
	msDelay(5);
		ledr3=1;
		ledy0=1;
		ledg1=1;
		ledr2=1;
		
		msDelay(1000);
		ledr3=0;
		ledy0=0;
		ledg1=0;
		ledr2=0;
		
	msDelay(5);
		ledr2=1;
		ledy1=1;
		ledg0=1;
		ledr3=1; 
		msDelay(1000);
		ledr2=0;
		ledy1=0;
		ledg0=0;
		ledr3=0; 
		msDelay(5);
	
}
}

