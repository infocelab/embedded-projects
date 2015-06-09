// Description:this is a program that keeps a record of

#include <fstream.h>
#include <stdio.h>
int main()
{
    float money;
    printf("enter your amount that you want record\n");
    scanf("%f",&money);
    ofstream jout("record.rec");
    jout<<money<<'\n';
    return 0;
}

		
		
