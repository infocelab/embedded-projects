
void main() {

ADCON0=0x01;
ADCON1=0x0E;
UART1_Init(9600);               // Initialize UART module at 9600 bps
  Delay_ms(100);                  // Wait for UART module to stabilize

   UART1_Write_Text("Embedded Projects");
   UART1_Write(0x0D);
while(1)
{
 UART1_Write_Text("hello");

      //Carriage Return);
    }
  }