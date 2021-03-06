#include <LiquidCrystal.h>

int vcc=A0;
int sensor=A1;
int gnd=A2;
float temp;
float tempf;
int fan=2;
int heater=3;
int value =0;
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  pinMode(vcc,OUTPUT);
  pinMode(sensor,INPUT);
  pinMode(gnd,OUTPUT);
  pinMode(fan,OUTPUT);
  pinMode(heater,OUTPUT);
  digitalWrite(vcc,HIGH);   // Vcc for LM35
  digitalWrite(gnd,LOW);    // Ground for LM35
  digitalWrite(fan,HIGH); 
  digitalWrite(heater,HIGH); 
  lcd.begin(16, 2);         // initializes the 16x2 LCD
  lcd.setCursor(0,0);       // sets the cursor at column 2 row 0
  lcd.print("TEME RAJNEESH:"); // prints temperature
}

void loop()
{

  temp=analogRead(sensor); // reads the sensor output
  temp=temp*5;             // converts the sensor reading to temperature
  temp=temp/10;            // adds the decimal point
  tempf=(temp*1.8)+32;     // converts to Fahrenheit 

  lcd.setCursor(0,1);   // sets cursor at column 0 row 1
  lcd.print(temp);      // prints temperature in degree Celsius
  lcd.print((char)223); // prints degree sign
  lcd.print("C");       // prints letter c
  delay(5000); 
  if(temp>40)
  {
    digitalWrite(fan,LOW); 
    digitalWrite(heater,HIGH); 
    lcd.clear();
    lcd.setCursor(2,0);       // sets the cursor at column 2 row 0
    lcd.print("Fan on"); 
    delay(100);  
  }
  else if(temp<40)
  {
    digitalWrite(heater,LOW); 
    digitalWrite(fan,HIGH); 
    lcd.clear();
    lcd.setCursor(2,0);       // sets the cursor at column 2 row 0
    lcd.print("heater on"); 
    delay(100);
  }
  else if(temp==40)
  {
    digitalWrite(heater,HIGH); 
    digitalWrite(fan,HIGH); 
    lcd.clear();
    lcd.setCursor(2,0);       // sets the cursor at column 2 row 0
    lcd.print("heater,fan off"); 
    delay(100);
  }
  delay(1000);          // 1 second delay
}
