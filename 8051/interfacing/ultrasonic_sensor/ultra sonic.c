#include<reg52.h>
 
#define First_Line 0x80
#define Second_Line 0xc0
#define Curser_On  0x0f
#define Curser_Off 0x0c
#define Clear_Display 0x01
#define Data_Port P2
 
sbit Lcd_rs = P0^0;
sbit Lcd_rw = P0^2;
sbit Lcd_en = P0^1;
 
sbit echo= P3^2; 
sbit trig= P3^5;
 
void Distance_Measure();
void Lcd8_Init();
void Lcd8_Command(unsigned char);
void Lcd8_Write(unsigned char,unsigned char);
void Lcd8_Display(unsigned char,const unsigned char*,unsigned int);
void Lcd8_Decimal2(unsigned char,unsigned char);
void Lcd8_Decimal3(unsigned char,unsigned char);
void Lcd8_Decimal4(unsigned char,unsigned int);
void Delay(unsigned int);
void del();  
 
unsigned char i,inch1,inch2,result,obj_distance,rept,sec,j,a=0,c=0,kc,cu=0xc0,l,e[20],num[20],n,v[20];
unsigned long int count=0,count1=0;
 
void main()
{
 
EA=1;
ET0=1;
TMOD=0x01;
TH0=TL0=0x00;
TR0=1;
Lcd8_Init();Delay(65000); 
    Lcd8_Display(0x80,"Ultrasonic      ",16);
Lcd8_Display(0xc0,"                ",16);
Delay(65000);Delay(65000);
Lcd8_Display(0xC0,"Distance:       ",16);
 
while(1)
{
 
Distance_Measure();
 
}
}
 
 
void Distance_Measure()
{
count=count1=0;
TH0=0x00;TL0=0x00; 
TR0=0;
for(i=0;i<10;i++)         
{
trig=0;           
Delay(1000);
trig=1;           
Delay(10);
trig=0;   
while(echo==0);
TR0=1; 
while(echo==1);
TR0=0;
count=TH0<<8;      
count=count|TL0;    
TH0=TL0=0x00; 
count1=count1+count;
Delay(5000);        
}
count=count1/10;
inch1=count%10000/1000;
inch2=count%1000/100;
result=(inch1*10)+inch2;
 
obj_distance=result-2;  
Lcd8_Decimal3(0XCb,obj_distance); 
 
}
 
void Lcd8_Init()
{
Lcd8_Command(0x38); //to select function set
Lcd8_Command(0x06); //entry mode set
Lcd8_Command(0x0c); //display on
Lcd8_Command(0x01); //clear display
}
 
void Lcd8_Command(unsigned char com)
{
Data_Port=com;
Lcd_en=1;
Lcd_rs=Lcd_rw=0;
Delay(125);
Lcd_en=0;
Delay(125);
}
 
void Lcd8_Write(unsigned char com,unsigned char lr)
{
Lcd8_Command(com);
 
Data_Port=lr; // Data 
Lcd_en=Lcd_rs=1;
Lcd_rw=0;
Delay(125);
Lcd_en=0;
Delay(125);
}
 
void Lcd8_Display(unsigned char com,const unsigned char *word,unsigned int n)
{
unsigned char Lcd_i;
 
for(Lcd_i=0;Lcd_i<n;Lcd_i++)
{ 
Lcd8_Write(com+Lcd_i,word[Lcd_i]);
  }
}
 
void Lcd8_Decimal2(unsigned char com,unsigned char val)
{
unsigned int Lcd_hr,Lcd_t,Lcd_o;
 
Lcd_hr=val%100;
Lcd_t=Lcd_hr/10;
Lcd_o=Lcd_hr%10;
 
Lcd8_Write(com,Lcd_t+0x30);
Lcd8_Write(com+1,Lcd_o+0x30);
}
 
 
void Lcd8_Decimal3(unsigned char com,unsigned char val)
{
unsigned int Lcd_h,Lcd_hr,Lcd_t,Lcd_o;
 
Lcd_h=val/100;
Lcd_hr=val%100;
Lcd_t=Lcd_hr/10;
Lcd_o=Lcd_hr%10;
 
Lcd8_Write(com,Lcd_h+0x30);
Lcd8_Write(com+1,Lcd_t+0x30);
Lcd8_Write(com+2,Lcd_o+0x30);
}
 
 
 
void Delay(unsigned int del)
{
while(del--);
}

