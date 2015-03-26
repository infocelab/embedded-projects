int motor_left[] = {5, 6};
int motor_right[] = {4, 3};
 
void setup() {
  // Setup motors
  int i;
    for(i = 0; i < 2; i++){
    pinMode(motor_left[i], OUTPUT);
    pinMode(motor_right[i], OUTPUT);
  }
}
 
void loop() {
  digitalWrite(motor_left[0], HIGH); 
  digitalWrite(motor_left[1], LOW); 
  digitalWrite(motor_right[0], HIGH); 
  digitalWrite(motor_right[1], LOW); 
  delay(1000);
 
  digitalWrite(motor_left[0], LOW); 
  digitalWrite(motor_left[1], LOW); 
  digitalWrite(motor_right[0], LOW); 
  digitalWrite(motor_right[1], LOW); 
  delay(25);
 
  digitalWrite(motor_left[0], LOW); 
  digitalWrite(motor_left[1], HIGH); 
  digitalWrite(motor_right[0], LOW); 
  digitalWrite(motor_right[1], HIGH);
  delay(1000);
 
  digitalWrite(motor_left[0], LOW); 
  digitalWrite(motor_left[1], LOW); 
  digitalWrite(motor_right[0], LOW); 
  digitalWrite(motor_right[1], LOW); 
  delay(25);
}
