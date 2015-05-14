#line 1 "G:/Celabcode/embedded-projects/micro_controllers/pic/interfacing/rf_module/rf.c"

void main()
{
 TRISD = 0xFF;
 TRISB = 0x00;
 RB0_bit=0;
 RB1_bit=0;
 RB2_bit=0;
 RB3_bit=0;

 while(1)
 {
 if(RD0_bit==0 && RD1_bit==1 )
 {
 if( RB0_bit== 0 )
 {
 delay_ms(200);
 RB1_bit = 0;
 delay_ms(200);
 RB0_bit=1;
 }
 else
 {
 RB1_bit = 0;
 delay_ms(200);
 RB0_bit=0;
 }
 delay_ms(200);
 }

 if(RD0_bit==1 && RD1_bit==0 )
 {
 if( RB1_bit== 0 )
 {
 delay_ms(200);
 RB0_bit = 0;
 delay_ms(200);
 RB1_bit=1;
 }
 else
 {
 RB0_bit = 0;
 delay_ms(200);
 RB1_bit=0;
 }
 delay_ms(200);
 }
 }
 }
