sbit INPUT1 at RD0_bit;
sbit INPUT2 at RD1_bit;
sbit INPUT3 at RD2_bit;
sbit INPUT4 at RD3_bit;
sbit OUTPUT1 at RC0_bit;
sbit OUTPUT2 at RC1_bit;
sbit OUTPUT3 at RC2_bit;
sbit OUTPUT4 at RC3_bit;
int relay1 = 0;
int relay2 = 0;
void main() {
   TRISD = 0xFF; // PORTD as input
   TRISC = 0x00; // PORTC as output
   
while(1)
{
if(INPUT1==0 && INPUT2==1 && INPUT3==1 && INPUT4==1)  // 1 - on
    {

if(relay1==0)
{
OUTPUT2 = 1;
 delay_ms(200);
 OUTPUT1 = 0;
 OUTPUT3 = 0;
 OUTPUT4 = 0;
  delay_ms(200);
 relay1 = 1;
 }
else
{

OUTPUT2 = 0;
 delay_ms(200);
 OUTPUT1 = 0;
 OUTPUT3 = 0;
 OUTPUT4 = 0;
  delay_ms(200);
 relay1 = 0;
}
 delay_ms(2000);

}

if(INPUT1==1 && INPUT2==0 && INPUT3==1 && INPUT4==1)  // 1 - on
   {

if(relay2==0)
 {
 OUTPUT4 = 1;
 delay_ms(200);
 OUTPUT1 = 0;
 OUTPUT2 = 0;
 OUTPUT3 = 0;
  delay_ms(200);
 relay2 = 1;
 }
else
{

OUTPUT4 = 0;
 delay_ms(200);
OUTPUT1 = 0;
 OUTPUT2 = 0;
 OUTPUT3 = 0;
 delay_ms(200);
 relay2 = 0;
}
 delay_ms(2000);

}


}
}