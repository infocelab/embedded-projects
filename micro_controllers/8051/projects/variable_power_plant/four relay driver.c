#include<reg51.h>
#define on 1
#define off 0
#define ip_on 0
#define ip_off 1

sbit relay0=P2^2;
sbit relay1=P2^3;
sbit relay2=P2^4;


sbit volt_7=P0^0;
sbit volt_14=P0^1;

void msDelay(unsigned int x)
{
	unsigned int i,j;
	for(i=0;i<=x;i++)
	for(j=0;j<=975;j++);
}
void main()
{
P2=0x00;
P0=0xFF;
		relay0=off;
	relay1=off;
		relay2=off;
relay0=on;
while(1)
{
	if(volt_7 == ip_on && volt_14 == ip_off)
	{
		relay0=off;
		relay1=on;
		relay2=off;
	}	
	else if(volt_7 == ip_on && volt_14 == ip_on)
	{
		relay1=off;
		relay2=on;
		relay0=off;
	}
	
	else if(volt_7 == ip_off && volt_14 == ip_off)
	{
		relay1=off;
		relay2=off;
		relay0=on;
	}
	
		msDelay(100);
}
}

