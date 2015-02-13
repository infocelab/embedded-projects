#include<LiquidCrystal.h>
LiquidCrystal lcd(12,11,6,5,4,3);
int pwm=9;
int pot=A0;
float value=0;
int percent;
float rev=0;
int rpm;
int oldtime=0;
int time;

void isr() //interrupt service routine
{
rev++;
}

void setup()
{
lcd.begin(16,2);                //initialize LCD
attachInterrupt(0,isr,RISING);  //attaching the interrupt
}

void loop()
{
delay(1000);
detachInterrupt(0);           //detaches the interrupt
time=millis()-oldtime;        //finds the time 
rpm=(rev/time)*60000;         //calculates rpm
oldtime=millis();             //saves the current time
rev=0;
value=analogRead(pot);        //reads the speed control POT
value=value/4;
analogWrite(pwm,value);       //sets the desired speed
percent=(value/255)*100;      //finds the duty cycle %
lcd.clear();
lcd.setCursor(0,0);
lcd.print("___TACHOMETER___");
lcd.setCursor(0,1);
lcd.print(rpm);
lcd.print(" RPM");
lcd.print("   ");
lcd.print(percent);
lcd.print("%");
attachInterrupt(0,isr,RISING);

}
