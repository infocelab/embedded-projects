#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
int r1=7;
int r2=6;
int r3=5;
//int r4=4;
int c1=3;
int c2=2;
int c3=4;
//int c4=0;
int colm1;
int colm2;
int colm3;
int colm4;

void setup()
{
  pinMode(r1,OUTPUT);
  pinMode(r2,OUTPUT);
  pinMode(r3,OUTPUT);
  pinMode(r4,OUTPUT);
  pinMode(c1,INPUT);
  pinMode(c2,INPUT);
  pinMode(c3,INPUT);
  pinMode(c4,INPUT);
  
  digitalWrite(c1,HIGH);
  digitalWrite(c2,HIGH);
  digitalWrite(c3,HIGH);
  digitalWrite(c4,HIGH);
  lcd.begin(16, 2);
  lcd.print("keypad");
  delay(4000);
 // lcd.clear();
 //  lcd.setCursor(0, 1);
}
void loop()
{  
  lcd.clear();
  lcd.setCursor(0, 1);
  lcd.print("ENTER NO =");
  delay(200);
 

  digitalWrite(r1,LOW);
  digitalWrite(r2,HIGH);
  digitalWrite(r3,HIGH);
  digitalWrite(r4,HIGH);
  colm1=digitalRead(c1);
  colm2=digitalRead(c2);
  colm3=digitalRead(c3);
  colm4=digitalRead(c4);
  if(colm1==LOW)
 { 
   lcd.print("1");
   delay(200);}
  else 
  {
   if(colm2==LOW)
    {
    lcd.print("2");
    delay(200);}
   else
   {
   if(colm3==LOW)
    { 
   lcd.print("3");
     delay(200);}
   else
   {
   if(colm4==LOW)
  { 
    lcd.print("A");
      delay(200);}
   }
 }
 }

  digitalWrite(r1,HIGH);
  digitalWrite(r2,LOW);
  digitalWrite(r3,HIGH);
  digitalWrite(r4,HIGH);
  colm1=digitalRead(c1);
  colm2=digitalRead(c2);
  colm3=digitalRead(c3);
  colm4=digitalRead(c4);
  if(colm1==LOW)
  {lcd.print("4");
    delay(200);}
  else
  {
  if(colm2==LOW)
  {lcd.print("5");
    delay(200);}
   else
   {
   if(colm3==LOW)
   {lcd.print("6");
      delay(200);}
   else
   {
   if(colm4==LOW)
   {lcd.print("B");
       delay(200);}
   }}}

  digitalWrite(r1,HIGH);
  digitalWrite(r2,HIGH);
  digitalWrite(r3,LOW);
  digitalWrite(r4,HIGH);
  colm1=digitalRead(c1);
  colm2=digitalRead(c2);
  colm3=digitalRead(c3);
  colm4=digitalRead(c4);
  if(colm1==LOW)
 { lcd.print("7");
     delay(200);}
  else
  {
   if(colm2==LOW)
  {lcd.print("8");
       delay(200);}
   else
   {
   if(colm3==LOW)
 { lcd.print("9");
        delay(200);}
   else
   {
   if(colm4==LOW)
  {lcd.print("C");
        delay(200);}
   }}}
  digitalWrite(r1,HIGH);
  digitalWrite(r2,HIGH);
  digitalWrite(r3,HIGH);
  digitalWrite(r4,LOW);
  colm1=digitalRead(c1);
  colm2=digitalRead(c2);
  colm3=digitalRead(c3);
  colm4=digitalRead(c4);
  if(colm1==LOW)
  {lcd.print("*");
      delay(200);}
  else
  {
   if(colm2==LOW)
  {lcd.print("0");
        delay(200);}
   else
   {
   if(colm3==LOW)
{lcd.print("#");
      delay(200);}
   else
   {
   if(colm4==LOW)
  { lcd.print("D");
       delay(200);}

   }}}

}
