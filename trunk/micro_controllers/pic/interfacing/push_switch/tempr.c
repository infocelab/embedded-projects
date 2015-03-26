

#include <pic.h>
#include "delay.h"

int main()
{
  TRISB0 = 0; //RB0 as Output PIN
  TRISD0 = 1; //RD0 as Input PIN

  RB0 = 0; //LED Off

  while(1)
  {
    if(RD0 == 1) //If Switch Pressed
    {
      RB0 = 1; //LED ON
      DelayMs(3000); //3 Second Delay
      RB0 = 0; //LED OFF
    }
  }
}