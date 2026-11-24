@echo off
rem Build the browser live demo into docs\app.jar (needs JDK 9 or newer for --release)
cd /d "%~dp0"
if exist out-web rmdir /s /q out-web
mkdir out-web
javac --release 8 -encoding UTF-8 -d out-web Start.java Frames\*.java entities\*.java interfaces\*.java repositories\*.java web\WebLauncher.java || exit /b 1
jar cfe docs\app.jar WebLauncher -C out-web . images repositories\data || exit /b 1
rmdir /s /q out-web
echo Built docs\app.jar
