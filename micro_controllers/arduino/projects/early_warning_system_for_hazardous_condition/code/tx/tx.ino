

#include <SoftwareSerial.h> 
#define Rx    12			    // DOUT to pin 6
#define Tx    13			    // DIN to pin 7
SoftwareSerial Xbee (Rx, Tx);
SoftwareSerial SIM900(2, 3);
int led = 7;

int pin=3;

void setup() 
{ 
    Serial.begin(9600);
    Xbee.begin(9600);
    delay(7000);   
      Serial.begin(9600); // open serial at 9600 bps
Serial.println("Initializing GSM Module");
Serial.println("Please wait ......");
SIM900.begin(19200);
  SIM900power();  
  delay(20000);  // give time to log on to network. 
    pinMode(led, OUTPUT);
    digitalWrite(led, LOW);
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
  SIM900.print("Smoke Detected: ");        // message to send
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
    if(val > 60 )
    {
       digitalWrite(led, HIGH);
       delay(500);
       digitalWrite(led, LOW);
       delay(100);
       sendSMS(val);
       Serial.println("Sending to xbee");
       Xbee.print("Y");
   }
 }
   

    

  
