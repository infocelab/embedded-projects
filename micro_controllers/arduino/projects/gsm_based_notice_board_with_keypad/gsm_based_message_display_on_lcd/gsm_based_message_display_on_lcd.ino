
#include <SoftwareSerial.h>
#include<LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
SoftwareSerial SIM900(2,3); //tx-2 rx-3
int lenth,lenth1,i=0,temp;
char str[200];
char name[80];
int got=0;

int r1=7;
int r2=6;
int r3=5;
int r4=A2;
int c1=A0;
int c2=A1;
int c3=4;
int c4=A3;
int colm1;
int colm2;
int colm3;
int colm4;


void setup()
{
  lcd.begin(16,2);
 Serial.begin(9600);
  SIM900.begin(9600);
  
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
  
}

char key='N';

char roll_no;
int key_count=0;

char read_keypad()
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
  {
     return '1'; 
  }
  else 
  {
     if(colm2==LOW)
     {
        return '2'; 
     }
     else
     {
        if(colm3==LOW)
        {
        return '3'; 
        }
        else
        {
      /*  if(colm4==LOW)
        {
          return 'A'; 
        }
        */
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
  {
        return '4'; 
  }
  else
  {
  if(colm2==LOW)
  {
           return '5'; 
  }
  else
   {
   if(colm3==LOW)
   {
       return '6'; 
   }
   else
   {
   /*if(colm4==LOW)
   {
            return 'B';
   }*/
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
 {
         return '7';  
 }
 else
  {
   if(colm2==LOW)
  {
        return '8'; 
  }
  else
   {
   if(colm3==LOW)
 {
         return '9';  
 }
 else
   {
   /*if(colm4==LOW)
  {
           return 'C'; 
   }*/
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
  {
           return '*'; 
  }
  else
  {
   if(colm2==LOW)
  {
           return '0'; 
  }
  else
   {
   if(colm3==LOW)
{
         return '#'; 
}
else
   {
   /*if(colm4==LOW)
  { 
           return 'D'; 
  }*/   }}}
return 'N';
}

void loop()
{
  lcd.setCursor(16,0);
 lcd.clear();
  lcd.print("no notice to display");
  SIM900.println("AT+CNMI=2,2,0,0,0");
  delay(100);
  lcd.setCursor(16,0);
      
  while(1)
  { 
    
    key='N';
  key_count=0;
  while(key == 'N')
{
  //Serial.println(key_count);
  key=read_keypad();
  if(key_count++ > 500)
  {
   key_count=0;
   break; 
  }
}
  switch(key)
{
 case '1':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Chandra Prakash ");
    lcd.setCursor(0, 1);
lcd.print("Room:R1 Seat:55");
delay(3000);
lcd.clear();
break;
 case '2':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Rajat");
    lcd.setCursor(0, 1);
lcd.print("Room:R2 Seat:26");
delay(3000);
lcd.clear();
break;

 case '3':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Harshit");
    lcd.setCursor(0, 1);
lcd.print("Room:R3 Seat:14");
delay(3000);
lcd.clear();
break;

 case '4':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Shameem");
    lcd.setCursor(0, 1);
lcd.print("Room:R2 Seat:09");
delay(3000);
lcd.clear();
break;

 case '5':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Gautam");
    lcd.setCursor(0, 1);
lcd.print("Room:R1 Seat:29");
delay(3000);
lcd.clear();
break;
 case '6':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Astha");
    lcd.setCursor(0, 1);
lcd.print("Room:R5 Seat:31");
delay(3000);
lcd.clear();
break;
 case '7':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Pratibha");
    lcd.setCursor(0, 1);
lcd.print("Room:R6 Seat:22");
delay(3000);
lcd.clear();
break;
 case '8':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Sakshi");
    lcd.setCursor(0, 1);
lcd.print("Room:R3 Seat:32");
delay(3000);
lcd.clear();
break;
 case '9':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Rohit");
    lcd.setCursor(0, 1);
lcd.print("Debarred");
delay(3000);
lcd.clear();
break;
 case '0':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Prabhat");
    lcd.setCursor(0, 1);
lcd.print("Debarred");
delay(3000);
lcd.clear();
break;

}


 Serial.print(got);
 Serial.println(name);
 if(got == 1)
 {
lcd.setCursor(0, 0);
  lcd.print(name);
 }
 else
 {
lcd.setCursor(0, 0);
  lcd.print("no notice to display");
   
 }
 

   for(int j=0;j<600;j++)
   {
    serialEvent();
    delay(1);   
   }
   if(temp==1)
   {
    i=0;
    lenth1=0;
    while(i<lenth)
    {
     if(str[i]=='*')
     {
       got=1;
      i++; 
      //Serial.println("name:");
      while(str[i]!='#')
      {
       name[lenth1]=str[i];
       Serial.print(name[lenth1]);
       lenth1++;
       i++;
      }
      name[lenth1]='\0';
      break;

     }
    i++;
    }
   // Serial.print(str);
    lcd.clear();
    lcd.setCursor(0,0);
    delay(10);
    lcd.print(name);
    temp=0;
    lenth=0;
    lenth1=0;  
   }
    lcd.scrollDisplayLeft();
    serialEvent();
    delay(1);
  }// end of while 1
}
 void serialEvent() 
{
 
  while (SIM900.available()) 
  {
    char inChar = (char)SIM900.read(); 
    str[lenth]=inChar;
    lenth++;
    if (inChar == '\n')
    {
      temp=1;     
    } 
  }
}


 
