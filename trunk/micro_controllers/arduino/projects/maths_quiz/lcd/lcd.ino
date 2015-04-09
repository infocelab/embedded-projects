// include the library code:
#include <LiquidCrystal.h>

// initialize the library with the numbers of the interface pins
//LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
LiquidCrystal lcd(12, 11, 5, 4, 3, 2); //  for simulation
long randNumber1;
long randNumber2;
long ans;
int btn_ok = 8;
int btn_left = 9;
int btn_right =10;
int btn_up = 6;
int btn_down = 7;
int buttonState; 
int oper_type=1; // 1=add, 2=sub,3=mul,4=div,5=percentage
int range=10;

void setup() 
{
   Serial.begin(9600);
  // set up the LCD's number of columns and rows: 
  lcd.begin(16, 2);
  // Print a message to the LCD.
  lcd.print("WELCOME TO");
  lcd.setCursor(0, 1);
  // print the number of seconds since reset:
  lcd.print("Maths Practice");
  
    // if analog input pin 0 is unconnected, random analog
  // noise will cause the call to randomSeed() to generate
  // different seed numbers each time the sketch runs.
  // randomSeed() will then shuffle the random function.
  randomSeed(analogRead(0));
  delay(500);
    pinMode(btn_ok, INPUT);
     pinMode(btn_left, INPUT);
      pinMode(btn_right, INPUT);
       pinMode(btn_up, INPUT);
        pinMode(btn_down, INPUT);
        

}

String oper_type_symbol()
{
 switch(oper_type)
{
 case 1:
     return " + ";     
 break;
 
 case 2:
 return " - ";
 break;
 
 case 3:
 return " * ";
 break;
 
 case 4:
 return " / ";
 break;
 
 case 5:
 return " % ";
 break;
}  
}


String oper_type_str()
{
 switch(oper_type)
{
 case 1:
     return "Addition";     
 break;
 
 case 2:
 return "Subtraction";
 break;
 
 case 3:
 return "Multiplication";
 break;
 
 case 4:
 return "Division";
 break;
 
 case 5:
 return "Percentage";
 break;
}  
}

long calculate(int r1,int r2)
{
 switch(oper_type)
{
 case 1:
     return r1+r2;     
 break;
 
 case 2:
 return r1 - r2;
 break;
 
 case 3:
 return r1*r2;
 break;
 
 case 4:
 return r1/r2;
 break;
 
 case 5:
 return r1%r2;
 break;
}  
}

void loop() 
{
  lcd.clear();
  // set the cursor to column 0, line 1
  // (note: line 1 is the second row, since counting begins with 0):
  lcd.setCursor(0, 0);
  // print the number of seconds since reset:
  lcd.print(oper_type_str());
  lcd.setCursor(0, 1);
  // print a random number from 0 to 299
  randNumber1 = random(range);
  lcd.print(randNumber1);
  lcd.print(oper_type_symbol());  

  // print a random number from 0, 100
  randNumber2 = random(range);
  lcd.print(randNumber2);
  lcd.print(" = ");
  
  delay(100);  
  
  
  ans = calculate(randNumber1,randNumber2);
  
  
  lcd.print(ans);
  delay(100);

  buttonState = digitalRead(btn_ok);
  if (buttonState == HIGH) 
  {
    lcd.clear();
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print("Mode : ");
    lcd.print(oper_type_str());
    lcd.setCursor(0, 1);
    lcd.print("Range: ");
    lcd.print(range);   
    delay(200);  
  }
      
  buttonState = digitalRead(btn_left);
  if (buttonState == HIGH) 
  {
    lcd.clear();
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print("Mode Changed to :");
    lcd.setCursor(0, 1);
    oper_type--;
    lcd.print(oper_type_str());   
    delay(200);  
  }


  buttonState = digitalRead(btn_right);
  if (buttonState == HIGH) 
  {
    lcd.clear();
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print("Mode Changed to :");
    lcd.setCursor(0, 1);
    oper_type++;
    lcd.print(oper_type_str());   
    delay(200);  
  }


  buttonState = digitalRead(btn_up);
  if (buttonState == HIGH) 
  {
    lcd.clear();
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print("Increasing Range to:");
    range = range * 10;
    lcd.setCursor(0, 1);
    lcd.print(range);   
    delay(200);  
  }


  buttonState = digitalRead(btn_down);
  if (buttonState == HIGH) 
  {
    lcd.clear();
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print("Decreasing Range to:");
    range = range / 10;
    lcd.setCursor(0, 1);
    lcd.print(range);   
    delay(200);  
  }

  }


