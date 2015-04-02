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

const int stepsPerRevolution_rotate = 20;  // change this to fit the number of steps per revolution
const int stepsPerRevolution_nozzel = 15;  // change this to fit the number of steps per revolution
Stepper myStepper_rotate(stepsPerRevolution_rotate, 2,3,4,5);  
Stepper myStepper_nozzel(stepsPerRevolution_nozzel, 7,8,9,10);  

const int receive_pin = 12;
int led = 13;
int fan = 6;
//int pump = A0


void setup()
{
    delay(1000);
    Serial.begin(9600);
    pinMode(fan, OUTPUT);   
    digitalWrite(fan, HIGH); 
   
    pinMode(A0, OUTPUT);   
    digitalWrite(A0, HIGH); 
   
    myStepper_nozzel.setSpeed(30);
    myStepper_rotate.setSpeed(80);
    // Initialise the IO and ISR
    vw_set_rx_pin(receive_pin);
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_setup(2000);	 // Bits per sec
    vw_rx_start();       // Start the receiver PLL running
     pinMode(led, OUTPUT);   
     digitalWrite(led, LOW);
     delay(500); 
     
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
            case 'c': // home code
               clk();//for clockwise rotation of motor
               Serial.print("Clockwise rotation");
               break;
            case 'a': // home code
               aclk();
                Serial.print("Anticlockwise rotation");
               break;
             case 't': // home code
               top();//for clockwise rotation of motor
               Serial.print("top");
               break;
            case 'd': // home code
               bottom();
                Serial.print("bottom");
               break;
            case 's': // home code
               stp();
                Serial.print("stop");
              break;
              case 'm': // home code
               fan_motor();
                Serial.print("fan start");
              break;
              case 'p': // home code
               pump_on();
                Serial.print("pump start");
              break;
         } // end of switch

} //End of if loop
delay(1000);
}// end of loop
void clk()
{   
     Serial.println("clockwise");
     myStepper_rotate.step(stepsPerRevolution_rotate);
     delay(500); 
     void stp();
     delay(1000);
}
void aclk()
{
   
     Serial.println("anti-clockwise");
     myStepper_rotate.step(-stepsPerRevolution_rotate);
     delay(500); 
     void stp();
     delay(1000);
   
delay(1000);
}


void top()
{   
     Serial.println("top");
     myStepper_nozzel.step(stepsPerRevolution_nozzel);
     delay(500); 

}
void bottom()
{
   
     Serial.println("bottom");
     myStepper_nozzel.step(-stepsPerRevolution_nozzel);
     delay(500); 

}
void fan_motor()
{
   
     Serial.println("Fan on");
     digitalWrite(fan, LOW);
     delay(5000); 
      digitalWrite(fan, HIGH);
     delay(1000); 

}
void pump_on()
{
   
     Serial.println("pump start");
     digitalWrite(A0, LOW);
     delay(5000); 
      digitalWrite(A0, HIGH);
     delay(1000); 

}
void stp()
{ 
     myStepper_rotate.step(0);
     delay(1000);
}
