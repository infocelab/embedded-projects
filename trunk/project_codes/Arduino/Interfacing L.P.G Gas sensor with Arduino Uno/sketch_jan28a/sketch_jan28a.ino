#include<LiquidCrystal.h>
int mq2=A0;
int rel=13;
int buz=10;
int d;
float p;

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void setup()
{
pinMode(rel,OUTPUT);
pinMode(buz,OUTPUT);
digitalWrite(rel,LOW);
digitalWrite(buz,LOW);
lcd.begin(16,2);
}
void loop()
{
d=analogRead(mq2);
lcd.setCursor(0,0);
lcd.print("LPG SENSOR");

if(d<60)
{
p=0;
}
else
{
p=(d-60)/9.64;
}
lcd.setCursor(0,1);
lcd.print(p);
lcd.setCursor(5,1);
lcd.print("%");
if(p>=30)
{
digitalWrite(rel,LOW);
digitalWrite(buz,HIGH);
lcd.setCursor(9,1);
lcd.print("TRIP");
}
else
{
digitalWrite(rel,HIGH);
digitalWrite(buz,LOW);
}
delay(500);
lcd.clear();
}
