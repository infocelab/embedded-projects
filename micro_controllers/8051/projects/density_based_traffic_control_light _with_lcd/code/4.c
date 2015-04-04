#include<reg52.h>							 //including sfr registers for ports of the controller
#include<lcd.h>

#define on 0
#define off 1
int scan=1;

//LCD Module Connections
sbit RS = P0^0;                                                                   
sbit EN = P0^1;                            
sbit D0 = P2^0;
sbit D1 = P2^1;
sbit D2 = P2^2;
sbit D3 = P2^3;
sbit D4 = P2^4;
sbit D5 = P2^5;
sbit D6 = P2^6;
sbit D7 = P2^7;

//for first segment
int count_1=0;
int runtime_1 = 15;
sbit R1 = P1^7;
sbit G1 = P1^6;
sbit module1_1 = P3^6;
sbit module1_2 = P3^7;

//for second segment
int count_2=0;
int runtime_2 = 15;
sbit R2 = P1^5;
sbit G2 = P1^4;
sbit module2_1 = P3^5;
sbit module2_2 = P3^4;

//for third segment
int count_3=0;
int runtime_3 = 15;
sbit R3 = P1^3;
sbit G3 = P1^2;
sbit module3_1 = P3^1;
sbit module3_2 = P3^0;

//for fourth segment
int count_4=0;
int runtime_4 = 15;
sbit R4 = P1^0;
sbit G4 = P1^1;
sbit module4_1 = P3^2;
sbit module4_2 = P3^3;


// 
//End LCD Module Connections
void Delay(int a)
{
    int j;
    int i;
    for(i=0;i<a;i++)
    {
        for(j=0;j<100;j++)
        {
        }
    }
}

char toChar(int a)
{
switch(a)
	{
		case 1:
		return '1';
		break;
		case 2:
		return '2';
		break;
		case 3:
		return '3';
		break;
		case 4:
		return '4';
		break;
		case 5:
		return '5';
		break;
		case 6:
		return '6';
		break;
		case 7:
		return '7';
		break;
		case 8:
		return '8';
		break;
		case 9:
		return '9';
		break;
		case 0:
		return '0';
		break;
		
	}

}

void main()
{
	int i,j,k,l;
	char c;
	Lcd8_init();                                  
	Lcd8_Set_Cursor(1,1);
	Lcd8_Write_String("Traffic Light");
	Lcd8_Set_Cursor(2,1);
	Lcd8_Write_String("Control");
	R1=off;
	G1=off;
	R2=off;
	G2=off;
	Delay(100);
	R3=off;
	G3=off;
	R4=off;
	G4=off;
	Delay(100);
	
	R1=on;
	R2=on;
	R3=on;
	R4=on;
	Delay(100);
	G1=off;
	G2=off;
	G3=off;
	G4=off;
	Delay(100);
	
  while(1)
  {

			 switch(scan)
			 {
				 case 1:
						// scan first segment
				    if(count_1 <= 3)
						{
							if( module1_1 == 1)
							{
								runtime_1=30;
							}
							if(module1_2 == 1)
							{
								runtime_1=60;
							}
					  }
			      R1=off;
						G1=on;
						count_1++;
						Lcd8_Clear();
							
						i=count_1;
						j=i%10;
						k=i/10;
						l=i/100;
						k=k-l*10;
						Lcd8_Set_Cursor(1,3);
						c=toChar(j);
						Lcd8_Write_Char(c);
		
						Lcd8_Set_Cursor(1,2);
						c=toChar(k);
						Lcd8_Write_Char(c);
      
						Lcd8_Set_Cursor(2,1);
						c=toChar(l);
						Lcd8_Write_Char(c);
				
						if(runtime_1 == 60)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg1:60 Secs");
						}
						else if(runtime_1 == 30)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg1:30 Secs");
						}
						else
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg1:15 Secs");
						}
				
						if(count_1 >= runtime_1)
						{
		     			G1=off;
							count_1=0;
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
								runtime_2=30;
							}
							if(module2_2 == 1)
							{
								runtime_2=60;
							}
					  }
			      R2=off;
						G2=on;
						count_2++;
						Lcd8_Clear();
										
						i=count_2;
						j=i%10;
						k=i/10;
						l=i/100;
						k=k-l*10;
						Lcd8_Set_Cursor(1,3);
						c=toChar(j);
						Lcd8_Write_Char(c);
		
						Lcd8_Set_Cursor(1,2);
						c=toChar(k);
						Lcd8_Write_Char(c);
      
						Lcd8_Set_Cursor(2,1);
						c=toChar(l);
						Lcd8_Write_Char(c);
		
		
						if(runtime_2 == 60)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg2:60 Secs");
						}
						else if(runtime_2 == 30)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg2:30 Secs");
						}
						else
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg2:15 Secs");
						}
				
						if(count_2 >= runtime_2)
						{
		     			G2=off;
							count_2=0;
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
								runtime_3=30;
							}
							if(module3_2 == 1)
							{
								runtime_3=60;
							}
					  }
			      R3=off;
						G3=on;
						count_3++;
						Lcd8_Clear();
		      
		  			i=count_3;
						j=i%10;
						k=i/10;
						l=i/100;
						k=k-l*10;
						Lcd8_Set_Cursor(1,3);
						c=toChar(j);
						Lcd8_Write_Char(c);
		
						Lcd8_Set_Cursor(1,2);
						c=toChar(k);
						Lcd8_Write_Char(c);
      
						Lcd8_Set_Cursor(2,1);
						c=toChar(l);
						Lcd8_Write_Char(c);
		
						
						if(runtime_3 == 60)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg3:60 Secs");
						}
						else if(runtime_3 == 30)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg3:30 Secs");
						}
						else
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg3:15 Secs");
						}
						
						if(count_3 >= runtime_3)
						{
		     			G3=off;
							count_3=0;
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
								runtime_4=30;
							}
							if(module4_2 == 1)
							{
								runtime_4=60;
							}
					  }
			      R4=off;
						G4=on;
						count_4++;
						Lcd8_Clear();
						
						i=count_4;
						j=i%10;
						k=i/10;
						l=i/100;
						k=k-l*10;
						Lcd8_Set_Cursor(1,3);
						c=toChar(j);
						Lcd8_Write_Char(c);
		
						Lcd8_Set_Cursor(1,2);
						c=toChar(k);
						Lcd8_Write_Char(c);
      
						Lcd8_Set_Cursor(2,1);
						c=toChar(l);
						Lcd8_Write_Char(c);
		
						if(runtime_4 == 60)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg4:60 Secs");
						}
						else if(runtime_4 == 30)
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg4:30 Secs");
						}
						else
						{	
						Lcd8_Set_Cursor(2,1);
						Lcd8_Write_String("Seg4:15 Secs");
						}
						
						if(count_4 >= runtime_4)
						{
		     			G4=off;
							count_4=0;
							scan=1;
							R4=on;
						}
				 break;
				}
		Delay(700);
  }
}




