char AT[]="AT";   // To initialize mode
char noecho[]="ATE0";   // To stop echo
char mode_text[]="AT+CMGF=1";   // to set text mode
char char_mode[]="AT+CSCS=\"GSM\"";   // to set character mode
char param[]="AT+CSMP=17,167,0,0";   // set the parameter of character
char mobile_no[]="AT+CMGS=\"+917827855025\"";   //use to set receinpent number and mesg
char terminator=0x1A;     // chartacter form of control + z terminator character
char mesg[]="welcome to microcontrollerslab.com";   // mesg we want to send
void send_to_modem(char *s)   //function to write anything serially
{
while(*s)
UART1_WRITE(*s++);
UART1_WRITE(0X0D);
}
void send_to_modem1(char *s)
{
while(*s)
UART1_WRITE(*s++);
}
void send_sms()
{

send_to_modem1(mesg);
delay_ms(100);
uart1_write(terminator);
delay_ms(1000);
}
void main()
{

UART1_INIT(9600);
send_to_modem(AT);
delay_ms(2000);
send_to_modem(noecho);
delay_ms(2000);
send_to_modem(mode_text);
delay_ms(2000);
send_to_modem(mobile_no);
delay_ms(2000);
send_sms();
}