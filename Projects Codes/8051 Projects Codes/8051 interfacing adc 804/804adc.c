
#include <REGX51.H>
#include<stdio.h>
#include<string.h>

sbit INTR = P0^5;
sbit RD_ADC = P0^4;
sbit WR_ADC = P0^3;
sfr MYDATA = 0x90;        //Port-1
sfr LcdData = 0xA0;        //Port-2
sbit RS =  P0^0;
sbit RW =  P0^2;
sbit EN =  P0^1;
void lcdcmd(unsigned char value);
void lcddata(unsigned char value);
void lcdstr(unsigned char msg[]);
void Delay(unsigned int itime);
void SerTX(unsigned char x);
void SerTX_str(unsigned char msg[]);
unsigned char msg[] = "temp --->";
void main()
{
    unsigned int temp;
    int hundreds,tens,ones;
    unsigned char buffer[10];
    TMOD = 0x20;    //Timer-1, 8-Bit Auto Reload Mode
    TH1 = 0xFD;        //9600 Baud Rate When Crystal Used is 11.0592MHZ
    SCON = 0x50;
    TR1 = 1;        //Start Timer
    MYDATA = 0xFF;    //Making P1 as Input Port
    INTR = 1;
    RD_ADC = 1;        //Set RD high
    WR_ADC = 1; 	//Set WR high
	lcdcmd(0x38);
    Delay(1);
    lcdcmd(0x0E);
    Delay(1);
    lcdcmd(0x01);
    Delay(1);
    lcdcmd(0x80);
    lcdstr("temp");
    lcdcmd(0x0C);
    while(1)
    {      
        lcdcmd(0xC0);                                                                
        WR_ADC = 0;        //Send WR Pulse
        Delay(1);
        WR_ADC = 1;        //Low-High Pulse means Start of Conversion
        while(INTR == 1);    //Wait until End of Conversion
        //When Conversion Gets Completed the INTR Pin Goes Low we get out of the Loop
        RD_ADC = 0;        //Send RD Pulse
        temp = MYDATA * 2;
        //Conversion Process Starts Here        
            ones = temp%1;
            temp = temp/1;
            tens = temp%1;
            hundreds = temp/10;
            sprintf(buffer,"%d.%d%d C",hundreds,tens,ones);
            lcdstr(buffer);
            SerTX_str(msg);
            SerTX_str(buffer);
            SerTX(13);
            SerTX(13);
            Delay(10);
            Delay(10);
            RD_ADC = 1;
    }
}
void lcdcmd(unsigned char value)
{
    LcdData = value;
    RS = 0;
    RW = 0;
    EN = 1;
    Delay(1);
    EN = 0;
}
void lcddata(unsigned char value)
{
    LcdData = value;
    RS = 1;
    RW = 0;
    EN = 1;
    Delay(1);
    EN = 0;
}
void Delay(unsigned int itime)
{
    unsigned int i,j;
    for(i=0;i<1275;i++)
    for(j=0;j<itime;j++);
}
void lcdstr(unsigned char msg[])
{
    unsigned short int len,i;
    len = strlen(msg);
    for(i=0;i<len;i++)
    {
        lcddata(msg[i]);
        Delay(1);
    }
}
void SerTX(unsigned char x)
{
    SBUF = x;
    while(TI == 0);
    TI = 0;
}
void SerTX_str(unsigned char msg[])
{
    unsigned short len,i;
    len = strlen(msg);
    for(i=0;i<len;i++)
    {    
        SerTX(msg[i]);
    }
}


