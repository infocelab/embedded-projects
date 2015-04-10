#include<reg51.h>
#include<lcd.h>
sbit led1 = P3^1;
sbit led2 = P3^2;
sbit led3 = P3^3;
sbit led4 = P3^4;

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


char seats[4]={'0','0','0','0'};
char card_id[12];

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

   void recieve()     //Function to recieve data serialy from RS232 
   {
    unsigned char k;
     for(k=0;k<12;k++)
     { 
       while(RI==0); 
       card_id[k] = SBUF;
			   RI=0;
     }
  }

    void main()
    { 
			int l;
			led1=0;
			led2=0;
			led3=0;
			led4=0;
			Delay(1000);
	    led1=1;
			led2=1;
			led3=1;
			led4=1;
			

		  TMOD=0x20;            //Enable Timer 1
      TH1=0XFD;
      SCON=0x50;
      TR1=1; 
	    Lcd8_init();
		  Lcd8_Set_Cursor(1,1);
	    Lcd8_Write_String("Welcome 2 Smart");
	    Delay(1000);
	    Lcd8_Set_Cursor(2,1);
      Lcd8_Write_String("Travelling");
	    Delay(1000);
	    Lcd8_Clear();
			Lcd8_Set_Cursor(1,1);
	    Lcd8_Write_String("PLZ Show Your");
	    Lcd8_Set_Cursor(2,1);
      Lcd8_Write_String("Card");
	
    while(1)
    {
         recieve(); 
				 if((card_id[0] == '1' && card_id[1] == '3' && card_id[2] == '0' && card_id[3] == '0' && card_id[4] == '4' && card_id[5] == 'A' && card_id[6] == '7' && card_id[7] == 'A' && card_id[8] == '5'  && card_id[9] == '2' && card_id[10] == '7' && card_id[11] == '1')
					 ||
				 (card_id[0] == '1' && card_id[1] == '3' && card_id[2] == '0' && card_id[3] == '0' && card_id[4] == '4' && card_id[5] == '9' && card_id[6] == 'C' && card_id[7] == 'F' && card_id[8] == '1'  && card_id[9] == '6' && card_id[10] == '8' && card_id[11] == '3')
				 )
				 {
					  Lcd8_Clear();
						Lcd8_Set_Cursor(1,1);
						Lcd8_Write_String("Valid User");
					  Delay(1000);
					  if(seats[0] == '0')
						{
							seats[0]='1';
							Lcd8_Set_Cursor(2,1);
						  Lcd8_Write_String("Seat No: 1");
							led1=0;
							Delay(2000);
						}
						else if(seats[1] == '0')
						{
							seats[1]='1'; 
							Lcd8_Set_Cursor(2,1);
						  Lcd8_Write_String("Seat No: 2");	
							led2=0;
              Delay(2000);							
						}
						else if(seats[2] == '0')
						{
							seats[2]='1';
							Lcd8_Set_Cursor(2,1);
						  Lcd8_Write_String("Seat No: 3");
							led3=0;
							Delay(2000);
						}
						else if(seats[3] == '0')
						{
							seats[3]='1';
							Lcd8_Set_Cursor(2,1);
						  Lcd8_Write_String("Seat No: 4");
							led4=0;
							Delay(2000);
						}
						else
						{
							Lcd8_Clear();
							Lcd8_Set_Cursor(1,1);
						  Lcd8_Write_String("Sorry: ");
							Lcd8_Set_Cursor(2,1);
						  Lcd8_Write_String("No Seats ");
							Delay(2000);
						}
				 }
			else 
				{
				  Lcd8_Clear();
				  Lcd8_Set_Cursor(1,1);
	        Lcd8_Write_String("Invalid User");
          Lcd8_Set_Cursor(2,1);
					Lcd8_Write_String("Try Again");
					Delay(2000);
						
				 }
				 
				 Lcd8_Clear();
	       Lcd8_Write_String("PLZ Show Your");
	       Lcd8_Set_Cursor(2,1);
         Lcd8_Write_String("Card");
				 Delay(2000);
      }
			
}