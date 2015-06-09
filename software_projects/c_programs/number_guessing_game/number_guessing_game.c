// Name: A Very Simple Number Guessing Game
// Description:The Number Guessing Game will generate a number between 1 and 100. The user will have infinite attempts to guess the number.
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
    int n;
    int num;
    srand(time(NULL)); //generate the random seed generator
    n = 1 + rand() % 100; //pick a number from 1 to 100
    printf("\nI have a number between 1 and 100\n");
    printf("Can you guess my number?\n");
    printf("Please type your first guess.\n");
    scanf("%d", &num);
    while (n != num)
    {
        if (num > n)
        {
            printf("Too High! Try again!\n");
            scanf("%d", &num);
        }
        else
        if (num < n)
        {
            printf("Too Low! Try again!\n");
            scanf("%d", &num);
        }
    }/*end of while loop*/
    printf("Excellent! You guessed the number!\n");
    return 0;
}

	
		
