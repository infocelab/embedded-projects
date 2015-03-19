unsigned int Hex(int a)
{
 switch(a)
  {
      case 1: return 0x06;
      case 2: return 0x5B;
      case 3: return 0x4F;
      case 4: return 0x66;
      case 5: return 0x6D;
      case 6: return 0x7D;
      case 7: return 0x07;
      case 8: return 0x7F;
      case 9: return 0x6F;
      case 0: return 0x3F;
  }
}

void main()
{
   int s = 0;
   int d = 10;
   CMCON = 0x07;   // To turn off comparators
   ADCON1 = 0x06;  // To turn off analog to digital converters
   TRISB = 0x00;
   TRISD = 0x00;
   do
   {
     PORTB = Hex(s%10);
     PORTD.F3 = 1;
     Delay_ms(10);
     PORTD.F3 = 0;
     PORTB = Hex((s/10)%10);
     PORTD.F2 = 1;
     Delay_ms(10);
     PORTD.F2 = 0;
     PORTB = Hex((s/100)%10);
     PORTD.F1 = 1;
     Delay_ms(10);
     PORTD.F1 = 0;
     PORTB = Hex((s/1000)%10);
     PORTD.F0 = 1;
     Delay_ms(10);
     PORTD.F0 = 0;

     if(d>0)
     {
       d--;
         if(d == 0)
         {
             s++;
             d = 10;
         }
         if(s > 9999)
           s = 0;
     }
   }while(1);
}