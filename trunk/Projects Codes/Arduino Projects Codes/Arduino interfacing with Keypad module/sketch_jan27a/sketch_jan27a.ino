
int r1=6;
int r2=7;
int r3=8;
int r4=9;
int c1=10;
int c2=11;
int c3=12;
int c4=13;
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
  Serial.begin(9600);
  digitalWrite(c1,HIGH);
  digitalWrite(c2,HIGH);
  digitalWrite(c3,HIGH);
  digitalWrite(c4,HIGH);
}
void loop()
{
  digitalWrite(r1,LOW);
  digitalWrite(r2,HIGH);
  digitalWrite(r3,HIGH);
  digitalWrite(r4,HIGH);
  colm1=digitalRead(c1);
  colm2=digitalRead(c2);
  colm3=digitalRead(c3);
  colm4=digitalRead(c4);
  if(colm1==LOW)
  {Serial.println("1");
   delay(200);}
  else
  {
   if(colm2==LOW)
   {Serial.println("2");
    delay(200);}
   else
   {
   if(colm3==LOW)
   {Serial.println("3");
     delay(200);}
   else
   {
   if(colm4==LOW)
   {Serial.println("A");
      delay(200);}
   }}}

  digitalWrite(r1,HIGH);
  digitalWrite(r2,LOW);
  digitalWrite(r3,HIGH);
  digitalWrite(r4,HIGH);
  colm1=digitalRead(c1);
  colm2=digitalRead(c2);
  colm3=digitalRead(c3);
  colm4=digitalRead(c4);
  if(colm1==LOW)
  {Serial.println("4");
    delay(200);}
  else
  {
   if(colm2==LOW)
   {Serial.println("5");
    delay(200);}
   else
   {
   if(colm3==LOW)
   {Serial.println("6");
      delay(200);}
   else
   {
   if(colm4==LOW)
   {Serial.println("B");
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
  {Serial.println("7");
     delay(200);}
  else
  {
   if(colm2==LOW)
   {Serial.println("8");
       delay(200);}
   else
   {
   if(colm3==LOW)
   {Serial.println("9");
        delay(200);}
   else
   {
   if(colm4==LOW)
   {Serial.println("C");
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
  {Serial.println("*");
      delay(200);}
  else
  {
   if(colm2==LOW)
   {Serial.println("0");
        delay(200);}
   else
   {
   if(colm3==LOW)
   {Serial.println("#");
      delay(200);}
   else
   {
   if(colm4==LOW)
   {Serial.println("D");
       delay(200);}

   }}}

}
