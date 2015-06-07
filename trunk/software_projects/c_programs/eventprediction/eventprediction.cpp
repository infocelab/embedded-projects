// Description:A demonstration of recursion to generate all the possible outcomes of a coin toss of given number of tosses.We will constrain the number of consecutive heads just to show you how flexible this data structure is and it can be modified to apply in various situations

#include <iostream>
#include <string>
#include <conio.h>
using namespace std;
class node
{
    public:
    node* left;
    node* right;
    node()   
    {
        left=NULL;
        right=NULL;
    }
};
static int head=0;
static int level=0;
static int num_nodes=0;
static string combo="";
static int leaves=0;
class tree
{
    public:
    node* root;
    tree()
    {
        root=NULL;
    }
    void add_nodes(node *&ptr,int heads, int levels)        
    {    
        ptr = new node;
        num_nodes++;
        if(head<heads && level<levels)         
        {
            head++;
            level++;
            combo+='H';
            add_nodes(ptr->left,heads,levels);
        }
        else
            head=0;
        if(level<levels)
        {
            level++;
            combo+='T';
            add_nodes(ptr->left,heads,levels);
        }
        if(level==levels)
        {
            leaves++;
            cout << combo << endl;
        }
        level--;
        string temp;
        if(combo.size()>0)
        {
            for(int i=0;i<(combo.size()-1);i++)
            temp += combo[i];
            combo=temp;
        }
    }
    void add_nodes(int heads, int levels)
    {
        add_nodes(root,heads,levels);
    }
};
int main()
{
    tree me;
    int heads;
    int levels;
    cout << "Welcome to Event Prediction (via the binary tree ADT) demo." << endl;
    cout << "\nDon't get this program wrong, the purpose of this is to generate all the possible outcomes of a coin toss of given number of tosses." << endl;
    cout << "<Note> : We will constrain the number of consecutive heads just to show you how flexible this data structure is and it can be modified to apply in various situations." << endl;
    cout << "\n" << endl;
    cout << "Enter max consecutive heads: ";
    cin >> heads;
    cout << "Enter max tosses: ";
    cin >> levels;
    cout << "\nH = Heads" << endl;
    cout << "T = Tails\n" << endl;
    me.add_nodes(heads,levels);
    cout << "\nNumber of Nodes built in the tree: " << num_nodes << endl;
    cout << "Number of Possible combinations (Leaves of the tree): " << leaves << endl;
    getch();
    return 0;
}



