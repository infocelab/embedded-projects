#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/pwm_in_micro_c/MyProject.c"
void main()
{
 short current_duty_1 = 16;


 TRISD = 0xFF;
 TRISC = 0x00;

 PWM1_Init(5000);


 PWM1_Start();


 PWM1_Set_Duty(current_duty_1);


 while (1)
 {
 if (RD0_bit == 1)
 {
 Delay_ms(40);
 current_duty_1 += 1;
 PWM1_Set_Duty(current_duty_1);
 }

 else if (RD1_bit == 1)
 {
 Delay_ms(40);
 current_duty_1 -=1;
 PWM1_Set_Duty(current_duty_1);
 }
#line 48 "E:/celabcode/Embedded-Projects/project_codes/pic/pwm_in_micro_c/MyProject.c"
 Delay_ms(10);
 }
}
