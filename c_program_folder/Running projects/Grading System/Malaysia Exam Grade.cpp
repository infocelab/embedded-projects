
// Name: Malaysia Exam Grade
// Description:Display Malaysia examination grade for MCE examination based on the provided mark and display the count of student in scrience and literature art stream.

#include <iostream.h>
#include <conio.h>
//#include <cstring.h>
main()


    {
    double tot,pt,m1,m2,m3,m4,m5,m6,m7,m8,studA=0,studB=0,tot_studA=0,tot_studB=0,code;
    char name[30],stud_cls,grade,clss;
    cout<<" *********************************";
    cout<<"\n * REPORT CARD SYSTEM *";
    cout<<"\n * *";
    cout<<"\n *********************************";
    char x;
    x=='Y';
    while (x !='N')


        {
        cout<<"\n\n\n*******************************************************************************";
        cout<<"\n\nEnter your name:";
        cin.getline(name,30);
        cout<<"\n\nEnter your class: ";
        cin>>stud_cls;
        cout<<"Enter 8 mark for these subject:";
        cout<<"\n\nB.Melayu:";
        cin>>m1;
        cout<<"\nEnglish:";
        cin>>m2;
        cout<<"\nScience:";
        cin>>m3;
        cout<<"\nMathematics:";
        cin>>m4;
        cout<<"\nHistory:";
        cin>>m5;
        cout<<"\nGeografy:";
        cin>>m6;
        cout<<"\nKHB:";
        cin>>m7;
        cout<<"\nPendidikan Islam/Moral:";
        cin>>m8;
        tot=m1+m2+m3+m4+m5+m6+m7+m8;
        pt=(tot/800)*100;
        if((pt>=90)&&(pt<=100))
        cout<<"\nGrade=A+";
        else if((pt>=80)&&(pt<=89))
        cout<<"\nGrade=A";
        else if((pt>=75)&&(pt<=79))
        cout<<"\nGrade=A-";
        else if((pt>=74)&&(pt<=70))
        cout<<"\nGrade=B+";
        else if((pt>=65)&&(pt<=69))
        cout<<"\nGrade=B";
        else if((pt>=60)&&(pt<=64))
        cout<<"\nGrade=C+";
        else if((pt>=50)&&(pt<=59))
        cout<<"\nGrade=C";
        else if((pt>=40)&&(pt<=49))
        cout<<"\nGrade=D";
        else if((pt>=30)&&(pt<=39))
        cout<<"\nGrade=E";
        else if((pt>=0)&&(pt<=29))
        cout<<"\nGrade=G";
        else
        cout<<"\nInvalid input";
        cout<<"\nStudent Name:"<<name;
        cout<<"\nEnter grade:";
        cin>>grade;
        if ((grade=='A+')||(grade=='A')||(grade=='A-')||(grade=='B+')||(grade=='B'))


            {
            clss='A';
            cout<<"\nYou get Science Stream";
            cout<<"\nList of subject: \n \n 111 BahasaMelayu \n 112 English \n 113 Mathematics \n 114 Pendidikan Islam/Moral \n 115 History \n 116 Additional Mathematic \n *117 Physic \n *118 Chemistry \n *119 Biology \n *120 English for Science and Technology";
            cout<<"\nSubjects with sign '*' is for elective subject.\nYou are require to choose your elective subject because 8 subject";
            cout<<"is limit for exam.";
            int i;
            i=1;
            while (i<3)


                {
                cout<<"\n Enter code subject you want to choose:";
                cin>>code;
                if(code==117)
                cout<<"\nYou choose Physic as your elective subject";
                else if(code==118)
                cout<<"\nYou choose Chemistry as your elective subject";
                else if(code==119)
                cout<<"\nYou choose Biology as your elective subject";
                else if(code==120)
                cout<<"\nYou choose English for Scince and Technology as your elective subject";
                else
                cout<<"\n!!Invalid code!!";
                i++;
            }
            studA=studA+1;
        }
        else if ((grade=='C+')||(grade=='C')||(grade=='D')||(grade=='E')||(grade=='G'))


            {
            clss='B';
            cout<<"\nYou get Professional Literature";
            cout<<"\nYour subject:\n \n111 BahasaMelayu \n 112 English \n 113 Mathematics \n 114 Pendidikan Islam/Moral \n 115 History \n 116 Additional Mathematic \n *121 Accounting Principle \n *122 Fundamentals of Economy \n *123 Additional Mathematics";
            cout<<"\nSubjects with sign '*' is for elective subject.\nYou are require to choose your elective subject because 8 subject is limit for your exam.";
            int i;
            i=1;
            while (i<3)


                {
                cout<<"\n Enter code subject you want to choose:";
                cin>>code;
                if(code==121)
                cout<<"\nYou choose Accounting Principle as your elective subject";
                else if(code==122)
                cout<<"\nYou choose Fundamentals of Economy as your elective subject";
                else if(code==123)
                cout<<"\nYou choose Additional Mathematics as your elective subject";
                else
                cout<<"\n!!Invalid code!!";
                i++;
            }
            studB=studB+1;
        }
        else


            {
            cout<<"Invalid grade";
        }
        cout<<"\n\n\n\n\tStudent Name:"<<name;
        cout<<"\n\tPointer:"<<pt;
        cout<<"\n\tGrade:"<<grade;
        cout<<"\n\tNew Class:"<<clss;
        cout<<"\n\n\tEnter Y to continue and N to stop:";
        cin>>x;
    }
    tot_studA=tot_studA+studA;
    tot_studB=tot_studB+studB;
    cout<<"\n\tTotal Student get Science Stream:"<<tot_studA;
    cout<<"\n\tTotal Student get Professional Literature:"<<tot_studB;
    getch();
    return 0;
}
	
		
