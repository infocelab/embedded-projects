#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/ir_module_use _led_on_and_off/ir_module_use _led_on_and_off.c"

void main()
{
 trisb=0x00;
 trisd=0xff;
 delay_ms(20);
 trisd=0x00;
 int x = 0;
 while(1)
 {
 if( portd.rd0==1 )
 {
 if(x==0)
 {
 portb.rb0=1;
 delay_ms(200);
 x=1;
 }
 else
 {
 portb.rb0=0;
 delay_ms(200);
 x=0;
 }
 }
 }
 }
