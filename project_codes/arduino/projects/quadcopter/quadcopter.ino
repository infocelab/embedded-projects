#include <Servo.h>
#include <SoftwareSerial.h>

SoftwareSerial mySerial(10, 11); // RX, TX
Servo esc1;
Servo esc2;
Servo esc3;
Servo esc4;
int throttlePin = 0;
int throttle1=400;
int throttle2=400;
int temp_throttle1=0;
int temp_throttle2=0;
void setup()
{
   esc1.attach(3);
   esc2.attach(5);
   //esc3.attach(6);
   //esc4.attach(9);
   Serial.begin(9600);
  // set the data rate for the SoftwareSerial port
 mySerial.begin(9600);
}
 
  void loop()
   {
   if (mySerial.available())
     {
    char data=mySerial.read();
    if( data == 'Z')
    {
      if(throttle1 < 4000)
        throttle1= throttle1 + 10;

      if(throttle2 < 4000)
        throttle2= throttle2 + 10;
      }
    else if(data == 'X')
    {
      if(throttle1 > 400)
        throttle1= throttle1 - 10;
      if(throttle2 > 400)
        throttle2= throttle2 - 10;
    }
    else if( data == 'C')
    {
      if(throttle1 < 4000)
        throttle1= throttle1 + 10;
     }
    else if(data == 'V')
    {
      if(throttle1 > 400)
        throttle1= throttle1 - 10;
    }
    else if( data == 'B')
    {
      if(throttle2 < 4000)
        throttle2= throttle2 + 10;
      }
    else if(data == 'N')
    {
      if(throttle2 > 400)
        throttle2= throttle2 - 10;
    }
    
    mySerial.print(throttle1);
    mySerial.print(",");
    mySerial.print(throttle2);
    mySerial.print(" ");
 
  }
  //throttle = analogRead(throttlePin);
  
//Serial.println(throttle);
temp_throttle1 = map(throttle1, 0, 1023, 0, 179);
esc1.write(temp_throttle1);
temp_throttle2 = map(throttle2, 0, 1023, 0, 179);
esc2.write(temp_throttle2);
}
