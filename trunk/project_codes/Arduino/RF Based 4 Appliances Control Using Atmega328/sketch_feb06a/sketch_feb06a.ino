//RF Robot
//All Input Pin To Each Individual Appliances
int sw1 =2;
int sw2 =3;
int sw3 =4;
int sw4 =5;
//All Output Pin To Each individual relays
int out1=8;
int out2=9;
int out1=10;
int out2=11;
//Variables To Hold The Output Signals
int relay1=0;
int relay2=0;
int relay3=0;
int relay4=0;

void setup()
{
Serial.begin(9600);
pinMode(sw1,INPUT);
pinMode(sw2,INPUT);
pinMode(out1,OUTPUT);
pinMode(out2,OUTPUT);

}
void loop()
{
 
   if((digitalRead(sw1)==LOW))
     {
      if(relay1==0)
      {
       digitalWrite(out1, HIGH);
       delay(100);
       relay1=1;
      }
      else
     {
      digitalWrite(out1, LOW);
      relay1=0;
      }
    }
    
 else if((digitalRead(sw2)==LOW))
     {
      if(relay2==0)
      {
       digitalWrite(out2, HIGH);
       delay(100);
       relay2=1;
      }
      else
     {
      digitalWrite(out2, LOW);
      relay2=0;
      }
    }
    
 else if((digitalRead(sw3)==LOW))
     {
      if(relay3==0)
      {
       digitalWrite(out3, HIGH);
       delay(100);
       relay3=1;
      }
      else
     {
      digitalWrite(out3, LOW);
      relay3=0;
      }
    }
     else if((digitalRead(sw4)==LOW))
     {
      if(relay4==0)
      {
       digitalWrite(out4, HIGH);
       delay(100);
       relay4=1;
      }
      else
     {
      digitalWrite(out4, LOW);
      relay4=0;
      }
    }
    delay(100);
}
    

