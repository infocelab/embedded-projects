#include <VirtualWire.h>

    // LED's
    int ledPin = 7;
    int ref_value1=0;
    int ref_value2=0;
    // Sensors 
   int Sensor1Data;
   int Sensor2Data;
   int motor1_input1=8;
   int motor1_input2=9;
   int motor2_input3=10;
   int motor2_input4=12;

   // RF Transmission container
   char Sensor1CharMsg[4];
   char Sensor2CharMsg[4]; 

   void setup() 
    {
    Serial.begin(9600);
  
    // sets the digital pin as output
    pinMode(ledPin, OUTPUT);   
    pinMode(motor1_input1, OUTPUT); 
    pinMode(motor1_input2, OUTPUT);      
    pinMode(motor2_input3, OUTPUT);      
    pinMode(motor2_input4, OUTPUT); 
  
  digitalWrite(motor1_input1, LOW); 
  digitalWrite(motor1_input2, LOW);    
  digitalWrite(motor2_input3, LOW);    
  digitalWrite(motor2_input4, LOW);    
    
    // VirtualWire 
    // Initialise the IO and ISR
    // Required for DR3100
    vw_set_ptt_inverted(true); 
    // Bits per sec
    vw_setup(2000);     
    
    // Start the receiver PLL running
    vw_rx_start();       

} // END void setup

    void loop()
      {
    uint8_t buf[VW_MAX_MESSAGE_LEN];
    uint8_t buflen = VW_MAX_MESSAGE_LEN;
    
    // Non-blocking
    if (vw_get_message(buf, &buflen)) 
    {
    int i;
        // Turn on a light to show received good message 
        digitalWrite(7, true); 
    
        // Message with a good checksum received, dump it. 
        for (i = 0; i < buflen; i++)
         {            
          // Fill Sensor1CharMsg Char array with corresponding 
          // chars from buffer.   
          Sensor1CharMsg[i] = char(buf[i]);
         }
        
        // Null terminate the char array
        // This needs to be done otherwise problems will occur
        // when the incoming messages has less digits than the
        // one before. 
        Sensor1CharMsg[buflen] = '\0';
        
        // Convert Sensor1CharMsg Char array to integer
        Sensor1Data = atoi(Sensor1CharMsg);
        Sensor2Data = atoi(Sensor2CharMsg);
        
        // DEBUG 
        Serial.print("Sensor 1: ");
        Serial.println(Sensor1Data);
         Serial.print("Sensor 2: ");
        Serial.println(Sensor2Data);
        digitalWrite(7, false);
        if(abs(Sensor1Data - ref_value1) > 10)
        {
          if(Sensor1Data>ref_value1)
          {
            rotate_motor1_right();
            delay(3000);
            motor_stop();
            ref_value1=Sensor1Data;
          }
          else if(Sensor1Data<ref_value1)
          {
            rotate_motor1_left();
            delay(3000);
            motor_stop();
            ref_value1=Sensor1Data;
          }
        
          else if(abs(Sensor2Data - ref_value2) > 10)
        {
          if(Sensor2Data>ref_value2)
          {
            rotate_motor2_right();
            delay(3000);
            motor_stop();
            ref_value2=Sensor2Data;
          }
          else if(Sensor2Data<ref_value2)
          {
            rotate_motor2_left();
            delay(3000);
            motor_stop();
            ref_value2=Sensor2Data;
          }
        }
        }
    }
}
void rotate_motor1_left()
{
 digitalWrite(motor1_input1, HIGH); 
 digitalWrite(motor1_input2, LOW); 
 digitalWrite(motor2_input3, LOW); 
 digitalWrite(motor2_input4, LOW); 
 delay(1000);
}
void rotate_motor1_right()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, HIGH); 
 digitalWrite(motor2_input3, LOW); 
 digitalWrite(motor2_input4, LOW); 
 delay(1000);
 }
 void rotate_motor2_left()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, LOW); 
 digitalWrite(motor2_input3, HIGH); 
 digitalWrite(motor2_input4, LOW); 
 delay(1000);
}
void rotate_motor2_right()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, LOW); 
 digitalWrite(motor2_input3, LOW); 
 digitalWrite(motor2_input4, HIGH); 
 delay(1000);
 }
 void motor_stop()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, LOW); 
 digitalWrite(motor2_input3, LOW); 
 digitalWrite(motor2_input4, LOW); 
 delay(1000);
}
