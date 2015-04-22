#include <VirtualWire.h>

    // LED's
    int ledPin = 7;
    int ref_value1=0;
    int ref_value2=0;
    int ref_value3=0;
    int ref_value4=0;

    // Sensors 

   int Sensor1Data;
   int Sensor2Data;
   int Sensor3Data;
   int Sensor4Data;

   int motor1_input1=8;
   int motor1_input2=9;
   int motor2_input1=10;
   int motor2_input2=12;
   int motor3_input1=8;
   int motor3_input2=9;
   int motor4_input1=10;
   int motor4_input2=12;

   char AllCharMsg[32];
   // RF Transmission container
   char Sensor1CharMsg[4];
   char Sensor2CharMsg[4]; 
   char Sensor3CharMsg[4];
   char Sensor4CharMsg[4]; 

   void setup() 
    {
    Serial.begin(9600);
  
    // sets the digital pin as output
    pinMode(ledPin, OUTPUT);   
    pinMode(motor1_input1, OUTPUT); 
    pinMode(motor1_input2, OUTPUT);      
    pinMode(motor2_input1, OUTPUT);      
    pinMode(motor2_input2, OUTPUT); 
 
    pinMode(motor3_input1, OUTPUT); 
    pinMode(motor3_input2, OUTPUT);      
    pinMode(motor4_input1, OUTPUT);      
    pinMode(motor4_input2, OUTPUT); 
 
  
  digitalWrite(motor1_input1, LOW); 
  digitalWrite(motor1_input2, LOW);    
  digitalWrite(motor2_input1, LOW);    
  digitalWrite(motor2_input2, LOW);    
  digitalWrite(motor3_input1, LOW); 
  digitalWrite(motor3_input2, LOW);    
  digitalWrite(motor4_input1, LOW);    
  digitalWrite(motor4_input2, LOW);    
    
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
          AllCharMsg[i] = char(buf[i]);
         }
        
        
        // Null terminate the char array
        // This needs to be done otherwise problems will occur
        // when the incoming messages has less digits than the
        // one before. 
        AllCharMsg[buflen] = '\0';
        
        // Read each command pair 
        char* command = strtok(AllCharMsg, "&");
        while (command != 0)
        {
          // Split the command in two values
          char* separator = strchr(command, ',');
          if (separator != 0)
          {
            // Actually split the string in 2: replace ':' with 0
            *separator = 0;
            Sensor1Data = atoi(command);
            ++separator;
            Sensor2Data = atoi(separator);
            ++separator;
            Sensor3Data = atoi(separator);
            ++separator;
            Sensor4Data = atoi(separator);

          // Do something with servoId and position
        }
        // Find the next command in input string
        command = strtok(0, "&");
      }

        
        // DEBUG 
        Serial.print("Sensor 1: ");
        Serial.println(Sensor1Data);
         Serial.print("Sensor 2: ");
        Serial.println(Sensor2Data);
          Serial.print("Sensor 3: ");
        Serial.println(Sensor3Data);
         Serial.print("Sensor 4: ");
        Serial.println(Sensor4Data);
     
        digitalWrite(7, false);
        if(abs(Sensor1Data - ref_value1) > 10)
        {
          if(Sensor1Data>ref_value1)
          {
            rotate_motor1_right();
            delay(3000);
            motor1_stop();
            ref_value1=Sensor1Data;
          }
          else if(Sensor1Data<ref_value1)
          {
            rotate_motor1_left();
            delay(3000);
            motor1_stop();
            ref_value1=Sensor1Data;
          }
        }      
        if(abs(Sensor2Data - ref_value2) > 10)
        {
          if(Sensor2Data>ref_value2)
          {
            rotate_motor2_right();
            delay(3000);
            motor2_stop();
            ref_value2=Sensor2Data;
          }
          else if(Sensor2Data<ref_value2)
          {
            rotate_motor2_left();
            delay(3000);
            motor2_stop();
            ref_value2=Sensor2Data;
          }
        }
     
     
        if(abs(Sensor3Data - ref_value3) > 10)
        {
          if(Sensor3Data>ref_value3)
          {
            rotate_motor3_right();
            delay(3000);
            motor3_stop();
            ref_value3=Sensor3Data;
          }
          else if(Sensor3Data<ref_value3)
          {
            rotate_motor3_left();
            delay(3000);
            motor3_stop();
            ref_value3=Sensor3Data;
          }
        }      
        if(abs(Sensor4Data - ref_value4) > 10)
        {
          if(Sensor4Data>ref_value4)
          {
            rotate_motor4_right();
            delay(3000);
            motor4_stop();
            ref_value4=Sensor4Data;
          }
          else if(Sensor4Data<ref_value4)
          {
            rotate_motor4_left();
            delay(3000);
            motor4_stop();
            ref_value4=Sensor4Data;
          }
        }
     }
}

void rotate_motor1_left()
{
 digitalWrite(motor1_input1, HIGH); 
 digitalWrite(motor1_input2, LOW); 
 delay(1000);
}
void rotate_motor1_right()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, HIGH); 
 delay(1000);
 }
 void rotate_motor2_left()
{
 digitalWrite(motor2_input1, HIGH); 
 digitalWrite(motor2_input2, LOW); 
 delay(1000);
}
void rotate_motor2_right()
{
 digitalWrite(motor2_input1, LOW); 
 digitalWrite(motor2_input2, HIGH); 
 delay(1000);
 }
 
 
 
void rotate_motor3_left()
{
 digitalWrite(motor3_input1, HIGH); 
 digitalWrite(motor3_input2, LOW); 
 delay(1000);
}
void rotate_motor3_right()
{
 digitalWrite(motor3_input1, LOW); 
 digitalWrite(motor3_input2, HIGH); 
 delay(1000);
 }
 void rotate_motor4_left()
{
 digitalWrite(motor4_input1, HIGH); 
 digitalWrite(motor4_input2, LOW); 
 delay(1000);
}
void rotate_motor4_right()
{
 digitalWrite(motor4_input1, LOW); 
 digitalWrite(motor4_input2, HIGH); 
 delay(1000);
 }
 
 void motor1_stop()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, LOW); 
 delay(1000);
}

 void motor2_stop()
{
 digitalWrite(motor2_input1, LOW); 
 digitalWrite(motor2_input2, LOW); 
 delay(1000);
}


 void motor3_stop()
{
 digitalWrite(motor3_input1, LOW); 
 digitalWrite(motor3_input2, LOW); 
 delay(1000);
}

 void motor4_stop()
{
 digitalWrite(motor4_input1, LOW); 
 digitalWrite(motor4_input2, LOW); 
 delay(1000);
}
