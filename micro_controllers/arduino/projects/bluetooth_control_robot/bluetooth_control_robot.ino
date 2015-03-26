/*
 * Control DC motor with Smartphone via bluetooth
 * created by Rui Santos, http://randomnerdtutorials.com
*/

int motor1a = 8; 
int motor1b = 9; 
int motor2a = 10; 
int motor2b = 11; 
int state;
int flag =0; 
void setup() 
{
    // sets the pins as outputs:
    pinMode(motor1a, OUTPUT);
    pinMode(motor1b, OUTPUT);
    pinMode(motor2a, OUTPUT);
    pinMode(motor2b, OUTPUT);
    // sets digital pin low so that relay initially will off :
    digitalWrite(Relay1, LOW);
    digitalWrite(Relay2, LOW);
    // initialize serial communication at 9600 bits per second:
    Serial.begin(9600);
}
 
void loop() 
{
    //if some date is sent, reads it and saves in state
    if(Serial.available() > 0)
    {     
      state = Serial.read(); 
     Serial.println(state); 
      flag=0;
    }   
    // if the state is '0' the relay1 will turn off
    if (state == '0')
    {
        digitalWrite(Relay1, LOW);
         if(flag == 0)
        {
          Serial.println("Relay1: off");
          flag=1;
        }
         
    }
    // if the state is '1' the relay1 will turn on
    else if (state == '1') 
    {
        digitalWrite(Relay1, HIGH); 
           if(flag == 0)
        {
          Serial.println("Relay1: on");
          flag=1;
        }
        
    }
    // if the state is '2' the relay2 will turn off
    else if (state == '2') 
    {
        digitalWrite(Relay2, LOW); 
           if(flag == 0)
        {
          Serial.println("Relay2: off");
          flag=1;
        }
         
    }
    // if the state is '3' the relay2 will turn on
    else if (state == '3') 
    {
        digitalWrite(Relay2, HIGH); 
           if(flag == 0)
        {
          Serial.println("Relay2: on");
          flag=1;
        }
        delay(100); 
    }
 
    delay(100); 
    
}
