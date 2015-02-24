#define MIN 10
#define MAX 40

void main()
{
  short current_duty_1  = MIN; // initial value for current_duty_1
  short current_duty_2 = MIN;  // initial value for current_duty_2
  short flag1 = 0;
  short flag2 = 0;
  
  TRISD = 0xFF; // PORTD as input
  TRISC = 0x00; // PORTC as output

  PWM1_Init(5000);  // Initialize PWM1
  PWM2_Init(5000);  // Initialize PWM2

  PWM1_Start();  // start PWM1
  PWM2_Start();  // start PWM2

  PWM1_Set_Duty(current_duty_1); // Set current duty for PWM1
  PWM2_Set_Duty(current_duty_2); // Set current duty for PWM2

  while (1)        // endless loop
  {
     if (RD0_bit == 1)   // if button on RD0 pressed
     {
      Delay_ms(40);
      current_duty_1 = MAX;  // increment current_duty_1
     PWM1_Set_Duty(current_duty_1);  //Change the duty cycle
     }
    else if (RD1_bit == 1)               // button on RD1 pressed
    {
        Delay_ms(40);
        current_duty_2 = MAX;  // increment current_duty_1
        PWM2_Set_Duty(current_duty_2);  //Change the duty cycle
     }
       if(current_duty_1 > MIN)
       {
          current_duty_1--;
          PWM1_Set_Duty(current_duty_1);  //Change the duty cycle
          Delay_ms(30);
       }
       if(current_duty_2 > MIN)
       {
         current_duty_2--;
         PWM2_Set_Duty(current_duty_2);  //Change the duty cycle
         Delay_ms(30);
       }
    Delay_ms(10);      // slow down change pace a little
  }
}