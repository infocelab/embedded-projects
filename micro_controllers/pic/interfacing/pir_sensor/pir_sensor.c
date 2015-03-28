void main()
{


  TRISD = 0xFF; // PORTD as input
  TRISB = 0x00; // PORTB as output

     RB0_bit=0;

  while (1)
  {
    if (RD0_bit == 1)
    {
       RB0_bit=1;
        Delay_ms(1000);
       RB0_bit=0;
    }

  }
}