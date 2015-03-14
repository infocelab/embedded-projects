 
#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
SoftwareSerial SIM900(2, 3); //tx-2 rx-3
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
char input[36];
int count = 0; // A variable to count the length of the Tag DATA


char incoming_char=0;
 
void setup()
{
  // set up the LCD's number of columns and rows: 
  lcd.begin(16, 2);
   lcd.print("WELCOME");
  Serial.begin(9600); // for serial monitor
  SIM900.begin(19200); // for GSM shield
  SIM900power();  // turn on shield
  delay(20000);  // give time to log on to network.
 
  SIM900.print("AT+CMGF=1\r");  // set SMS mode to text
  delay(100);
  SIM900.print("AT+CNMI=2,2,0,0,0\r"); 
  // blurt out contents of new SMS upon receipt to the GSM shield's serial out
  delay(100);
     for(int i=0;i<36;i++)
        input[i]='\0';
          lcd.setCursor(0, 1);
          count=0;
}
 
void SIM900power()
// software equivalent of pressing the GSM shield "power" button
{
  digitalWrite(9, HIGH);
  delay(1000);
  digitalWrite(9, LOW);
  delay(7000);
}

void gsm_read()
{
 // Now we simply display any text that the GSM shield sends out on the serial monitor
  if(SIM900.available() >0)
  {

   // while(SIM900.available()) // Keep reading Byte by Byte from the Buffer till the Buffer is empty
    {
    incoming_char=SIM900.read(); //Get the character from the cellular serial port.
    Serial.print(incoming_char); //Print the incoming character to the terminal.
    input[count] = incoming_char; // Read 1 Byte of data and store it in a character variable
    count++; // Increment the Byte count after every Byte Read
    delay(25); 
    }
 
  } 
  
}
void loop()
{
  // set the cursor to column 0, line 1
  // (note: line 1 is the second row, since counting begins with 0):

  
gsm_read();
   lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print(input);
      if(count >= 35)
      {
        count=0;
        for(int i=0;i<18;i++)
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
     delay(120);
   }

   // scroll 29 positions (string length + display length) to the right
   // to move it offscreen right:
   for (int positionCounter = 0; positionCounter < 29; positionCounter++) {
     // scroll one position right:
     lcd.scrollDisplayRight(); 
     // wait a bit:
     delay(120);
   }

     // scroll 16 positions (display length + string length) to the left
     // to move it back to center:
   for (int positionCounter = 0; positionCounter < 16; positionCounter++) {
     // scroll one position left:
     lcd.scrollDisplayLeft(); 
     // wait a bit:
     delay(120);
   }
      }
  
}
