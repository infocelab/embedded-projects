//Program to make a digital thermometer with display in centigrade scale

#include<reg51.h>
#define port P0
#define adc_input P1
#define dataport P2
#define sec 100
sbit rs = port^0;
sbit rw = port^2;
sbit e = port^1;

sbit wr= port^3;
sbit rd= port^4;
sbit intr= port^5;

int test_intermediate3=0, test_final=0,test_intermediate1[10],test_intermediate2[3]={0,0,0};

void delay(unsigned int msec )
{
int i ,j ;
for(i=0;i<msec;i++)
  for(j=0; j<1275; j++);
}

void lcd_cmd(unsigned char item)  //Function to send command to LCD
{
dataport = item;
rs= 0;
//rw=0;
e=1;
delay(1);
e=0;
return;
}

void lcd_data(unsigned char item) //Function to send data to LCD
{
dataport = item;
rs= 1;
//rw=0;
e=1;
delay(1);
e=0;
//delay(100);
return;
}

void lcd_data_string(unsigned char *str)  // Function to send string to LCD
{
int i=0;
while(str[i]!='\0')
{
  lcd_data(str[i]);
  i++;
  delay(10);
}
return;
}

void shape()     // Function to create the shape of degree
{
lcd_cmd(64);
lcd_data(2);
lcd_data(5);
lcd_data(2);
lcd_data(0);
lcd_data(0);
lcd_data(0);
lcd_data(0);
lcd_data(0);
}
    
void convert()    // Function to convert the values of ADC into numeric value to be sent to LCD
{
int s;
test_final=test_intermediate3;
lcd_cmd(0xc1);
delay(2);
lcd_data_string("TEMP:");
s=test_final/100;
test_final=test_final%100;
lcd_cmd(0xc8);
if(s!=0)
lcd_data(s+48);
else
lcd_cmd(0x06);
s=test_final/10;
test_final=test_final%10;
lcd_data(s+48);
lcd_data(test_final+48);
lcd_data(0);
lcd_data('c');
lcd_data(' ');
delay(2);
}

void main()
{
int i,j;
adc_input=0xff;
lcd_cmd(0x38);
lcd_cmd(0x0c);  //Display On, Cursor  Blinking
delay(2);
lcd_cmd(0x01);  // Clear Screen
delay(2);

while(1)
{
lcd_cmd(0xc1);
delay(2);
lcd_data_string("TEMP:");
delay(2000);
continue;

for(j=0;j<3;j++)
  {
   for(i=0;i<10;i++)
   {
    delay(1);
    rd=1;
    wr=0;
    delay(1);
    wr=1;
    while(intr==1);
    rd=0;
    lcd_cmd(0x88);
    test_intermediate1[i]=adc_input/10;
    delay(1);
    intr=1;
   }
   for(i=0;i<10;i++)
   test_intermediate2[j]=test_intermediate1[i]+test_intermediate2[j];
  }

test_intermediate2[0]=test_intermediate2[0]/3;
test_intermediate2[1]=test_intermediate2[1]/3;
test_intermediate2[2]=test_intermediate2[2]/3;
test_intermediate3=test_intermediate2[0]+test_intermediate2[1]+test_intermediate2[2];
shape();
convert();
}
}
