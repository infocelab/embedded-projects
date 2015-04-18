#line 1 "G:/Celabcode/embedded-projects/micro_controllers/pic/interfacing/rfid/rfid.c"

sbit LCD_RS at RB2_bit;
sbit LCD_EN at RB3_bit;
sbit LCD_D4 at RB4_bit;
sbit LCD_D5 at RB5_bit;
sbit LCD_D6 at RB6_bit;
sbit LCD_D7 at RB7_bit;

sbit LCD_RS_Direction at TRISB2_bit;
sbit LCD_EN_Direction at TRISB3_bit;
sbit LCD_D4_Direction at TRISB4_bit;
sbit LCD_D5_Direction at TRISB5_bit;
sbit LCD_D6_Direction at TRISB6_bit;
sbit LCD_D7_Direction at TRISB7_bit;


void main()
{
 char i, rfid[13];
 Lcd_Init();
 Lcd_Cmd(_LCD_CLEAR);
 Lcd_Cmd(_LCD_CURSOR_OFF);
 Lcd_Out(1,1,"rfid tag reader");

 UART1_Init(9600);

 rfid[12] = '\0';

 while(1)
 {
 if(UART1_Data_Ready())
 {
 for(i=0;i<12;)
 {
 if(UART1_Data_Ready())
 {
 rfid[i] = UART1_Read();
 i++;
 }
 }

 if((rfid[0] ^ rfid[2] ^ rfid[4] ^ rfid[6] ^ rfid[8] == rfid[10]) && (rfid[1] ^ rfid[3] ^ rfid[5] ^ rfid[7] ^ rfid[9] == rfid[11]))
 {
 Lcd_Out(2,1,rfid);
 }
 else
 {
 Lcd_Out(2,1,"Error ");
 }
 }
 }
}
