
// LCD module connections
sbit LCD_RS at RC2_bit;
sbit LCD_EN at RC3_bit;
sbit LCD_D4 at RC4_bit;
sbit LCD_D5 at RC5_bit;
sbit LCD_D6 at RB6_bit;
sbit LCD_D7 at RB7_bit;

sbit LCD_RS_Direction at TRISC2_bit;
sbit LCD_EN_Direction at TRISC3_bit;
sbit LCD_D4_Direction at TRISC4_bit;
sbit LCD_D5_Direction at TRISC5_bit;
sbit LCD_D6_Direction at TRISB6_bit;
sbit LCD_D7_Direction at TRISB7_bit;
// End LCD module connections
unsigned char rfid[12];

void main()

{
 int i;
 trisb=0x00;
   UART1_Init(9600);                 // Initialize UART, 9600 baud rate
   //rfid[12] = '\0';                  // String Terminating Character
   Lcd_Init(); // Initialize LCD
 Lcd_Cmd(_LCD_CLEAR); // Clear display
 Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
 Lcd_Out(1,1,"Welcome to RFID ");//Write text'Hello World' in first row
 delay_ms(1000);
 Lcd_Out(2,1,"Security System");//Write text'Hello World' in first row
  delay_ms(1000);
 Lcd_Cmd(_LCD_CLEAR); // Clear display
 Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
 Lcd_Out(1,1,"PLZ Show Your RFID ");//Write text'Hello World' in first row
 delay_ms(1000);
 Lcd_Out(2,1,"Card");//Write text'Hello World' in first row
     while(1)
    {
   if(UART1_Data_Ready())          // If UART Data Ready
   {
     for(i=0;i<12;)                // To Read 12 characters
     {
       if(UART1_Data_Ready())
       {
         rfid[i] = UART1_Read();
         i++;
       }
     }
        if((rfid[0] ^ rfid[2] ^ rfid[4] ^ rfid[6] ^ rfid[8] == rfid[10]) && (rfid[1] ^ rfid[3] ^ rfid[5] ^ rfid[7] ^ rfid[9] == rfid[11]))
     {
       Lcd_Out(2,1,rfid);
       delay_ms(1000);
        if(rfid[0] == '1' && rfid[1] == '3' && rfid[2] == '0' && rfid[3] == '0' && rfid[4] == '4' &&  rfid[5] == 'A' && rfid[6] == '0' && rfid[7] == '4' && rfid[8] == 'A' && rfid[9] == 'B'  && rfid[10] == 'F' && rfid[11] == '6' )
       {
            Lcd_Cmd(_LCD_CLEAR); // Clear display
            Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
            Lcd_Out(1,1,"ACCESS GRANTED");//Write text'Hello World' in first row
             portb.rb0=0xff;
              delay_ms(2000);
                portb.rb0=0x00;
            delay_ms(2000);
       }
       else
       {
            Lcd_Cmd(_LCD_CLEAR);
            Lcd_Out(1,1,"ACCESS DENIED");//Write text'Hello World' in first row
            delay_ms(2000);
       }
     }
          delay_ms(1000);
          Lcd_Cmd(_LCD_CLEAR);
          Lcd_Out(1,1,"PLZ Show RFID ");//Write text'Hello World' in first row
     delay_ms(2000);
     Lcd_Out(2,1,"Card ");//Write text'Hello World' in first row

 }
  }
     }