// transmitter.pde
//
// Simple example of how to use VirtualWire to transmit messages
// Implements a simplex (one-way) transmitter with an TX-C1 module
//
// See VirtualWire.h for detailed API docs
// Author: Mike McCauley (mikem@airspayce.com)
// Copyright (C) 2008 Mike McCauley
// $Id: transmitter.pde,v 1.3 2009/03/30 00:07:24 mikem Exp $

#include <VirtualWire.h>

const int led_pin = 11;
const int input_pin = 8;
const int transmit_pin = 3;
const int receive_pin = 2;
const int transmit_en_pin = 4;
int count=0;

void setup()
{
    delay(1000);
    Serial.begin(9600);	// Debugging only
    Serial.println("setup");
    delay(10);
    Serial.println("SEND: 1 for Tubelight.. SEND: 2 For CFL..  SEND: 3 For Fan...");
    Serial.println("............................................:");

    // Initialise the IO and ISR
    vw_set_tx_pin(transmit_pin);
    vw_set_rx_pin(receive_pin);
    vw_set_ptt_pin(transmit_en_pin);
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_setup(2000);       // Bits per sec
    pinMode(led_pin, OUTPUT);
    pinMode(input_pin, INPUT);
    digitalWrite(input_pin, LOW);
}

//byte count = 1;

void loop()
{
  int i;
  char data = Serial.read();    // Read character,
  //char msg[1] = {'h'};
   char msg[1] = {data};

  //msg[6] = count;
  //digitalWrite(led_pin, HIGH); // Flash a light to show transmitting
  //digitalRead(input_pin);
  //if(i==HIGH)
  if(data=='1')
    {
      if(count==0)
      {
         vw_send((uint8_t *)msg, 1);
         vw_wait_tx(); // Wait until the whole message is gone
         //digitalWrite(led_pin, LOW);
         Serial.println("Tubelight Is ON, SEND Smame digit to OFF IT:");
         delay(1000);
         count=1;
      }
         else
       {
         vw_send((uint8_t *)msg, 1);
         vw_wait_tx(); // Wait until the whole message is gone
         //digitalWrite(led_pin, LOW);
         Serial.println("Tubelight Is OFF, SEND Smame digit to ON IT:");
         delay(1000);
         count=0;
       }
        // count = count + 1;
   }
    else if(data=='2')
    {
       if(count==0)
        {
         vw_send((uint8_t *)msg, 1);
         vw_wait_tx(); // Wait until the whole message is gone
         //digitalWrite(led_pin, LOW);
         Serial.println("CFL Is ON, SEND Smame digit to OFF IT:");
         delay(1000);
         count=1;
        }
        else
       {
         vw_send((uint8_t *)msg, 1);
         vw_wait_tx(); // Wait until the whole message is gone
         //digitalWrite(led_pin, LOW);
         Serial.println("CFL Is OFF, SEND Smame digit to ON IT:");
         delay(1000);
         count=0;
       } 
     }
  else if(data=='3')
  {
    if(count==0)
      {
         vw_send((uint8_t *)msg, 1);
         vw_wait_tx(); // Wait until the whole message is gone
         //digitalWrite(led_pin, LOW);
         Serial.println("FAN Is ON, SEND Smame digit to OFF IT:");
         delay(1000);
         count=1;
      }
      else
      {
         vw_send((uint8_t *)msg, 1);
         vw_wait_tx(); // Wait until the whole message is gone
         //digitalWrite(led_pin, LOW);
         Serial.println("FAN Is OFF, SEND Smame digit to ON IT:");
         delay(1000);
         count=0;
      }
  }
}
