
const int analogInPin = A0;  // Analog input pin that the potentiometer is attached to
const int analogOutPin = 9; // Analog output pin that the LED is attached to
int sensorValue = 0;        // value read from the pot
int outputValue = 0;        // value output to the PWM (analog out)
int ledPin = 13;      // select the pin for the LED

void setup()
{
    pinMode(ledPin, OUTPUT);  

  Serial.begin(9600); // Initialize Serial Communication - Both with the RFID reader & the Serial Monitor
}

int i=0;
void loop()
{ 
  // read the analog in value:
  sensorValue = analogRead(analogInPin);            
  // map it to the range of the analog out:
  outputValue = map(sensorValue, 0, 1023, 0, 255);  
  // change the analog out value:
  analogWrite(analogOutPin, outputValue);           

  if(outputValue > 5)
  {
    // turn the ledPin on
  digitalWrite(ledPin, HIGH);  
  delay(10);
     // turn the ledPin off:        
  digitalWrite(ledPin, LOW);   
 
    
  }
  // wait 2 milliseconds before the next loop
  // for the analog-to-digital converter to settle
  // after the last reading:
  delay(20);  
  
}


