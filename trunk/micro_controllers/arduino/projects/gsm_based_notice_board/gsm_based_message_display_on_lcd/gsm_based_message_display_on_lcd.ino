#include <SoftwareSerial.h>
#include<LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
SoftwareSerial SIM900(2,3); //tx-2 rx-3
int lenth,lenth1,i=0,temp;
char str[200];
char name[80];
int got=0;

void setup()
{
  lcd.begin(16,2);
 Serial.begin(9600);
  SIM900.begin(9600);
  SIM900.println("AT+CNMI=2,2,0,0,0");
  delay(100);
}

void loop()
{
      
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
     lcd.scrollDisplayLeft();
    serialEvent();
    delay(1);

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
        lcd.clear();
       got=1;
      i++; 
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
    }// end of while 1
    lcd.clear();
    lcd.setCursor(0,0);
    delay(10);
    lcd.print(name);
    temp=0;
    lenth=0;
    lenth1=0;  
   }
   
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


 
