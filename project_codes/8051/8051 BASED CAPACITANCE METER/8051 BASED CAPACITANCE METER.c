#include <reg51.h>
unsigned char j,n,t,DispBuf[4];
unsigned int cap;
unsigned char code
BitTab[4]={0xbf,0xdf,0xef,0xf7};//Bit driver code
unsigned char code
DispTab[11]={0xfe,0x70,0xed,0xf9,0x73,0xdb,0xdf,0xf0,0xff,0xfb,0x40};//Font code
sbit P1_2=P1^2;
sbit P3_6=P3^6;
main()        //Main program
{    TMOD=0x11;//Timer T0, T1 are working in a regular way
    TH1=0xec;
    TL1=0x78;//T1 time is 5ms time
    IE=0X88; //Open break
    TR1=1;  //Open Timer T1
    for(;;)  //Infinite loop, timer interrupt return point
        ;
}
Timer1() interrupt 3//Timer interrupt service routine
{    TH1=0xec;
    TL1=0x78;
    t=BitTab[j];//Take place value
    P1=P1|0x78;//P1.3-P1.6 get 1 free
    P1=P1&t;  //P1.3-P1.6 out of the bit value output
    t=DispBuf[j];//Remove the number to be displayed
    t=DispTab[t];//Code to take shape
    P3=t; //P3 output displayed by the font code
    j++;  //j as the digital control of the counter, value 0-3, display program which, through its recognized display digital tube
    if(j==4)
    j=0;
    n++;
    if(n==48)//Every once in 48 break capacitance measurements
    {  
        n=0;
        TH0=0;
        TL0=0;
        P1_2=1;//Begin charging capacitor
        TR0=1; //Open Timer T0
        for(;P3_6==0;)//Determine whether the charging voltage reaches the reference voltage
            ;
        TR0=0;//Charging voltage reaches the reference voltage, the timer T0 related
        P1_2=0;
        cap=TL0|(TH0<<8);//T0 timer values obtained in
        cap=cap-3;//Error correction
        if(cap>=2000)
        {
            DispBuf[3]=10;
            DispBuf[2]=10;
            DispBuf[1]=10;
            DispBuf[0]=1;  //Ultra range, the maximum display 1, the rest of you do not show (off)
        }
        if(cap<2000)  //Not exceed the range, take you value
        {
              DispBuf[3]=cap%10;//Check digit
            cap=cap/10;
            DispBuf[2]=cap%10;//Take 10 digits
            cap=cap/10;
            DispBuf[1]=cap%10;//Take 100 bits
            DispBuf[0]=cap/10;//The median take 1000
        }
    }
}