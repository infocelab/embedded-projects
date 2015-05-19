#include<reg52.h>
#include<stdio.h>
#include <intrins.h>

sbit motor_pin = P2^0;
void Delay(unsigned int);
void Delay_servo(unsigned int);
void main()
{
  motor_pin = 0;

  do
  {
    //Turn to 0 degree
    motor_pin = 1;
    Delay_servo(50);
    motor_pin = 0;

    Delay(1000);

    //Turn to 90 degree
    motor_pin=1;
    Delay_servo(82);
    motor_pin=0;

    Delay(1000);
    //Turn to 180 degree
    motor_pin=1;
    Delay_servo(110);
    motor_pin=0;

    Delay(1000);
  }while(1);
}

void Delay(unsigned int ms)
{
  unsigned long int us = ms*1000;
  while(us--)
  {
    _nop_();
  }
}

void Delay_servo(unsigned int us)
{
  while(us--)
  {
    _nop_();
  }
}