// Name: Cellular Automata
// Description:This program creates a sequence of cellular automata. Cellular automata are simply sequences of 0's and 1's that the computer randomly generates, and then creates subsequent lines of 0's and 1's from the first. These automata create equilateral triangles made from 0's and are thought to be the beginnings of artificial intelligence programming.

#include <stdio.h>
#include <math.h>
#include <time.h>
#define LENGTH 100
main()
{
    int counter, counter2;
    int row[LENGTH] = {0}, number;
    
    printf("How many entries?\n");
    scanf("%d", &number);	
    
    while (number != -1)
    {		
        srand(time(NULL));
        for (counter = 1; counter <= number; counter++)
        row[counter] = rand() % 2; 
        
        for (counter2 = 1; counter2 <= 1000; counter2++)
        {	
            for (counter = 1; counter <= number; counter++)  
            {
                if (counter == number)
                row[counter] = 0;
                else	
                {
                    switch(row[counter])
                    {
                        case 0:
                        if (row[counter + 1] == 0)
                        row[counter] = 0;
                        else if (row[counter + 1] == 1)
                        row[counter] = 1;
                        break;

                        case 1:
                        if (row[counter + 1] == 0)
                        row[counter] = 1;
                        else if (row[counter + 1] == 1)
                        row[counter] = 0;
                        break;
                   } // switch
               } // else
           } // for 		
           for (counter = 1; counter <= number; counter++)
           printf("%d", row[counter]);
           printf("\n\a");	
       } // for

       printf("How many entries?\n");
       scanf("%d", &number);
    } // while	
    return 0;
} // main



