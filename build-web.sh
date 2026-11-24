#!/bin/sh
# Build the browser live demo into docs/app.jar (needs JDK 9 or newer for --release)
cd "$(dirname "$0")" || exit 1
rm -rf out-web && mkdir out-web
javac --release 8 -encoding UTF-8 -d out-web Start.java Frames/*.java entities/*.java interfaces/*.java repositories/*.java web/WebLauncher.java || exit 1
jar cfe docs/app.jar WebLauncher -C out-web . images repositories/data || exit 1
rm -rf out-web
echo "Built docs/app.jar"
