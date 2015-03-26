 
#include <Stepper.h>
 int leftsensor = A0; 
 int rightsensor = A1; 
 int val_diff = 100;
const int stepsPerRevolution = 20;  // change this to fit the number of steps per revolution

  Stepper myStepper(stepsPerRevolution, 9,10,11,12);            
 
void setup() 
{
  Serial.begin(9600);
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
  if ( abs(left - right) > val_diff && left > right)
  {  
     Serial.println("moving left");
   myStepper.step(-stepsPerRevolution);
  }
  else if ( abs(left - right) > val_diff && right > left)
  {
     Serial.println("moving right");
    myStepper.step(stepsPerRevolution);
  }
  delay(10000);  
}
 

