int ledPin =13;
int EP =9;

void setup(){
  pinMode(ledPin, OUTPUT);
  pinMode(EP, INPUT); //set EP input for measurment
  Serial.begin(9600); //init serial 9600
  Serial.println("----------------------Vibration demo------------------------");
}
void loop(){
  long measurement =TP_init();
  delay(50);
  Serial.print("measurment = ");
  Serial.println(measurement);
  if (measurement > 1000){
    digitalWrite(ledPin, HIGH);
  }
  else{
    digitalWrite(ledPin, LOW); 
  }
}

long TP_init(){
  delay(10);
  long measurement=pulseIn (EP, HIGH);  //wait for the pin to get HIGH and returns measurement
  return measurement;
}
