 int leftsensor = A3; 
 int rightsensor = A4; 
 int motor_driver_D0=8;
 int motor_driver_D1=9;  

 int val_diff = 100;
 
void setup() 
{
  Serial.begin(9600);
  pinMode(leftsensor, INPUT);
  pinMode(rightsensor, INPUT);
  
  pinMode(motor_driver_D0, OUTPUT);
  pinMode(motor_driver_D1, OUTPUT);
  
  digitalWrite(motor_driver_D0,LOW);
  digitalWrite(motor_driver_D1,LOW);
  
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
     Serial.println("moving start");
    digitalWrite(motor_driver_D0,HIGH);
     digitalWrite(motor_driver_D1,LOW);
     delay(500);
  }
  else if ( abs(left - right) > val_diff && right > left)
  {
     Serial.println("moving start");
     digitalWrite(motor_driver_D1,HIGH);
     digitalWrite(motor_driver_D0,LOW);
     delay(500);
  }
  else
  {
    Serial.println("stop");
    stop_rotation();
    delay(500);
  }
  
}
void stop_rotation()
{
   digitalWrite(motor_driver_D0,LOW);
   digitalWrite(motor_driver_D1,LOW);
   delay(500);
}
 

