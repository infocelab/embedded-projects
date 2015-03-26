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

const int relay1 = 8;
const int relay2 = 9;
const int relay3 = 10;
const int transmit_pin = 2;
const int receive_pin = 3;
const int transmit_en_pin = 4;
int count = 0;
void setup()
{
    delay(1000);
    Serial.begin(9600);	// Debugging only
    Serial.println("setup");

    // Initialise the IO and ISR
    vw_set_tx_pin(transmit_pin);
    vw_set_rx_pin(receive_pin);
    vw_set_ptt_pin(transmit_en_pin);
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_setup(2000);	 // Bits per sec

    vw_rx_start();       // Start the receiver PLL running 
    pinMode(relay1, OUTPUT);
    digitalWrite(relay1, LOW);
    pinMode(relay2, OUTPUT);
    digitalWrite(relay2, LOW);
    pinMode(relay3, OUTPUT);
    digitalWrite(relay3, LOW);
}

void loop()
{
    //int count = 0;
    uint8_t buf[VW_MAX_MESSAGE_LEN];
    uint8_t buflen = VW_MAX_MESSAGE_LEN;

    if (vw_get_message(buf, &buflen)) // Non-blocking
    {
        delay(100);
	int i;
         if(buf[0]=='1')
         {
           if(count==0)
           {
           digitalWrite(relay1, HIGH); // Flash a light to show received good message
	   Serial.print("Got: ");
           delay(3000);
           //digitalWrite(relay1, LOW);
           //delay(3000);
           count=1;
           }
           else
           {
            digitalWrite(relay1, LOW); // Flash a light to show received good message
	   Serial.print("Got: ");
           delay(3000);
           //digitalWrite(relay1, LOW);
           //delay(3000);
           count=0;
           }
         }
         else if(buf[0]=='2')
         {
           if(count==0)
           {
           digitalWrite(relay2, HIGH); // Flash a light to show received good message
	   Serial.print("Got: ");
           delay(3000);
           //digitalWrite(relay2, LOW);
           //delay(3000);
           count=1;
           }
           else
           {
           digitalWrite(relay2, LOW); // Flash a light to show received good message
	   Serial.print("Got: ");
           delay(3000);
           //digitalWrite(relay2, LOW);
           //delay(3000);
           count=0;
           }
	}
            else if(buf[0]=='3')
          {
            if(count==0)
            {
           digitalWrite(relay3, HIGH); // Flash a light to show received good message
	   Serial.print("Got: ");
           delay(3000);
           //digitalWrite(relay3, LOW);
           //delay(3000);
           count=1;
           }
           else
           {
           digitalWrite(relay3, LOW); // Flash a light to show received good message
	   Serial.print("Got: ");
           delay(3000);
           //digitalWrite(relay3, LOW);
           //delay(3000);
           count=0;
           }
	 }
	/*for (i = 0; i < buflen; i++)
	{
	    //Serial.print(buf[i], HEX);
             Serial.write(buf[0]);
	    Serial.print(' ');
	}
	Serial.println();
        //digitalWrite(led_pin, LOW);*/
    }
}


