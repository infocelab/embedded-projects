
// Name: Largest of Three Numbers 2.0
#include <stdio.h>
#include <conio.h>
int main(){
      float a, b, c;
      printf("Enter three numbers: ");
      scanf("%f %f %f", &a, &b, &c);
      if(a>=b && a>=c)
         printf("Largest number = %.2f", a);
      if(b>=a && b>=c)
         printf("Largest number = %.2f", b);
      if(c>=a && c>=b)
         printf("Largest number = %.2f", c);
      getch();
      return 0;
}

	
		
