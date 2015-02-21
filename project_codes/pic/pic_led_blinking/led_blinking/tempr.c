/*Code written by 
Anshuman Bezborah
BTech,4th year,SRM University
chennai*/
#include<pic.h>
#include<math.h>
#include"lcd.h"
#include"delay.h"

void disp(float); // prototype declaration of a function to display a float number
char lookup(int);  //prototype declaration of a function to find ASCII code for digits

void main()     // main program begins
{
	TRISB=0x00;
while(1) 
{
 RB0=1;
DelayMs(1000);
RB0=0;
DelayMs(1000);

}

}
