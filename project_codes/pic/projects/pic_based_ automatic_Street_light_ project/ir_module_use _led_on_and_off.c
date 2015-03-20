#define MIN 10
#define MAX 40

void main()
{
  //short current_duty_1  = MIN; // initial value for current_duty_1
  //short current_duty_2 = MIN;  // initial value for current_duty_2
  //short flag1 = 0;
  //short flag2 = 0;

  TRISD = 0xFF; // PORTD as input
  TRISC = 0x00; // PORTC as output

  //PWM1_Init(5000);  // Initialize PWM1
  //PWM2_Init(5000);  // Initialize PWM2

  //PWM1_Start();  // start PWM1
  //PWM2_Start();  // start PWM2

  //PWM1_Set_Duty(current_duty_1); // Set current duty for PWM1
  //PWM2_Set_Duty(current_duty_2); // Set current duty for PWM2
       RC0_bit=1;
       RC1_bit=0;
       RC2_bit=0;
       RC3_bit=0;
       RC4_bit=0;
           
  while (1)        // endless loop
  {
    if (RD0_bit == 1)   // if button on RD0 pressed
    {
       RC1_bit=1;
       RC0_bit=0;
    }
    else if (RD1_bit == 1)               // button on RD1 pressed
    {
       RC2_bit=1;
       RC1_bit=0;
    }
    else if (RD2_bit == 1)               // button on RD1 pressed
    {
       RC3_bit=1;
       RC2_bit=0;
    }
    else if (RD3_bit == 1)               // button on RD1 pressed
    {
       RC4_bit=1;
       RC3_bit=0;
    }
    else if (RD4_bit == 1)               // button on RD1 pressed
    {
       RC4_bit=0;
       RC0_bit=1;
     }
     Delay_ms(5);      // slow down change pace a little
  }
}