
// Name: driven Software for book and tape selling Store
// Inputs:(1) enter Option
/*
(2) title of publication
(3) Three Sales
(4) Book Title
(5) Page Count
(6) Tape Title
(7) Tape Size*/
// Returns:(1) Three Sales
//(2) Book Title
//(3) Page Count
//(4) Tape Title
//(5) Tape Size
//
#include<iostream.h>
class publication
{
    private:
    char str[50];
    public:
    void input(void)
    {
        cout<<"enter the title of publication:"<<endl;
        cin.get(str,50);
    }
    virtual void getdata()=0;
    virtual void putdata()=0;
};
class sales
{
    protected:
    int i; 
    float array[3];
    public:
    void getdata(void)
    {
        cout<<"enter sales:"<<endl; 
        for(i=0;i<=2;i++)
        { 
            cin>>array[i];
            cin.get();
        }
    }
    void putdata(void)
    { 
        cout<<"three sales:"<<endl;
        for(i=0;i<=2;i++)
        {
        cout<<array[i]<<endl;
        }
    }
};
class book:public publication,public sales 
{
    private:
    char str1[50];
    int page_count;
    public:
    void getdata(void)
    {
        cout<<"........Book Detail......."<<endl;
        cout<<"enter the title :"<<endl;
        cin.get(str1,50);
        cout<<"enter a page count"<<endl;
        cin>>page_count;
        cin.get();
        sales::getdata();
    }
    void putdata(void)
    {
         cout<<"The title:"<<str1<<endl;
        cout<<"A page count:"<<page_count<<endl;
        sales::putdata();
    }
};
class tape:public publication,public sales
{
    private:
    char str3[50];
    int tape_size;
    public:
    void getdata(void)
    {
        cout<<"........Tape Detail......."<<endl;
        cout<<"enter the title:"<<endl;
        cin.get(str3,50);
        cout<<"enter the tape size:"<<endl;
        cin>>tape_size;
        sales::getdata();
    }
    void putdata(void)
    { cout<<"The title is "<<str3<<endl;
        cout<<"The size of tape is "<<tape_size<<endl;
        sales::putdata();
    }
};
int main()
{ 
    publication *x[10];
    int i,ch,j;
    i=0;
    do
    {
        cout<<"1 Tape"<<endl
        <<"2 Book"<<endl
        <<"3 Exit"<<endl
        <<"enter your option:";
        cin>>ch;
        cin.get();
        if (ch==1) x[i]=new tape;
        else
        if (ch==2) x[i]=new book;
        else
        if (ch==3) break;
        else
        continue;
        x[i]->getdata();
        i++;
    }
    while(i<10||ch!=3);
    for(j=0;j<i;j++) x[j]->putdata();
    return 0;
}


	
