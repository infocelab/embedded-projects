  #include <math.h>
  int pwm_pin1 = 5;               // set output pwm pin
  int pwm_pin2 = 6;               // set output pwm pin
  int reference_value = 512; 
  float t1=0;                    //Time period for switching of first MOSFET
  float t2=0;                       //Time period for switching of second MOSFET
 
  float f=40000;                      //variable for desired frequincy  
 
  float t1_on_percentage = 50;        //required percentage for which t1 shild turn on
  float t1_off_percentage;       //required percentage for which t1 shild turn off
  float t2_on_percentage = 14;        //required percentage for which t2 shild turn on
  float t2_off_percentage;       //required percentage for which t2 shild turn off
  
  float t1_on_time;               //Time for which first mosfet should on
  float t1_off_time;             //Time for which first mosfet should off
  float t2_on_time;              //Time for which second mosfet should on
  float t2_off_time;             //Time for which second mosfet should off
  
 
   void setup() 
    {
    Serial.begin(9600);
    pinMode(pwm_pin1, OUTPUT); // declare the pwmpin as an OUTPUT:
    pinMode(pwm_pin2, OUTPUT); // declare the pwmpin as an OUTPUT:
    t1=1/f ;
    t2=t1;
    Serial.print("Time period: ");
    Serial.print(t1,8);
    Serial.println("Us");
    
    t1_on_time = (t1*t1_on_percentage)/100;
    Serial.print("T1 on time:  ");
    Serial.print(t1_on_time,8);
    Serial.println("Us");
    
    t1_off_time = t1-t1_on_time;
    Serial.print("t1_off_time: ");
    Serial.print(t1_off_time,8);
    Serial.println("Us");
    
    t2_on_time = (t2*t2_on_percentage)/100;
    Serial.print("t2_on_time:   ");
    Serial.print(t2_on_time,8);
    Serial.println("Us");
    
    t2_off_time = t2-t2_on_time;
    Serial.print("t2_off_time: ");
    Serial.print(t2_off_time,8);
    Serial.println("Us");
    
   
    Serial.println("......................................");
    Serial.println("......................................");
    delay(1000);
    }
   void loop() 
   {
    int voltage = analogRead(A0);
    Serial.println(voltage);
    Serial.print("previous value :");
    Serial.println(t1_on_time,8);
    if(voltage>reference_value)
    {
        t1_on_time = t1_on_time - 0.0000005     ;
        Serial.print("new value      :");
        Serial.println(t1_on_time,8);  
    }
    else if(voltage<reference_value)
    {
      t1_on_time = (t1_on_time +  0.0000005);
    }
    else if(voltage==reference_value)
    {
    }
    digitalWrite(pwm_pin1,LOW);
    delayMicroseconds(t1_on_time-t2_on_time);
    digitalWrite(pwm_pin2,LOW);
    delayMicroseconds(t2_on_time);
    digitalWrite(pwm_pin1,HIGH);
    digitalWrite(pwm_pin2,HIGH);
    delayMicroseconds(t1_off_time);
  
  }
