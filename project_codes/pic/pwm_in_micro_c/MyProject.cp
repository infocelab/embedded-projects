#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/pwm_in_micro_c/MyProject.c"
void main()
{
 short current_duty_1 = 16;
 short current_duty_2 = 16;

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
 current_duty_1 += 5;
 PWM1_Set_Duty(current_duty_1);
 }

 if (RD1_bit == 1)
 {
 Delay_ms(40);
 current_duty_1 -=5;
 PWM1_Set_Duty(current_duty_1);
 }

 if (!RD2_bit)
 {
 Delay_ms(40);
 current_duty_2++;
 PWM2_Set_Duty(current_duty_2);
 }

 if (!RD3_bit)
 {
 Delay_ms(40);
 current_duty_2--;
 PWM2_Set_Duty(current_duty_2);
 }

 Delay_ms(10);
 }
}
