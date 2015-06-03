
// Name: decimal to time
// Description:this program coverts decimal number to time

#include <cstdlib>
#include <iostream>
using namespace std;
int main(int argc, char *argv[])

    {
    double min, stdmin;
    int stdn;
    //this program changes decimal number to hour and min
    cout <<"please time as Decimal ";
    cin >> stdmin;
    stdn=int(stdmin);
    min=stdmin-stdn;
    min=min* 0.6;
    cout << stdn << " h " << min*100 << " min\n";
    system("PAUSE");
    return EXIT_SUCCESS;
}

	
		
