void main()
{
    CMCON = 0x07;   // To turn off comparators
    ADCON1 = 0x06;  // To turn off analog to digital converters

    TRISB = 0;        // PORT B as output port
    PORTB = 0x0F;

   while(1)
   {
    PORTB=0x01; //0001
    Delay_ms(1000);
    PORTB=0x02; //0010
    Delay_ms(1000);
    PORTB=0x04; //0100
    Delay_ms(1000);
    PORTB=0x08; //1000
    Delay_ms(1000);
   }
}