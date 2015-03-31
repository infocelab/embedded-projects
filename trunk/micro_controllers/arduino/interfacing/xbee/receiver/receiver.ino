

#include <SoftwareSerial.h> 
#define Rx    6			    // DOUT to pin 6
#define Tx    7			    // DIN to pin 7
SoftwareSerial Xbee (Rx, Tx);


int led = 13;

void setup() 
{ 
    Serial.begin(9600);
    Xbee.begin(9600);
    delay(7000);   
    Xbee.print("Home");
    delay(100);
    Xbee.print(" Automation");
    delay(100);
    Xbee.println(" using zigbee");
    delay(100);
    Xbee.println("Made by:");
    delay(100);
    Xbee.println("Shankar Kumar Pandit");
    delay(100);
    pinMode(led, OUTPUT);
    digitalWrite(led, LOW);
    
}

void loop() 
{
    int wait=0;
   if(Xbee.available()) 
   {            // Is data available from XBee?
              char incoming = Xbee.read();    // Read character,
              if(incoming == '1')
              {
                
                 digitalWrite(led, HIGH);
                 delay(100);
                 Xbee.println("");
                 Xbee.println("Led ON CELAB");
              }
  
              if(incoming == '2')
              {
              
                 digitalWrite(led, LOW);
                 delay(100);
                 Xbee.println("");
                 Xbee.println("Led OFF");
              }
              
             
   }
}
   

    

  
