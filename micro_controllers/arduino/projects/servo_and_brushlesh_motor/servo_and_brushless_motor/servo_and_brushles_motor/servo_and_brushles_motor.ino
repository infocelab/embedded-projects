#include <Servo.h> 
Servo myservo;  // create servo object to control a servo 
                  // a maximum of eight servo objects can be created 
   
int pos = 0;    // variable to store the servo position 
Servo esc;
int throttle1=350;
int temp_throttle1=0;     

int INPUT1 = 2;
int INPUT2 = 3;
int INPUT3 = 4;
int INPUT4 = 5;

void setup()
{
Serial.begin(9600);
pinMode(INPUT1, INPUT);
pinMode(INPUT2, INPUT);
pinMode(INPUT3, INPUT);
pinMode(INPUT4, INPUT);

digitalWrite(INPUT1,HIGH);
digitalWrite(INPUT2,HIGH);
digitalWrite(INPUT3,HIGH);
digitalWrite(INPUT4  ,HIGH);

myservo.attach(9);  // attaches the servo on pin 9 to the servo object 
  esc.attach(8);
  Serial.begin(9600);
}
void loop()
{

     Serial.print(digitalRead(INPUT1));
   Serial.print(digitalRead(INPUT2));
   Serial.print(digitalRead(INPUT3));
   Serial.println(digitalRead(INPUT4));
   Serial.print(" T=");
   Serial.println(throttle1);
   
 if(digitalRead(INPUT1)==HIGH && digitalRead(INPUT2)==HIGH && digitalRead(INPUT3)==HIGH && digitalRead(INPUT4)==LOW )
   { 
     bldc_inc();
    }
    
 else if(digitalRead(INPUT1)==LOW && digitalRead(INPUT2)==HIGH && digitalRead(INPUT3)==HIGH && digitalRead(INPUT4)==HIGH )
 {
    bldc_dec();
 }
else if(digitalRead(INPUT1)==HIGH && digitalRead(INPUT2)==HIGH && digitalRead(INPUT3)==LOW && digitalRead(INPUT4)==HIGH )
 {
   servo_left();
 }
 else if(digitalRead(INPUT1)==HIGH && digitalRead(INPUT2)==LOW && digitalRead(INPUT3)==HIGH && digitalRead(INPUT4)==HIGH )
 {
   servo_right();
 }
}
void bldc_inc()
{
   Serial.println("bldc inc");
           if(throttle1 < 4000)
          throttle1= throttle1 + 10; 
               temp_throttle1 = map(throttle1, 0, 1023, 0, 179);
     esc.write(temp_throttle1);
     delay(500);
}
  
void bldc_dec()
{ 
  Serial.println("bldc dec");
         if(throttle1 > 300)
       throttle1= throttle1 - 10;
            temp_throttle1 = map(throttle1, 0, 1023, 0, 179);
     esc.write(temp_throttle1);
     delay(500);
}

void servo_left()
{ 
  Serial.println("servo left");
  pos += 10;
        myservo.write(pos);              // tell servo to go to position in variable 'pos' 
      delay(15);                       // waits 15ms for the servo to reach the position 
}
void servo_right()
{ 
  Serial.println("servo right");
    pos -= 10;
        myservo.write(pos);              // tell servo to go to position in variable 'pos' 
      delay(15);                       // waits 15ms for the servo to reach the position 
}

