
//GPS Vehicle tracker
#define F_CPU 12000000			//12Mhz
#include <avr/io.h>			//Header file for AVR device specific I/O Definitions.
#include <avr/pgmspace.h>		//Header file for incorporating program space string utilities.
#include <util/delay.h>			//Header file for incorporating delay routines.
#include<inttypes.h>


#define USART_BAUDRATE 9600
#define BAUD_PRESCALE (((F_CPU / (USART_BAUDRATE * 16UL))) - 1)

void WaitMs(unsigned int ms);		

void usart_init();
unsigned int usart_getch();
void usart_writech(unsigned char data);
void usart_message(unsigned char *var);

unsigned char value,i,lati_value[9],lati_dir, longi_value[10], longi_dir, final_message[30];
unsigned char deg = 0xB0;



void sendmessage(char msg[], char num[])
{ 
 int i=0,j=0; 
 puts("AT+CMGF="); 
 putchar(49); // sends the ASCII value of '1' 
 puts("AT+CMGS="); 
 putchar('\"'); 
 while(num[i]!='\0') 
 { 
 j=(int)num[i];  putchar(j); //sends the ASCII values of the numbers
 i++;
 } 
 puts("Hello World"); 
 putchar('26'); //sends the ASCII value of <Ctrl>+<Z> 
 
} 



int main()
{

DDRC=0x00;
PORTC=0xff;

    usart_init();
	WaitMs(1000);
	usart_message("ATH");
	WaitMs(50);

       
	usart_message("AT+CMGF=1");
	usart_writech(0x0D);
	WaitMs(20);
		 
	WaitMs(20);
	usart_message("AT+CMGS=\"9958357446\"");
	usart_writech(0x0D);
	usart_message("Working gsm module ok shankar");
	usart_writech(0x1A);
	WaitMs(1000);

	sendmessage("OK","9958357446");
    while(1)
	{
		a:
		value=usart_getch();
		if(value=='$')
		{		
			value=usart_getch();
			if(value=='G')
			{
				value=usart_getch();
				if(value=='P')
				{
					value=usart_getch();
					if(value=='G')
					{				
						value=usart_getch();
						if(value=='A')
						{
							value=usart_getch();
							if(value==',')
							{
								value=usart_getch();
								while(value!=',')
								{
									value=usart_getch();
								}
	
								for(i=0; i<9; i++)
								{
									lati_value[i] = usart_getch();
								}
								value = usart_getch();
	
								lati_dir=usart_getch();
								value=usart_getch();
								for(i=0; i<10; i++)
								{			

									longi_value[i] = usart_getch();
								}
								value = usart_getch();
	
								for(i=1;value!=',';i++)
								{
									longi_value[i]=usart_getch();

									value=longi_value[i];
								}
								longi_dir=usart_getch();
							}
						}
					}
				}
			}
		}
		if(*lati_value && *longi_value)
		{
			for(i=0; i<9; i++)
			{
				final_message[i] = lati_value[i];

			}		

			final_message[9] = lati_dir;
			final_message[10] = ' ';
			for(i=0; i<10; i++)
			{

				final_message[i+11] = longi_value[i];
			}

	
			final_message[21] = longi_dir;
			final_message[22] = '\0';
		}
		else
		goto a;
		while(PINC==0xff);
		WaitMs(1000);
		usart_message("ATH");
		WaitMs(50);

       
		usart_message("AT+CMGF=1");
		usart_writech(0x0D);
		WaitMs(20);
		 
		WaitMs(20);
		usart_message("AT+CMGS=\"+919958357446\"");
		usart_writech(0x0D);
		usart_message(final_message);//message
		usart_writech(0x1A);
		WaitMs(1000);
		goto a;
	 
    }


	return 0;	
	
}


void WaitMs(unsigned int ms)		
{
	unsigned int i;

	for(i=0;i<=ms;i++)
	{
		_delay_ms(1);
	}
}


 
void usart_init()
{


UCSRB =  (1 << RXEN) | (1 << TXEN);                    

// Use 8-bit character sizes
//UCSRC |= (1 << URSEL) | (1 << UCZS0) | (1 << UCZS1);   
UCSRC |= (1 << URSEL) | (1 << UCSZ0) | (1 << UCSZ1);   

// Load lower 8-bits of the baud rate value into the low byte of the UBRR register
UBRRL = BAUD_PRESCALE;  
                              
UBRRH = (BAUD_PRESCALE >> 8);                          

}
 
 
unsigned int usart_getch()
{

while (!(UCSRA & (1 << RXC)));                          

return(UDR);                                            
}

void usart_writech(unsigned char data)
{
 
 while(!(UCSRA & (1<<UDRE)));
 UDR = data;
}

void usart_message(unsigned char *var) 
{
int h;
while(*var)         
usart_writech(var++); // send message
for(h=0;h<=200;h++); 
}
