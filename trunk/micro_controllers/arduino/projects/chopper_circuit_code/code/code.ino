  #include <math.h>
  int pwm_pin1 = 5;               // set output pwm pin
  int pwm_pin2 = 6;               // set output pwm pin
 
  float t1=0;                    //Time period for switching of first MOSFET
  float t2=0;                       //Time period for switching of second MOSFET
 
  float f=40000;                      //variable for desired frequincy  
 
  float t1_on_percentage = 60;        //required percentage for which t1 shild turn on
  float t1_off_percentage;       //required percentage for which t1 shild turn off
  float t2_on_percentage = 15;        //required percentage for which t2 shild turn on
  float t2_off_percentage;       //required percentage for which t2 shild turn off
  
  float t1_on_time;              //Time for which first mosfet should on
  float t1_off_time;             //Time for which first mosfet should off
  float t2_on_time;              //Time for which second mosfet should on
  float t2_off_time;             //Time for which second mosfet should off
  
 
   void setup() 
    {
    Serial.begin(9600);
    pinMode(pwm_pin1, OUTPUT); // declare the pwmpin as an OUTPUT:
    pinMode(pwm_pin2, OUTPUT); // declare the pwmpin as an OUTPUT:
    t1=t2;
    t1=1/f ;
    t1=t1*1000000;
    Serial.print("Time period: ");
    Serial.print(t1,6);
    Serial.println("Us");
    
    t1_on_time = (t1*t1_on_percentage)/100;
    Serial.print("T1 on time:  ");
    Serial.print(t1_on_time,6);
    Serial.println("Us");
    
    t1_off_time = t1-t1_on_time;
    Serial.print("t1_off_time: ");
    Serial.print(t1_off_time,6);
    Serial.println("Us");
    
    t2_on_time = (t1_on_time*t2_on_percentage)/100;
    Serial.print("t2_on_time:   ");
    Serial.print(t2_on_time,6);
    Serial.println("Us");
    
    t2_off_time = t1-t2_on_time;
    Serial.print("t2_off_time: ");
    Serial.print(t2_off_time,6);
    Serial.println("Us");
    
   
    Serial.println("......................................");
    Serial.println("......................................");
    
    delay(1000);
    }
   void loop() 
   {
    digitalWrite(pwm_pin1,HIGH);
    delayMicroseconds(t1_on_time-t2_on_time);
    digitalWrite(pwm_pin2,HIGH);
    delayMicroseconds(t2_on_time);
    digitalWrite(pwm_pin1,LOW);
    digitalWrite(pwm_pin2,LOW);
    delayMicroseconds(t1_off_time);
   
  }
