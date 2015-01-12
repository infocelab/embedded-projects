#include<regx52.h>
int i=0,j,d=0;
sbit INC=P3^1;
void display(int);
void delay(unsigned int msec)  // Function to provide time delay in msec.
{
for(i=0;i<msec;i++)
for(j=0;j<675;j++);
}


void make_A()
{
	P1 = 0x02;
	P2 = 0xFC;
	delay(d);
	P1 = 0x04;
	P2 = 0x12;
	delay(d);
	P1 = 0x08;
	P2 = 0x12;
	delay(d);
	P1 = 0x10;
	P2 = 0x12;
	delay(d);
	P1 = 0x20;
	P2 = 0x12;
	delay(d);
	P1 = 0x40;
	P2 = 0xFC;
	delay(d);
}

void make_B()
{
	P1 = 0x02;
	P2 = 0x7C;
	delay(d);
	P1 = 0x04;
	P2 = 0x92;
	delay(d);
	P1 = 0x08;
	P2 = 0x92;
	delay(d);
	P1 = 0x10;
	P2 = 0x92;
	delay(d);
	P1 = 0x20;
	P2 = 0xFE;
	delay(d);
	P1 = 0x40;
	P2 = 0x82;
	delay(d);
}
void make_C()
{
	P1 = 0x02;
	P2 = 0x82;
	delay(d);
	P1 = 0x04;
	P2 = 0x82;
	delay(d);
	P1 = 0x08;
	P2 = 0x82;
	delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x82;
	delay(d);
	P1 = 0x40;
	P2 = 0x7C;
	delay(d);
}
void make_D()
{
	P1 = 0x02;
	P2 = 0x7C;
	delay(d);
	P1 = 0x04;
	P2 = 0x82;
	delay(d);
	P1 = 0x08;
	P2 = 0x82;
	delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x82;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
	P1 = 0x80;
	P2 = 0x82;
	delay(d);
}
void make_E()
{
	P1 = 0x02;
	P2 = 0x92;
	delay(d);
	P1 = 0x04;
	P2 = 0x92;
	delay(d);
	P1 = 0x08;
	P2 = 0x92;
	delay(d);
	P1 = 0x10;
	P2 = 0x92;
	delay(d);
	P1 = 0x20;
	P2 = 0x92;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
}
void make_F()
{
	P1 = 0x02;
	P2 = 0x12;
	delay(d);
	P1 = 0x04;
	P2 = 0x12;
	delay(d);
	P1 = 0x08;
	P2 = 0x12;
	delay(d);
	P1 = 0x10;
	P2 = 0x12;
	delay(d);
	P1 = 0x20;
	P2 = 0x12;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
	
} 
void make_G()
{
	P1 = 0x02;
	P2 = 0x00;
	delay(d);
	P1 = 0x04;
	P2 = 0x36;
	delay(d);
	P1 = 0x08;
	P2 = 0x52;
	delay(d);
	P1 = 0x10;
	P2 = 0x42;
	delay(d);
	P1 = 0x20;
	P2 = 0x42;
	delay(d);
	P1 = 0x40;
	P2 = 0x3C;
	delay(d);
}
void make_H()
{
	P1 = 0x02;
	P2 = 0xFE;
	delay(d);
	P1 = 0x04;
	P2 = 0x10;
	delay(d);
	P1 = 0x08;
	P2 = 0x10;
	delay(d);
	P1 = 0x10;
	P2 = 0x10;
	delay(d);
	P1 = 0x20;
	P2 = 0x10;
	delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
}
void make_I()
{
	P1 = 0x02;
	P2 = 0x00;
	delay(d);
	P1 = 0x04;
	P2 = 0x82;
	delay(d);
	P1 = 0x08;
	P2 = 0xFE;
	delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x00;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);
}

void make_J()
{
	P1 = 0x02;
	P2 = 0x00;
	delay(d);
	P1 = 0x04;
	P2 = 0x02;
	delay(d);
	P1 = 0x08;
	P2 = 0x7E;
	delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x40;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);
}
void make_K()
{
	P1 = 0x02;
	P2 = 0x00;
	delay(d);
	P1 = 0x04;
	P2 = 0x82;
	delay(d);
	P1 = 0x08;
	P2 = 0x82;
	delay(d);
	P1 = 0x10;
	P2 = 0x44;
	delay(d);
	P1 = 0x20;
	P2 = 0x28;
	delay(d);
	P1 = 0x40;
	P2 = 0xFF;
	delay(d);
}
void make_L()
{
	P1 = 0x02;
	P2 = 0x00;
	delay(d);
	P1 = 0x04;
	P2 = 0x80;
	delay(d);
	P1 = 0x08;
	P2 = 0x80;
	delay(d);
	P1 = 0x10;
	P2 = 0x80;
	delay(d);
	P1 = 0x20;
	P2 = 0x80;
	delay(d);
	P1 = 0x40;
	P2 = 0xFF;
	delay(d);
}
void make_M()
{
	P1 = 0x04;
	P2 = 0xFE;
		delay(d);
	P1 = 0x08;
	P2 = 0x04;
		delay(d);
	P1 = 0x10;
	P2 = 0x08;
		delay(d);
	P1 = 0x20;
	P2 = 0x04;	
		delay(d);
	P1 = 0x40;
	P2 = 0xFE;
	delay(d);
	//P1 = 0x40;
	//P2 = 0x00;
	//delay(d);
}
void make_N()
{
	P1 = 0x02;
	P2 = 0x7E;
		delay(d);
	P1 = 0x04;
	P2 = 0x20;
		delay(d);
	P1 = 0x08;
	P2 = 0x10;
		delay(d);
	P1 = 0x10;
	P2 = 0x08;	
		delay(d);
	P1 = 0x20;
	P2 = 0x04;
	delay(d);
	P1 = 0x40;
	P2 = 0x7E;
	delay(d);
		P1 = 0x80;
	P2 = 0x00;
	delay(d);
				
	}
