#include<reg51.h>
#define on 0
#define off 1
#define reset 1
int scan=2;

//for first segment
int count_1=0;
int runtime_1 = 30;
sbit R1 = P2^0;
sbit Y1 = P2^1;
sbit G1 = P2^2;
sbit SS_CLK_1 = P2^3;
sbit SS_RST_1 = P2^4;
sbit module1_1 = P0^0;

//for second segment
int count_2=0;
int runtime_2 = 30;
sbit R2 = P3^0;
sbit Y2 = P3^1;
sbit G2 = P3^2;
sbit SS_CLK_2 = P3^4;
sbit SS_RST_2 = P3^3;
sbit module2_1 = P0^1;



void msDelay(unsigned int x)
{
     unsigned int i,j;
     for(i=0;i<x;i++)
     for(j=0;j<775;j++);
}

void ss_reset(int d)
{
  switch(d)
  {
      case 1:
			 SS_RST_1=1;
			 msDelay(50);
			 SS_RST_1=0;
			 msDelay(50);
			break;
    case 2:
			 SS_RST_2=1;
			 msDelay(50);
			 SS_RST_2=0;
			 msDelay(50);
		break;
		
		case 3:
			
		
		break;
		
		case 4:
			
		
		break;


  }  	
	
	
}


void clock(int d)
{
	switch(d)
	{
		case 1:
			 count_1++;
			 SS_CLK_1=1;
			 msDelay(50);
			 SS_CLK_1=0;
			 msDelay(50);
		break;
		case 2:
			 count_2++;
			 SS_CLK_2=1;
			 msDelay(50);
			 SS_CLK_2=0;
			 msDelay(50);
		
		break;
		
		case 3:
			
		
		break;
		
		case 4:
			
		
		break;
		
		
		
		
	}
	
}
void main()
{
P2=0x00;
P0=0xFF;
	R1=off;
	Y1=off;
	G1=off;
	R2=off;
	Y2=off;
	G2=off;
	R1=on;
	R2=on;
    while(1)
     { 
			 
			 switch(scan)
			 {
				 case 1:
						// scan first segment
				    if(count_1 == 0)
						{
							if( module1_1 == 1)
							{
								runtime_1=60;
							}
							else
							{
								runtime_1=30;
							}
					  }
			      R1=off;
						G1=on;
						clock(1);
						if(count_1 >= runtime_1)
						{
							count_1=0;
							ss_reset(1);
							scan=2;
							G1=off;
							Y1=on;
							msDelay(3000);
							Y1=off;
							R1=on;
						}
				 break;
					case 2:
						// scan second segment
						if(count_2 == 0)
						{
							if( module2_1 == 1)
							{
								runtime_2=60;
							}
							else
							{
								runtime_2=30;
							}
						}
			      R2=off;
						G2=on;
						clock(2);
						if(count_2 >= runtime_2)
						{
							count_2=0;
							ss_reset(2);
							scan=1;
							G2=off;
							Y2=on;
							msDelay(3000);
							Y2=off;
							R2=on;
						}
				 break;
			}
			 
			
     }
}
 