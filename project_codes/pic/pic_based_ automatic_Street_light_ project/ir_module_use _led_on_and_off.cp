#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/pic_based_ automatic_Street_light_ project/ir_module_use _led_on_and_off.c"



void main()
{
 short current_duty_1 =  10 ;
 short current_duty_2 =  10 ;
 short flag1 = 0;
 short flag2 = 0;

 TRISD = 0xFF;
 TRISC = 0x00;

 PWM1_Init(5000);
 PWM2_Init(5000);

 PWM1_Start();
 PWM2_Start();

 PWM1_Set_Duty(current_duty_1);
 PWM2_Set_Duty(current_duty_2);

 while (1)
 {
 if (RD0_bit == 1)
 {
 Delay_ms(40);
 current_duty_1 =  40 ;
 PWM1_Set_Duty(current_duty_1);
 }
 else if (RD1_bit == 1)
 {
 Delay_ms(40);
 current_duty_2 =  40 ;
 PWM2_Set_Duty(current_duty_2);
 }
 if(current_duty_1 >  10 )
 {
 current_duty_1--;
 PWM1_Set_Duty(current_duty_1);
 Delay_ms(30);
 }
 if(current_duty_2 >  10 )
 {
 current_duty_2--;
 PWM2_Set_Duty(current_duty_2);
 Delay_ms(30);
 }
 Delay_ms(10);
 }
}
