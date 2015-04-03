#include<reg51.h>
#define on 0
#define off 1
#define reset 1
int scan=1;

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

// for third segment
int count_3=0;
int runtime_3 = 30;
sbit R3 = P2^5;
sbit Y3 = P2^6;
sbit G3 = P2^7;
sbit SS_CLK_3 = P3^7;
sbit SS_RST_3 = P3^6;
sbit module3_1 = P0^2;

// for fourth segment
int count_4=0;
int runtime_4 = 30;
sbit R4 = P1^0;
sbit Y4 = P1^1;
sbit G4 = P1^2;
sbit SS_CLK_4 = P1^4;
sbit SS_RST_4 = P1^3;
sbit module4_1 = P0^3;


void msDelay(unsigned int x)
{
     unsigned int i,j;
     for(i=0;i<x;i++)
     for(j=0;j<775;j++);
}

void ss_reset(int d)
{
	int delay = 30;
  switch(d)
  {
		case 0: // reset all
			 SS_RST_1=1;
			 SS_RST_2=1;
			 SS_RST_3=1;
			 SS_RST_4=1;
			 msDelay(delay);
			 SS_RST_1=0;
			 SS_RST_2=0;
			 SS_RST_3=0;
			 SS_RST_4=0;
			 msDelay(delay);
			 count_1=0;
			 count_2=0;
			 count_3=0;
			 count_4=0;
		break;
      case 1:
			 SS_RST_1=1;
			 msDelay(delay);
			 SS_RST_1=0;
			 msDelay(delay);
			break;
			
    case 2:
			 SS_RST_2=1;
			 msDelay(delay);
			 SS_RST_2=0;
			 msDelay(delay);
		break;
		
		case 3:
			 SS_RST_3=1;
			 msDelay(delay);
			 SS_RST_3=0;
			 msDelay(delay);
		break;
		
		case 4:
			 SS_RST_4=1;
			 msDelay(delay);
			 SS_RST_4=0;
			 msDelay(delay);
		break;

  }  	
}


void clock(int d)
{
	int delay = 20;
	switch(d)
	{
		case 1:
			 count_1++;
			 SS_CLK_1=1;
			 msDelay(delay);
			 SS_CLK_1=0;
			 msDelay(delay);
		break;
		case 2:
			 count_2++;
			 SS_CLK_2=1;
			 msDelay(delay);
			 SS_CLK_2=0;
			 msDelay(delay);
		
		break;
		
		case 3:
			 count_3++;
			 SS_CLK_3=1;
			 msDelay(delay);
			 SS_CLK_3=0;
			 msDelay(delay);
		break;
		
		case 4:
			 count_4++;
			 SS_CLK_4=1;
			 msDelay(delay);
			 SS_CLK_4=0;
			 msDelay(delay);
		break;
	}
	
}
void main()
{
P2=0x00;
P1=0x00;
P0=0xFF;
	R1=off;
	Y1=off;
	G1=off;
	R2=off;
	Y2=off;
	G2=off;
	R3=off;
	Y3=off;
	G3=off;
	R4=off;
	Y4=off;
	G4=off;

	R1=on;
	R2=on;
	R3=on;
	R4=on;

ss_reset(0);

	while(1)
     { 				
			 clock(1);
			 clock(2);
			 clock(3);
			 clock(4);
			 
			 switch(scan)
			 {
				 case 1:
						// scan first segment
				    if(count_1 <= 3)
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
						if(count_1 >= runtime_1)
						{
		     			G1=off;
							Y1=on;
							msDelay(3000);
							Y1=off;
							ss_reset(0);
							scan=2;
							R1=on;
						}
				 break;
					case 2:
							// scan second segment
				    if(count_2 <= 3)
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
						if(count_2 >= runtime_2)
						{
		     			G2=off;
							Y2=on;
							msDelay(3000);
							Y2=off;
							ss_reset(0);
							scan=3;
							R2=on;
						}
				 break;
							case 3:
							// scan third segment
				    if(count_3 <= 3)
						{
							if( module3_1 == 1)
							{
								runtime_3=60;
							}
							else
							{
								runtime_3=30;
							}
					  }
			      R3=off;
						G3=on;
						if(count_3 >= runtime_3)
						{
		     			G3=off;
							Y3=on;
							msDelay(3000);
							Y3=off;
							ss_reset(0);
							scan=4;
							R3=on;
						}
				 break;
								case 4:
							// scan fourth segment
				    if(count_4 <= 3)
						{
							if( module4_1 == 1)
							{
								runtime_4=60;
							}
							else
							{
								runtime_4=30;
							}
					  }
			      R4=off;
						G4=on;
						if(count_4 >= runtime_4)
						{
					    G4=off;
							Y4=on;
							msDelay(3000);
							Y4=off;
							ss_reset(0);
							scan=1;
							R4=on;
						}
				 break;
				}
     }
}
 