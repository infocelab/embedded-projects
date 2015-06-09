// Name: Quadratic Equation
// Description:Gives real number solutions to quadratic equation.

#include <stdio.h> // The stdlib library for keyboard input and console output
#include <stdlib.h> //Used for system() and exit() function
#include <math.h> //Used for sqrt() function
void prn_banner();
void prn_menu();
void quadratic_equation();
void prn_solutions();
void quit_program();
void yes_no();
void main()
{
    	system("cls"); //Clears screen
    	prn_banner(); //Call prn_banner() function
    	prn_menu(); //Call prn_menu() function
}
void prn_menu()
{
    	char menu_select; //One character set
    	printf("\n\t\t\t"); //Adds a line and three tabs
    	printf("Main Menu\n\n"); //Print out sentence and two lines
    	printf("1. Calculate Quadratic Equation Solutions\n"); //Print out sentence with one of two 
        //choices and a line
    	printf("2. Quit\n\n"); //Print out sentence with other of two choices and two lines
    	printf("Please enter your selection => "); //Prompts user to input selection
    	fflush(stdin); //Content of the last input is cleared
    	scanf("%c", &menu_select); //Read in character menu_select from keyboard
    	switch (menu_select) //Conditioned branching of character constant
       	{
      		case '1': //If character "1" is keyed in from keyboard then,
     	    	quadratic_equation(); //call quadratic_equation() function
                break; //Exit from loop
      		case '2': //If character "2" is keyed in from keyboard then,
			     quit_program(); //Call quit_program() function
			     exit(-1); //Exit function (ends program completely)
			     break; //Exit from loop
	    }
}
float not_legal(float e, float f)
{
    if(e != 0 && f >= 0) //If variable e is not equal to 0 and variable f is greater than or equal to 0,
    return 0;//then return the value 0
    else //Else if variable e is equal to 0 and variable f is less than 0,
    return 1;//then return the value 0
}
double solution1(float g, float h, float i)
{
    return (-h + sqrt(i))/(2*g); //Return the value of the equation (-h + sqrt(i))/(2*g)
}
double solution2(float j, float k, float l)
{
    return (-k - sqrt(l))/(2*j); //Return the value of the equation (-k - sqrt(l))/(2*j)
}
void quadratic_equation(void)
{
    float a, b, c, d, square; //Four floats set
    double quadratic_solution1, quadratic_solution2; //Two doubles set
    printf("\n\n\t"); //Print out two lines and a tab
    printf(" ax^2 + bx + c = 0 \n"); //Print out quadratic equation and a line
    do //Makes overall statement loop until requirements are met
    {
        do //Makes statement loop until requirements are met 
        {
            printf("\n"); //Print out a line
            printf("Please enter coefficient for a => "); //Prompts user to input a number for 
            //variable a
            scanf("%f", &a); //Read in variable a from the keyboard
            if(a == 0) //If variable a is equal to 0,
            printf("Equation Undefined. Please"
            " re-input the coefficient for a.\n"); //then print out sentence and a line
        } //If the requirement is met, then skip loop and go to next statement
       
        while(a == 0); //Loop only when variable a is equal to 0
            printf("\n"); //Print out a line
            printf("Please enter coefficient for b => "); //Prompt user to input a number for variable b
            scanf("%f", &b); //Read in variable b from the keyboard
            printf("\n"); //Print out a line
            printf("Please enter coefficient for c => "); //Prompt user to input a number for variable c
            scanf("%f", &c); //Read in variable c from the keyboard
            printf("\n"); //Print out a line
            square = (b*b-4*a*c); //Set variable square to b^2-4ac
            d = not_legal(a, square); //Set variable d to not_legal(a, square) function
            if(d == 1) //If variable d is equal to 1,
                printf("Real number solutions cannot be calculated. Please"
                "e-input the coefficients.\n"); //then print out sentence and a line
     } //If the requirement is met, then skip loop and go to next statement
    
     while(d == 1); //Loop overall statement only when variable a is equal to 0 or 
     //when square root of variable square is less than 0
     printf("For coefficients: a = %f\n", a); //Print out sentence and variable a,
     printf("\t\t b = %f\n", b);//variable b,
     printf("\t\t c = %f\n", c);//and variable c
     printf("\n"); //Print out a line
     quadratic_solution1 =solution1(a, b, square); //Set variable quadratic_solution1 to solution1(a, b. 
     //square) function
     quadratic_solution2 = solution2(a, b, square); //Set variable quadratic_solution2 to solution2(a, b, 
     //square) function 
     prn_solutions(quadratic_solution1, quadratic_solution2); //Call prn_solutions() function
     yes_no(); //Call yes_no() function
}
void prn_solutions(double m, double n)
{
    printf("Solutions: "); //Print out sentence
    printf("x = %f", m); //Print out sentence and value of variable m (returned from 
    //quadratic_equation() function)
    printf(", %f\n", n);//and variable n (returned from quadratic_equation() function)
    printf("\n"); //Print out a line
}
void quit_program()
{
    printf("\n"); //Print out a line
    printf("Y'all come back now ya hear?\n\n"); //Print out sentence
    printf("\n"); //Print out a line
}
void yes_no()
{
    int key = 0; //One integer set to 0
    printf("\n\n"); //Print out two lines
    printf("Would you like to quit? Y/N => "); //Prompt user to either quit or restart program
    do 
    {   //Makes program loop until requirement is met
        key = getchar(); //Integer is set to get character function
        if (key == 78 || key == 110) //If key "n" or "N" is keyed in from keyboard,
        main(); //then program prompts main() function
        else if (key == 98 || key == 121) //But if key "y" or "Y" is keyed in from keyboard,
        {
            printf("\n\n");//then print out two lines,
            key = 0;//set integer back to 0,
            exit(-1); //and end program completely
        }
    }
    while (1); //Ends loop only when any of the four keys are entered from keyboard
}
void prn_banner()
{
    printf("\n%s%s%s\n", // Print out the banner:
    " **********************************\n",
    " * Quadratic Equation Program *\n",
    " **********************************\n\n");
}



