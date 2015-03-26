void main()
{
  trisb=0x00;
  while(1)
  {
    portb.rb0=0x00;
    delay_ms(500);
    portb.rb0=0xff;
    delay_ms(500);
     portb.rb1=0x00;
    delay_ms(500);
    portb.rb1=0xff;
    delay_ms(500);
     portb.rb2=0x00;
    delay_ms(500);
    portb.rb2=0xff;
    delay_ms(500);
     portb.rb3=0x00;
    delay_ms(500);
    portb.rb4=0xff;
    delay_ms(500);
   }

}