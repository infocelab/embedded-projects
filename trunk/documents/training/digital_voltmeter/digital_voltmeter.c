#define F_CPU 1000000UL  //Define clock speed
#include "LiquidCrystal.h"

int analogInput = 0;
float vout = 0.0;
float vin = 0.0;
float R1 = 100000.0; // resistance of R1 (100K) -see text!
float R2 = 10000.0; // resistance of R2 (10K) - see text!
int value = 0;


int main(void)
{
LiquidCrystal_lcd(12, 11, 5, 4, 3, 2); 
  setup();
  loop();
}

// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pin as an output.
   pinMode(analogInput, INPUT);
  lcd_begin(16, 2);
  lcd_print("DC VOLTMETER");
   
}

// the loop routine runs over and over again forever:
void loop() {
while(1)
{
   // read the value at analog input
   value = analogRead(analogInput);
   vout = (value * 5.0) / 1024.0; // see text
   vin = vout / (R2/(R1+R2)); 
   if (vin<0.09) {
   vin=0.0;//statement to quash undesired reading !
} 
lcd_setCursor(0, 1);
lcd_print("INPUT V= ");
lcd_printl(vin/10);
delay(1000);
}
}
