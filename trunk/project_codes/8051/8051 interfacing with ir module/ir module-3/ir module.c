#include<reg52.h>   
 
sbit led = P2^0;
sbit module = P0^0;
 
void Delay(int a)
{
    int j;
    int i;
    for(i=0;i<a;i++)
    {
        for(j=0;j<100;j++)
        {
        }
    }
}
 
void main()
{
     led=0;
     module=1;
                    
  while(1)
  {
           if(module == 1)
           {
                led=1;
                Delay(1000);
led=0;
                Delay(500);
           }
  }
}
 