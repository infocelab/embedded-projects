#include <stdio.h>
#include<conio.h>
#include <stdlib.h>
 
int main()
 {
          int i=1, num, max=5;
          while(i<=5)
          {
                     num=rand();
                     if(num>=100&&num<=200)
                           {
                           printf("\nRandom number is: %d",num);
                           i++;
                           }
          else
          {
          i=i  ;        
          }
          }
 getch();
  return 0;
}
