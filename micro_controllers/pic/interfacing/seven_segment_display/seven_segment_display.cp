#line 1 "E:/celabcode/Embedded-Projects/project_codes/pic/seven_segment_display/seven_segment_display.c"

unsigned short i;


unsigned short Mask_7seg(unsigned short num) {
 switch (num) {
 case 0: return 0x3F;
 case 1: return 0x06;
 case 2: return 0x5B;
 case 3: return 0x4F;
 case 4: return 0x66;
 case 5: return 0x6D;
 case 6: return 0x7D;
 case 7: return 0x07;
 case 8: return 0x7F;
 case 9: return 0x6F;
 }
}

void main() {
 INTCON = 0;
 TRISA = 0;
 TRISB = 0;
 PORTB = 0;
 PORTA = 2;


 do {
 for (i = 0; i <= 9u; i++) {
 PORTB = Mask_7seg(i);
 Delay_ms(1000);
 }
 } while (1);
}
