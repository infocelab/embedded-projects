// Sweep
// by BARRAGAN <http://barraganstudio.com> 
// This example code is in the public domain.


#include <Servo.h> 
 
Servo myservo1;  // create servo object to control a servo 
Servo myservo2;                // a  of eight servo objects can be created 
 
int pos1 = 90;    // variable to store the servo position 
int pos2=90;

void setup() 
{ 
  Serial.begin(9600);
  myservo1.attach(9);  // attaches the servo on pin 9 to the servo object 
  myservo2.attach(10);
} 
 
 int step_size=15;
void loop() 
{ 

   char input = Serial.read();
 if(input == 'a') 
{
 pos1 = pos1+step_size; 
 }
 
 if(input == 'b') 
{
 pos1 = pos1-step_size; 
 }
 if(input == 'c') 
{
 pos2 = pos2+step_size; 
 }
 if(input == 'd') 
{
 pos2 = pos2-step_size; 
 }
 if(input == 'u') 
{
  pos1 = pos1-step_size; 
 pos2 = pos2+step_size; 
 }
 if(input == 'l') 
{
  pos1 = pos1+step_size;
 pos2 = pos2-step_size; 
 }
   Serial.print(pos1);
    Serial.print("  ");
    Serial.println(pos2);
    //Serial.println(pos);
  
    myservo1.write(pos1); 
    myservo2.write(pos2);     // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 

 /* for(pos = 0; pos < 90; pos += 1)  // goes from 0 degrees to 180 degrees 
  {                      // in steps of 1 degree 
    Serial.print("clock: "); 
    Serial.println(pos);
    myservo1.write(pos); 
     myservo2.write(-pos);     // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  } 
  for(pos = 90; pos>=1; pos-=1)     // goes from 180 degrees to 0 degrees 
  {
  Serial.print("Anticlock: "); 
    Serial.println(pos);
      
    myservo1.write(pos);
     myservo2.write(-pos);       // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  }*/ 
} 
