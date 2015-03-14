int count = 0; // A variable to count the length of the Tag DATA
char input[12];
boolean flag = 0;
#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
void setup()
{
  Serial.begin(9600); // Initialize Serial Communication - Both with the RFID reader & the Serial Monitor
  lcd.begin(16, 2);
  lcd.print("WELCOME");
  delay(10);
  lcd.setCursor(0, 1);
}


void loop()
{ 
  //Serial.println("Bat");
  delay(100);
       count =0;
    if(Serial.available()) // Check if there is Incoming Data in the Serial Buffer. This is data coming from the RFID reader
  {
    while(Serial.available()) // Keep reading Byte by Byte from the Buffer till the Buffer is empty
    {
       lcd.write( Serial.read());
       delay(50); // A small delay - Removing this might make the Program run faster and not respond properly as data from the reader could be slow
    }

 

  }
  
     lcd.clear();

}
