#include <SoftwareSerial.h>
SoftwareSerial SIM900(2, 3);
int mq3_analogPin = A0; // connected to the output pin of MQ3 
int relay = 13;
void setup(){
  Serial.begin(9600); // open serial at 9600 bps
Serial.println("Initializing GSM Module");
Serial.println("Please wait ......");
 pinMode(relay, OUTPUT);
SIM900.begin(19200);
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

void sendSMS(int val)
{
  Serial.println("Sending SMS");
  SIM900.print("AT+CMGF=1\r");                                                        // AT command to send SMS message
  delay(100);
  SIM900.println("AT+CMGS=\"+917503021151\"\r");                                     // recipient's mobile number, in international format
  delay(100);
  SIM900.print("Alcohol Detected: ");        // message to send
  SIM900.println(val);
  delay(100);
  SIM900.println((char)26);                       // End AT command with a ^Z, ASCII code 26
  delay(2000); 
  SIM900.println();
  delay(5000);                                     // give module time to send SMS
  SIM900power();                                   // turn off module
}
 
int flag = 0; 
void loop()
{
  // give ample warmup time for readings to stabilize

  int mq3_value = analogRead(mq3_analogPin);
  Serial.println(mq3_value);
  if(mq3_value > 300 && flag == 0)
  {
    sendSMS(mq3_value);
    //Relay Trigger
     digitalWrite(relay, HIGH);
      delay(1000); 
      digitalWrite(relay, LOW);
      delay(1000);
    flag=1;
  }
  if(mq3_value < 300 && flag == 1)
  {
   flag =0; 
  }
  delay(100); //Just here to slow down the output.
}
