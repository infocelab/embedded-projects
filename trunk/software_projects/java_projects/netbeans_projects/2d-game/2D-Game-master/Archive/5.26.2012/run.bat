@echo off
:start
cls
set /p class=Enter the class: 
cls
E: >nul
cd E:\2DGame\src >nul
H:\Programs\Java\jdk1.6.0_26\bin\java.exe %class%
pause
goto start