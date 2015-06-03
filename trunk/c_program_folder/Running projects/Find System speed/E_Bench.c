// Name: E_Bench
// Description:This is a simple benchmarking program - that is, it executes a specific procedure that is the same over all computers to determine their approximate speed.
//The results for my computer and two of my friends' computers are in the source file comments. Email me if you have something like dual P4's and you obtained a ridiculous rating.

#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <stdio.h>
#include <math.h>

    int PASCAL WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,


        						LPSTR lpCmdLine, int nCmdShow) {
        	SetPriorityClass(GetCurrentProcess(), REALTIME_PRIORITY_CLASS);
        	LARGE_INTEGER freq, count, count2;
        	BOOL ok = QueryPerformanceFrequency(&freq);


            	if (!ok) {
            		MessageBox(0, "Performance timers aren't supported.", "Error", MB_OK);
            		return 0;
            	}
            	Sleep(500);
            	QueryPerformanceCounter(&count);
            	double work = 0, cycle = 0;

                int i=0;
                	for ( i = 0; i < 10000; i++) 
                    {
                		work += sin(cycle) * 0.357;
                		work -= sin(cycle) * 2.9348;
                		if (cycle > 3.1415926536 * 2) 
                        cycle = 0;
                	}
                 	
                	QueryPerformanceCounter(&count2);
                	SetPriorityClass(GetCurrentProcess(), NORMAL_PRIORITY_CLASS);
                	double dcount = ((double)(count2.QuadPart - count.QuadPart)) / ((double)freq.QuadPart) * 1000;
                	char string[50] = "";
                	sprintf(string, "The operation took %f milliseconds.", dcount);
                	MessageBox(0, string, "Info", MB_OK);
                	return 0;
            }

	
		
