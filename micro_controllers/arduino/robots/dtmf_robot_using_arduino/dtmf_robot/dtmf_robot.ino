//RF Robot
//All Input Pin From DTMF Module to Arduino uno
int INPUT1 = 2;
int INPUT2 = 3;
int INPUT3 = 4;
int INPUT4 = 5;
//All Output Pin from Arduino to Motor Driver
int OUTPUT1 = 9;
int OUTPUT2 = 10;
int OUTPUT3 = 11;
int OUTPUT4 = 12;

void setup()
{
Serial.begin(9600);
pinMode(INPUT1, INPUT);
pinMode(INPUT2, INPUT);
pinMode(INPUT3, INPUT);
pinMode(INPUT4, INPUT);

pinMode(OUTPUT1, OUTPUT);
pinMode(OUTPUT2, OUTPUT);
pinMode(OUTPUT3, OUTPUT);
pinMode(OUTPUT4, OUTPUT);

digitalWrite(OUTPUT1, LOW);
digitalWrite(OUTPUT2, LOW);
digitalWrite(OUTPUT3, LOW);
digitalWrite(OUTPUT4, LOW);
}
void loop()
{
 
 if((digitalRead(INPUT1)==HIGH) && (digitalRead(INPUT2)==LOW)&&  (digitalRead(INPUT3)==LOW) && (digitalRead(INPUT4)==LOW))
   { 
      stp();
      delay(20);
      fwd();
     delay(100);
      
    }
    
 else if((digitalRead(INPUT1)==LOW) && (digitalRead(INPUT2)==HIGH)&&  (digitalRead(INPUT3)==LOW)&&  (digitalRead(INPUT4)==LOW))
 {
      stp();
      delay(20);
      bck();
      delay(100);
 }
  else if((digitalRead(INPUT1)==LOW) && (digitalRead(INPUT2)==LOW)&&  (digitalRead(INPUT3)==HIGH) && (digitalRead(INPUT4)==LOW))
 {
      stp();
      delay(20);
      lft();
      delay(100);
 }
  else if((digitalRead(INPUT1)==LOW) && (digitalRead(INPUT2)==LOW)&&  (digitalRead(INPUT3)==LOW) && (digitalRead(INPUT4)==HIGH))
 {
      stp();
      delay(20);
      rgt();
      delay(100);
 }
  else if((digitalRead(INPUT1)==HIGH) &&  (digitalRead(INPUT2)==HIGH) &&  (digitalRead(INPUT3)==LOW) &&  (digitalRead(INPUT4)==LOW))
 {
      stp();
      delay(100);
  }
}
void fwd()
{ 
digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,HIGH);
}

void bck()
{ 
digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,LOW);
}

void lft()
{ 
digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,LOW);
}
void rgt()
{ 
digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,HIGH);
}
void stp()
{ 
digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,LOW);
}
