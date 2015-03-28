#include<reg51.h>
#define on 1
#define off 0

sbit relay0=P2^0;
sbit relay1=P2^1;
sbit relay2=P2^2;


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
	if(volt_7 == 1)
	{
		relay0=off;
		relay1=on;
		relay2=off;
	}
	if(volt_14 == 1)
	{
		relay1=off;
		relay2=on;
		relay0=off;
	}
		msDelay(100);
}
}

