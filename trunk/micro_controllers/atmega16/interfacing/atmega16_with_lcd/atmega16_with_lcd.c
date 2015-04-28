#define F_CPU 1000000UL  //Define clock speed
#include <avr/io.h>
#include <util/delay.h>

#include "lcd.h"

void main()
{
    unsigned char i;
   for(i=0;i<10;i++) _delay_loop_2(0);
   
    while(1)
   {

   //Initialize LCD module
   LCDInit(LS_BLINK|LS_ULINE);
  
   for(i=0;i<10;i++) _delay_loop_2(0);
   //Clear the screen
   LCDClear();

   //Simple string printing
   LCDWriteStringXY(0,0,"Welcome to CELAB");
   //LCDWriteString("Congrats ");

   //A string on line 2
   LCDWriteStringXY(0,1,"Loading ");

   //Print some numbers
   for (i=0;i<99;i+=1)
   {
      LCDWriteIntXY(9,1,i,3);
      LCDWriteStringXY(12,1,"%");
      _delay_loop_2(0);

   }

   //Clear the screen
   LCDClear();

   //Some more text

   LCDWriteString("Hello world");
   LCDWriteStringXY(0,1,"ComputronicsLab");    // <--- Write ur NAME HERE !!!!!!!!!!!

   //Wait
  for(i=0;i<50;i++) _delay_loop_2(0);

   //Some More ......
   LCDClear();
   LCDWriteString("Computronics");
   LCDWriteStringXY(0,1,"Lab");
   for(i=0;i<50;i++) _delay_loop_2(0);
   }

}
