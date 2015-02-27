#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/motor_driver_interfacing_pic/motor_driver_interfacing_pic.c"
void main()
{
 TRISB = 0;
 PORTB = 1;
 do
 {

 PORTB.F1 = 1;
 Delay_ms(2000);


 PORTB = 0;
 Delay_ms(2000);


 PORTB.F2 = 1;
 Delay_ms(2000);


 PORTB = 0;
 Delay_ms(2000);

 }while(1);
}
