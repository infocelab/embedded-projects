// receiver.pde
//
// Simple example of how to use VirtualWire to receive messages
// Implements a simplex (one-way) receiver with an Rx-B1 module
//
// See VirtualWire.h for detailed API docs
// Author: Mike McCauley (mikem@airspayce.com)
// Copyright (C) 2008 Mike McCauley
// $Id: receiver.pde,v 1.3 2009/03/30 00:07:24 mikem Exp $

#include <VirtualWire.h>
const int receive_pin = 12;
int OUTPUT1 = 8;
int OUTPUT2 = 9;
int OUTPUT3 = 10;
int OUTPUT4 = 11;

void setup()
{
    delay(1000);
    Serial.begin(9600);	// Debugging only
    Serial.println("setup");

    // Initialise the IO and ISR
    vw_set_rx_pin(receive_pin);
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_setup(2000);	 // Bits per sec
    vw_rx_start();       // Start the receiver PLL running
}


void loop()
{
    
    uint8_t buf[VW_MAX_MESSAGE_LEN];
    uint8_t buflen = VW_MAX_MESSAGE_LEN; 
  
  
  if (vw_get_message(buf, &buflen)) // Non-blocking
    {
        buf[buflen] = '\0';
        Serial.println((char *)buf);
        
           switch(buf[0])
           {
            case 'f': // home code
               fwd();
               Serial.print("forward");
               break;
            case 'b': // home code
               bwk();
                Serial.print("backward");
               break;
            case 'l': // home code
               lft();
                Serial.print("left");
              break;            
            case 'r': // home code
               rgt();
                Serial.print("right");
              break;
            case 's': // home code
               stp();
                Serial.print("stop");
              break;
          
         } // end of switch

} //End of if loop

}// end of loop
void fwd()
{ 
digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,LOW);
}
void bwk()
{ digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,HIGH);
}
void lft()
{ digitalWrite(OUTPUT1,LOW);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,LOW);
}
void rgt()
{ digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,LOW);
digitalWrite(OUTPUT3,LOW);
digitalWrite(OUTPUT4,HIGH);
}
void stp()
{ digitalWrite(OUTPUT1,HIGH);
digitalWrite(OUTPUT2,HIGH);
digitalWrite(OUTPUT3,HIGH);
digitalWrite(OUTPUT4,HIGH);
}

