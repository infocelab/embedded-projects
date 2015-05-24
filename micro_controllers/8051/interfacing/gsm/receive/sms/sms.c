#include<reg51.h>
sbit rs=P0^0;
sbit rw=P0^2;
sbit e=P0^1;
void gsmcmdsend(unsigned char *cmd);


unsigned char card_id[96];
unsigned char header[]="CELAB";
unsigned char gsm_cmd3[]="AT&W";
unsigned char gsm_cmd4[]="AT+CMGF";
 int count=0;
void gsmcmdsend(unsigned char *cmd)		
{
	unsigned char i;
	for(i=0;*cmd!='\0';i++)
	{
		SBUF=*cmd;
	   	while(TI==0);
		TI=0;
		cmd++;
		}
		SBUF=0x0A;
		while(TI==0);
		TI=0;
		SBUF=0x0D;
		while(TI==0);
		TI=0;
		while(RI==0);
		RI=0;
}
void delay(int count)    //Function to provide delay
{
    int i,j;
    for(i=0;i<count;i++)
    for(j=0;j<1275;j++);
}
void cmm(char value)
{
	P2 = value;
	rs=0;
	rw=0;
	e=1;
	delay(1);
	e=0;
	delay(1);
	return;
}
void dat(char value)
{
	P2 =value;
	rs=1;
	rw=0;
	e=1;
	delay(1);
	e=0;
	delay(1);
	return;
}
void lcdin()
{	cmm(0x38);
	cmm(0x0e);
	cmm(0x01);
	cmm(0x06);
	cmm(0x85);
	return;
}
void recieve()     //Function to recieve data serialy from RS232 
{
	int flag=0;
    unsigned char k;
	int i=0;
	RI=0;
     for(k=0;k<=90;k++)
     { 
			   while(RI==0); 
     
		 if(SBUF == '#')
		 {
			 	RI=0;
		   card_id[i]='\0';
			 count=i;
 					break;		
		 }
		 if(flag == 1)
		 card_id[i++]=SBUF;
    
	
		   if(SBUF == '*')
			 {
 					flag=1;
				 count=0;
			 }
			RI=0;
    }
	
}
void main()
{
	int l,i;
	P1=0x00;
	lcdin();
	TMOD=0x20;            //Enable Timer 1
    TH1=0XFD;
    SCON=0x50;
    TR1=1;
gsmcmdsend(gsm_cmd3);
cmm(0x01);
gsmcmdsend(gsm_cmd4);
cmm(0x01);
cmm(0x85);
for(i=0;i<5;i++)
	{dat(header[i]);}
	cmm(0xc0);
while(1)
       {
	     recieve();
				 l=0;
		 
 cmm(0x01);
for(l=0;l<count;l++)
	{
		
		if(card_id[l] == '\0')
			break;
		dat(card_id[l]);
	}
    }
}


end;						//end of program  