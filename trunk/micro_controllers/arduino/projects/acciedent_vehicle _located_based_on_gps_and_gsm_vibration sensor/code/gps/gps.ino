#include <SoftwareSerial.h>
SoftwareSerial SIM900(2, 3);
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
   
void sendSMS()
{
 Serial.println("sending sms");
  SIM900.print("AT+CMGF=1\r");                                                        // AT command to send SMS message
  delay(100);
  SIM900.println("AT+CMGS=\"+917503021151\"\r");                                     // recipient's mobile number, in international format
  delay(100);

  SIM900.print("Latitude:");        // message to send
  Serial.print("Latitude:");
  delay(100);
  SIM900.print(latitude);        // message to send
  Serial.println(latitude);
  delay(100);

  SIM900.print("Longitude:");        // message to send
  Serial.print("Longitude:");
  delay(100);
  SIM900.print(logitude);        // message to send
  Serial.println(logitude);
  delay(100);
  
  SIM900.println((char)26);                       // End AT command with a ^Z, ASCII code 26
  delay(2000); 
  SIM900.println();
  delay(5000);                                     // give module time to send SMS

}


void setup()
{
   SIM900.begin(9600); // for GSM shield
   GPS.begin(9600); // for GPS shield
   delay(20000);  // give time to log on to network.
   SIM900.print("AT+CMGF=1\r");  // set SMS mode to text
   delay(100);
   SIM900.print("AT+CNMI=2,2,0,0,0\r"); 
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
    sendSMS();
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

 
