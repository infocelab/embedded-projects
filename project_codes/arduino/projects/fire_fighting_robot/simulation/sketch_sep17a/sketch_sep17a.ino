#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

const int groundpin = 18;
const int powerpin = 19;
int OUTPUT1 = 8;
int OUTPUT2 = 9;
int OUTPUT3 = 10;
int OUTPUT4 = 13;
const int xpin = A0;                  // x-axis of the accelerometer
const int ypin = A1;                  // y-axis
const int zpin = A2;                  // z-axis (only on 3-axis models)
int x_value = 512;
int y_value = 512;
int z_value = 512;
 
void setup()
{
  // initialize the serial communications:
  Serial.begin(9600);
  lcd.begin(16, 2);
  lcd.print("WELCOME RRS");
  lcd.setCursor(0, 0);

  pinMode(OUTPUT1, OUTPUT);
  pinMode(OUTPUT2, OUTPUT);
  pinMode(OUTPUT3, OUTPUT);
  pinMode(OUTPUT4, OUTPUT);
  
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
  Serial.print(x);
  Serial.print(",");
  Serial.print(y);
  Serial.print(",");
  Serial.print(z);
  Serial.println();
  if(abs(x - x_value) >= 20 && x > x_value)
  {
    lcd.clear();
    lcd.print("forward");
    fwd();
  }
  else if(abs(x - x_value) >= 20 && x < x_value)
  {
    lcd.clear();
    lcd.print("backward");
    bwk();
  }
  else if(abs(y - y_value) >= 20 && y > y_value)
  {
    lcd.clear();
    lcd.print("left");
    lft();
  }
  else if(abs(y - y_value) >= 20 && y < y_value)
  {
    lcd.clear();
    lcd.print("right");
    rgt();
  }
  else
  {
    lcd.clear();
    lcd.print("stop");
    stp();
  }
  delay(100);

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


