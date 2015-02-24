#include<reg51.h>
sbit led0=P2^0;
sbit led1=P2^1;
sbit led2=P2^2;
sbit led3=P2^3;
sbit led4=P2^4;
sbit led5=P2^5;
sbit led6=P2^6;
sbit led7=P2^7;
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

	led0=1;
	msDelay(5);
	led1=1;
		msDelay(5);
		led2=1;
	msDelay(5);
	led3=1;
		msDelay(5);
		led4=1;
	msDelay(5);
	led5=1;
		msDelay(5);
		led6=1;
		msDelay(5);
		led7=1;
	msDelay(5);
	led0=0;
		msDelay(5);
		led1=0;
	msDelay(5);
	led2=0;
		msDelay(5);
		led3=0;
	msDelay(5);
	led4=0;
		msDelay(5);
		led5=0;
	msDelay(5);
	led6=0;
		msDelay(5);
		led7=1;
		msDelay(5);
}
}

