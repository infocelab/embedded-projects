int pirPin = 8;
int val;
int led =13;

void setup() 
{
  Serial.begin(9600);
  pinMode(led, OUTPUT);
  digitalWrite(led, LOW);
}

void loop() 
{
  val = digitalRead(pirPin); //read state of the PIR
  
  if (val == LOW) 
  {
    digitalWrite(led, LOW);
    Serial.println("No motion"); //if the value read is low, there was no motion
  }
  else 
  {
    digitalWrite(led, HIGH);
    Serial.println("Motion!"); //if the value read was high, there was motion
  }
  
  delay(1000);
}
