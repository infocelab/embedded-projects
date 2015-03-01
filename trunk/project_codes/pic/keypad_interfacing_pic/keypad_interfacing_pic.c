unsigned short kp, cnt, oldstate = 0;
char txt[6];
// Keypad module connections
char keypadPort at PORTB;
// End Keypad module connections
// LCD module connections
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
// End LCD module connections
void main()
{
  cnt = 0; // Reset counter
  Keypad_Init(); // Initialize Keypad
  Lcd_Init(); // Initialize Lcd
  Lcd_Cmd(_LCD_CLEAR); // Clear display
  Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
  Lcd_Out(1, 1, "1");
  Lcd_Out(1, 1, "Key :"); // Write message text on Lcd
  Lcd_Out(2, 1, "Times:");
  do
  {
    kp = 0; // Reset key code variable
    // Wait for key to be pressed and released
    do
      //kp = Keypad_Key_Press(); // Store key code in kp variable
      kp = Keypad_Key_Click(); // Store key code in kp variable
    while (!kp);
    // Prepare value for output, transform key to it's ASCII value
    switch (kp)
    {
      case 1: kp = 49; break; // 1
      case 2: kp = 50; break; // 2
      case 3: kp = 51; break; // 3
      case 4: kp = 65; break; // A commented since 4th column is absent for 4*3 keypad
      case 5: kp = 52; break; // 4
      case 6: kp = 53; break; // 5
      case 7: kp = 54; break; // 6
      case 8: kp = 66; break; // B commented since 4th column is absent for 4*3 keypad
      case 9: kp = 55; break; // 7
      case 10: kp = 56; break; // 8
      case 11: kp = 57; break; // 9
      case 12: kp = 67; break; // C commented since 4th column is absent for 4*3 keypad
      case 13: kp = 42; break; // *
      case 14: kp = 48; break; // 0
      case 15: kp = 35; break; // #
      case 16: kp = 68; break; // D
    }
    if (kp != oldstate)
    { // Pressed key differs from previous
      cnt = 1;
      oldstate = kp;
    }
    else
    { // Pressed key is same as previous
      cnt++;
    }
    Lcd_Chr(1, 10, kp); // Print key ASCII value on Lcd
    if (cnt == 255)
    { // If counter varialble overflow
      cnt = 0;
      Lcd_Out(2, 10, " ");
    }

    WordToStr(cnt, txt); // Transform counter value to string
    Lcd_Out(2, 10, txt); // Display counter value on Lcd
 } while (1);
}