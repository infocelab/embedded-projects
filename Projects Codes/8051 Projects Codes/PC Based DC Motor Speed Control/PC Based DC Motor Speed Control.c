#include<reg51.h>
sbit cmd=P1^0;
sbit led=P2^2;
sbit m1=P2^0;
sbit encoder = P3^3;
unsigned int curspeed = 0;
sbit PWMPIN =P2^0;
#define minspeed 40

unsigned int pwm_width;

bit pwm_flag = 0;
bit flag =0;
unsigned int a=0;
int i=0,j=0,k=0,l=0;
void msdelay(unsigned int x);
void send(unsigned char z);
 void display(int speed);

void delay()					// 1 sec delay
  {
  	int k;
	TL1 = 0xAF;					// load value 15535=3CAF
	TH1 = 0x3C;
	TR1 = 1;
	for(k=0;k<20;k++)
	  {
		while(TF1==0);
		TF1 = 0;
		TL1 = 0xAF;
		TH1 = 0x3C;
	  }
	TR1 = 0;
  }
	/*
	void int1(void) interrupt 2		// for rpm external interrupt 1 function
{
	//EA=0; 							// first disable interrupts
	led=0;						    // give indication
	//TR1=1;						    // start timer 1
	delay();					    // give 1 sec delay
	//TR1=0;							// stop timer
	led=1;
	//flag=1;  				     // if not then set the flag
	//EX1 = 0;
 }
	*/
 
 void rpm_setup()
{
	//TMOD = 0;
	//EA = 1;
	EX1 = 1;
  //IT0 = 1;
}
void pwm_setup()
{
	//TMOD = 0;
	pwm_width = minspeed;
	EA = 1;
	ET0 = 1;
	TR0 = 1;
}

void timer0() interrupt 1 
{
	if(!pwm_flag) 
	{	//Start of High level
		pwm_flag = 1;	//Set flag
		PWMPIN = 1;	//Set PWM o/p pin
		TH0 = pwm_width;	//Load timer
		TF0 = 0;	 //Clear interrupt flag
		return;	 //Return
	}
	else 
	{	//Start of Low level
		pwm_flag = 0;	//Clear flag
		PWMPIN = 0;	//Clear PWM o/p pin
		TH0 = 255 - pwm_width;	//Load timer
		TF0 = 0;	//Clear Interrupt flag
		return;	 //return
	}
	
}
void send(unsigned char z)
{
	
	switch(z)
	{
		case '0':
			SBUF=0x30; 
			TI=0;
			while(TI==0);
		break;
		case '1':
			SBUF=0x31; 
			TI=0;
			while(TI==0);
		break;
		case '2':
			SBUF=0x32; 
			TI=0;
			while(TI==0);
		break;
		case '3':
			SBUF=0x33; 
			TI=0;
			while(TI==0);
		break;
		case '4':
			SBUF=0x34; 
			TI=0;
			while(TI==0);
		break;
		case '5':
			SBUF=0x35; 
			TI=0;
			while(TI==0);
		break;
		case '6':
			SBUF=0x36; 
			TI=0;
			while(TI==0);
		break;
		case '7':
			SBUF=0x37; 
			TI=0;
			while(TI==0);
		break;
		case '8':
			SBUF=0x38; 
			TI=0;
			while(TI==0);
		break;
		case '9':
			SBUF=0x39; 
			TI=0;
			while(TI==0);
		break;
		case 'w':
			SBUF=0x77;
			TI=0;
			while(TI==0);
		break;
		case 'x':
			SBUF=0x78;
			TI=0;
			while(TI==0);
		break;
		case 'y':
			SBUF=0x79;
			TI=0;
			while(TI==0);
		break;
		case 'z':
			SBUF=0x7A;
			TI=0;
			while(TI==0);
		break;
		
	}
	 		
		
}

void msdelay(unsigned int x)
{
	unsigned int i,j;

	for(i=0;i<x;i++)
	for(j=0;j<1275;j++);
}

