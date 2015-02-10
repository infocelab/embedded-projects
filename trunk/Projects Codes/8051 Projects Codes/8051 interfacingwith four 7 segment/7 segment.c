 
#include<stdio.h>
#include<reg51.h>
unsigned char SetDisplay(unsigned char);
void delay();
sbit eseg1000 = P3^7;
sbit eseg100   = P3^6;
sbit eseg10   = P3^5;
sbit eseg1     = P3^4;
 
unsigned char d0,d1,d2,d3;
 
 
unsigned char SetDisplay(unsigned char value)
{
            unsigned char segment[]={0x3f,0x06,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x67};  
   if(value<=10)
                        return segment[value];
   else
                        return 0;
}
 
//--------------
//Delay Function
//--------------
void delay()
{        
   int i;          
   for(i=0; i<500; i++)
            i = i + 0;        
}                  
 
//--------------
//Main Program
//--------------
void main(void)
{
   unsigned char count = 0;  
   unsigned long timer = 0;
   int turn = 1;              
            P2 = 0xFF;
   while(1)
            {
       if(turn==1)                               //7-Seg Display 0
                        {
                                    eseg1000=0;
                                    eseg100=0;
                                    eseg10=0;
                                    eseg1=1;
                                    P2=SetDisplay(d0);
                           turn = 2;
                           delay();
                        }
                        else if(turn==2)       //7-Seg Display 1
                        {
                                    eseg1=0;
                                    eseg1000=0;
                                    eseg100=0;
                                    eseg10=1;
                                    P2=SetDisplay(d1);
                           turn = 3;
                           delay();
                        }
                        else if(turn==3)       //7-Seg Display 2
                        {
                                    eseg10=0;
                                    eseg1=0;
                                    eseg1000=0;
                                    eseg100=1;
                                    P2=SetDisplay(d2);
                           turn = 0;
                           delay();
                        }
                        else                                         //7-Seg Display 3
                        {
                                    eseg100=0;
                                    eseg10=0;
                                    eseg1=0;
                                    eseg1000=1;
                   P2=SetDisplay(d3);
                           turn = 1;
                           delay();
                        }
 
       if(timer == 100){
                       d0++;
                   timer=0;
                                    if(d0>=10){ 
                           d0=0;
                                    d1++;
                                                if(d1>=10){
                                                d1=0;
                                                d2++;
                                                            if(d2>=10){
                                                                        d2=0;
                                                                        d3++;
                                                                        if(d3>=10){
                                                                                    d3=0;
                                                                        }
                                                            }
                                       }
                                    }
               }
            timer++;       
   }
}
 