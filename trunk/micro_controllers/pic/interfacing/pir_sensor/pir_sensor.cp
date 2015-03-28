#line 1 "E:/celabcode/Embedded-Projects/micro_controllers/pic/interfacing/pir_sensor/pir_sensor.c"
void main()
{


 TRISD = 0xFF;
 TRISB = 0x00;

 RB0_bit=0;

 while (1)
 {
 if (RD0_bit == 1)
 {
 RB0_bit=1;
 Delay_ms(1000);
 RB0_bit=0;
 }

 }
}
