//INCLUDE files for :Easy directory listing
#include <iostream.h>
#include <windows.h>
#include <conio.h>

int GetDir(char* dPath)
{
    WIN32_FIND_DATA FileData;
    HANDLE hFile;
    hFile = FindFirstFile(dPath,&FileData);
    if ( INVALID_HANDLE_VALUE == hFile ) 
    {
        cout << "No files" << endl;
        return false;
    }
    for ( ;; )
    {
        cout << FileData.cFileName << endl;
        if ( 0 == FindNextFile(hFile, &FileData ) )
        break;
    }
    return true;
}
int main()
{
    GetDir("a.txt");
    getch();
    return true;
}
	
		
