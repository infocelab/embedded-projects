/*
 ADXL3xx
 
 Reads an Analog Devices ADXL3xx accelerometer and communicates the
 acceleration to the computer.  The pins used are designed to be easily
 compatible with the breakout boards from Sparkfun, available from:
 http://www.sparkfun.com/commerce/categories.php?c=80

 http://www.arduino.cc/en/Tutorial/ADXL3xx

 The circuit:
 analog 0: accelerometer self test
 analog 1: z-axis
 analog 2: y-axis
 analog 3: x-axis
 analog 4: ground
 analog 5: vcc
 
 created 2 Jul 2008
 by David A. Mellis
 modified 30 Aug 2011
 by Tom Igoe 
 
 This example code is in the public domain.

*/

// these constants describe the pins. They won't change:
const int groundpin = 18;             // analog input pin 4 -- ground
const int powerpin = 19;
int OUTPUT1 = 8;
int OUTPUT2 = 9;
int OUTPUT3 = 10;
int OUTPUT4 = 11;
const int xpin = A3;                  // x-axis of the accelerometer
const int ypin = A2;                  // y-axis
const int zpin = A1;                  // z-axis (only on 3-axis models)

void setup()
{
  // initialize the serial communications:
  Serial.begin(9600);
  pinMode(OUTPUT1, OUTPUT);
  pinMode(OUTPUT2, OUTPUT);
  pinMode(OUTPUT3, OUTPUT);
  pinMode(OUTPUT4, OUTPUT);
  
  // Provide ground and power by using the analog inputs as normal
  // digital pins.  This makes it possible to directly connect the
  // breakout board to the Arduino.  If you use the normal 5V and
  // GND pins on the Arduino, you can remove these lines.
  pinMode(groundpin, OUTPUT);
  pinMode(powerpin, OUTPUT);
  digitalWrite(OUTPUT1, HIGH);
  digitalWrite(OUTPUT2, HIGH);
  digitalWrite(OUTPUT3, HIGH);
  digitalWrite(OUTPUT4, HIGH);
  digitalWrite(groundpin, LOW); 
  digitalWrite(powerpin, HIGH);
}

void loop()
{
  int x = analogRead(xpin);
  int y = analogRead(ypin);
  int z = analogRead(zpin);
  // print the sensor values:
  Serial.print(analogRead(xpin));
  // print a tab between values:
  Serial.print("\t");
  Serial.print(analogRead(ypin));
  // print a tab between values:
  Serial.print("\t");
  Serial.print(analogRead(zpin));
  Serial.println();
  // delay before next reading:
  delay(100);
  
  int x_value = 353;
  int y_value = 352;
  int z_value = 475;
     
     if( (abs(y - y_value)) > 20 && (abs(y - y_value)) < 50)
      {
            Serial.println("fwd");
              stp();
              fwd();
             delay(100);
      } 
            else if( (abs(y - y_value)) > 50)
                {
                  Serial.println("bwk");
                  stp();
                  bwk();
                 delay(100);
                }
                
                  else if( (abs(x - x_value)) > 45 && (abs(x - x_value)) < 55)
                {
                  Serial.println("lft");
                  stp();
                  lft();
                   delay(60);
                }
                
                  else if( (abs(x - x_value)) > 55)
                {
                   Serial.println("rgt");
                   stp();
                   rgt();
                   delay(60);
                }
           
      else
        {
          Serial.println("Stp");
           stp();
          delay(100);
         }
}

void fwd()
{ 
digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,LOW);
}
void bwk()
{ digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,HIGH);
}
void lft()
{ digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,LOW);
}
void rgt()
{ digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,HIGH);
}
void stp()
{ digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,HIGH);
}


