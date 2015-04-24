// receiver.pde
//
// Simple example of how to use VirtualWire to receive messages
// Implements a simplex (one-way) receiver with an Rx-B1 module
//
// See VirtualWire.h for detailed API docs
// Author: Mike McCauley (mikem@airspayce.com)
// Copyright (C) 2008 Mike McCauley
// $Id: receiver.pde,v 1.3 2009/03/30 00:07:24 mikem Exp $

#include <VirtualWire.h>
#include <Stepper.h>
const int stepsPerRevolution = 15;  // change this to fit the number of steps per revolution
Stepper myStepper(stepsPerRevolution, 2,3,4,5);            

const int receive_pin = 12;
int motor1_a = 7;
int motor1_b = 8;
int motor2_a = 9;
int motor2_b = 10;

int led = 13;

void setup()
{
    delay(1000);
    Serial.begin(9600);
    myStepper.setSpeed(80);
    // Initialise the IO and ISR
    vw_set_rx_pin(receive_pin);
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_setup(2000);	 // Bits per sec
    vw_rx_start();       // Start the receiver PLL running
    pinMode(motor1_a, OUTPUT);
    pinMode(motor1_b, OUTPUT);
    pinMode(motor2_a, OUTPUT);
    pinMode(motor2_b, OUTPUT);
    
    digitalWrite(motor1_a,LOW);
    digitalWrite(motor1_b,LOW);
    digitalWrite(motor2_a,LOW);
    digitalWrite(motor2_b,LOW);

     pinMode(led, OUTPUT);   
     digitalWrite(led, LOW);     
}


void loop()
{
    
    uint8_t buf[VW_MAX_MESSAGE_LEN];
    uint8_t buflen = VW_MAX_MESSAGE_LEN; 
  
  
  if (vw_get_message(buf, &buflen)) // Non-blocking
    {
        buf[buflen] = '\0';
        Serial.println((char *)buf);
          digitalWrite(led, HIGH);   // turn the LED on (HIGH is the voltage level)
          delay(500);               // wait for a second
          digitalWrite(led, LOW);    // turn the LED off by making the voltage LOW
          delay(500);    
           switch(buf[0])
           {
            case 'f': // home code
            
               fwd();
               Serial.print("forward");
               break;
            case 'b': // home code
               bwk();
                Serial.print("backward");
               break;
            case 'l': // home code
               lft();
                Serial.print("left");
              break;            
            case 'r': // home code
               rgt();
                Serial.print("right");
              break;
            case 's': // home code
               stp();
                Serial.print("stop");
              break;
               case '1': // home code
               cntl();
                Serial.print("center from left");
               break;
               case '2': // home code
               cntr();
                Serial.print("center from right");
               break;
          
         } // end of switch

} //End of if loop
delay(1000);
}// end of loop
void fwd()
{   
     digitalWrite(motor1_a,HIGH);
     digitalWrite(motor1_b,LOW);
     digitalWrite(motor2_a,HIGH);
     digitalWrite(motor2_b,LOW);
delay(1000);
}
void bwk()
{
    digitalWrite(motor1_a,LOW);
    digitalWrite(motor1_b,HIGH);
    digitalWrite(motor2_a,LOW);
    digitalWrite(motor2_b,HIGH);
delay(1000);
}
void lft()
{ 
     delay(500);
     digitalWrite(motor1_a,HIGH);
     digitalWrite(motor1_b,LOW);
     digitalWrite(motor2_a,HIGH);
     digitalWrite(motor2_b,LOW);
     Serial.println("clockwise");
     myStepper.step(stepsPerRevolution);
     delay(1000);
    
}
void rgt()
{
      delay(500); 
      digitalWrite(motor1_a,HIGH);
      digitalWrite(motor1_b,LOW);
      digitalWrite(motor2_a,HIGH);
      digitalWrite(motor2_b,LOW);
      Serial.println("counterclockwise");
       myStepper.step(-stepsPerRevolution);
      delay(1000); 
}
void stp()
{ 
    delay(500); 
    digitalWrite(motor1_a,LOW);
    digitalWrite(motor1_b,LOW);
    digitalWrite(motor2_a,LOW);
    digitalWrite(motor2_b,LOW);
    myStepper.step(0);
   delay(1000);
}
   void cntl()
   {
     myStepper.step(-stepsPerRevolution/2);   // for come back the wheel in straight position
     delay(1000);
   }
    void cntr()
   {
     myStepper.step(stepsPerRevolution/2);   // for come back the wheel in straight position
     delay(1000);
   }
