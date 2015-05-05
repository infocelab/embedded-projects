#include<reg51.h>
#include<lcd.h>
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


 unsigned char card_id[12];
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
			
			TMOD=0x20;            //Enable Timer 1
      TH1=0XFD;
      SCON=0x50; 
      TR1=1; 
	    Lcd8_init();
		  Lcd8_Set_Cursor(1,0);
	    Lcd8_Write_String("RFID based Tele-");
	    Lcd8_Set_Cursor(2,0);
      Lcd8_Write_String("-medicine System");
	    Delay(5000);
			Lcd8_Clear();
	    Lcd8_Set_Cursor(0,1);
      Lcd8_Write_String("Please Show Your");
			Lcd8_Set_Cursor(2,0);
      Lcd8_Write_String("Card");
	    Delay(100);
    while(1)
    {
         recieve(); 
			
				 if(card_id[0] == '1' && card_id[1] == '3' && card_id[2] == '0' && card_id[3] == '0' && card_id[4] == '4' && card_id[5] == 'A' && card_id[6] == '0' && card_id[7] == '1' && card_id[8] == 'E'  && card_id[9] == 'D' && card_id[10] == 'B' && card_id[11] == '5')
				 {
					  					
					  Lcd8_Clear();
						Lcd8_Set_Cursor(1,0);
						Lcd8_Write_String("Anand Sharma");
					  Delay(300);
						Lcd8_Set_Cursor(2,0);
						Lcd8_Write_String("diseases-Cancer");	
						Delay(800);
						}
				 
				 else if(card_id[0] == '1' && card_id[1] == '3' && card_id[2] == '0' && card_id[3] == '0' && card_id[4] == '4' && card_id[5] == '9' && card_id[6] == 'D' && card_id[7] == 'E' && card_id[8] == 'C'  && card_id[9] == 'C' && card_id[10] == '4' && card_id[11] == '8')
				 {
					  Lcd8_Clear();
						Lcd8_Set_Cursor(1,0);
						Lcd8_Write_String("Anup Rajpal");
					  Delay(300);
						Lcd8_Set_Cursor(2,0);
						Lcd8_Write_String("diseases-Maleria");	
						Delay(800);
					}
				 else
				 {
					   Lcd8_Clear();
						 Lcd8_Set_Cursor(1,0);
	           Lcd8_Write_String("Invalid Card");
				     Lcd8_Set_Cursor(2,0);
						 Lcd8_Write_String("Contact Security:");
             Delay(500);
				 }
				 Delay(2000);
				 Lcd8_Clear();
	       Lcd8_Write_String("RFID based Tele-");
	       Delay(1000);
	       Lcd8_Set_Cursor(2,0);
         Lcd8_Write_String("-medicine System");
				 Delay(5000);
				 Lcd8_Clear();
				 Lcd8_Set_Cursor(0,1);
	       Lcd8_Write_String("Please Show Your");
	       Delay(1000);
	       Lcd8_Set_Cursor(2,0);
         Lcd8_Write_String("Card");
      }
		}
			
