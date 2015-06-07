#include <iostream>     
#include <fstream>      
#include <conio.h>

int main () 
{
    std::ifstream ifs ("a.txt", std::ifstream::in);
    char c = ifs.get();
    while (ifs.good()) 
    {
        std::cout << c;
        c = ifs.get();
    }
    ifs.close();
    getch();
    return 0;
}
		
		
