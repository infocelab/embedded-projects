#include <SoftwareSerial.h>
SoftwareSerial SIM900(7, 8); // configure software serial port
// 7 - GSM TX , 8 - GSM RX
 
void setup()
{
  Serial.begin(9600);
  SIM900.begin(9600);               
  SIM900power();  
  delay(20000);  // give time to log on to network. 
}
 
void SIM900power()
// software equivalent of pressing the GSM shield "power" button
{
  digitalWrite(9, HIGH);
  delay(1000);
  digitalWrite(9, LOW);
  delay(5000);
}
 
void callSomeone()
{
  Serial.println("Calling");
  SIM900.println("ATD+917503021151;"); // dial US (212) 8675309
  //SIM900.println("AT+CMGS=\"+917503021151\"");    
  delay(100);
  SIM900.println();
  delay(30000);            // wait for 30 seconds...
  SIM900.println("ATH");   // hang up
}
 
 void sendSMS()
{
  SIM900.print("AT+CMGF=1\r");                                                        // AT command to send SMS message
  delay(100);
  SIM900.println("AT+CMGS=\"+917503021151\"\r");                                     // recipient's mobile number, in international format
  delay(100);
  SIM900.println("Helloworld");        // message to send
  delay(100);
  SIM900.println((char)26);                       // End AT command with a ^Z, ASCII code 26
  delay(2000); 
  SIM900.println();
  delay(5000);                                     // give module time to send SMS
  SIM900power();                                   // turn off module
}
void loop()
{
  callSomeone(); // call someone
  SIM900power();   // power off GSM shield
  Serial.println("sending sms");
  sendSMS();
  //do {} while (1); // do nothing
}

