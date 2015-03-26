#include<reg51.h>
#include <string.h>
sbit rs = P3^1;					// rs pin of LCD
sbit en = P3^0;					// en pin of LCD
sbit rw = P3^2;					// rw pin of LCD
sbit b = P0^7;					// busy flag 
sbit led1=P2^0;					// run indicator
sbit led2=P2^1;					// stop indicator
sbit led3=P2^2;					// clockwise direction indicator
sbit led4=P2^3;					// anticlockwise direction indicator
sbit PWM=P2^4;					// PWM output
sbit RL1=P2^5;					// relay 1 pin
sbit RL2=P2^6;					// relay 2 pin

unsigned int x=10;				// ontime 
unsigned int y=10;				// offtime
unsigned int m=0;				// mode
unsigned int d=0;				// direction
unsigned int t=100;				// time
unsigned int r=0;				// run flag

void start(void);				// function initilization
void mode(void);
void direction(void);
void incspeed(void);
void decspeed(void);
void inctime(void);
void dectime(void);
void time(unsigned int);
void delay(unsigned int);
void keydly(void);
void busy(void);

void writecmd(unsigned char a)		// send command to LCD
  {
	busy();							// check busy flag
	rs = 0;							// select command register
	rw = 0;							// write enable
	P0 = a;							// send byte to LCD
	en = 1;							// apply strobe pulse
	en = 0;
  }
void writedata(unsigned char b)		// send data to LCD
  {
	busy();							// check busy flag
	rs = 1;							// select data register
	rw = 0;							// write enable
	P0 = b;							// write enable	
	en = 1;							// send byte to LCD
	en = 0;							// apply strobe pulse						
  }
void busy()							// check busy flag of LCD
  {
	en = 0;							// disable display
	P0 = 0xFF;						// P0 as input
	rs = 0;							// select command register
	rw = 1;							// read enable
	while(b==1)						// if busy bit is 1
	{
	 en=0;							// remain withine loop
	 en=1;
	}
	en=0;							
  }
void writestr(unsigned char *s)		// send string message to LCD
 {
	unsigned char l,i;
	l = strlen(s);					// get length of string
	for(i=0;i<l;i++)				 
	{
		writedata(*s);				// till the length of string 
		s++;						// send characters one by one
	}
 }
void start()						// start rotating motor
  {
  	if(m==0)						// for m=0 start continuous mode
	  {
	  	RL1=0;						// switch on RL1
		r=1;						// set run flag
	  	P1=0xFF;					// send all 1's to P1
		while(P1==0xFF)				// till no key is pressed
	  	  {
			led1=1;					// indication on run LED
			PWM=1;					// send high logic to PWM pin
			delay(x);				// on time delay
			PWM=0;					// now send low logic to PWM
			delay(y);				// off time delay
	  	  }
		}
		else if(m==1)				// for m=1 start reversible mode
		  {
		  	r=1;					// set run flag
			P1=0xFF;				// send all 1's to P1
			while(P1==0xFF)			// till no key is pressed
			  {
			  	
				led1=1;				// run LED=1
				led3=1;
				led4=0;
				PWM=1;				// send high on PWM pin
				RL2=1;				// select one direction
				RL1=0;			  	// switch on RL1
				time(t);			// wait for desired time
				RL1=1;				// switch off RL1
				led1=0;				// run LED=0;
				time(20);			// wait for 1 sec
				led1=1;				// again run LED=1
				led3=0;
				led4=1;
				RL2=0;				// select other direction
				RL1=0;				// switch on RL1			
				time(t);			// wait for desire time
				RL1=1;				// switch off RL1
				led1=0;				// run LED=0
				time(20);			// wait for 1 sec
			   }
			 	PWM=0;
			   
			}
		  else if(m==2)				// for m=2 start jogging mode
		    {
				r=1;				       // reset run flag
				P1=0xFF;				   // send all 1's to P1
			while(P1==0xFF)			// till no key is pressed
			  {
			  	led1=1;	
				PWM=1;				  // send high on PWM pin
				RL1=0;				  // switch on RL1
				time(t);			  // wait for 1 sec
				RL1=1;				  // switch off RL1
				PWM=0;				  // send low on PWM pin 
				led1=0;	
				time(20);
			  }	
			  
			} 
  }
void direction()					// alter the direction
  {
	keydly();						// key debounce delay
	d++;							// increment count
	if((d%2)==0)					// check for even or odd
	  {
		led3=1;						// indicate on LEDs
		led4=0;
		RL2=1;						// switch ON / OFF RL2
	  }
	else
	  {
		led3=0;
		led4=1;
		RL2=0;
	  }
  }
 void mode()								// change mode of rotation
   {
   	keydly();								// key debounce delay
	writecmd(0x80);							// display message on first line first column
	m++;									// increment count	
	if(m==3) m=0;							// if it is 3 reset it
	if(m==0)
	  { writestr("mode:continuous ");	// otherwise display mode
	  time(15);
	  }
	else if(m==1) 
    {writestr("mode:reversible ");
	   time(15);
	}
	else if(m==2) 
	{writestr("mode:jogging    "); 
	time(15); 	
   }
   }
 void decspeed()									// increase speed 
   {
   		int z;   		
		keydly();									// key debounce
		writecmd(0xC0);								// select second line on LCD
		if(y<14) 									// if not max pulse width
	  	  {
		  	x--;
	  		y++;									// increase it convert it in to			  	  	
			z=y-5+0x30;								// 1 to 10 scale and ASCII
			writestr("speed: ");					// diaplay speed on LCD
			writedata(z);
			writestr("       ");
		  }
		  else if(y==14) writestr("min speed: 9  ");	// if max width display message	
	}
