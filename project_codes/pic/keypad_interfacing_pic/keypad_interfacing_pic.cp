#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/keypad_interfacing_pic/keypad_interfacing_pic.c"
unsigned short kp, cnt, oldstate = 0;
char txt[6];

char keypadPort at PORTB;


sbit LCD_RS at RD2_bit;
sbit LCD_EN at RD3_bit;
sbit LCD_D4 at RC4_bit;
sbit LCD_D5 at RC5_bit;
sbit LCD_D6 at RC6_bit;
sbit LCD_D7 at RC7_bit;
sbit LCD_RS_Direction at TRISD2_bit;
sbit LCD_EN_Direction at TRISD3_bit;
sbit LCD_D4_Direction at TRISC4_bit;
sbit LCD_D5_Direction at TRISC5_bit;
sbit LCD_D6_Direction at TRISC6_bit;
sbit LCD_D7_Direction at TRISC7_bit;

void main()
{
 cnt = 0;
 Keypad_Init();
 Lcd_Init();
 Lcd_Cmd(_LCD_CLEAR);
 Lcd_Cmd(_LCD_CURSOR_OFF);
 Lcd_Out(1, 1, "1");
 Lcd_Out(1, 1, "Key :");
 Lcd_Out(2, 1, "Times:");
 do
 {
 kp = 0;

 do

 kp = Keypad_Key_Click();
 while (!kp);

 switch (kp)
 {
 case 1: kp = 49; break;
 case 2: kp = 50; break;
 case 3: kp = 51; break;
 case 4: kp = 65; break;
 case 5: kp = 52; break;
 case 6: kp = 53; break;
 case 7: kp = 54; break;
 case 8: kp = 66; break;
 case 9: kp = 55; break;
 case 10: kp = 56; break;
 case 11: kp = 57; break;
 case 12: kp = 67; break;
 case 13: kp = 42; break;
 case 14: kp = 48; break;
 case 15: kp = 35; break;
 case 16: kp = 68; break;
 }
 if (kp != oldstate)
 {
 cnt = 1;
 oldstate = kp;
 }
 else
 {
 cnt++;
 }
 Lcd_Chr(1, 10, kp);
 if (cnt == 255)
 {
 cnt = 0;
 Lcd_Out(2, 10, " ");
 }

 WordToStr(cnt, txt);
 Lcd_Out(2, 10, txt);
 } while (1);
}
