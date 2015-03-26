// final coding for complete Tilt Detection
int groundpin = 18; // analog input pin 4 -- ground 
int powerpin = 19;              // analog input pin 5 -- voltage
int xpin = A3;                   // x-axis of the accelerometer
int ypin = A2;                   // y-axis
int zpin = A1;                   // z-axis (only on 3-axis models)
long x_nu=340;
long y_nu=340;


int forwardPin = 12;
int backPin = 10;
int leftPin = 11;
int rightPin = 8;
int centerPin = 9;


long x = 0;
long y = 0;

void setup()
{
  Serial.begin(9600);
   pinMode(groundpin, OUTPUT);
  pinMode(powerpin, OUTPUT);
  digitalWrite(groundpin, LOW); 
  digitalWrite(powerpin, HIGH);
  
  pinMode(forwardPin, OUTPUT);
  pinMode(backPin, OUTPUT);
  pinMode(leftPin, OUTPUT);
  pinMode(rightPin, OUTPUT);
  pinMode(centerPin, OUTPUT);
}

void loop()
{

    
  x = analogRead(xpin);
  y = analogRead(ypin);
   Serial.print("X=");
   Serial.print(x);
   Serial.print("   Y=");
   Serial.println(y);
  digitalWrite(forwardPin, HIGH);
  digitalWrite(backPin, HIGH);
  digitalWrite(leftPin, HIGH);
  digitalWrite(rightPin, HIGH);
  digitalWrite(centerPin, HIGH);
  
  if ( abs(x - x_nu) < 20 && abs(y - y_nu) < 20)  
  { 
    digitalWrite(centerPin, LOW);
    Serial.println("neutral");
    delay(1000);
  } 
  else if ( abs(y - y_nu) > 20 && y > y_nu)  
  { 
    digitalWrite(forwardPin, LOW);
    Serial.println("forward");
    delay(1000);
  }
  else if ( abs(y - y_nu) > 20 && y < y_nu)  
  {
    digitalWrite(backPin, LOW);//backwards
    Serial.println("backward");
    delay(1000);
  }
  else if ( abs(x - x_nu) > 20 && x > x_nu)  
  { 
    digitalWrite(rightPin, LOW);
    Serial.println("right");
    delay(1000);
  }
  else if ( abs(x - x_nu) > 20 && x < x_nu)  
  { 
    digitalWrite(leftPin, LOW);
    Serial.println("left");
    delay(1000);
  }
}

