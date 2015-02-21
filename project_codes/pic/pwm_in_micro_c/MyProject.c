void main()
{
  short current_duty_1  = 16; // initial value for current_duty_1
  short current_duty_2 = 16;  // initial value for current_duty_2

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
      current_duty_1 += 5;  // increment current_duty_1
      PWM1_Set_Duty(current_duty_1);  //Change the duty cycle
     }

    if (RD1_bit == 1)               // button on RD1 pressed
    {
      Delay_ms(40);
      current_duty_1 -=5;  // decrement current_duty_1
      PWM1_Set_Duty(current_duty_1);
     }

    if (!RD2_bit)     // if button on RD2 pressed
    {
      Delay_ms(40);
      current_duty_2++;    // increment current_duty_2
      PWM2_Set_Duty(current_duty_2);
     }

    if (!RD3_bit)       // if button on RD3 pressed
    {
      Delay_ms(40);
      current_duty_2--;   // decrement current_duty_2
      PWM2_Set_Duty(current_duty_2);
     }

    Delay_ms(10);      // slow down change pace a little
  }
}