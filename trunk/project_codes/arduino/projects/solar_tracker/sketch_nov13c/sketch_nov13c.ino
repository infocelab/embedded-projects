/* 
 Stepper Motor example
  
 This program drives a bipolar or unipolar stepper motor. 
 The motor is attached to digital pins 2 - 5 of the Arduino.
  
 If the button attached to A0 is pressed the motor should revolve one revolution in one direction,
 while if the button attached to A1 is pressed then one revolution in the other direction.  
  
 Author: Arturo Guadalupi <a.guadalupi@arduino.cc> 
 */
 
#include <Stepper.h>
 int leftsensor = 5; 
 int rightsensor = 6; 
 
const int stepsPerRevolution = 20;  // change this to fit the number of steps per revolution
// for your motor
 
// initialize the stepper library on pins 2 through 5:

Stepper myStepper(stepsPerRevolution, 9,10,11,12);            
 
void setup() 
{
  Serial.begin(9600);
  // set the speed at 10 rpm:
  myStepper.setSpeed(5);
  pinMode(leftsensor, INPUT);
  pinMode(rightsensor, INPUT);
  digitalWrite(leftsensor,LOW);
  digitalWrite(rightsensor,LOW);
  delay(50);
}
 
void loop() 
{
  if (digitalRead(leftsensor) == HIGH)
  {
    // step one revolution  in one direction:
   // myStepper.step(stepsPerRevolution);
   myStepper.step(3);
   delay(100);
  }
 
 
  if (digitalRead(rightsensor) == HIGH)
  {
    myStepper.step(-3);
   delay(100);
    // step one revolution in the other direction:
   // myStepper.step(-stepsPerRevolution);
  }
  //Note that + stands for clockwise while - for counterclockwise 
}
 

