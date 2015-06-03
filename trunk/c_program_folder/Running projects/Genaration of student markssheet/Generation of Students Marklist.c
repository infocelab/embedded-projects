
// Name: Generation of Students Marklist

#include <stdio.h>
#include <string.h>
#include <conio.h>
struct stud
    {
    char name[50];
    int rn;
    float cd;
    float ld;
    float m3;
    float ee;
    float edc;
};
void main()


    {
    int i,n;
    float tot[50],avg[50];
    struct stud sd[70];
   
    printf ("Enter how many no. of students : ");
    scanf ("%d",&n);
    for (i=0;i<n;i++)


        {
        printf ("Enter the name : ");
        scanf ("%s",sd[i].name);
        printf ("Enter the roll no.: ");
        scanf ("%d",&sd[i].rn);
        printf ("Enter the marks\n");
        printf ("Maths : ");
        scanf ("%f",&sd[i].m3);
        printf ("EDC : ");
        scanf ("%f",&sd[i].edc);
        printf ("L & D : ");
        scanf ("%f",&sd[i].ld);
        printf ("E.E : ");
        scanf ("%f",&sd[i].ee);
        printf ("C & D : ");
        scanf ("%f",&sd[i].cd);
        tot[i]=sd[i].m3+sd[i].cd+sd[i].ld+sd[i].edc+sd[i].ee;
        avg[i]=tot[i]/5;
    }
   
    printf ("\t\t\t|||||||||||||||||||\n");
    printf ("\t\t\t|| * MARK LIST * ||\n");
    printf ("\t\t\t|||||||||||||||||||\n");
    printf ("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    printf ("R.No.\tName\tMaths\t C&D\t L&D\t EDC\t E.E\t Total\tAverage\tResult\n");
    printf ("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    for (i=0;i<n;i++)


        {
        printf ("%d\t%s\t%3.0f\t%3.0f\t%3.0f\t%3.0f\t%3.0f\t%4.0f\t%3.2f\t",sd[i].rn,sd[i].name,sd[i].m3,sd[i].cd,sd[i].ld,sd[i].edc,sd[i].ee,tot[i],avg[i]);
        if ((sd[i].m3<50)&&(sd[i].cd<50)&&(sd[i].ld<50)&&(sd[i].edc<50)&&(sd[i].ee<50))


            {
            printf ("Fail\n");
            printf ("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
        else


            {
            printf ("Pass\n");
            printf ("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
    }
    getch();
}

		
