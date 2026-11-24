#!/bin/sh
# Compile and start Pixel Palace (needs JDK 8 or newer)
cd "$(dirname "$0")" || exit 1
mkdir -p out
javac -encoding UTF-8 -d out Start.java Frames/*.java entities/*.java interfaces/*.java repositories/*.java || exit 1
java -cp out Start