void ISR_sc(void) interrupt 4
{
	unsigned char v;

	if(RI==1)
	{
		v = SBUF;
		if(v==0x30)  // zero
		{
			led=1;
			pwm_width = pwm_width - 1;
			if(pwm_width<minspeed)
		  {
			    pwm_width =minspeed;
		  }
			//SBUF=0x32; 
			//TI=0;
			//while(TI==0);
			
			
		}
		if(v==0x31)  // 0ne
		{
			led=0;
			pwm_width = pwm_width + 1;
			//SBUF=0x33; 
			//TI=0;
			//while(TI==0);
		}
		if(v==0x32) // two
		{
				//IT1 = 1;   // Configure interrupt 1
				//EX1 = 1;   // Enable EX1 Interrupt
				//msdelay();	
				//IT1 = 0;   // Configure interrupt 1
				//EX1 = 0;   // Enable EX1 Interrupt
			//led=0;						    // give indication
			//TR1=1;						    // start timer 1
			//delay();					    // give 1 sec delay
			//TR1=0;							// stop timer
			//led=1;	
		  //tmp1 = (TL1 & 0x0F);  			 // get lower nibble of TL0
		  //tmp2 = TL1 >> 4; 				 // get upper nibble of TL0
		  //tmp2 = tmp2*16;					 // multiply upper nibble with 16
		  //t = tmp1+tmp2;				     // get decimal number
		  //t=t*60;						     // multiply it with 60
			//t = 6789;

		}
		flag=1;
		RI=0;
		/*i= (pwm_width - 40) * 10 + 100 ;
		j=i%10;
    k=i/10;
    l=i/100;
    k=k-l*10;

		send(l);
		send(k);
		send(j);
		send('#');
	*/
		
		return;
	}

}
 void display(int speed)						 // convert hex to desimal and 
  {									 // decimal to ascii
		unsigned int tmp1,tmp2,t,t1,i;
		unsigned char asci[4];	
		//tmp1 = (TL1 & 0x0F);  			 // get lower nibble of TL0
		//tmp2 = TL1 >> 4; 				 // get upper nibble of TL0
		//tmp2 = tmp2*16;					 // multiply upper nibble with 16
		//t = tmp1+tmp2;				     // get decimal number
		//t=t*60;						     // multiply it with 60
		t = speed;
		i=3;
		if(t >= 9999)
		{
			t=9999;
		}
		if(t>=1000)						 // if more then 4 digits
	  {
			while(t>10)
		  {		
				t1=t%10;
				asci[i]=t1+0x30;		 // convert them one by one 
				t=t/10;					 // into ASCII
				i--;
		  }
			asci[0]=t+0x30;
	  }
		else	  						 // otherwise convert
	  {
			while(t>10)
		  {		
				t1=t%10;
				asci[i]=t1+0x30;	    // last three digits
				t=t/10;
				i--;
		  }
			asci[1]=t+0x30;
			asci[0]=0x30;			   // and put first digit as 0
	  }
			send('x');
		  msdelay(7);
      send((unsigned char)asci[0]);
		  msdelay(5);
			send((unsigned char)asci[1]);
		  msdelay(5);
			send((unsigned char)asci[2]);
		  msdelay(5);
			send((unsigned char)asci[3]);
		  msdelay(5);
  }

void main()
{
	
	TMOD=0X20;
	SCON=0X50;
	IE=0X90;
	//IE=0XFF;
	TH1=0XFD;
	TR1=1;
	led=1;
	msdelay(500);
	led=0;
	msdelay(500);
	led=1;
	pwm_setup();
	encoder = 1;
	flag=0;
	//send('y');
  //ET1 = 1;
	//TR1 = 1;
	while(1)
	{
		
		//EX1 = 1;
		//while(flag==0);			  // remain withine loop till rpm flag is clear
		if (flag == 1)
		{
			//i= (pwm_width - minspeed) * 10 + 100 ;
			i= pwm_width; 
			//i= pwm_width;
		  display(i * 10);	
	    flag=0;
		}
		//display(i);	
	  //delay();					    // give 1 sec delay		
	  //IE=0X90;

		if(cmd ==0)
			cmd=0;
		/*
		i= (pwm_width - 40) * 10 + 100 ;
		j=i%10;
    k=i/10;
    l=i/100;
    k=k-l*10;

		send(l);
		send(k);
		send(j);
		send('z');*/
		//msdelay(200);
		/*if(cmd==0)
		{
			SBUF=0X31; 
			TI=0;
			while(TI==0);
			//led=1;
			while(cmd==0);
		}
		if(cmd==1)
		{
			SBUF=0X30;
			TI=0;
			while(TI==0);
			//led=0;
			while(cmd==1);
		}*/
	}
}