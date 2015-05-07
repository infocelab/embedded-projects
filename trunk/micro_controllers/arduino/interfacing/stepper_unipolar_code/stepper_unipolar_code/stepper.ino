#include <Stepper.h>
// pins need to be set this way to fix reverse.
int in1Pin = 2;
int in2Pin = 3;
int in3Pin = 4;
int in4Pin = 5;
/*---wiring connection---//
int in1Pin = 4;
int in2Pin = 3;
int in3Pin = 5;
int in4Pin = 2;

*/
Stepper motor(64, in1Pin, in2Pin, in3Pin, in4Pin);

void setup(){
    pinMode(in1Pin, OUTPUT);
    pinMode(in2Pin, OUTPUT);
    pinMode(in3Pin, OUTPUT);
    pinMode(in4Pin, OUTPUT);
    motor.setSpeed(450);
}

void loop(){
    int steps = 2048;
   // motor.step(steps);
    //delay(1500);
    steps = -2048;
    //motor.step(steps);
    delay(1500); //Semicolon added
}
