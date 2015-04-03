#include <LiquidCrystal.h>
#include <VirtualWire.h>
const int transmit_pin = 2;
const int transmit_en_pin = 3;
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

const int xpin = A0;                  // x-axis of the accelerometer
const int ypin = A1;                  // y-axis
const int zpin = A2;                  // z-axis (only on 3-axis models)
int x_value = 340;
int y_value = 340;
int z_value = 340;
 
void setup()
{

    lcd.begin(16, 2);
    lcd.print("DAMPING CONTROL");
    lcd.setCursor(0, 1);
    lcd.print("PROJECT-2015");
    delay(5000);
 
}

void loop()
{
  int x = analogRead(xpin);
  int y = analogRead(ypin);
  int z = analogRead(zpin);
  print_on_lcd(x,y,z);
  delay(1000);
} 
void print_on_lcd(int x, int y , int z)
{
    lcd.clear();  
    lcd.setCursor(0, 0);
    lcd.print("ACCELEROMETER");
    lcd.setCursor(0, 1);
    lcd.print("x=");
    lcd.print(x);
    lcd.print(",Y=");
    lcd.print(y);     
}

