void main()
{
 TRISB = 0; // PORT B as output port
 PORTB = 1; // Set RB0 to high
 do
 {
   //To turn motor clockwise
   PORTB.F1 = 1;
   Delay_ms(2000);//2 seconds delay

   //To Stop motor
   PORTB = 0; // or PORTB = 3
   Delay_ms(2000);//2 seconds delay

   //To turn motor anticlockwise direction
   PORTB.F2 = 1;
   Delay_ms(2000);//2 seconds delay

   //To Stop motor
   PORTB = 0; // or PORTB = 3 (3 = 0b00000011)
   Delay_ms(2000); // 2 seconds delay

 }while(1);
}