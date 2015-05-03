#line 1 "G:/Celabcode/embedded-projects/micro_controllers/pic/interfacing/led_blinking/led_blinking - Copy/led_blinking.c"
void main()
{
 trisb=0x00;
 while(1)
 {
 portb.rb0=0x00;
 delay_ms(200);
 portb.rb0=0xff;
 delay_ms(200);
 }

}
