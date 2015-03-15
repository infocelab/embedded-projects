#include <LiquidCrystal.h>
#include <VirtualWire.h>
const int transmit_pin = 1;
const int transmit_en_pin = 3;
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

const int xpin = A0;                  // x-axis of the accelerometer
const int ypin = A1;                  // y-axis
const int zpin = A2;                  // z-axis (only on 3-axis models)
int x_value = 340;
int y_value = 340;
int z_value = 340;
 
void setup()
{
  // initialize the serial communications:
  Serial.begin(9600);
 vw_set_tx_pin(transmit_pin);
 vw_set_ptt_pin(transmit_en_pin);
 vw_set_ptt_inverted(true); // Required for DR3100
  vw_setup(2000);       // Bits per sec
  lcd.begin(16, 2);
  lcd.print("WELCOME RRS");
  lcd.setCursor(0, 0);

 
}

void loop()
{
  int x = analogRead(xpin);
  int y = analogRead(ypin);
  int z = analogRead(zpin);
  // print the sensor values:
  Serial.print(x);
  Serial.print(",");
  Serial.print(y);
  Serial.print(",");
  Serial.print(z);
  Serial.println();
  if(abs(x - x_value) >= 20 && x > x_value)
  {
    lcd.clear();
    lcd.print("forward");
    fwd();
  }
  else if(abs(x - x_value) >= 20 && x < x_value)
  {
    lcd.clear();
    lcd.print("backward");
    bwk();
  }
  else if(abs(y - y_value) >= 20 && y > y_value)
  {
    lcd.clear();
    lcd.print("left");
    lft();
  }
  else if(abs(y - y_value) >= 20 && y < y_value)
  {
    lcd.clear();
    lcd.print("right");
    rgt();
  }
  else
  {
    lcd.clear();
    lcd.print("stop");
    stp();
  }
  delay(100);

}

void fwd()
{ 
   char msg[] = {'f'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void bwk()
{ 
   char msg[] = {'b'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void lft()
{ 
   char msg[] = {'l'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void rgt()
{ 
   char msg[] = {'r'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void stp()
{ 
   char msg[] = {'s'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}


