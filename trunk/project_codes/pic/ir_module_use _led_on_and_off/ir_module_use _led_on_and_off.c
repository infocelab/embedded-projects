
void main()
{
  unsigned int j=10;
  trisb=0x00;
  trisd=0xff;
  delay_ms(20);
  trisd=0x00;

  while(1)
  {
    if( portd.rd0==1 )
     {
     if(j==0)
     {
      portb.rb0=1;
      delay_ms(200);
      j=1;
      }
       else
      {
      portb.rb0=0;
      delay_ms(200);
       j=0;
      }
      }
  }
  }



