#include<reg52.h>							 //including sfr registers for ports of the controller
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
sbit soil_sensor = P0^3;
sbit motor_pin_1 = P3^0;
sbit motor_pin_2 = P3^1;

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
void main()
{
		int i;
	P0 = 0xFF;
	P3 = 0x00;

	Lcd8_init();                                  
    Lcd8_Set_Cursor(1,1);
	  Lcd8_Write_String("Solar Based");
		Lcd8_Set_Cursor(2,1);
	  Lcd8_Write_String("Irrigation Sys");
		for(i=0;i<15;i++)
		{
		  Delay(1000);
			Lcd8_Shift_Left();
		}
		for(i=0;i<15;i++)
		{
			Delay(1000);
			Lcd8_Shift_Right();
		}
		Delay(3000);
	
   while(1)
  {                                   
  	if(soil_sensor == 0xFF)
		{
	  Lcd8_Set_Cursor(1,1);
	  Lcd8_Write_String("Wet Condition");
		Lcd8_Set_Cursor(2,1);
	  Lcd8_Write_String("Motor Off");
		motor_pin_1 = 1;
    motor_pin_2 = 1; //Rotates Motor Anit Clockwise
    Delay(1000);
		}
	  if(soil_sensor == 0x00)
		{
		Lcd8_Set_Cursor(1,1);
	  Lcd8_Write_String("Dry Condition");
		Lcd8_Set_Cursor(2,1);
	  Lcd8_Write_String("Motor On");
		motor_pin_1 = 1;
    motor_pin_2 = 0; //Stops Motor
    Delay(1000);
	
		}

		 Delay(2000);
  }
}




