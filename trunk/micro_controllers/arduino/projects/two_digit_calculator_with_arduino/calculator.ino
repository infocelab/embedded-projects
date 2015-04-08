#include <LiquidCrystal.h>
int getKey();
char getOper();
void result(float result);
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
int row[4]={7, 6, 5, 4};
int col[4]={3, 2, 1, 0};
int key1;
char oper;
int key2;
void setup()
{
lcd.begin(16, 2);
for(int i=0;i<=3;i++)
{
pinMode(row[i], OUTPUT);
pinMode(col[i], INPUT);
}
for(int j=0;j<=3;j++)
digitalWrite(col[j], HIGH);
for(int k=0;k<=3;k++)
digitalWrite(row[k], HIGH);
lcd.print("CALCULATOR!!!!");
delay(4000);
lcd.clear();
lcd.setCursor(0, 0);
}

void loop()
{
lcd.clear();
lcd.setCursor(0, 0 );
lcd.print("ENTER 1 NO =");
key1=getKey();
delay(3000);
lcd.clear();
lcd.setCursor(0, 0);
lcd.print("ENTER 2 NO =");
key2=getKey();
delay(3000);
lcd.clear();
lcd.setCursor(0, 0);
lcd.print("OPERATOR =");
oper=getOper();
delay(3000);
lcd.clear();
lcd.setCursor(0, 0);
lcd.print("RESULT =");
switch(oper)
    {
     case '+':
              result((float)key1+key2);
              break;
     case '-':         
              result((float)key1-key2);
              break;
     case '/':
              result((float)key1/key2);
              break;
     case '*':
              result((float)key1*key2);
              break;
     case '^':
              result((float)pow(key1,key2)+1);
              break;
     case '%':
              result(key1%key2);     
              break;  
    }
}
int getKey()
{
  int key=13;
  int Readrow,Readcol;
while(key!=1 && key!=2 && key!=3 && key!=4 && key!=5 && key!=6 && key!=7 && key!=8 && key!=9
&& key!=0)
{
  digitalWrite(row[0], LOW);
Readrow=digitalRead(row[0]);
Readcol=digitalRead(col[0]);
if((Readrow==LOW) && (Readcol==LOW))
{
lcd.print("1");
digitalWrite(row[0], HIGH);
return key=1;
}
digitalWrite(row[0], HIGH);
digitalWrite(row[0], LOW);
Readrow=digitalRead(row[0]);
Readcol=digitalRead(col[1]);
if( (Readrow==LOW )&&( Readcol==LOW))
{
lcd.print("2");
digitalWrite(row[0], HIGH);
return key=2;
}
digitalWrite(row[0], HIGH);
digitalWrite(row[0], LOW);
Readrow=digitalRead(row[0]);
Readcol=digitalRead(col[2]);
if( (Readrow==LOW) &&( Readcol==LOW))
{
lcd.print("3");
digitalWrite(row[0], HIGH);
return key=3;
}
digitalWrite(row[0], HIGH);
digitalWrite(row[0], LOW);
Readrow=digitalRead(row[0]);
Readcol=digitalRead(col[3]);
if(( Readrow==LOW )&&( Readcol==LOW))
{
lcd.print("4");
digitalWrite(row[0], HIGH);
return key=4;
}
digitalWrite(row[0], HIGH);
for(int i=0;i<=3;i++)
{
digitalWrite(row[1], LOW);
Readrow=digitalRead(row[1]);
Readcol=digitalRead(col[i]);
if( (Readrow==LOW) && (Readcol==LOW))
{
lcd.print(4+(i+1));
digitalWrite(row[1], HIGH);
return key=(4+(i+1));
break;
}
}
digitalWrite(row[1], HIGH);
digitalWrite(row[2], LOW);
Readrow=digitalRead(row[2]);
Readcol=digitalRead(col[0]);
if( (Readrow==LOW )&& (Readcol==LOW))
{
lcd.print("9");
digitalWrite(row[2], HIGH);
return key=9;
}
digitalWrite(row[2], HIGH);
digitalWrite(row[2], LOW);
Readrow=digitalRead(row[2]);
Readcol=digitalRead(col[1]);
if( (Readrow==LOW) &&( Readcol==LOW))
{
lcd.print("0");
digitalWrite(row[2], HIGH);
return key=0;
}
digitalWrite(row[2], HIGH);
key=13;
}//While loop ends
return 0;
}//GetKey function ends
char getOper()
{
  int Readrow,Readcol;
  char key='l';
  while(key!='+' && key!='-' && key!='/' && key!='*' && key!='^' && key!='%' )
  {
    digitalWrite(row[2], LOW);
Readrow=digitalRead(row[2]);
Readcol=digitalRead(col[2]);
if( (Readrow==LOW) &&( Readcol==LOW))
{
lcd.print("+");
digitalWrite(row[2], HIGH);
return key='+';
}
digitalWrite(row[2], HIGH);
digitalWrite(row[2], LOW);
Readrow=digitalRead(row[2]);
Readcol=digitalRead(col[3]);
if( (Readrow==LOW) && (Readcol==LOW))
{
lcd.print("-");
digitalWrite(row[2], HIGH);
return key='-';
}
digitalWrite(row[2], HIGH);
digitalWrite(row[3], LOW);
Readrow=digitalRead(row[3]);
Readcol=digitalRead(col[0]);
if( (Readrow==LOW) && (Readcol==LOW))
{
lcd.print("/");
digitalWrite(row[3], HIGH);
return key='/';
}
digitalWrite(row[3], HIGH);
digitalWrite(row[3], LOW);
Readrow=digitalRead(row[3]);
Readcol=digitalRead(col[1]);
if( (Readrow==LOW) && (Readcol==LOW))
{
lcd.print("*");
digitalWrite(row[3], HIGH);
return key='*';
}
digitalWrite(row[3], HIGH);
digitalWrite(row[3], LOW);
Readrow=digitalRead(row[3]);
Readcol=digitalRead(col[2]);
if( (Readrow==LOW) && (Readcol==LOW))
{
lcd.print("^");
digitalWrite(row[3], HIGH);
return key='^';
}
digitalWrite(row[3], HIGH);
digitalWrite(row[3], LOW);
Readrow=digitalRead(row[3]);
Readcol=digitalRead(col[3]);
if( (Readrow==LOW) && (Readcol==LOW))
{
lcd.print("%");
digitalWrite(row[3], HIGH);
return key='%';
}
digitalWrite(row[3], HIGH);
key='c';
}//while loop ends
return '\0';
}//getOper function ends
void result(float result)
{
  int unitvalue,tenvalue,decimal;
  float value=result;
  if(result<0.0)
  {
  lcd.print("-");
  value=result*(-1);
  }
  if(value>10.0)
  {
  tenvalue=(int)value/10;
  lcd.print(tenvalue);
  }
  unitvalue=(int)value%10;
  lcd.print(unitvalue);
  lcd.print(".");
  decimal=(int)((int)(value*10)%10);
  lcd.print(decimal);
delay(5000);
lcd.clear();
lcd.setCursor(0, 0);
}

