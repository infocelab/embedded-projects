#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/interfacing/stepper_motor/Stepper Driving Bipolar.c"
void main()
{
 CMCON = 0x07;
 ADCON1 = 0x06;

 TRISB = 0;
 PORTB = 0x0F;

 while(1)
 {
 PORTB=0x01;
 Delay_ms(1000);
 PORTB=0x02;
 Delay_ms(1000);
 PORTB=0x04;
 Delay_ms(1000);
 PORTB=0x08;
 Delay_ms(1000);
 }
}
