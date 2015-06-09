// Name: Password Encryptor (Source Code)

#include<iostream.h>
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
int cmp(char *a,char *b);
void newp(void);
int main(void)
{
    FILE *fp;
    char passs[2][6];
    cout<<endl<<"This is Program is made by computronics lab"<<endl;
    if((fp=fopen("pass.pas","r"))==NULL)
    {
        newp();
        exit(0);
    }
    fgets(passs[0],7,fp);
    for(int i=0;i<6;i++)
    {
        passs[0][i]=passs[0][i]+1;
    }
    cout<<endl<<"Enter Password:";
    for(int i=0;i<6;i++)
    {
        passs[1][i]=getch();
        printf("*");
    }
    if((cmp(passs[0],passs[1]))==0)
    {
        cout<<endl<<"You Have Entered The Restricted Area Of The Program"<<endl;
    }
    else
    cout<<endl<<"Wrong Password"<<endl;
    fclose(fp);
    return 0;
}
void newp(void)
{
    FILE *fp;
    char pass[6],passs[6];
    int a=1;
    cout<<endl<<"This Is The First Time This Program Is Being Used In This Computer"<<endl;
    fp=fopen("pass.pas","w");
    while(a!=0)
    {
        cout<<endl<<"Enter Password:";
        for(int i=0;i<6;i++)
        {
            pass[i]=getch();
            fflush(stdin);
            printf("*");
        }
        pass[6]=' ';
        cout<<endl<<"Enter Password Again:";
        for(int i=0;i<6;i++)
        {
            passs[i]=getch();
            fflush(stdin);
            printf("*");
        }
        a=cmp(pass,passs);
        if(a!=0)
        cout<<endl<<"Passwords Do Not Match"<<endl;
    }
    for(int i=0;i<6;i++)
    {
        passs[i]=passs[i]-1;
    }
    fputs(passs,fp);
    fclose(fp);
}
int cmp(char *a,char *b)
{
    int z=0;
    for(int i=0;i<6;i++)
    {
        if(*(a+i)!=*(b+i))
        z=1;
    }
    return z;
}

		
		