void incspeed()											// increase speed 
   {
   		int w; 
		keydly();  	
		writecmd(0xC0);									// key debounce								
		if(y>6) 										// if not minimum width
	  	  {
		  	x++;
	  		y-- ;										// decrease it				  
			w=y-5+0x30;									// do same as above		
			writestr("speed: ");
			writedata(w);
			writestr("       ");
		  }
		 else if(y==6) writestr("max speed: 1  ");		// if min width display message	  	  
	}
void inctime()											// increase time 
  {
  	int p;  	
	keydly();											// key debounce delay
	writecmd(0xC0);										
	if(t<180)											// if not max time 
	  {
		t+=20;											// increase it by 1 sec		
		p=t/20;
		p=p+0x30;										// convert it in to ASCII		
		writestr("time: ");								// display it
		writedata(p);
		writestr(" sec    ");
	  }
	else if(t==180) writestr("max time: 9 sec");		// if max time display message	 
  }
void dectime()											// decrease time
  {
  	int q;  				
	keydly();											// key debounce delay
	writecmd(0xC0);
	if(t>20) 											// if not min time 
	  {
		t-=20;											// decrease it		  
	 	q=t/20;
	 	q=q+0x30;										// do same as above 	
	 	writestr("time:");
	 	writedata(q);
	 	writestr("sec");
	  }
	else if(t==20) writestr("min time: 1 sec");			// if min time display message	 
  }
void keydly()						// key debounce delay
  {
	int a,b;
	for(a=0;a<50;a++)
	  for(b=0;b<1000;b++);
  }
void time(unsigned int c)			// change time in seconds
 {
	int k;
	TL1 = 0xAF;						// use timer 1
	TH1 = 0x3C;						// to generate 50 ms delay
	TR1 = 1;						  // start timer
	for(k=0;k<=c;k++)				// rotate loop in multiples of 20
	  {
		while(TF1==0);				// wait till timer overflow
		TF1 = 0;					 // reset the flag
		TL1 = 0xAF;					// reload it
		TH1 = 0x3C;
	  }
	TR1 = 0;						 // stop timer
  }
void delay(unsigned int c1)			// change time in micro seconds
 {
	int a;
	TH0=0x9B;						// select timer 0 
	TL0=0x9B;						// to generate 100 micro second delay
	TR0=1;							// start timer							
	for(a=0;a<c1;a++)				// rotate loop between 5 to 15
	  {
		while(TF0==0);				// wait until timer overflow
		TF0=0;						// reset the flag
	  }
	TR0=0;							// stop timer 
  }

void main()
  {
	TMOD=0x12;						// timer1 in 16 bit timer, timer 0 in 8 bit auto reload mode 
	P2=0xC0;						 // LEDs off, relays OFF
	P0=0x00;						 // P0, P3 output ports
	P3=0x00;
	writecmd(0x3C);					// initilize LCD
	writecmd(0x0E); 
	writecmd(0x01); 
	writecmd(0x84);					// display message
    writestr("DC Motor");			// DC motor controller in
	writecmd(0xC3);					// center of LCD
	writestr("Controller");	
agin:P1=0xFF;						  // P1 as input port
	while(P1==0xFF);				// wait until any key press
loop:switch(P1)
	  {
		case 0xFE:					 // for first key 
			keydly();				   // key debounce
			writecmd(0x01); 
			writestr("motor start");
			time(50);						// wait for 2.5 sec
			writecmd(0x80);	
    	writestr("mode:continuous ");	// display current mode and speed
			writecmd(0xC0);
			writestr("speed: 5       ");	
			led1=1;					// Run LED ON
			led2=0;					// stop LED OFF
			led3=1;					// clockwise direction ON
			led4=0;					// anticlockwise direction OFF
			start();				// sart rotating motor
			break;
		case 0xFD:					 // for second key
			keydly();				  // key debounce
			r=0;					   // run flag reset
			writecmd(0x01);			
			writestr("motor stoped");	// display message
			led1=0;					// Run OFF
			led2=1;					// stop LED ON
			led3=0;					// clockwise direction OFF
			led4=0;					// anticlockwise direction OFF
			RL1=0;				  // switch off RL1
			PWM=0;				  // send low on PWM pin 
			time(2);
			break;
		case 0xFB:					// for third key
      keydly();			  // key debounce
			writecmd(0x01);			
			writestr("key 3");	// display message
			time(1);
			mode();					// select mode					
			if(r==1) start();		// jump to start if run flag is set
			break;
		case 0xF7:					// for fourth key		
			direction();			// change direction			
			if(r==1) start();		// jump to start if run flag is set
			break;
		case 0xEF:					// for fifth key			
			incspeed();				// increase speed
			if(r==1) start();		// jump to start if run flag is set
			break;
		case 0xDF:					// for sixth key			
			decspeed();				// decrease speed		
			if(r==1) start();		// jump to start if run flag is set
			break;
		case 0xBF:					// for seventh key		
			inctime();				// increase time
			if(r==1) start();		// jump to start if run flag is set
			break;
		case 0x7F:					// for eigth key		
			dectime();				// decrease time			
			if(r==1) start();		// jump to start if run flag is set
			break;
	   }
	if(r==1) goto loop;				// if run flag is set jump of key detect
	else goto agin;					// if not jump to again
  }
			
