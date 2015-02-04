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

const int led_pin = 13;
const int transmit_pin = 2;
const int receive_pin = 3;
const int transmit_en_pin = 4;
const int relay1 = 8;
const int relay2 = 9;
const int relay3 = 10;
const int relay4 = 11;
float temp;
int tempPin = 0;

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

    pinMode(led_pin, OUTPUT);
}
int count=1;
char * home_code="1111";
char * unit_code="3333";
char * source;
int relay=0;
int loopAgain=1;
char deg[5]; 
int sendtemp=0;

void loop()
{
    uint8_t buf[VW_MAX_MESSAGE_LEN];
    uint8_t buflen = VW_MAX_MESSAGE_LEN; 
  
  if(sendtemp == 1)
  {
    for(int i=0;i<5;i++)
  {
     Serial.print("Yes Sending Temperature:");
              char datamsg[128]="#,1111,3333,2222,5,";
              temp = analogRead(tempPin);
              temp = temp * 0.48828125;
              dtostrf(temp, 3, 3, deg);
              strcat(datamsg, deg);
              Serial.println(datamsg);
              datamsg[strlen(datamsg)]='\n';
              vw_send((uint8_t *)datamsg, strlen(datamsg));
              vw_wait_tx();
            delay(3000);
  }       
  sendtemp=0;
  }
  if (vw_get_message(buf, &buflen)) // Non-blocking
    {
        buf[buflen] = '\0';
        Serial.println((char *)buf);
        //parsing
        // Read each command pair 
        const char s[2] = ",";
        char *token;
   
        /* get the first token */
        token = strtok((char *)buf, s);
        //token = strtok(NULL, s);
        /* walk through other tokens */
        loopAgain=1;
        while( token != NULL ) 
        {
           if(loopAgain == 0 )
               break;
           if(strcmp((char *)token,"#")==0)
           break;
           Serial.print(count);
           Serial.print(":");
           Serial.println(token );
           //delay(1000);
           switch(count)
           {
             case 1: // home code
               if(strcmp((char *)home_code , (char *)token) != 0)
               {
                  Serial.println("Home Code not matched");
                  loopAgain=0;     
               }
               else
               {
                  //Serial.println("Home Code OK");       
               }
               break;
            case 2: // source
              //strcpy((char *)source,(char *)token);
              //Serial.println("Source Saved OK");       
            break;
            case 3: // destination
              if(strcmp(unit_code , token) != 0)
              {
                Serial.println("Unit Code not matched");
                loopAgain=0;     
              }
              else
              {
                //Serial.println("Unit Code OK");        
              }
              break;
          case 4: // relay
            if(strcmp(token,"1")==0)
            {
               relay=1;
            }
            else if(strcmp(token,"2")==0)
            {
              relay=2;
            }
            else if(strcmp(token,"3")==0)
            {
              relay=3;
            }
            else if(strcmp(token,"4")==0)
            {              
              relay=4;
            }
            else if(strcmp(token,"5")==0)
            {              
              relay=5;
            }
            break;
            case 5: // task
            if(strcmp(token,"1")==0)
            {
              if(relay == 1)
              {
                digitalWrite(relay1,HIGH);
              }
              else if(relay == 2)
              {
                digitalWrite(relay2,HIGH);
              }
              else if(relay == 3)
              {
                digitalWrite(relay3,HIGH);
              }
              else if(relay == 4)
              {
                digitalWrite(relay4,HIGH);
              }
            }
            else if(strcmp(token,"2")==0) // task to off
            {
              if(relay == 1)
              {
                digitalWrite(relay1,LOW);
              }
              else if(relay == 2)
              {
                digitalWrite(relay2,LOW);
              }
              else if(relay == 3)
              {
                digitalWrite(relay3,LOW);
              }
              else if(relay == 4)
              {
                digitalWrite(relay4,LOW);
              }
            }
            else if(strcmp(token,"3")==0) // temprature
            {
              sendtemp=1;
            /* Serial.print("Sending Temperature");
              char datamsg[128]="#,1111,3333,2222,5,";
              temp = analogRead(tempPin);
              temp = temp * 0.48828125;
              dtostrf(temp, 3, 3, deg);
              strcat(datamsg, deg);
              Serial.println(datamsg);
              vw_send((uint8_t *)datamsg, strlen(datamsg));
              vw_wait_tx();
            delay(1000);*/ 
            }
            break;    
         } // end of switch
    
        token = strtok(NULL, s);
        count++;
      }// end of while
      count=1;
   } // end of if
} // end of loop
