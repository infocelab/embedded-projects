int relay1=8;
int relay2=9;

void setup()
{
  Serial.begin(9600);
  pinMode(relay1,OUTPUT);
  pinMode(relay2,OUTPUT);
  digitalWrite(relay1,LOW);
  digitalWrite(relay2,LOW);
  delay(200);
}
void loop()
{
  digitalWrite(relay1,HIGH);
  delay(1000);
  digitalWrite(relay1,LOW);
  digitalWrite(relay2,HIGH);
  delay(1000);
  digitalWrite(relay2,LOW);
}
