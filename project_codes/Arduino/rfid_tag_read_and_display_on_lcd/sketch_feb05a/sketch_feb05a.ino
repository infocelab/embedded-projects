int count = 0; // A variable to count the length of the Tag DATA
char input[12];
boolean flag = 0;
#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
void setup()
{
  Serial.begin(9600); // Initialize Serial Communication - Both with the RFID reader & the Serial Monitor
  lcd.begin(16, 2);
  lcd.print("WELCOME 2 RFID");
  lcd.setCursor(0, 1);
  lcd.print("Tag Read ");
  delay(2000);
  lcd.clear();
  lcd.print("Example");
}


void loop()
{ 
    if(Serial.available()) // Check if there is Incoming Data in the Serial Buffer. This is data coming from the RFID reader
  {
     count =0;
    while(Serial.available()) // Keep reading Byte by Byte from the Buffer till the Buffer is empty
    {
       input[count] = Serial.read(); // Read 1 Byte of data and store it in a character variable
       count++; // Increment the Byte count after every Byte Read
       delay(5); // A small delay - Removing this might make the Program run faster and not respond properly as data from the reader could be slow
    }
    
    if(count == 12)
    {
      lcd.clear();
      lcd.print("CARD ID");
      lcd.setCursor(0, 1);
      lcd.print(input);
      delay(2000);
      count=0;
      flag = 1;
     lcd.clear();
    lcd.print("Plz show ur card");
  }
}
