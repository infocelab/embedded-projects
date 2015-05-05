#include<reg51.h>
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
		  Lcd8_Set_Cursor(1,1);
	    Lcd8_Write_String("Welcome 2 RFID ");
	    Delay(1000);
	    Lcd8_Set_Cursor(2,1);
      Lcd8_Write_String("Tag Read Example");
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
     		Lcd8_Clear();	
			  Lcd8_Set_Cursor(1,1);
	      Lcd8_Write_String("Unique card ID:");
			  Lcd8_Set_Cursor(2,1);
				for(l=0;l<12;l++)
						{	 
              Lcd8_Write_Char(card_id[l]);
						}
					Delay(5000);
			Lcd8_Clear();
	    Lcd8_Write_String("PLZ Show Your RFID ");
			Delay(1000);
	    Lcd8_Set_Cursor(2,1);
      Lcd8_Write_String("Card");			
	  }
			
			
}