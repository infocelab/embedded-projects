

#include <SoftwareSerial.h> 
#define Rx    6			    // DOUT to pin 6
#define Tx    7			    // DIN to pin 7
#include <DHT11.h>
SoftwareSerial Xbee (Rx, Tx);

int led = 13;

int pin=3;
DHT11 dht11(pin); 

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
    Xbee.println("Gaurav");
    delay(100);
    pinMode(led, OUTPUT);
    digitalWrite(led, LOW);
    
}

void loop() 
{
    int wait=0;
    int err;
    float temp, humi;
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
              
              if(incoming == '3')
              {
              
                 if((err=dht11.read(humi, temp))==0)
                       {
                     Serial.print("temperature:");
                      Serial.print(temp);
                     Xbee.println("temperature:");
                     Xbee.println(temp);
                     
                     Serial.print(" humidity:");
                     Serial.print(humi);
                     Xbee.println("humidity:");
                     Xbee.println(humi);
                     Xbee.println();
                     }
                   else
                    {
                     Serial.println();
                    Serial.print("Error No :");
                    Serial.print(err);
                    Serial.println();    
                   }
                  delay(DHT11_RETRY_DELAY); //delay for reread
                  }
     }
 }
   

    

  
