#include<reg51.h>
int i=0,j,d=0;
void delay(unsigned int msec)  // Function to provide time delay in msec.
{
for(i=0;i<msec;i++)
for(j=0;j<675;j++);
}
 
void make_A()
{
	P1 = 0x02;
	P2 = 0xFC;
	delay(d);
	P1 = 0x04;
	P2 = 0x12;
	delay(d);
	P1 = 0x08;
	P2 = 0x12;
	delay(d);
	P1 = 0x10;
	P2 = 0x12;
	delay(d);
	P1 = 0x20;
	P2 = 0x12;
	delay(d);
	P1 = 0x40;
	P2 = 0xFC;
	delay(d);
}

void make_B()
{
	P1 = 0x02;
	P2 = 0x7C;
	delay(d);
	P1 = 0x04;
	P2 = 0x92;
	delay(d);
	P1 = 0x08;
	P2 = 0x92;
	delay(d);
	P1 = 0x10;
	P2 = 0x92;
	delay(d);
	P1 = 0x20;
	P2 = 0xFE;
	delay(d);
	P1 = 0x40;
	P2 = 0x82;
	delay(d);
}
void make_C()
{
	P1 = 0x02;
	P2 = 0x82;
	delay(d);
	P1 = 0x04;
	P2 = 0x82;
	delay(d);
	P1 = 0x08;
	P2 = 0x82;
	delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x82;
	delay(d);
	P1 = 0x40;
	P2 = 0x7C;
	delay(d);
}
void make_D()
{
	P1 = 0x02;
	P2 = 0x7C;
	delay(d);
	P1 = 0x04;
	P2 = 0x82;
	delay(d);
	P1 = 0x08;
	P2 = 0x82;
	delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x82;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
	P1 = 0x80;
	P2 = 0x82;
	delay(d);
}
void make_E()
{
	P1 = 0x02;
	P2 = 0x92;
	delay(d);
	P1 = 0x04;
	P2 = 0x92;
	delay(d);
	P1 = 0x08;
	P2 = 0x92;
	delay(d);
	P1 = 0x10;
	P2 = 0x92;
	delay(d);
	P1 = 0x20;
	P2 = 0x92;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
}
void make_F()
{
	P1 = 0x02;
	P2 = 0x12;
	delay(d);
	P1 = 0x04;
	P2 = 0x12;
	delay(d);
	P1 = 0x08;
	P2 = 0x12;
	delay(d);
	P1 = 0x10;
	P2 = 0x12;
	delay(d);
	P1 = 0x20;
	P2 = 0x12;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
}
void main ()
{
	int k=0;
	P1 = 0x00;
	delay(1);
	P2 = 0x00;
	d=1;
	while(1)
	{
	  for(k=0;k<100;k++)
		{
			make_A();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_B();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_C();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_D();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_E();
		}
		delay(20);
			for(k=0;k<100;k++)
		{
			make_F();
		}
		delay(20);
	}
}
