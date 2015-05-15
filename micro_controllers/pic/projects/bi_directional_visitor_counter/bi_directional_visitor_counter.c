// LCD module connections
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
// End LCD module connections
#define ENTER RD0_bit
#define EXIT RD1_bit
void Delay(int a)
{
    int j;
    int i;
    for(i=0;i<a;i++)
    {
        for(j=0;j<100;j++)
        {
        }
    }
}

char toChar(int a)
{
switch(a)
        {
                case 1:
                return '1';
                break;
                case 2:
                return '2';
                break;
                case 3:
                return '3';
                break;
                case 4:
                return '4';
                break;
                case 5:
                return '5';
                break;
                case 6:
                return '6';
                break;
                case 7:
                return '7';
                break;
                case 8:
                return '8';
                break;
                case 9:
                return '9';
                break;
                case 0:
                return '0';
                break;

        }

}
void main()
{
        int i,j,k,l;
        int count=0;
        char c;
        ENTER=1;
        EXIT=1;
  TRISD = 0xFF; // PORTD as input
 Lcd_Init(); // Initialize LCD
 Lcd_Cmd(_LCD_CLEAR); // Clear display
 Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
  Lcd_Out(1,1,"WELCOME:");//Write text'Hello World' in first row
  c=toChar(count);
   Lcd_chr(2,1,c);
 while(1)
{
 if(ENTER == 1)
 {
   Lcd_Cmd(_LCD_CLEAR);
   Lcd_Out(1,1,"WELCOME");
   count++;
     if(count == 999)
     count=0;
     Delay(500);
 }
  if(EXIT == 1)
  {
   Lcd_Cmd(_LCD_CLEAR);
   Lcd_Out(1,1,"THANKS");
   count--;
if(count == -1)
count=0;
Delay(500);
}
    i=count;
    j=i%10;
    k=i/10;
    l=i/100;
    k=k-l*10;
    c=toChar(j);
    Lcd_chr(2,3,c);
    c=toChar(k);
    Lcd_chr(2,2,c);
    c=toChar(l);
    Lcd_chr(2,1,c);
    }
    }