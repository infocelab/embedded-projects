
//INCLUDE files for :BAC(Binary to Array Convertor)

#include <iostream.h>
#include <fstream.h>
#include <string.h>
#include <stdio.h>
//**************************************
// Name: BAC(Binary to Array Convertor)
// Description:It extracts the bytes of a binary file into an array, wich you can later use by entering the file created by this prog into your project... what can this be used for... recreating the program or file, any TXT, JPG, EXE...

// Inputs:File to extract from, File to save to.
// Returns:The array with the program you extracted

int main(void)
    {
    char FName[2][256], AName[256];
    int byte, count = 0, cop = 0;
    long size = 0;
    FILE *IFile;
    cout << " BAC(Binary to Array Converter) v1.1" << endl;
    cout << " Programmed by: Marco Lugo" << endl;
    cout << endl;
    cout << " This program will convert any binary file to an array so you can store It" << endl;
    cout << " In your program or cpp file for later recreating the binary file." << endl;
    cout << endl;
    cout << endl;
    cout << " Enter filename of the file to convert: ";
    cin.getline(FName[0], 256, '\n');
    cout << " Enter filename of the file to save the array: ";
    cin.getline(FName[1], 256, '\n');
    IFile = fopen(FName[0], "rb");
    if(!IFile) return(-1);
    ofstream Arrayf(FName[1]);
    while(FName[0][cop] != '\0')


        {
        if(FName[0][cop] == '.')


            {
            AName[cop] = '_';
        }
        else


            {
            AName[cop] = FName[0][cop];
        }
        cop++;
    }
    AName[cop] = '\0';//Entering the NULL cahracter at the end of the array
    Arrayf << "int " << AName << "[] {" << endl;
    while(byte != -1)


        {
        byte = fgetc(IFile);
        if(count == 18)


            {
            Arrayf << endl;
            count = 0;
        }
        if(byte != -1)


            {
            Arrayf << byte << ", ";
            size++;
        }
        else


            {
            Arrayf << byte << " };";
        }
        count++;
    }
    fclose(IFile);
    Arrayf.close();
    cout << endl;
    cout << " " << size << " bytes of data where extracted and converted..." << endl;
    cout << endl;
    cout << endl;
    cout << " Press ENTER to exit...";
    cin.get();
    return(0);
}
		
		
