
#include <VirtualWire.h>
const int transmit_pin = 2;
const int transmit_en_pin = 13;
 
void setup()
{
  Serial.begin(9600);
  // initialize the serial communications:
 vw_set_tx_pin(transmit_pin);
 vw_set_ptt_pin(transmit_en_pin);
 vw_set_ptt_inverted(true); // Required for DR3100
  vw_setup(2000);       // Bits per sec
  delay(1000);
}
 char d;
 
void loop()
{
   // send data only when you receive data:
   if (Serial.available() > 0) {
   // read the incoming byte:
   d = Serial.read();
   switch(d)
   {
    case 'f':
   fwd();
   break; 
    case 'b':
   bwk();
   break; 
     
    case 'l':
   lft();
   break; 
     
   case 'r':
   rgt();
   break; 
    case 's':
   stp();
   break; 
    
   }
  }
  delay(100);
 }

void fwd()
{ 
   char msg[] = {'f','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void bwk()
{ 
   char msg[] = {'b','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void lft()
{ 
   char msg[] = {'l','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void rgt()
{ 
   char msg[] = {'r','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}
void stp()
{ 
   char msg[] = {'s','\0'};
   vw_send((uint8_t *)msg, 2);
  vw_wait_tx(); // Wait until the whole message is gone
  delay(300);
}


