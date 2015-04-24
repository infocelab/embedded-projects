// LCD module connections
sbit LCD_RS at RD2_bit;
sbit LCD_EN at RD3_bit;
sbit LCD_D4 at RC4_bit;
sbit LCD_D5 at RC5_bit;
sbit LCD_D6 at RC6_bit;
sbit LCD_D7 at RC7_bit;

sbit LCD_RS_Direction at TRISD2_bit;
sbit LCD_EN_Direction at TRISD3_bit;
sbit LCD_D4_Direction at TRISC4_bit;
sbit LCD_D5_Direction at TRISC5_bit;
sbit LCD_D6_Direction at TRISC6_bit;
sbit LCD_D7_Direction at TRISC7_bit;
// End LCD module connections

int a;

//Interrupt function will be automatically executed on Interrupt
void interrupt()
{
  if(INTCON.RBIF == 1)                 //Makes sure that it is PORTB On-Change Interrupt
  {
    INTCON.RBIE = 0;                   //Disable On-Change Interrupt
    if(PORTB.F4 == 1)                  //If ECHO is HIGH
      T1CON.F0 = 1;                    //Start Timer
    if(PORTB.F4 == 0)                  //If ECHO is LOW
    {
      T1CON.F0 = 0;                    //Stop Timer
      a = (TMR1L | (TMR1H<<8))/58.82;  //Calculate Distance
    }
  }
  INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt flag
  INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt
}

void main()
{
  char txt[7];
  Lcd_Init();
  Lcd_Cmd(_LCD_CLEAR);                 // Clear display
  Lcd_Cmd(_LCD_CURSOR_OFF);            // Cursor off

  TRISB = 0b00010000;
  INTCON.GIE = 1;                      //Global Interrupt Enable
  INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt Flag
  INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt

  Lcd_Out(1,1,"Developed By");
  Lcd_Out(2,1,"CELAB");

  Delay_ms(3000);
  Lcd_Cmd(_LCD_CLEAR);

  T1CON = 0x10;                        //Initializing Timer Module

   while(1)
  {
    TMR1H = 0;                  //Sets the Initial Value of Timer
    TMR1L = 0;                  //Sets the Initial Value of Timer

    PORTB.F0 = 1;               //TRIGGER HIGH
    Delay_us(10);               //10uS Delay
    PORTB.F0 = 0;               //TRIGGER LOW

    while(!PORTB.F4);           //Waiting for Echo
    T1CON.F0 = 1;               //Timer Starts
    while(PORTB.F4);            //Waiting for Echo goes LOW
    T1CON.F0 = 0;               //Timer Stops

    a = (TMR1L | (TMR1H<<8));   //Reads Timer Value
    a = a/58.82;                //Converts Time to Distance
    a = a + 1;                  //Distance Calibration\
    if(a>=2 && a<=400)          //Check whether the result is valid or not
    {
      IntToStr(a,txt);
      Ltrim(txt);
      Lcd_Cmd(_LCD_CLEAR);
      Lcd_Out(1,1,"Distance = ");
      Lcd_Out(1,12,txt);
      Lcd_Out(1,15,"cm");
    }
    Delay_ms(400);
  }
}