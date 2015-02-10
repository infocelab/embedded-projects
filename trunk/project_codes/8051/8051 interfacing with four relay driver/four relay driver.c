#include<reg51.h>
sbit relay0=P2^0;
sbit relay1=P2^1;
sbit relay2=P2^2;
sbit relay3=P2^3;
void msDelay(unsigned int x)
{
	unsigned int i,j;
	for(i=0;i<=x;i++)
	for(j=0;j<=1675;j++);
}
void main()
{
	P2=0x00;
while(1)
	{

	relay0=1;
	msDelay(100);
		relay1=1;
	msDelay(100);
relay2=1;
		msDelay(100);
	relay2=0;
		msDelay(100);
	relay3=1;
	msDelay(100);
			relay0=0;
	msDelay(100);
			relay1=0;
	msDelay(100);
		relay2=0;
		msDelay(100);
	relay3=0;
		msDelay(100);
}
}

