

#include <SoftwareSerial.h> 
#define Rx    12			    // DOUT to pin 6
#define Tx    13			    // DIN to pin 7
SoftwareSerial Xbee (Rx, Tx);

int led = 7;

int buzzer=8;

void setup() 
{ 
    Serial.begin(9600);
    Xbee.begin(9600);
    delay(7000);   
    pinMode(led, OUTPUT);
   pinMode(buzzer, OUTPUT);
    digitalWrite(led, LOW);
        digitalWrite(buzzer, LOW);
    
}

void loop() 
{
    int wait=0;
    int err;
   if(Xbee.available()) 
   {     
     Serial.println("OK");
     // Is data available from XBee?
              char incoming = Xbee.read();    // Read character,
              if(incoming == 'Y')
              {
                Serial.println("YES");
                 digitalWrite(led, HIGH);
                 delay(1000);
                 digitalWrite(led, LOW);
                 delay(100);
                  digitalWrite(buzzer, HIGH);
                  delay(5000);
                  digitalWrite(buzzer, LOW);
                  delay(100);
              }
  
     }
 }
   

    

  
