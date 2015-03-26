int count = 0; // A variable to count the length of the Tag DATA
char input[36];
boolean row = 0;
#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
void setup()
{
  Serial.begin(9600); // Initialize Serial Communication - Both with the RFID reader & the Serial Monitor
  lcd.begin(16, 2);
  lcd.print("WELCOME");
  lcd.setCursor(0, 0);
  delay(10);
       count =0;
}

int i=0;
void loop()
{ 
    if(Serial.available()) // Check if there is Incoming Data in the Serial Buffer. This is data coming from the RFID reader
  {

    while(Serial.available()) // Keep reading Byte by Byte from the Buffer till the Buffer is empty
    {
       input[count] = Serial.read(); // Read 1 Byte of data and store it in a character variable
       count++; // Increment the Byte count after every Byte Read
       delay(5); // A small delay - Removing this might make the Program run faster and not respond properly as data from the reader could be slow
    }
  } 
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print(input);
      if(count >= 35)
      {
        count=0;
        for(i=0;i<36;i++)
        input[i]='\0';
      }
      
      if(count > 0)
      {
        // scroll 13 positions (string length) to the left 
   // to move it offscreen left:
   for (int positionCounter = 0; positionCounter < 13; positionCounter++) {
     // scroll one position left:
     lcd.scrollDisplayLeft(); 
     // wait a bit:
     delay(12);
   }
   // scroll 29 positions (string length + display length) to the right
   // to move it offscreen right:
   for (int positionCounter = 0; positionCounter < 29; positionCounter++) {
     // scroll one position right:
     lcd.scrollDisplayRight(); 
     // wait a bit:
     delay(12);
   }
   
     // scroll 16 positions (display length + string length) to the left
     // to move it back to center:
   for (int positionCounter = 0; positionCounter < 16; positionCounter++) {
     // scroll one position left:
     lcd.scrollDisplayLeft(); 
     // wait a bit:
     delay(12);
   }
      }
     // delay(20);
   }


