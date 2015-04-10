/*
  AnalogReadSerial
  Reads an analog input on pin 0, prints the result to the serial monitor.
  Attach the center pin of a potentiometer to pin A0, and the outside pins to +5V and ground.
 
 This example code is in the public domain.
 */

// the setup routine runs once when you press reset:
void setup() {
  // initialize serial communication at 9600 bits per second:
  Serial.begin(9600);
}

// the loop routine runs over and over again forever:
void loop() {
  // read the input on analog pin 0:
  int R = analogRead(A0);
  int G = analogRead(A1);
  int B = analogRead(A2);  // print out the value you read:
    Serial.print("R=");
    Serial.print(R);
     Serial.print("  G=");
    Serial.print(G);
     Serial.print("  B=");
    Serial.println(B);
  delay(1000);        // delay in between reads for stability
}
