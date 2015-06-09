// Name: All_In_One converter
// Description:This is a simple console application in c programming language. The code will create an exe converter application which can convert tempareture from c-f anf f-c and various distances

#include<stdio.h>
#include<conio.h>
void main()
{
    float c,f,km,m,rate;
    float rs,dollar,pound;
    float input;
    float inch,mm;
    int no;
    char ch;
    do
    {
        system("cls");        
        printf("(I)Temperature Conversion menu:\n\n");
        printf("1.Celsius to Fahrenhite\n2.Fahrenhite to celsius\n\n");
        printf("(II)Length Conversion menu:\n\n");
        printf("3.Kilometer to Meter\n4.Meter to Kilometer\n5.Kilometer to Mile\n6.Mile to Kilometer\n");
        printf("7.Inch to Milimeter\n8.Milimeter to Inch\n\n");
        printf("(III)Currency Conversion menu:\n\n");
        printf("9.Dollar to Rs.\n10.Rs. to Dollar\n11.Pound to Rs.\n12.Rs. to Pound\n\n");
        printf("Enter your choice(The no. of the submenu):");
        scanf("%d",&no);
        switch(no)
        {
            case 1:
            {
                printf("\nEnter the temperature in Celsius:");
                scanf("%f",&input);
                f=(input*1.8)+32;
                printf("\nThe temperature in Fahrenhite is:%f",f);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 2:
            {
                printf("\nEnter the temperature in Fahrenhite:");
                scanf("%f",&input);
                c=(input-32)*5/9;
                printf("\nThe temperature in Celsius is:%f",c);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 3:
            {
                printf("\nEnter the lenght in Kilometer:");
                scanf("%f",&input);
                m=(input*1000);
                printf("\nThe lenght in Meter is:%f",m);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 4:
            {
                printf("\nEnter the length in Meter:");
                scanf("%f",&input);
                km=input/1000;
                printf("\nThe lenght in Kilometer is:%f",km);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 5:
            {
                printf("\nEnter the length in Kilometer:");
                scanf("%f",&input);
                m=input*.6214;
                printf("\nThe lenght in Mile is:%f",m);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 6:
            {
                printf("\nEnter the length in Mile:");
                scanf("%f",&input);
                km=input/.6214;
                printf("\nThe length in Kilometer is:%f",km);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 7:
            {
                printf("\nEnter the lenght in Inch:");
                scanf("%f",&input);
                mm=input*25.4;
                printf("\nThe length in Milimeter is:%f",mm);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 8:
            {
                printf("\nEnter the length in Milimeter:");
                scanf("%f",&input);
                inch=input/25.4;
                printf("\nThe length in Inch is:%f",inch);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 9:
            {
                printf("\nEnter the Current rate of Dollar in RS.:");
                scanf("%f",&rate);
                printf("\nEnter the amount of Dollar:");
                scanf("%f",&input);
                rs=(rate*input);
                printf("\nThe total amount of Rs. is:%f",rs);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 10:
            {
                printf("\nEnter the Current rate of Dollar in RS.:");
                scanf("%f",&rate);
                printf("\nEnter the amount of Rs.:");
                scanf("%f",&input);
                dollar=(input/rate);
                printf("\nThe total amount of Dollar is:%f",dollar);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 11:
            {
                printf("\nEnter the currency rate of Pound in Rs.:");
                scanf("%f",&rate);
                printf("\nEnter the amount of Pound:");
                scanf("%f",&input);
                rs=rate*input;
                printf("\nThe total amount of Rs. is:%f",rs);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            case 12:
            {
                printf("\nEnter the currency rate of Pound in Rs.:");
                scanf("%f",&rate);
                printf("\nEnter the amonut of Rs.:");
                scanf("%f",&input);
                pound=input/rate;
                printf("\nThe total amount of Pound is:%f",pound);
                fflush(stdin);
                printf("\nDo you want to continue(y or n):");
                scanf("%c",&ch);
                if(ch=='n'||'N')
                break;
            };
            default:
            {
                printf("\n!WORNING!");
                printf("\n!There is no such kind of submenu,Please select a valid submenu no.");
            };
        };
    }
    while(ch=='y'||ch=='Y');
    getch();
}
	
		
