

int input = 0;

void setup() {              
  // initialize the PWM pin #3 as an output.
  pinMode(3, OUTPUT);
  Serial.begin(9600); 
}

void loop() {
    input = Serial.read();
    if (input == '0'){
      analogWrite(3, 0);
      Serial.println("Speed is 0!");
    }
    if (input == '1'){
      analogWrite(3, 64);
      Serial.println("Speed is at 25%");
    }
    if (input == '2'){
      analogWrite(3, 127);
      Serial.println("Speed is at 50%");
    }
    if (input == '3'){
      analogWrite(3, 192);
      Serial.println("Speed is at 75%");
    }
    if (input == '4'){
      analogWrite(3,255);
      Serial.println("Speed is at 100%");
    }
}
