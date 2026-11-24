@echo off
rem Compile and start Pixel Palace (needs JDK 8 or newer)
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -d out Start.java Frames\*.java entities\*.java interfaces\*.java repositories\*.java || exit /b 1
java -cp out Start
