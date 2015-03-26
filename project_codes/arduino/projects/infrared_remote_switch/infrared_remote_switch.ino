/* 
source: www.electroschematics.com
You'll need to change the led pins and the codes 
accordingly to your configuration and IR remote
*/
 
#include <IRremote.h>
 
int RECV_PIN = 2; // the pin where you connect the output pin of TSOP4838
int relay1 = 3;
int relay2 = 8;
int relay3 = 9;
int relay4 = 10;
int relay5 = 11;
int relay6 = 12;
int itsONrelay[] = {0,0,0,0,0,0,0};
/* the initial state of LEDs is OFF (zero) 
the first zero must remain zero but you can 
change the others to 1's if you want a certain
led to light when the board is powered */
#define code1    6306 // code received from button 1
#define code1_1  2210 // code received from button 1
#define code2  6308 // code received from button 2
#define code2_1  2212 // code received from button 2
#define code3  6311 // code received from button 3
#define code3_1  2215 // code received from button 3
#define code4  6312 // code received from button 4
#define code4_1  2216 // code received from button 4
#define code5  6315 // code received from button 5
#define code5_1  2219 // code received from button 5
#define code6  6317 // code received from button 6
#define code6_1  2221 // code received from button 6

IRrecv irrecv(RECV_PIN);
 
decode_results results;
 
void setup()
{
  Serial.begin(9600);   // you can comment this line
  irrecv.enableIRIn();  // Start the receiver
  pinMode(relay1, OUTPUT);
  pinMode(relay2, OUTPUT);
  pinMode(relay3, OUTPUT);
  pinMode(relay4, OUTPUT);
  pinMode(relay5, OUTPUT);
  pinMode(relay6, OUTPUT);
}
 
void loop() {
  if (irrecv.decode(&results)) {
    unsigned int value = results.value;
   delay(200);
    switch(value) {
       case code1:
       case code1_1:
       Serial.print(value); 
         Serial.println(" - code 1");
         if(itsONrelay[1] == 1) {        // if first led is on then
            digitalWrite(relay1, LOW);   // turn it off when button is pressed
            itsONrelay[1] = 0;           // and set its state as off
         } else {                      // else if first led is off
             digitalWrite(relay1, HIGH); // turn it on when the button is pressed
             itsONrelay[1] = 1;          // and set its state as on
         }
         //delay(200);
          break; 
       case code2:
       case code2_1:
       Serial.print(value); 
       Serial.println(" - code 2");
         if(itsONrelay[2] == 1) {
            digitalWrite(relay2, LOW);
            itsONrelay[2] = 0;
         } else {
             digitalWrite(relay2, HIGH);
             itsONrelay[2] = 1;
         }
         //delay(200);
          break;
       case code3:
       case code3_1:
       Serial.print(value); 
       Serial.println(" - code 3");
         if(itsONrelay[3] == 1) {
            digitalWrite(relay3, LOW);
            itsONrelay[3] = 0;
         } else {
             digitalWrite(relay3, HIGH);
             itsONrelay[3] = 1;
         }
         //delay(200);
          break;  
       case code4:
       case code4_1:
       Serial.print(value); 
       Serial.println(" - code 4");
         if(itsONrelay[4] == 1) {
            digitalWrite(relay4, LOW);
            itsONrelay[4] = 0;
         } else {
             digitalWrite(relay4, HIGH);
             itsONrelay[4] = 1;
         }
         //delay(200);
          break;
       case code5:
       case code5_1:
       Serial.print(value); 
       Serial.println(" - code 5");
         if(itsONrelay[5] == 1) {
            digitalWrite(relay5, LOW);
            itsONrelay[5] = 0;
         } else {
             digitalWrite(relay5, HIGH);
             itsONrelay[5] = 1;
         }
        // delay(200);
          break;
       case code6:
       case code6_1:
       Serial.print(value); 
       Serial.println(" - code 6");
         if(itsONrelay[6] == 1) {
            digitalWrite(relay6, LOW);
            itsONrelay[6] = 0;
         } else {
             digitalWrite(relay6, HIGH);
             itsONrelay[6] = 1;
         }
        // delay(200);
          break;  
          default:
            Serial.print("default - "); 
            Serial.println(value); // you can comment this line
            //delay(200);
         
         break;    
         
    }
   
       irrecv.resume(); // Receive the next value
  
  }
}