void make_O()
{

	P1 = 0x01;
	P2 = 0x00;
		delay(d);
	P1 = 0x02;
	P2 = 0x00;
		delay(d);
	P1 = 0x04;
	P2 = 0x7C;
		delay(d);
	P1 = 0x08;
	P2 = 0x82;	
		delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x82;
	delay(d);
	P1 = 0x40;
	P2 = 0x7C;
	delay(d);
}
void make_P()
{
	P1 = 0x02;
	P2 = 0x1C;
		delay(d);
	P1 = 0x04;
	P2 = 0x22;
		delay(d);
	P1 = 0x08;
	P2 = 0x22;
		delay(d);
	P1 = 0x10;
	P2 = 0x22;	
		delay(d);
	P1 = 0x20;
	P2 = 0xFC;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);
}
void make_Q()
{
	//P1 = 0x01;
//	P2 = 0x00;
		delay(d);
	P1 = 0x01;
	P2 = 0x00;
		delay(d);
	P1 = 0x02;
	P2 = 0x80;
		delay(d);
	P1 = 0x04;
	P2 = 0x7C;
		delay(d);
	P1 = 0x08;
	P2 = 0xA2;	
		delay(d);
	P1 = 0x10;
	P2 = 0x82;
	delay(d);
	P1 = 0x20;
	P2 = 0x82;
	delay(d);
	P1 = 0x40;
	P2 = 0x7C;
	delay(d);
	
}
void make_R()
{
	P1 = 0x02;
	P2 = 0x1C;
		delay(d);
	P1 = 0x04;
	P2 = 0xA2;
		delay(d);
	P1 = 0x08;
	P2 = 0x62;
	delay(d);
	P1 = 0x10;
	P2 = 0x22;	
		delay(d);
	P1 = 0x20;
	P2 = 0x22;
	delay(d);
	P1 = 0x40;
	P2 = 0xFC;
	delay(d);

}
void make_S()
{
	P1 = 0x02;
	P2 = 0x00;
		delay(d);
	P1 = 0x04;
	P2 = 0x62;
		delay(d);
	P1 = 0x08;
	P2 = 0x92;
	delay(d);
	P1 = 0x10;
	P2 = 0x92;	
		delay(d);
	P1 = 0x20;
	P2 = 0x8C;
	delay(d);
	P1 = 0x40;
	P2 = 0x80;
	delay(d);
}
void make_T()
{
	delay(d);
	P1 = 0x02;
	P2 = 0x02;
		delay(d);
	P1 = 0x04;
	P2 = 0x02;
		delay(d);
	P1 = 0x08;
	P2 = 0xFE;
	delay(d);
	P1 = 0x10;
	P2 = 0x02;	
		delay(d);
	P1 = 0x20;
	P2 = 0x02;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);

}
void make_U()
{
	delay(d);
	P1 = 0x02;
	P2 = 0x7E;
		delay(d);
	P1 = 0x04;
	P2 = 0x80;
		delay(d);
	P1 = 0x08;
	P2 = 0x80;
	delay(d);
	P1 = 0x10;
	P2 = 0x80;	
		delay(d);
	P1 = 0x20;
	P2 = 0x7E;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);

}
void make_V()
{
	delay(d);
		P1 = 0x01;
	P2 = 0x0E;
		delay(d);
	P1 = 0x02;
	P2 = 0x010;
		delay(d);
	P1 = 0x04;
	P2 = 0x20;
		delay(d);
	P1 = 0x08;
	P2 = 0x40;
	delay(d);
	P1 = 0x10;
	P2 = 0x40;	
		delay(d);
	P1 = 0x20;
	P2 = 0x20;
	delay(d);
	P1 = 0x40;
	P2 = 0x10;
	delay(d);
	P1 = 0x80;
	P2 = 0x0E;
	delay(d);
}

