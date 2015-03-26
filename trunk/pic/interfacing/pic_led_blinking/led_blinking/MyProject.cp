#line 1 "C:/Users/ABC/Desktop/led blinking/MyProject.c"
void main()
{
 trisb=0x00;
 while(1)
 {
 portb.rb0=0x00;
 delay_ms(200);
 portb.rb0=0xff;
 delay_ms(200);
 }

}
