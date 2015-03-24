/* 
 Stepper Motor example
  
 This program drives a bipolar or unipolar stepper motor. 
 The motor is attached to digital pins 2 - 5 of the Arduino.
  
 If the button attached to A0 is pressed the motor should revolve one revolution in one direction,
 while if the button attached to A1 is pressed then one revolution in the other direction.  
  
 Author: Arturo Guadalupi <a.guadalupi@arduino.cc> 
 */
 
#include <Stepper.h>
 int leftsensor = A0; 
 int rightsensor = A1; 
 
const int stepsPerRevolution = 20;  // change this to fit the number of steps per revolution
// for your motor
 
// initialize the stepper library on pins 2 through 5:
int stepCount = 0;
  Stepper myStepper(stepsPerRevolution, 9,10,11,12);            
 
void setup() 
{
  Serial.begin(9600);
  // set the speed at 10 rpm:
  myStepper.setSpeed(60);
  pinMode(leftsensor, INPUT);
  pinMode(rightsensor, INPUT);
  digitalWrite(leftsensor,LOW);
  digitalWrite(rightsensor,LOW);
  delay(50);
}
 
void loop() 
{
  int left= analogRead(leftsensor);
  int right= analogRead(rightsensor);
  Serial.print("Left Sensor:");
  Serial.print(left);
  Serial.print("     Right Sensor:");
  Serial.println(analogRead(rightsensor));

  delay(1000);
  if ( abs(left - right) > 30 && left > right)
  {  
     Serial.println("moving left");
   myStepper.step(-stepsPerRevolution);
  }
  else if ( abs(left - right) > 30 && right > left)
  {
     Serial.println("moving right");
    myStepper.step(stepsPerRevolution);
  }
     delay(500);  
}
 

