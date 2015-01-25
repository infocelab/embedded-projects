//RF Robot
int sw1 =2;
int sw2 =3;
int sw3 =4;
int sw4 =5;
int out1=8;
int out2=9;
int out3=10;
int out4=11;
void setup()
{
  Serial.begin(9600);
pinMode(sw1,INPUT);
pinMode(sw2,INPUT);
pinMode(sw3,INPUT);
pinMode(sw4,INPUT);
pinMode(out1,OUTPUT);
pinMode(out2,OUTPUT);
pinMode(out3,OUTPUT);
pinMode(out4,OUTPUT);
}
void loop()
{
  
if ((digitalRead(sw1)==LOW)&& (digitalRead(sw2)==HIGH) &&( digitalRead(sw3) == HIGH ) &&(digitalRead(sw4)==HIGH))
{
  Serial.println("fwd");
fwd();

}
else if ((digitalRead(sw1)==HIGH)&& (digitalRead(sw2)==LOW)&&(digitalRead(sw3)==HIGH)&&(digitalRead(sw4)==HIGH))
{
   Serial.println("bwd");
bwk();
}
else if ((digitalRead(sw1)==HIGH)&&(digitalRead(sw2)==HIGH)&&(digitalRead(sw3)==LOW)&&(digitalRead(sw4)==HIGH))
{
   Serial.println("left");
lft();
}
else if ((digitalRead(sw1)==HIGH)&& (digitalRead(sw2)==HIGH) &&(digitalRead(sw3)==HIGH)&&(digitalRead(sw4)==LOW))
{
   Serial.println("rgt");
rgt();
}
else
{ 
digitalWrite(out1,LOW);
digitalWrite(out2,LOW);
digitalWrite(out3,LOW);
digitalWrite(out4,LOW);

}
}
void fwd()
{ 
digitalWrite(out1,HIGH);
digitalWrite(out2,LOW);
digitalWrite(out3,HIGH);
digitalWrite(out4,LOW);
}
void bwk()
{ digitalWrite(out1,LOW);
digitalWrite(out2,HIGH);
digitalWrite(out3,LOW);
digitalWrite(out4,HIGH);
}
void lft()
{ digitalWrite(out1,LOW);
digitalWrite(out2,HIGH);
digitalWrite(out3,HIGH);
digitalWrite(out4,LOW);
}
void rgt()
{ digitalWrite(out1,HIGH);
digitalWrite(out2,LOW);
digitalWrite(out3,LOW);
digitalWrite(out4,HIGH);
}
