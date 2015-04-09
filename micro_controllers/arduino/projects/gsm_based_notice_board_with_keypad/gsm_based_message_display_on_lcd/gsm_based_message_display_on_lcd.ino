 
#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
SoftwareSerial SIM900(2, 3); //tx-2 rx-3
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
#define  msg_len  128
char input[msg_len];
int count = 0; // A variable to count the length of the Tag DATA
int delay_val = 200;
int msg=0;
unsigned char incoming_char=0;

int r1=7;
int r2=6;
int r3=5;
int r4=4;
int c1=3;
int c2=2;
int c3=0;
int c4=1;
int colm1;
int colm2;
int colm3;
int colm4;

void setup()
{
  // set up the LCD's number of columns and rows: 
  lcd.begin(16, 2);
  lcd.print("GSM Notice Board");
  lcd.setCursor(0, 1);
  lcd.print("Anchal & Rohit");
  Serial.begin(9600); // for serial monitor
  SIM900.begin(19200); // for GSM shield
  SIM900power();  // turn on shield
  delay(20000);  // give time to log on to network.
 
  SIM900.print("AT+CMGF=1\r");  // set SMS mode to text
  delay(100);
  SIM900.print("AT+CNMI=2,2,0,0,0\r"); 
  // blurt out contents of new SMS upon receipt to the GSM shield's serial out
  delay(100);
     for(int i=0;i<msg_len;i++)
        input[i]='\0';
          lcd.setCursor(0, 1);
          count=0;
          
  
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
  delay(3000);
  lcd.clear();
   lcd.setCursor(0, 1);
}
 
void SIM900power()
// software equivalent of pressing the GSM shield "power" button
{
  digitalWrite(9, HIGH);
  delay(1000);
  digitalWrite(9, LOW);
  delay(7000);
}

int gsm_read()
{
 // Now we simply display any text that the GSM shield sends out on the serial monitor
  while(SIM900.available() > 0)
  {
    incoming_char=SIM900.read(); //Get the character from the cellular serial port.
    Serial.print(incoming_char); //Print the incoming character to the terminal.
   if(incoming_char == '@')
   {
      msg=1;
      count=0;
          for(int i=0;i<msg_len;i++)
        input[i]='\0';
      while(msg == 1)
      {     
        incoming_char=SIM900.read(); //Get the character from the cellular serial port.
        Serial.print(incoming_char); //Print the incoming character to the terminal.
         if(incoming_char > 127)
         {
           input[count] ='\0';
           return 0;
         }
           input[count] = incoming_char; // Read 1 Byte of data and store it in a character variable
           count++; // Increment the Byte count after every Byte Read 
       if(incoming_char == '*')
       {
         msg=0;
         input[count-1] ='\0';
       }
      
       delay(25);
       
    }
  }
  } 
}


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
        if(colm4==LOW)
        {
          return 'A'; 
        }
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
   if(colm4==LOW)
   {
            return 'B';
   }
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
   if(colm4==LOW)
  {
           return 'C'; 
   }}}}
   
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
   if(colm4==LOW)
  { 
           return 'D'; 
  }   }}}
return 'N';
}
char key='N';

char roll_no;
char key_count=0;

void loop()
{
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("ENTER NO :");
key='N';
while(key == 'N')
{
  key=read_keypad();
  /*if(key_count++ > 100)
  {
   key_count=0;
   break; 
  }*/
}
//lcd.print(key);

switch(key)
{
 case '1':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Amit Kumar");
    lcd.setCursor(0, 1);
lcd.print("Room:R1 Seat:55");
break;
  
 case '2':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Rohit");
    lcd.setCursor(0, 1);
lcd.print("Room:R2 Seat:26");
break;

 case '3':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Pankaj");
    lcd.setCursor(0, 1);
lcd.print("Room:R3 Seat:14");
break;

 case '4':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Prakash");
    lcd.setCursor(0, 1);
lcd.print("Room:R2 Seat:09");
break;

 case '5':
  lcd.clear();
    lcd.setCursor(0, 0);
lcd.print("Ajay");
    lcd.setCursor(0, 1);
lcd.print("Room:R1 Seat:29");
break;
}
delay(3000);
      // set the cursor to column 0, line 1
  // (note: line 1 is the second row, since counting begins with 0):
gsm_read();   
////////////////////////
    /* for(int i=0;i<msg_len;i++)
           input[i]='Z';
      count=10;*/
///////////////////////
      if(count > 0)
      {
         lcd.clear();
         lcd.setCursor(0, 0);
         lcd.print(input);
         if(count >= msg_len)
         {
           count=0;
           for(int i=0;i<msg_len;i++)
           input[i]='\0';
         }
         
            // scroll 13 positions (string length) to the left 
   // to move it offscreen left:
   for (int positionCounter = 0; positionCounter < count; positionCounter++) {
     // scroll one position left:
     lcd.scrollDisplayLeft(); 
     // wait a bit:
     delay(delay_val);
   }

   // scroll 29 positions (string length + display length) to the right
   // to move it offscreen right:
   for (int positionCounter = 0; positionCounter < (count*2); positionCounter++) {
     // scroll one position right:
     lcd.scrollDisplayRight(); 
     // wait a bit:
	delay(delay_val);
   }

     // scroll 16 positions (display length + string length) to the left
     // to move it back to center:
   for (int positionCounter = 0; positionCounter < (count*2); positionCounter++) {
     // scroll one position left:
     lcd.scrollDisplayLeft(); 
     // wait a bit:
     delay(delay_val);
   }  
      } 
      
      
}
