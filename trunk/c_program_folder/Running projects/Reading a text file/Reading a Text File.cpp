#include <iostream>     // std::cout
#include <fstream>      // std::ifstream
#include<conio.h>
int main () {

  std::ifstream ifs ("D:\Running projects\Reading a text file\a.txt", std::ifstream::in);

  char c = ifs.get();

  while (ifs.good()) {
    std::cout << c;
    c = ifs.get();
  }

  ifs.close();
getch();
  return 0;
  
}
		
		
