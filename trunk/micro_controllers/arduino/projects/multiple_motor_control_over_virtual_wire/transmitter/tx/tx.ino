#include <VirtualWire.h>

    // LED's
     const int ledPin = 7;

     // Sensors 
     const int Sensor1Pin = A0;
     int Sensor1Data;
     
    char Sensor1CharMsg[4]; 

    void setup()
       {
  
       pinMode(ledPin,OUTPUT);
      // Sensor(s)
       pinMode(Sensor1Pin,INPUT);
 
       // for debugging
      Serial.begin(9600); 
 
       // VirtualWire setup
      vw_setup(2000);     // Bits per sec
     }

    void loop()
    {
  
     // Read and store Sensor 1 data
     Sensor1Data = analogRead(Sensor1Pin);
    
     // Convert integer data to Char array directly 
     itoa(Sensor1Data,Sensor1CharMsg,10);
  
     // DEBUG
      Serial.print("Sensor1 Integer: ");
      Serial.print(Sensor1Data);
      Serial.print(" Sensor1 CharMsg: ");
      Serial.print(Sensor1CharMsg);
      Serial.println(" ");
      delay(1000);
     // END DEBUG
 
    digitalWrite(7, true); // Turn on a light to show transmitting
    vw_send((uint8_t *)Sensor1CharMsg, strlen(Sensor1CharMsg));
    vw_wait_tx(); // Wait until the whole message is gone
    digitalWrite(7, false); // Turn off a light after transmission
    delay(200); 
 
    } // END void loop...
