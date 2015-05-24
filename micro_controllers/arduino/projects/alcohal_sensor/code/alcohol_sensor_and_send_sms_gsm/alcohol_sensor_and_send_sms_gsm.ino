

#include <SoftwareSerial.h> 

SoftwareSerial SIM900(2, 3);
int led = 7;
int buzzer = 10;
int relay = 13;

int pin=3;

void setup() 
{ 
    Serial.begin(9600);

    delay(7000);   
      Serial.begin(9600); // open serial at 9600 bps
Serial.println("Initializing GSM Module");
Serial.println("Please wait ......");
SIM900.begin(19200);
  SIM900power();  
  delay(20000);  // give time to log on to network. 
     pinMode(relay, OUTPUT);
   pinMode(led, OUTPUT);
   pinMode(buzzer, OUTPUT);
   digitalWrite(buzzer,HIGH);
   digitalWrite(led,HIGH);
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
  SIM900.println("AT+CMGS=\"+917827855025\"\r");                                     // recipient's mobile number, in international format
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

 int val;
void loop() 
{
    int wait=0;
    int err;
    val=analogRead(0);//Read Gas value from analog 0
    Serial.println(val,DEC);//Print the value to serial port
    delay(1000);
    if(val > 300 )
    {
      digitalWrite(relay, HIGH);
      delay(500); 
      digitalWrite(relay, LOW);
      delay(500);
      digitalWrite(led, LOW);
      delay(500);
      digitalWrite(buzzer, LOW);
      delay(500);
       
       sendSMS(val);
   
   }
 }
   

    

   
