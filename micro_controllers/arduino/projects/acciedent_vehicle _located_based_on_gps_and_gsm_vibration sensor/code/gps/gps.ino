#include <SoftwareSerial.h>
SoftwareSerial mySerial(2, 3);
SoftwareSerial GPS(11,12);
#define vibrate_sense A0

char str[70];
char *test="$GPGGA";      
char logitude[10];
char latitude[10];
int i=0,j=0,k=0;

long TP_init()
{
   delay(10);
   long measurement=pulseIn (vibrate_sense, HIGH);  //wait for the pin to get HIGH and returns measurement
   return measurement;
}
   
 void SendMessage()
{
  mySerial.println("AT+CMGF=1");    //Sets the GSM Module in Text Mode
  delay(1000);  // Delay of 1000 milli seconds or 1 second
  mySerial.println("AT+CMGS=\"+917827855025\"\r"); // Replace x with mobile number
  delay(1000);
   Serial.println("sending sms");
  mySerial.print("Latitude:");        // message to send
  Serial.print("Latitude:");
  delay(100);
  mySerial.print(latitude);        // message to send
  Serial.println(latitude);
  delay(100);

  mySerial.print("Longitude:");        // message to send
  Serial.print("Longitude:");
  delay(100);
 mySerial.print(logitude);        // message to send
  Serial.println(logitude);
  delay(100);
  
  mySerial.println((char)26);// ASCII code of CTRL+Z
  delay(1000);                                    // give module time to send SMS

}


void setup()
{
  mySerial.begin(9600);   // Setting the baud rate of GSM Module  
  Serial.begin(9600);    // Setting the baud rate of Serial Monitor (Arduino)
  delay(100);
   GPS.begin(9600); // for GPS shield
   delay(20000);  // give time to log on to network.
    mySerial.print("AT+CMGF=1");  // set SMS mode to text
   delay(100);
  mySerial.print("AT+CNMI=2,2,0,0,0\r"); 
   // blurt out contents of new SMS upon receipt to the GSM shield's serial out
   delay(100);
   Serial.begin(9600);
   pinMode(vibrate_sense, INPUT);
   delay(3000);
}

void loop()
{
  serialEvent();
  long measurement =TP_init();
  Serial.println(measurement);
  if (measurement >= 1000)
  {
    j=0;
    for(i=18;i<27;i++)          //extract latitude from string
    {
      latitude[j]=str[i];
      j++;
    }
    k=0;
    for(i=30;i<40;i++)          //extract longitude from string
    {
      logitude[k]=str[i];
      k++;
    }
     SendMessage();
    delay(5000);
  }
}

void serialEvent()
{
  while (GPS.available())            //Serial incomming data from GPS
  {
    char inChar = (char)GPS.read();
     str[i]= inChar;                    //store incomming data from GPS to temparary string str[]
     i++;
     if (i < 7)                      
     {
      if(str[i-1] != test[i-1])         //check for right string
      {
        i=0;
      }
     }
    if(i >=60)
    {
     break;
    }
  }
}

 
