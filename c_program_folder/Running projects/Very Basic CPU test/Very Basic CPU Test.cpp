
// Name: CPU Test
// Description:Very Basic CPU Test. You input a number the code will
// show the time it takes to count from 1 to X. Please vote or comment on my code.

#include <iostream>
#include <ctime>
using namespace std;
int main()


    {
    system("CLS");
    long int startnumber = 0;
    long int number;
    cout << " ******************************\n"
    << " * CPU Test*\n"
    << " *by Asmodeus *\n"
    << " ******************************\n\n\n"
    << "This will measure the time is takes the CPU to\n"
    << "count from 1 to the number you input.\n\n"
    << "Please input a number - ";
    cin >> number;
    time_t rawtime1;
    time ( &rawtime1 );
    for (; startnumber < number ;)


        {
        startnumber++;
        cout << startnumber << " ";
    }
    if (startnumber == number)


        {
        int test;
        time_t rawtime;
        time ( &rawtime );
        cout << "\n\nStart Time Was --- " << ctime (&rawtime1) << endl;
        cout << "End Time Is--- " << ctime (&rawtime) << endl;
        system("PAUSE");
        cout << "\n\n\nRun another test?\n";
        cout << "[1] Yes\n"
        << "[2] No\n\n";
        cin >> test;
        if (test == 1)


            {
            main();
        }
        else if (test == 2)


            {
            return 0;
        }
    }
}

		
		
