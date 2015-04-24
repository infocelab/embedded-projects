/*
Hardware connections:

- (GND) to GND
+ (VDD) to 3.3V

(WARNING: do not connect + to 5V or the sensor will be damaged!)

You will also need to connect the I2C pins (SCL and SDA) to your
Arduino. The pins are different on different Arduinos:

Any Arduino pins labeled:  SDA  SCL
Uno, Redboard, Pro:        A4   A5
Mega2560, Due:             20   21
Leonardo:                   2    3

*/

#include <SFE_BMP180.h>
#include <Wire.h>
#include <LiquidCrystal.h>
// You will need to create an SFE_BMP180 object, here called "pressure":
#include "DHT.h"

#define DHTPIN 2     // what pin we're connected to
#define DHTTYPE DHT11   // DHT 11 
DHT dht(DHTPIN, DHTTYPE);

SFE_BMP180 pressure;

#define ALTITUDE 1655.0 // Altitude of SparkFun's HQ in Boulder, CO. in meters
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  Serial.begin(9600);
  lcd.begin(16, 2);
  Serial.println("REBOOT");
 // Initialize the sensor (it is important to get calibration values stored on the device)
  Serial.println("DHTxx test!");
 
  dht.begin();
  
  delay(200);
  if (pressure.begin())
    Serial.println("BMP180 init success");
  else
  {
    // Oops, something went wrong, this is usually a connection problem,
    // see the comments at the top of this sketch for the proper connections.

    Serial.println("BMP180 init fail\n\n");
    while(1); // Pause forever.
  }
}

void loop()
{
  char status;
  double T,P,p0,a;

  // Loop here getting pressure readings every 10 seconds.

  // If you want sea-level-compensated pressure, as used in weather reports,
  // you will need to know the altitude at which your measurements are taken.
  // We're using a constant called ALTITUDE in this sketch:
   float h = dht.readHumidity();
  
  Serial.println();
  Serial.print("provided altitude: ");
  Serial.print(ALTITUDE,0);
  Serial.print(" meters, ");
  Serial.print(ALTITUDE*3.28084,0);
  Serial.println(" feet");

  status = pressure.startTemperature();
  if (status != 0)
  {
    // Wait for the measurement to complete:
    delay(status);
    status = pressure.getTemperature(T);
    if (status != 0)
    {
      // Print out the measurement:
      Serial.print("temperature: ");
      Serial.print(T,2);
       lcd.setCursor(0,0); 
       lcd.print("TEMP");
      lcd.setCursor(0,1);
      lcd.print(T);
      lcd.setCursor(4,1);
      lcd.print("C");
      delay(100);
      Serial.print(" deg C, ");
      Serial.print((9.0/5.0)*T+32.0,2);
      Serial.println(" deg F");

      status = pressure.startPressure(3);
      if (status != 0)
      {
        // Wait for the measurement to complete:
        delay(status);
        status = pressure.getPressure(P,T);
        if (status != 0)
        {
          // Print out the measurement:
          Serial.print("absolute pressure: ");
          Serial.print(P,2);
          Serial.print(" mb, ");
          lcd.setCursor(6,0); 
          lcd.print("PRESSURE"); 
          lcd.setCursor(6,1);
          lcd.print(P);
          lcd.setCursor(12,1);
          lcd.print("mb");
          lcd.setCursor(15,0); 
          lcd.print("HUMIDITY"); 
          lcd.setCursor(15,1);
          lcd.print(h);
          Serial.print(P*0.0295333727,2);
          Serial.println(" inHg");

           for (int positionCounter = 0; positionCounter < 16; positionCounter++) 
           {
           // scroll one position left:
           lcd.scrollDisplayLeft(); 
           // wait a bit:
           delay(200);
           }

          // scroll 29 positions (string length + display length) to the right
          // to move it offscreen right:
          for (int positionCounter = 0; positionCounter <29; positionCounter++) 
          {
         // scroll one position right:
         lcd.scrollDisplayRight(); 
         // wait a bit:
	 delay(200);
          }

        // scroll 16 positions (display length + string length) to the left
        // to move it back to center:
        for (int positionCounter = 0; positionCounter <16; positionCounter++)
        {
        // scroll one position left:
        lcd.scrollDisplayLeft(); 
        // wait a bit:
        delay(200);
         }

          p0 = pressure.sealevel(P,ALTITUDE); // we're at 1655 meters (Boulder, CO)
          Serial.print("relative (sea-level) pressure: ");
          Serial.print(p0,2);
          Serial.print(" mb, ");
          Serial.print(p0*0.0295333727,2);
          Serial.println(" inHg");

          a = pressure.altitude(P,p0);
          Serial.print("computed altitude: ");
          Serial.print(a,0);
          Serial.print(" meters, ");
          Serial.print(a*3.28084,0);
          Serial.println(" feet");
        }
        else Serial.println("error retrieving pressure measurement\n");
      }
      else Serial.println("error starting pressure measurement\n");
    }
    else Serial.println("error retrieving temperature measurement\n");
  }
  else Serial.println("error starting temperature measurement\n");

  delay(5000);  // Pause for 5 seconds.
}
