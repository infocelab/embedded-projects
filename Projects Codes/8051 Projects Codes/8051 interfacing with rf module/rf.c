#include<reg52.h>
//INPUT PIN
sbit INPUT1 = P0^0;
sbit INPUT2 = P0^1;
sbit INPUT3 = P0^2;
sbit INPUT4 = P0^3;
//OUTPUT PIN
sbit OUTPUT1 = P2^1;
sbit OUTPUT2 = P2^2;
sbit OUTPUT3 = P2^3;
sbit OUTPUT4 = P2^4;
int relay1 = 0;
int relay2 = 0;
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
	  int relay1 = 0;
	int relay2 = 0;
	  int i;
	  P0 = 0xFF; //Por0 used as a Input Port
	  Delay(10);
	  P2 = 0x00;  //Por3 used as a Output Port
	  Delay(10);
	  
			while(1)
	{
		if(INPUT1==0 && INPUT2==1 && INPUT3==1 && INPUT4==1)  // 1 - on
    {
         
				 if(relay1==0)
				 {
          OUTPUT2 = 1;
			    Delay(100);
			    OUTPUT1 = 0;
			    OUTPUT3 = 0;
			    OUTPUT4 = 0;
		      Delay(100);
					 relay1 = 1;
				 }
				else
				{
					
					OUTPUT2 = 0;
			    Delay(100);
			    OUTPUT1 = 0;
			    OUTPUT3 = 0;
			    OUTPUT4 = 0;
		      Delay(100);
					 relay1 = 0;
				}				
				Delay(1000);
				
			}
			
		if(INPUT1==1 && INPUT2==0 && INPUT3==1 && INPUT4==1)  // 1 - on
    {
         
				 if(relay2==0)
				 {
          OUTPUT4 = 1;
			    Delay(100);
			    OUTPUT1 = 0;
			    OUTPUT2 = 0;
			    OUTPUT3 = 0;
		      Delay(100);
					 relay2 = 1;
				 }
				else
				{
					
					OUTPUT4 = 0;
			    Delay(100);
			    OUTPUT1 = 0;
			    OUTPUT2 = 0;
			    OUTPUT3 = 0;
		      Delay(100);
					 relay2 = 0;
				}				
				Delay(1000);
				
			}
			
	
    }
	}