void make_W()
{
	P1 = 0x02;
	P2 = 0xFE;
		delay(d);
	P1 = 0x04;
	P2 = 0x40;
		delay(d);
	P1 = 0x08;
	P2 = 0x20;
		delay(d);
	P1 = 0x10;
	P2 = 0x40;	
		delay(d);
	P1 = 0x20;
	P2 = 0xFE;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);
}
void make_X()
{
	P1 = 0x02;
	P2 = 0x42;
		delay(d);
	P1 = 0x04;
	P2 = 0x24;
		delay(d);
	P1 = 0x08;
	P2 = 0x18;
		delay(d);
	P1 = 0x10;
	P2 = 0x18;	
		delay(d);
	P1 = 0x20;
	P2 = 0x24;
	delay(d);
	P1 = 0x40;
	P2 = 0x42;
	delay(d);

}
void make_Y()
{
	P1 = 0x02;
	P2 = 0x02;
		delay(d);
	P1 = 0x04;
	P2 = 0x04;
		delay(d);
	P1 = 0x08;
	P2 = 0xF8;
		delay(d);
	P1 = 0x10;
	P2 = 0x04;	
		delay(d);
	P1 = 0x20;
	P2 = 0x02;
	delay(d);
	P1 = 0x40;
	P2 = 0x00;
	delay(d);
}
void make_Z()
{
	P1 = 0x02;
	P2 = 0x42;
		delay(d);
	P1 = 0x04;
	P2 = 0x46;
		delay(d);
	P1 = 0x08;
	P2 = 0x4A;
		delay(d);
	P1 = 0x10;
	P2 = 0x52;	
		delay(d);
	P1 = 0x20;
	P2 = 0x62;
	delay(d);
	P1 = 0x40;
	P2 = 0x42;
	delay(d);
}
void main ()
{
	int k=0, count=0;
	P1 = 0x00;
	delay(1);
	P2 = 0x00;
	d=1;
	P3=0xFF;

	while(1)
	{
		if( INC == 1) 
		{
			 count++;
				delay(1);
			if(count == 27)
				count=0;
		}
		for(k=0;k<100;k++)
		{
			display(count);
	  }
	  delay(2);
		
		/*
		for(k=0;k<100;k++)
		{
			make_A();
		}
		for(k=0;k<100;k++)
		{
			make_B();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_C();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_D();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_E();
		}
		delay(20);
			for(k=0;k<100;k++)
		{
			make_F();
		}
		delay(20);
		for(k=0;k<100;k++)
		{
			make_G();
		}
		delay(20);
	
			for(k=0;k<100;k++)
		{
			make_H();
		}
		delay(20);
			for(k=0;k<100;k++)
		{
			make_I();
		}
		delay(20);
			for(k=0;k<100;k++)
		{
			make_J();
		}
		delay(20);
			for(k=0;k<100;k++)
		{
			make_K();
		}
		delay(20);
			for(k=0;k<100;k++)
		{
			make_L();
		}
		delay(20);
	
	for(k=0;k<100;k++)
		{
			make_M();
		}
		delay(20);
	for(k=0;k<100;k++)
		{
			}
		delay(20);
	for(k=0;k<100;k++)
		{
			make_N();
		}
		delay(20);
	for(k=0;k<100;k++)
		{
				make_O();
		}
		delay(20);
	for(k=0;k<100;k++)
		{
						make_P();
		}
		delay(20);
	for(k=0;k<100;k++)
		{
									make_Q();					
		}
		delay(20);
for(k=0;k<100;k++)
		{
											make_R();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
											make_S();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
														make_T();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
														make_U();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
											make_V();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
													make_W();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
														make_X();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
																make_Y();					
		}
		delay(20);
	for(k=0;k<100;k++)
		{
																		make_Z();					
		}
		delay(20);
	*/
	}
}

void display(int i )
{
	switch(i)
	{
		case 1:
			make_A();
		break;
		case 2:
			make_B();
		break;
		case 3:
			make_C();
		break;
		case 4:
			make_D();
		break;
		case 5:
			make_E();
		break;
		case 6:
			make_F();
		break;
		case 7:
			make_G();
		break;
		case 8:
			make_H();
		break;
		case 9:
			make_I();
		break;
		case 10:
			make_J();
		break;
		case 11:
			make_K();
		break;
		case 12:
			make_L();
		break;
		case 13:
			make_M();
		break;
		case 14:
			make_N();
		break;
		case 15:
			make_O();
		break;
		case 16:
			make_P();
		break;
		case 17:
			make_Q();
		break;
		case 18:
			make_R();
		break;
		case 19:
			make_S();
		break;
		case 20:
			make_T();
		break;
		case 21:
			make_U();
		break;
		case 22:
			make_V();
		break;
		case 23:
			make_W();
		break;
		case 24:
			make_X();
		break;
		case 25:
			make_Y();
		break;
		case 26:
			make_Z();
		break;
		
		
	}
}
