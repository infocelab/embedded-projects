#include <VirtualWire.h>
const int ledPin = 7;
     
// Sensors 
const int Sensor1Pin = A0;
const int Sensor2Pin = A1;
const int Sensor3Pin = A2;
const int Sensor4Pin = A3;

     int Sensor1Data;
     int Sensor2Data;
     int Sensor3Data;
     int Sensor4Data;
 
     String AllCharMsg;
     char Sensor1CharMsg[4];
     char Sensor2CharMsg[4];  
     char Sensor3CharMsg[4];
     char Sensor4CharMsg[4];  

char arr[32];

    void setup()
       {
  
       pinMode(ledPin,OUTPUT);
      // Sensor(s)
       pinMode(Sensor1Pin,INPUT);
       pinMode(Sensor2Pin,INPUT);
       pinMode(Sensor3Pin,INPUT);
       pinMode(Sensor4Pin,INPUT);
 
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
     Sensor3Data = analogRead(Sensor3Pin);
     Sensor4Data = analogRead(Sensor4Pin);
    
     // Convert integer data to Char array directly 
     itoa(Sensor1Data,Sensor1CharMsg,10);
     itoa(Sensor2Data,Sensor2CharMsg,10);
     itoa(Sensor3Data,Sensor3CharMsg,10);
     itoa(Sensor4Data,Sensor4CharMsg,10);
  
     // DEBUG
      Serial.print("Sensor1 Integer: ");
      Serial.print(Sensor1Data);
      Serial.print(" Sensor1 CharMsg: ");
      Serial.println(Sensor1CharMsg);
      Serial.println("....................... ");
      Serial.print("Sensor2 Integer: ");
      Serial.print(Sensor2Data);
      Serial.print(" Sensor2 CharMsg: ");
      Serial.print(Sensor2CharMsg);
      Serial.println(" ");
      Serial.println("....................... ");
      Serial.print("Sensor3 Integer: ");
      Serial.print(Sensor3Data);
      Serial.print(" Sensor3 CharMsg: ");
      Serial.print(Sensor3CharMsg);
      Serial.println(" ");
      Serial.println("....................... ");
      Serial.print("Sensor4 Integer: ");
      Serial.print(Sensor4Data);
      Serial.print(" Sensor4 CharMsg: ");
      Serial.print(Sensor4CharMsg);
      Serial.println(" ");
      delay(2000);
     
     // END DEBUG
    
    AllCharMsg = (String)Sensor1CharMsg + (String)',' + (String)Sensor2CharMsg + (String)',' + (String)Sensor3CharMsg + (String)',' + (String)Sensor4CharMsg + (String)'&';
    AllCharMsg.toCharArray(arr,32);
    digitalWrite(7, true); // Turn on a light to show transmitting
    vw_send((uint8_t *)arr, strlen(arr));
    vw_wait_tx(); // Wait until the whole message is gone
    digitalWrite(7, false); // Turn off a light after transmission
    delay(200); 
 
    } // END void loop...
