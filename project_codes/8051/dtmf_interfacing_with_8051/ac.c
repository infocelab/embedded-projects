#include<reg52.h>	
#include<lcd.h>
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

//INPUT PIN
sbit INPUT1 = P1^0;
sbit INPUT2 = P1^1;
sbit INPUT3 = P1^2;
sbit INPUT4 = P1^3;

//OUTPUT PIN
sbit OUTPUT1 = P3^3;
sbit OUTPUT2 = P3^4;
sbit OUTPUT3 = P3^5;
sbit OUTPUT4 = P3^6;
sbit OUTPUT5 = P3^7;

int s1 =1;
int s2 =1;
int s3 =1;
int s4 =1;

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
   

 void main()
{
	  int i;
	  P1 = 0xFF; //Por1 used as a Input Port
	  Delay(10);
	  P3 = 0x00;  //Por1 used as a Output Port
	  Delay(10);
	  Lcd8_init();
	  Lcd8_Set_Cursor(1,1);
	  Lcd8_Write_String("DTMF Based");
		Delay(1000);
		Lcd8_Set_Cursor(2,1);
		Lcd8_Write_String("Appliance Cntrl");
		Delay(500);
	 	
		while(1)
	{
		if(INPUT1==0 && INPUT2==1 && INPUT3==1 && INPUT4==1)  // 1 - on
    {

       OUTPUT4 = 1;
			 Delay(100);
			 OUTPUT1 = 0;
			 OUTPUT2 = 0;
			 OUTPUT3 = 0;
			 OUTPUT5 = 0;
		   Delay(100);
		   Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Appliance Bulb"); 
			 Delay(100);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("ON");
			 s1=0;

		}
		else if(INPUT1==1 && INPUT2==0 && INPUT3==1 && INPUT4==1) // 2 - off
    {
			
       OUTPUT4 = 0;
			 Delay(100);
			 OUTPUT1 = 0;
			 OUTPUT2 = 0;
			 OUTPUT3 = 0;
			 OUTPUT5 = 0;
		   Delay(100);
		   Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Appliance Bulb"); 
			 Delay(100);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("OFF");
			 Delay(100);
        s1=1;
      }
			 Delay(500);
    }
	}

  	
 /* while(1)
  {                                   
    Lcd8_Set_Cursor(1,1);
	  Lcd8_Write_String("DTMF Based");
		Delay(1000);
		Lcd8_Set_Cursor(2,1);
		Lcd8_Write_String("Appliance Cntrl");
		Delay(1000);
		if(INPUT1==0 && INPUT2==1 && INPUT3==1 && INPUT4==1)
		{
			 OUTPUT4 = 1;
			  Delay(100);
			 OUTPUT1 = 0;
			 OUTPUT2 = 0;
			 OUTPUT3 = 0;
			 OUTPUT5 = 0;
		   Delay(2000);
		   Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Appliance Bulb"); 
			 Delay(1000);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("ON");
			 Delay(1000);
			 

			}	
			if(INPUT1 == 0 && INPUT2==0 && INPUT3==1 && INPUT4==1 )
			{
				   pwm_width--;
				 //pwm_width++;
			  if(pwm_width >= 30)
			  pwm_width=0;
				  OUTPUT4 = 0;
			   // OUTPUT1 = 0;
			    OUTPUT2 = 0;
			    OUTPUT3 = 0;
			    OUTPUT5 = 0;
		      Delay(2000);
			}
	  else if(INPUT1==0 && INPUT2==0 && INPUT3==1 && INPUT4==1)
		  {
			  OUTPUT4 = 1;
			  Delay(100);
				OUTPUT3 = 0;
			  OUTPUT1 = 0;
			  OUTPUT2 = 0;
				OUTPUT5 =0;
				 Delay(100);
			 Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Appliance Two"); 
			 Delay(1000);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("ON");
			 Delay(1000);
			 
			}
			else if(INPUT3==0 && INPUT1==1 && INPUT2==1 && INPUT4==1)
			{
			 OUTPUT5 = 1;
			 Delay(100);
			 OUTPUT3 =0;
			 OUTPUT1 = 0;
			 OUTPUT2 = 0;
			 OUTPUT4 = 0;
			 Delay(100);
			 Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Appliance Three"); 
			 Delay(1000);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("ON");
			 Delay(1000);
			
			}
			 else if(INPUT2==0 && INPUT3==0 && INPUT1==1 && INPUT4==1)
			{
			 OUTPUT1= 0;
			 Delay(1000);
			 OUTPUT2 = 1;
			 Delay(10);
			 OUTPUT3 = 0;
			 OUTPUT4 = 0;
			 OUTPUT5 = 0;
			 Delay(100);
			 Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Motor On"); 
			 Delay(1000);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("Left");
			 Delay(1000);
			}
			
			else if(INPUT1==0 && INPUT3==0 && INPUT2==1 && INPUT4==1)  // for motor
			{
				pwm_setup();
				 pwm_width--;
				if(pwm_width <= 0)
				pwm_width=255;
			 Delay(100);
			 OUTPUT2 = 0;
				Delay(10);
			  OUTPUT3 =0;
				Delay(10);
			  OUTPUT5 = 0;
			  OUTPUT4 = 0;
			 Delay(100);
			 Lcd8_Clear();	
       Lcd8_Set_Cursor(1,1);
	     Lcd8_Write_String("Motor On"); 
			 Delay(1000);
		   Lcd8_Set_Cursor(2,1);
		   Lcd8_Write_String("Right");
			 Delay(1000);
			}
		}
			
  }*/
