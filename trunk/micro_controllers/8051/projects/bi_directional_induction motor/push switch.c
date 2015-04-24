#include<reg52.h>
//INPUT PIN
sbit INPUT = P3^1;
//OUTPUT PIN
sbit OUTPUT = P2^0;
int relay = 0;
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
	  P3 = 0xFF; //Por0 used as a Input Port
	  Delay(10);
	  P2 = 0x00;  //Por3 used as a Output Port
	  P3=0;
	  Delay(10);
	  
			while(1)
	   {
		  if(INPUT==1 )  // 1 - on
     {
         
				 if(relay==0)
				 {
          OUTPUT = 1;
			    Delay(5000);
					relay = 1;
					while(INPUT==1); 
				 }
				else
				{
					
					OUTPUT = 0;
			    Delay(5000);
					 relay = 0;
				}				
				
			
				
			}
		}
		Delay(1000);
	}
