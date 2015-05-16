
#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
// constants won't change. They're used here to 
// set pin numbers:
const int irPin1 = 2;     // the number of the pushbutton pin
const int irPin2 = 3;
int count=0;
// variables will change:
int irState1 = 0; // variable for reading the pushbutton status
int irState2 = 0;

void setup() {
  lcd.begin(16, 2);
  lcd.print("WELCOME");
  // initialize the LED pin as an output:
     
  // initialize the pushbutton pin as an input:
  pinMode(irPin1, INPUT); 
  pinMode(irPin2, INPUT);
delay(1000);

  
}

void loop(){
  // read the state of the pushbutton value:
  irState1 = digitalRead(irPin1);
   irState2 = digitalRead(irPin2);
   
   
  if (irState1 == HIGH) { 
     lcd.clear();
    lcd.setCursor(0,0); 
      delay(10); 
    lcd.print("WELCOME");
        count++;
if(count == 999)
count=0; 
delay(500); 
 } 
  if (irState2 == HIGH) {
     lcd.clear();
   lcd.setCursor(0,0);
delay(10);
  lcd.print("THANKS");
count--;
if(count == -1)
count=0;
delay(500); 

  }
  
    lcd.setCursor(12,0); 
    delay(10);
 lcd.print(count);

}

