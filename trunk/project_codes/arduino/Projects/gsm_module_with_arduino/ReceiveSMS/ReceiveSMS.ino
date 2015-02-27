#include <SoftwareSerial.h>
SoftwareSerial SIM900(7, 8);
 
char incoming_char=0;
char data[256];
int i=0;
void setup()
{
  Serial.begin(9600); // for serial monitor
  SIM900.begin(9600); // for GSM shield
  SIM900power();  // turn on shield
  delay(20000);  // give time to log on to network.
 
  SIM900.print("AT+CMGF=1\r");  // set SMS mode to text
  delay(100);
  SIM900.print("AT+CNMI=2,2,0,0,0\r"); 
  // blurt out contents of new SMS upon receipt to the GSM shield's serial out
  delay(100);
  SIM900.print("AT+CLIP=1\r"); // turn on caller ID notification
  delay(100);
}
 
void SIM900power()
// software equivalent of pressing the GSM shield "power" button
{
  digitalWrite(9, HIGH);
  delay(1000);
  digitalWrite(9, LOW);
  delay(7000);
}
 
void loop()
{
  // Now we simply display any text that the GSM shield sends out on the serial monitor
  while(SIM900.available() >0)
  {
    data[i++]=SIM900.read();
    //incoming_char=SIM900.read(); //Get the character from the cellular serial port.
    //Serial.print(incoming_char); //Print the incoming character to the terminal.
  }
  if(i > 0)
  {
   Serial.print(data);
   i=0; 
   Serial.println("=====Sending SMS======");
   SIM900.print("AT+CMGF=1\r");                                                        // AT command to send SMS message
   delay(200);
   SIM900.println("AT+CMGS=\"+917503021151\"");                                     // recipient's mobile number, in international format
   delay(200);
   SIM900.println("Hello, world.");        // message to send
   delay(200);
   SIM900.println((char)26);                       // End AT command with a ^Z, ASCII code 26
   delay(200); 
   SIM900.println();
   delay(5000);                                     // give module time to send SMS
   //SIM900power();
   Serial.println("=====SMS SENT======");  
  }
}
