@echo off
:path
cls
set /p p=Enter the path: 
set /p perm=Perminent path?(Y/N): 
if %perm% == Y goto startY
if %perm% == N goto startN
:startN
cls
set /p class=Enter the class: 
cls
echo %p%\%class%
H:\Programs\Java\jdk1.6.0_26\bin\javac.exe %p%\%class%
pause
goto path
:startY
cls
set /p class=Enter the class: 
cls
echo %p%\%class%
H:\Programs\Java\jdk1.6.0_26\bin\javac.exe %p%\%class%
pause
goto startY