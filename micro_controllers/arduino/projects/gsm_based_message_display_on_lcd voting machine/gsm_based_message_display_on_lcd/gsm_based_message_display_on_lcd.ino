#include <SoftwareSerial.h>
#include<LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
SoftwareSerial SIM900(2,3); //tx-2 rx-3
int lenth,lenth1,i=0,temp;
char str[200];


int c1=0,c2=0,c3=0;
int p1=0,p2=6,p3=12;
int g1=0,g2=0,g3=0;


void setup()
{
  lcd.begin(16,2);
 Serial.begin(9600);
  SIM900.begin(9600);
  SIM900.println("AT+CNMI=2,2,0,0,0");
  delay(100);
  
 lcd.setCursor(0, 0);
 lcd.print("Welcome to ");
 
 lcd.setCursor(0, 1);
 lcd.print("Voting Machine");
 delay(2000);
}

void vote_display()
{
 lcd.clear();
 lcd.setCursor(0, 0);
 lcd.print("C1    C2    C3");
 
 lcd.setCursor(p1, 1);
 lcd.print(c1);
 
 lcd.setCursor(p2, 1);
 lcd.print(c2);
 
 lcd.setCursor(p3, 1);
 lcd.print(c3);  
  
}

void loop()
{
  vote_display();
   for(int j=0;j<600;j++)
   {
    serialEvent();
    delay(1); 
   }

    
   if(temp==1)
   {
         i=0;
     String stringOne(str);
     Serial.println("!!!!!!");
     Serial.print(stringOne);
     int no1 = stringOne.indexOf("7503021151", 1 );
     if (no1 > 0) {
     Serial.print("==================================");
     if(g1 == 1)
     {
       lcd.clear();
       lcd.setCursor(0, 0);
       lcd.print("Resend Msg Denied");
       i=lenth;
     }
     else
     {
       lcd.clear();
       lcd.setCursor(0, 0);
       lcd.print("Success");
       g1=1;
     }
     delay(3000);
   }
     int no2 = stringOne.indexOf("8802038023", 1 );
     if (no2 > 0) {
     Serial.print("==================================");
     if(g2 == 1)
     {
       lcd.clear();
       lcd.setCursor(0, 0);
       lcd.print("Resend Msg Denied");
       i=lenth;
     }
     else
     {
       lcd.clear();
       lcd.setCursor(0, 0);
       lcd.print("Success");
       g2=1;
     }
     delay(3000);
   }
   
   
   
     int no3 = stringOne.indexOf("7503021151", 1 );
     if (no3 > 0) {
     Serial.print("==================================");
     if(g3 == 1)
     {
       lcd.clear();
       lcd.setCursor(0, 0);
       lcd.print("Resend Denied");
       i=lenth;
     }
     else
     {
       lcd.clear();
       lcd.setCursor(0, 0);
       lcd.print("Success");
       g3=1;
     }
     delay(3000);
   }
 
   
    while(i<lenth)
    {   
     if(str[i]=='*')
     { 
       if(str[i+1] == '1')
           c1++;

       if(str[i+1] == '2')
           c2++;

       if(str[i+1] == '3')
           c3++;
       break;
       
     }
     i++;
     
    }// end of while 1
    temp=0;
    lenth=0; 
    for(i=0;i<200;i++)
    str[i]='\0';
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


 
