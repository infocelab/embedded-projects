#include <Servo.h>
Servo esc;
int throttle1=350;
int temp_throttle1=0;
 
  void setup()
  {
  esc.attach(9);
  Serial.begin(9600);
  }
 
    void loop()
    {
       char data = Serial.read();
        if( data == 'I')
         {
          if(throttle1 < 4000)
          throttle1= throttle1 + 30;
         }
     else if(data == 'D')
     {
         if(throttle1 > 300)
         throttle1= throttle1 - 30;
     }
      Serial.println(throttle1);
      delay(1000);
      Serial.println(".......................");
   
       temp_throttle1 = map(throttle1, 0, 1023, 0, 179);
       esc.write(temp_throttle1);
  }
