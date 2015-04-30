#line 1 "G:/Celabcode/embedded-projects/micro_controllers/pic/projects/digital_voltmeter/digital_voltmeter.c"
sbit LCD_RS at RC2_bit;
sbit LCD_EN at RC3_bit;
sbit LCD_D4 at RC4_bit;
sbit LCD_D5 at RC5_bit;
sbit LCD_D6 at RC6_bit;
sbit LCD_D7 at RC7_bit;

sbit LCD_RS_Direction at TRISC2_bit;
sbit LCD_EN_Direction at TRISC3_bit;
sbit LCD_D4_Direction at TRISC4_bit;
sbit LCD_D5_Direction at TRISC5_bit;
sbit LCD_D6_Direction at TRISC6_bit;
sbit LCD_D7_Direction at TRISC7_bit;







unsigned long temp;
unsigned int i;
char digit[]="0.000 VOLTS";

void main() {


TRISA=0xFF;


ADCON0=0x01;
ADCON1=0x0E;



 Lcd_Init();

 Lcd_Cmd(_LCD_CLEAR);
 Lcd_Cmd(_LCD_CURSOR_OFF);
 LCD_Out(1,1,"EMBEDDED");
 LCD_Out(2,1,"PROJECTS BLOG");
 Delay_ms(1000);

 do {
 temp = ADC_Read(0);
 temp=temp*5000/1023;



 digit[0]=(temp/1000)+48;
 digit[2]=((temp%1000)/100)+48;
 digit[3]=(((temp%1000)%100)/10)+48;
 digit[4]=(((temp%1000)%100)%10)+48;

 LCD_Cmd(_LCD_CLEAR);
 LCD_Out(1,1,digit);


 Delay_ms(500);

 } while(1);
}
