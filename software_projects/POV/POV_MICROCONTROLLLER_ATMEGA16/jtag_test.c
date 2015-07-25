//Program to disable JTAG of AVR microcontroller
#define F_CPU 16000000UL
#include<avr/io.h>
#include<util/delay.h>
 
int main(void)
{
int i=0;
DDRC=0xFF; // Port C as output port
PORTC=0x00;
 
/* JTAG port is enabled*/
while(i<=10)
{
PORTC=~PORTC; // toggle all bits of port C
_delay_ms(10); //1 sec delay
i++;
}
 
/*Now diable JTAG port*/
MCUCSR=(1<<JTD); // sendig 1 to JTD
MCUCSR=(1<<JTD);
 
while(1)
{
PORTC=~PORTC;
_delay_ms(10);
}
 
}
 
