#include<reg51.h>
sbit relay=P2^1;
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

	relay=1;
	msDelay(100);
		relay=0;
	msDelay(100);
	}
}	