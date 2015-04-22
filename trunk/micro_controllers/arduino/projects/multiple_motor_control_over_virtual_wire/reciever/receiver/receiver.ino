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
   int motor3_input1=4;
   int motor3_input2=5;
   int motor4_input1=6;
   int motor4_input2=7;
 
   int dd=500;
 
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
motor1_stop();
motor2_stop();
motor3_stop();
motor4_stop();


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
        
        
        AllCharMsg[buflen] = '\0';
        Serial.println(AllCharMsg);
        
        char* command = strtok(AllCharMsg, ",");
         Sensor1Data = atoi(command);
        int h=0;
        while (command != NULL)
        {
          command = strtok(NULL,",");
          if(h == 0)
          Sensor2Data = atoi(command);
          if(h == 1)
          Sensor3Data = atoi(command);
          
          if(h == 2)
          Sensor4Data = atoi(command);
          
          h++;
        }
 
        
        // DEBUG 
        /*
        Serial.print("Sensor 1: ");
        Serial.print(Sensor1Data);
         Serial.print("  Sensor 2: ");
        Serial.print(Sensor2Data);
          Serial.print("  Sensor 3: ");
        Serial.print(Sensor3Data);
         Serial.print("  Sensor 4: ");
        Serial.println(Sensor4Data);
     */
        digitalWrite(7, false);
        if(abs(Sensor1Data - ref_value1) > 10)
        {
          if(Sensor1Data>ref_value1)
          {
            rotate_motor1_right();
            delay(dd);
            motor1_stop();
            ref_value1=Sensor1Data;
          }
          else if(Sensor1Data<ref_value1)
          {
            rotate_motor1_left();
            delay(dd);
            motor1_stop();
            ref_value1=Sensor1Data;
          }
        }      
        if(abs(Sensor2Data - ref_value2) > 10)
        {
          if(Sensor2Data>ref_value2)
          {
            rotate_motor2_right();
            delay(dd);
            motor2_stop();
            ref_value2=Sensor2Data;
          }
          else if(Sensor2Data<ref_value2)
          {
            rotate_motor2_left();
            delay(dd);
            motor2_stop();
            ref_value2=Sensor2Data;
          }
        }
     
     
        if(abs(Sensor3Data - ref_value3) > 10)
        {
          if(Sensor3Data>ref_value3)
          {
            rotate_motor3_right();
            delay(dd);
            motor3_stop();
            ref_value3=Sensor3Data;
          }
          else if(Sensor3Data<ref_value3)
          {
            rotate_motor3_left();
            delay(dd);
            motor3_stop();
            ref_value3=Sensor3Data;
          }
        }      
        if(abs(Sensor4Data - ref_value4) > 10)
        {
          Serial.println("===============");
          if(Sensor4Data>ref_value4)
          {
            rotate_motor4_right();
            delay(dd);
            motor4_stop();
            ref_value4=Sensor4Data;
          }
          else if(Sensor4Data<ref_value4)
          {
            rotate_motor4_left();
            delay(dd);
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
}
void rotate_motor1_right()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, HIGH); 
 }
 void rotate_motor2_left()
{
 digitalWrite(motor2_input1, HIGH); 
 digitalWrite(motor2_input2, LOW); 
}
void rotate_motor2_right()
{
 digitalWrite(motor2_input1, LOW); 
 digitalWrite(motor2_input2, HIGH); 
 }
 
 
 
void rotate_motor3_left()
{
 digitalWrite(motor3_input1, HIGH); 
 digitalWrite(motor3_input2, LOW); 
}
void rotate_motor3_right()
{
 digitalWrite(motor3_input1, LOW); 
 digitalWrite(motor3_input2, HIGH); 
 }
 void rotate_motor4_left()
{
 digitalWrite(motor4_input1, HIGH); 
 digitalWrite(motor4_input2, LOW); 
}
void rotate_motor4_right()
{
 digitalWrite(motor4_input1, LOW); 
 digitalWrite(motor4_input2, HIGH); 
 }
 
 void motor1_stop()
{
 digitalWrite(motor1_input1, LOW); 
 digitalWrite(motor1_input2, LOW); 
 delay(500);
}

 void motor2_stop()
{
 digitalWrite(motor2_input1, LOW); 
 digitalWrite(motor2_input2, LOW); 
 delay(500);
}


 void motor3_stop()
{
 digitalWrite(motor3_input1, LOW); 
 digitalWrite(motor3_input2, LOW); 
 delay(500);
}

 void motor4_stop()
{
 digitalWrite(motor4_input1, LOW); 
 digitalWrite(motor4_input2, LOW); 
 delay(500);
}
