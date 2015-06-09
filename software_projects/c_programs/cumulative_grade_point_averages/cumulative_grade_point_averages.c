// Name: cumulative grade point average calculator
// Description:The code asks fo number of theory and sessional /practical papers and their names and grades obtained in the respective papers and displays the cgpa obtained.

#define CREDIT_TH 3
#define CREDIT_SS 2
#include<conio.h>
#include<stdio.h>
void main()
{
	int calculate(char);
	double cgpa;
	double den;
	int p,s;
	int i,j;
	int gp_theory=0,gp_sessional=0;
	system("cls");
    struct theory
   	{
		char subject[30];
		char grade;
	};
	struct theory th_paper[10];
	
	struct sessional
	{
		char sub[30];
		char grd;
	};
	struct sessional se_paper[10];
	
	printf("Number of Theory Papers:");
	scanf("%d",&p);
	printf("Number of Sessionals:");
	scanf("%d",&s);
	den=(p*CREDIT_TH)+(s*CREDIT_SS);
	
	for(i=0;i<p;i++)
	{
		printf("\nTheory Paper %d:",i+1);
		scanf("%s",&th_paper[i].subject);
		printf("\nGrade:");
		scanf("%s",&th_paper[i].grade);
		gp_theory+=(CREDIT_TH*calculate(th_paper[i].grade));
   	}
   	for(j=0;j<s;j++)
   	{
		printf("\nSessional %d:",j+1);
		scanf("%s",&se_paper[j].sub);
		printf("\nGrade:");
		scanf("%s",&se_paper[j].grd);
		gp_sessional+=(CREDIT_SS*calculate(se_paper[j].grd));
    }
    cgpa=(gp_theory+gp_sessional)/den;
	printf("\nCGPA:%.2f",cgpa);
	getch();
}
int calculate(char temp)
{
    switch(temp)
    {
        case 's':
        return 10;
        case 'a':
        return 9;
        case 'b':
        return 8;
        case 'c':
        return 7;
        case 'd':
        return 6;
        case 'e':
        return 5;
        case 'f':
        return 0;
    }
}



