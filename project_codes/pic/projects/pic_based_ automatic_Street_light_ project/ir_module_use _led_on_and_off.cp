#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/pic_based_ automatic_Street_light_ project/ir_module_use _led_on_and_off.c"



void main()
{





 TRISD = 0xFF;
 TRISC = 0x00;









 RC0_bit=1;
 RC1_bit=0;
 RC2_bit=0;
 RC3_bit=0;
 RC4_bit=0;

 while (1)
 {
 if (RD0_bit == 1)
 {
 RC1_bit=1;
 RC0_bit=0;
 }
 else if (RD1_bit == 1)
 {
 RC2_bit=1;
 RC1_bit=0;
 }
 else if (RD2_bit == 1)
 {
 RC3_bit=1;
 RC2_bit=0;
 }
 else if (RD3_bit == 1)
 {
 RC4_bit=1;
 RC3_bit=0;
 }
 else if (RD4_bit == 1)
 {
 RC4_bit=0;
 RC0_bit=1;
 }
 Delay_ms(5);
 }
}
