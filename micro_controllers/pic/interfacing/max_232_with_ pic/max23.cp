#line 1 "G:/Users/celab/Desktop/max232 with pic/max23.c"

void main() {

ADCON0=0x01;
ADCON1=0x0E;
UART1_Init(9600);
 Delay_ms(100);

 UART1_Write_Text("Embedded Projects");
 UART1_Write(0x0D);
while(1)
{
 UART1_Write_Text("hello");


 }
 }
