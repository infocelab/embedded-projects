//Reading text file
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>
int main ( void )
{
    static const char filename[] = "chat.log";
    FILE *file = fopen ( "a.txt", "r" );
    if ( file != NULL )
    { 
        char line [ 128 ]; /* or other suitable maximum line size */
        while ( fgets ( line, sizeof line, file ) != NULL ) /* read a line */
        {
            fputs ( line, stdout ); /* write the line */
        } 
        fclose ( file );
    }
    else
    {
        perror ( filename ); /* why didn't the file open? */
    }
    getch();
    return 0;
}
