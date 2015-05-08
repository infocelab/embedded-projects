#line 1 "G:/Users/celab/Desktop/pic gsm/keypad.c"
char AT[]="AT";
char noecho[]="ATE0";
char mode_text[]="AT+CMGF=1";
char char_mode[]="AT+CSCS=\"GSM\"";
char param[]="AT+CSMP=17,167,0,0";
char mobile_no[]="AT+CMGS=\"+92090078601\"";
char terminator=0x1A;
char mesg[]="welcome to microcontrollerslab.com";
void send_to_modem(char *s)
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
