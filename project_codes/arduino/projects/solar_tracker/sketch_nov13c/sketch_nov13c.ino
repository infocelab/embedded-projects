/* 
 Stepper Motor example
  
 This program drives a bipolar or unipolar stepper motor. 
 The motor is attached to digital pins 2 - 5 of the Arduino.
  
 If the button attached to A0 is pressed the motor should revolve one revolution in one direction,
 while if the button attached to A1 is pressed then one revolution in the other direction.  
  
 Author: Arturo Guadalupi <a.guadalupi@arduino.cc> 
 */
 
#include <Stepper.h>
 
const int stepsPerRevolution = 300;  // change this to fit the number of steps per revolution
// for your motor
 
// initialize the stepper library on pins 2 through 5:

Stepper myStepper(stepsPerRevolution, 8,9,10,11);            
 
void setup() 
{
  Serial.begin(9600);
  // set the speed at 10 rpm:
  myStepper.setSpeed(10);
  pinMode(A0, INPUT);
  pinMode(A1, INPUT);
  digitalWrite(A0,HIGH);
  digitalWrite(A1,HIGH);
}
 
void loop() 
{
  if (digitalRead(A0) == LOW)
  {
    // step one revolution  in one direction:
   // myStepper.step(stepsPerRevolution);
   myStepper.step(5);
   delay(500);
  }
 
 
  if (digitalRead(A1) == LOW)
  {
    myStepper.step(-5);
   delay(500);
    // step one revolution in the other direction:
   // myStepper.step(-stepsPerRevolution);
  }
  //Note that + stands for clockwise while - for counterclockwise 
}
 

