
// Program to interface single seven segment
 
#include<reg51.h>
sbit switch_1=P3^0;
sbit switch_2=P3^1;
sbit switch_3=P3^2;
sbit switch_4=P3^3;
sbit switch_5=P3^4;
sbit buzzer = P0^1;
delay_ms(int time)		// Time delay function
{
	int i,j;
 	for(i=0;i<time;i++)
  	for(j=0;j<1275;j++);
}

void main()
{
	//P3=0xFF;
	char num[]={0x3f,0x06,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x67};// Hex values corresponding to digits 0 to 9
	P3=0xFF;
  P0=0xFF;

  while(1)
	{  
		if(switch_1==0)
		{
		P2 = num[1];
		switch_2==1;
		switch_3==1;
		switch_4==1;
		switch_5==1;
		buzzer=0;			
		delay_ms(300);
		buzzer=1;	
		delay_ms(1000);
		}
	else if(switch_2==0)
		{
		P2 = num[2];
		switch_1==1;
		switch_3==1;
		switch_4==1;
		switch_5==1;
		buzzer=0;			
		delay_ms(300);
		buzzer=1;	
		delay_ms(1000);
		}
	else if(switch_3==0)
		{
		P2 = num[3];
		switch_2==1;
		switch_1==1;
		switch_4==1;
		switch_5==1;
		buzzer=0;			
		delay_ms(300);
		buzzer=1;	
		delay_ms(1000);
		}
	else if(switch_4==0)
		{
		P2 = num[4];
		switch_2==1;
		switch_3==1;
		switch_1==1;
		switch_5==1;
		buzzer=0;			
		delay_ms(300);
		buzzer=1;	
		delay_ms(1000);	
		}
	else if(switch_5==0)
		{
		P2 = num[5];
		switch_2==1;
		switch_3==1;
		switch_4==1;
		switch_1==1;
		buzzer=0;			
		delay_ms(300);
		buzzer=1;	
		delay_ms(1000);
		}
		
	}
}

