
void main()
{
   TRISD = 0xFF; // PORTD as input
  TRISB = 0x00; // PORTB as output    int relay = 0;
   RB0_bit=0;
   RB1_bit=0;
   RB2_bit=0;
   RB3_bit=0;

   while(1)
     {
    if(RD0_bit==0 && RD1_bit==1 )  // 1 - on
    {
  if( RB0_bit== 0 )
  {
         delay_ms(200);
          RB1_bit = 0;
        delay_ms(200);
        RB0_bit=1;
  }
   else
      {
     RB1_bit = 0;
      delay_ms(200);
        RB0_bit=0;
     }
   delay_ms(200);
 }

    if(RD0_bit==1 && RD1_bit==0 )  // 1 - on
    {
  if( RB1_bit== 0 )
  {
         delay_ms(200);
          RB0_bit = 0;
        delay_ms(200);
        RB1_bit=1;
  }
   else
      {
     RB0_bit = 0;
      delay_ms(200);
        RB1_bit=0;
     }
   delay_ms(200);
     }
     }
     }