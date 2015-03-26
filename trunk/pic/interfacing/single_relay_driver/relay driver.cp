#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/single_relay_driver/relay driver.c"
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
