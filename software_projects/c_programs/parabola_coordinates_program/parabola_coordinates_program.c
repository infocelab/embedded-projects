// Name: Parabola Coordinates Program
// Description: A program that finds coordinates to a parabola.

#include <stdio.h>
#include <math.h>
#include <conio.h>

int main()
    {
    float a, b, c, x1, x2, vp, z;
    printf("Please enter a, b, and c of your quadratic equation (in that order): ");
    scanf("%f",&a);
    scanf("%f",&b);
    scanf("%f",&c);
      
    x1 = (-b + sqrt(b*b - 4*a*c))/(2*a); //First x-intercept
    x2 = (-b - sqrt(b*b - 4*a*c))/(2*a); //Second x-intercept
    z = -b/(2*a);
    vp = (a*z)*(a*z) + (b*z) + c; //Vertex point
    
    printf("The x-intercepts are %lg and %f\n", x1, x2);
    printf("The y-intercept is %f\n", c);
    printf("The vertex point is %f , %f\n", z, vp);
    getch();
    return 0;
    }
	
		
