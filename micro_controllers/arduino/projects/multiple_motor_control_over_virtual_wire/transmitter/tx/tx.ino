#include <VirtualWire.h>

    // LED's
     const int ledPin = 7;

     // Sensors 
     const int Sensor1Pin = A0;
     const int Sensor2Pin = A1;
     int Sensor1Data;
     int Sensor2Data;
     String AllCharMsg;
     char Sensor1CharMsg[4];
     char Sensor2CharMsg[4];  

    void setup()
       {
  
       pinMode(ledPin,OUTPUT);
      // Sensor(s)
       pinMode(Sensor1Pin,INPUT);
       pinMode(Sensor2Pin,INPUT);
 
       // for debugging
      Serial.begin(9600); 
 
       // VirtualWire setup
      vw_setup(2000);     // Bits per sec
     }

    void loop()
    {
  
     // Read and store Sensor 1 data
     Sensor1Data = analogRead(Sensor1Pin);
     Sensor2Data = analogRead(Sensor2Pin);
    
     // Convert integer data to Char array directly 
     itoa(Sensor1Data,Sensor1CharMsg,10);
     itoa(Sensor2Data,Sensor2CharMsg,10);
  
     // DEBUG
      Serial.print("Sensor1 Integer: ");
      Serial.print(Sensor1Data);
      Serial.print(" Sensor1 CharMsg: ");
      Serial.println(Sensor1CharMsg);
      delay(1000);
       Serial.println("....................... ");
      Serial.print("Sensor2 Integer: ");
      Serial.print(Sensor2Data);
      Serial.print(" Sensor2 CharMsg: ");
      Serial.print(Sensor2CharMsg);
      Serial.println(" ");
      delay(1000);
     // END DEBUG
 
    AllCharMsg = Sensor1CharMsg + ',' + Sensor2CharMsg;
    
    digitalWrite(7, true); // Turn on a light to show transmitting
    vw_send((uint8_t *)AllCharMsg, strlen(AllCharMsg));
    vw_wait_tx(); // Wait until the whole message is gone
    digitalWrite(7, false); // Turn off a light after transmission
    delay(200); 
 
    } // END void loop...
