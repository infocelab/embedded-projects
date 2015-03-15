#include <LiquidCrystal.h>
#include <VirtualWire.h>
const int transmit_pin = 2;
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
 vw_set_tx_pin(transmit_pin);
 vw_set_ptt_pin(transmit_en_pin);
 vw_set_ptt_inverted(true); // Required for DR3100
  vw_setup(2000);       // Bits per sec
  lcd.begin(16, 2);
  lcd.print("GESTURE CONTROL");
  lcd.setCursor(0, 0);
  lcd.setCursor(0, 1);
   lcd.print("   ROBOT ! ");
  delay(1000);
 
}

void loop()
{
  int x = analogRead(xpin);
  int y = analogRead(ypin);
  int z = analogRead(zpin);

  if(abs(x - x_value) >= 20 && x > x_value)
  {
    rgt();
  }
  else if(abs(x - x_value) >= 20 && x < x_value)
  {
    lft();
  }
  else if(abs(y - y_value) >= 20 && y > y_value)
  {
    fwd();
  }
  else if(abs(y - y_value) >= 20 && y < y_value)
  {
     bwk();
  }
  else
  {
    stp();
  }
  delay(100);
  }

void fwd()
{ 
      lcd.clear();
    lcd.print("forward");
   char msg[] = {'f','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void bwk()
{ 
      lcd.clear();
    lcd.print("backward");
   char msg[] = {'b','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void lft()
{ 
      lcd.clear();
    lcd.print("left");
   char msg[] = {'l','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void rgt()
{ 
      lcd.clear();
    lcd.print("right");
   char msg[] = {'r','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void stp()
{ 
      lcd.clear();
    lcd.print("stop");
   char msg[] = {'s','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}


