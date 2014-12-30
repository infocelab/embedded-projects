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
#include <String.h>

const int led_pin = 11;
const int transmit_pin = 3;
const int receive_pin = 2;
const int transmit_en_pin = 4;

void setup()
{
   Serial.begin(9600);

    // Initialise the IO and ISR
    vw_set_tx_pin(transmit_pin);
    vw_set_rx_pin(receive_pin);
    vw_set_ptt_pin(transmit_en_pin);
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_setup(2000);       // Bits per sec
    pinMode(led_pin, OUTPUT);
    digitalWrite(led_pin, LOW);
    vw_rx_start();       // Start the receiver PLL running
}

byte count = 0;
byte xml[7];
int flag=0;
//char msg[7] = {'H','E','L','L','O','O','K'};
char msg[128];
char incomingByte = 0;   // for incoming serial data
uint8_t buf[VW_MAX_MESSAGE_LEN];
uint8_t buflen = VW_MAX_MESSAGE_LEN;

void loop()
{
        while(Serial.available() > 0) {
                // read the incoming byte:
                incomingByte = Serial.read();
               msg[count++]=incomingByte;
               flag=1;
               
        }
        
        if (vw_get_message(buf, &buflen)) // Non-blocking
        {
          buf[buflen] = '\n';
          Serial.println((char *)buf);
        }

        msg[count]='\0';
        if(flag == 1)
        {
          Serial.println(msg);
          //Sending the string
          vw_send((uint8_t *)msg, strlen(msg));
          vw_wait_tx(); 
          count=0;
          flag=0;
        }
}
