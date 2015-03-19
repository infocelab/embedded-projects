
unsigned short i;

// Function returns mask of num for common cathode 7seg. display
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
}//~

void main() {
  INTCON = 0;  // Disable PEIE, INTE, RBIE, T0IE
  TRISA  = 0;
  TRISB  = 0;
  PORTB  = 0;
  PORTA  = 2;

  // Main loop
  do {
    for (i = 0; i <= 9u; i++) {
      PORTB = Mask_7seg(i);  // Display digit on 7seg display
      Delay_ms(1000);        // 1 second pause
    }
  } while (1);
}//~!