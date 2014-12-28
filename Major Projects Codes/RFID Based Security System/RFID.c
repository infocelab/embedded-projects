#include<reg51.h>
#include<lcd.h>
sbit Relay = P3^2;
sbit Buz = P3^4;
//LCD Module Connections
sbit RS = P3^7;                                                                   
sbit EN = P3^6;                            
sbit D0 = P2^0;
sbit D1 = P2^1;
sbit D2 = P2^2;
sbit D3 = P2^3;
sbit D4 = P2^4;
sbit D5 = P2^5;
sbit D6 = P2^6;
sbit D7 = P2^7;

sbit OPENM = P1^3; 
sbit CLOSEM = P1^5; 

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
       card_id[k] = SBUF + 48;
			   RI=0;
     }
  }

    void main()
    { 
			int l;
			Relay = 0;
			Buz = 1;
		  TMOD=0x20;            //Enable Timer 1
      TH1=0XFD;
      SCON=0x50;
      TR1=1; 
	    Lcd8_init();
		  Lcd8_Set_Cursor(1,1);
	    Lcd8_Write_String("Welcome to RFID ");
	    Delay(1000);
	    Lcd8_Set_Cursor(2,1);
      Lcd8_Write_String("Security System");
	    Lcd8_Set_Cursor(1,1);
	    Delay(1000);
	    Lcd8_Clear();
	    Lcd8_Write_String("PLZ Show Your RFID ");
	    Delay(1000);
	    Lcd8_Set_Cursor(2,1);
      Lcd8_Write_String("Card");
	
    while(1)
    {
         recieve(); 
				 if(card_id[7] == 'N' && card_id[8] == 'J' && card_id[9] == 'J' && card_id[10] == 'N' && card_id[11] == '0')
				 {
					  Lcd8_Clear();
						Lcd8_Set_Cursor(1,1);
						Lcd8_Write_String("ACCESS GRANTED ");
					  Relay = 1;
					  Delay(300);
					  Relay = 0;
					  Delay(300);
					  OPENM = 0;
					  Delay(600);
					  OPENM = 1;
					  Delay(300);
					  CLOSEM = 0;
					  Delay(600);
					  CLOSEM = 1;
						Lcd8_Set_Cursor(2,1);
						for(l=7;l<12;l++)
						{	 
              Lcd8_Write_Char(card_id[l]);
						}
				 }
				 else 
				 {
					   Lcd8_Clear();
						 Lcd8_Set_Cursor(1,1);
	           Lcd8_Write_String("ACCESS DENIED ");
             Relay = 0;
					   Delay(100);
             Buz = 0;	
             Delay(5000);
					   Buz = 1;	
					   Delay(200);
						 Lcd8_Set_Cursor(2,1);
						 for(l=7;l<12;l++)
						{	 
             Lcd8_Write_Char(card_id[l]);
						}
						
				 }
				 Delay(2000);
				 Lcd8_Clear();
	       Lcd8_Write_String("PLZ Show Your RFID ");
	       Delay(1000);
	       Lcd8_Set_Cursor(2,1);
         Lcd8_Write_String("Card");
      }
			
}